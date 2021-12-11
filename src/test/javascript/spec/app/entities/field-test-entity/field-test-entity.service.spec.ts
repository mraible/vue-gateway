/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT, DATE_TIME_FORMAT } from '@/shared/date/filters';
import FieldTestEntityService from '@/entities/field-test-entity/field-test-entity.service';
import { FieldTestEntity } from '@/shared/model/field-test-entity.model';
import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('FieldTestEntity Service', () => {
    let service: FieldTestEntityService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new FieldTestEntityService();
      currentDate = new Date();
      elemDefault = new FieldTestEntity(
        123,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        'PT1S',
        'PT1S',
        false,
        false,
        EnumFieldClass.ENUM_VALUE_1,
        EnumRequiredFieldClass.ENUM_VALUE_1,
        'AAAAAAA',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'image/png',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            localDateTom: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredTom: dayjs(currentDate).format(DATE_FORMAT),
            instantTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instantRequiredTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a FieldTestEntity', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            localDateTom: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredTom: dayjs(currentDate).format(DATE_FORMAT),
            instantTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instantRequiredTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateTom: currentDate,
            localDateRequiredTom: currentDate,
            instantTom: currentDate,
            instantRequiredTom: currentDate,
            zonedDateTimeTom: currentDate,
            zonedDateTimeRequiredTom: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a FieldTestEntity', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a FieldTestEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringTom: 'BBBBBB',
            stringRequiredTom: 'BBBBBB',
            stringMinlengthTom: 'BBBBBB',
            stringMaxlengthTom: 'BBBBBB',
            stringPatternTom: 'BBBBBB',
            numberPatternTom: 'BBBBBB',
            numberPatternRequiredTom: 'BBBBBB',
            integerTom: 1,
            integerRequiredTom: 1,
            integerMinTom: 1,
            integerMaxTom: 1,
            longTom: 1,
            longRequiredTom: 1,
            longMinTom: 1,
            longMaxTom: 1,
            floatTom: 1,
            floatRequiredTom: 1,
            floatMinTom: 1,
            floatMaxTom: 1,
            doubleRequiredTom: 1,
            doubleMinTom: 1,
            doubleMaxTom: 1,
            bigDecimalRequiredTom: 1,
            bigDecimalMinTom: 1,
            bigDecimalMaxTom: 1,
            localDateTom: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredTom: dayjs(currentDate).format(DATE_FORMAT),
            instantTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instantRequiredTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationTom: 'PT2S',
            durationRequiredTom: 'PT2S',
            booleanTom: true,
            booleanRequiredTom: true,
            enumTom: 'BBBBBB',
            enumRequiredTom: 'BBBBBB',
            uuidTom: 'BBBBBB',
            uuidRequiredTom: 'BBBBBB',
            byteImageTom: 'BBBBBB',
            byteImageRequiredTom: 'BBBBBB',
            byteImageMinbytesTom: 'BBBBBB',
            byteImageMaxbytesTom: 'BBBBBB',
            byteAnyTom: 'BBBBBB',
            byteAnyRequiredTom: 'BBBBBB',
            byteAnyMinbytesTom: 'BBBBBB',
            byteAnyMaxbytesTom: 'BBBBBB',
            byteTextTom: 'BBBBBB',
            byteTextRequiredTom: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            localDateTom: currentDate,
            localDateRequiredTom: currentDate,
            instantTom: currentDate,
            instantRequiredTom: currentDate,
            zonedDateTimeTom: currentDate,
            zonedDateTimeRequiredTom: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a FieldTestEntity', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a FieldTestEntity', async () => {
        const patchObject = Object.assign(
          {
            stringTom: 'BBBBBB',
            stringRequiredTom: 'BBBBBB',
            integerMaxTom: 1,
            longTom: 1,
            longMaxTom: 1,
            floatMinTom: 1,
            floatMaxTom: 1,
            doubleMinTom: 1,
            bigDecimalRequiredTom: 1,
            bigDecimalMinTom: 1,
            localDateTom: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredTom: dayjs(currentDate).format(DATE_FORMAT),
            instantTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationTom: 'PT2S',
            booleanRequiredTom: true,
            enumTom: 'BBBBBB',
            enumRequiredTom: 'BBBBBB',
            uuidTom: 'BBBBBB',
            byteImageRequiredTom: 'BBBBBB',
            byteAnyTom: 'BBBBBB',
            byteAnyMaxbytesTom: 'BBBBBB',
            byteTextTom: 'BBBBBB',
            byteTextRequiredTom: 'BBBBBB',
          },
          new FieldTestEntity()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            localDateTom: currentDate,
            localDateRequiredTom: currentDate,
            instantTom: currentDate,
            instantRequiredTom: currentDate,
            zonedDateTimeTom: currentDate,
            zonedDateTimeRequiredTom: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a FieldTestEntity', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of FieldTestEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringTom: 'BBBBBB',
            stringRequiredTom: 'BBBBBB',
            stringMinlengthTom: 'BBBBBB',
            stringMaxlengthTom: 'BBBBBB',
            stringPatternTom: 'BBBBBB',
            numberPatternTom: 'BBBBBB',
            numberPatternRequiredTom: 'BBBBBB',
            integerTom: 1,
            integerRequiredTom: 1,
            integerMinTom: 1,
            integerMaxTom: 1,
            longTom: 1,
            longRequiredTom: 1,
            longMinTom: 1,
            longMaxTom: 1,
            floatTom: 1,
            floatRequiredTom: 1,
            floatMinTom: 1,
            floatMaxTom: 1,
            doubleRequiredTom: 1,
            doubleMinTom: 1,
            doubleMaxTom: 1,
            bigDecimalRequiredTom: 1,
            bigDecimalMinTom: 1,
            bigDecimalMaxTom: 1,
            localDateTom: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredTom: dayjs(currentDate).format(DATE_FORMAT),
            instantTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instantRequiredTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredTom: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationTom: 'PT2S',
            durationRequiredTom: 'PT2S',
            booleanTom: true,
            booleanRequiredTom: true,
            enumTom: 'BBBBBB',
            enumRequiredTom: 'BBBBBB',
            uuidTom: 'BBBBBB',
            uuidRequiredTom: 'BBBBBB',
            byteImageTom: 'BBBBBB',
            byteImageRequiredTom: 'BBBBBB',
            byteImageMinbytesTom: 'BBBBBB',
            byteImageMaxbytesTom: 'BBBBBB',
            byteAnyTom: 'BBBBBB',
            byteAnyRequiredTom: 'BBBBBB',
            byteAnyMinbytesTom: 'BBBBBB',
            byteAnyMaxbytesTom: 'BBBBBB',
            byteTextTom: 'BBBBBB',
            byteTextRequiredTom: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateTom: currentDate,
            localDateRequiredTom: currentDate,
            instantTom: currentDate,
            instantRequiredTom: currentDate,
            zonedDateTimeTom: currentDate,
            zonedDateTimeRequiredTom: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of FieldTestEntity', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a FieldTestEntity', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a FieldTestEntity', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
