/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT, DATE_TIME_FORMAT } from '@/shared/date/filters';
import FieldTestServiceImplEntityService from '@/entities/field-test-service-impl-entity/field-test-service-impl-entity.service';
import { FieldTestServiceImplEntity } from '@/shared/model/field-test-service-impl-entity.model';
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
  describe('FieldTestServiceImplEntity Service', () => {
    let service: FieldTestServiceImplEntityService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new FieldTestServiceImplEntityService();
      currentDate = new Date();
      elemDefault = new FieldTestServiceImplEntity(
        123,
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
            localDateMika: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredMika: dayjs(currentDate).format(DATE_FORMAT),
            instantMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
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

      it('should create a FieldTestServiceImplEntity', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            localDateMika: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredMika: dayjs(currentDate).format(DATE_FORMAT),
            instantMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateMika: currentDate,
            localDateRequiredMika: currentDate,
            instantMika: currentDate,
            instanteRequiredMika: currentDate,
            zonedDateTimeMika: currentDate,
            zonedDateTimeRequiredMika: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a FieldTestServiceImplEntity', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a FieldTestServiceImplEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringMika: 'BBBBBB',
            stringRequiredMika: 'BBBBBB',
            stringMinlengthMika: 'BBBBBB',
            stringMaxlengthMika: 'BBBBBB',
            stringPatternMika: 'BBBBBB',
            integerMika: 1,
            integerRequiredMika: 1,
            integerMinMika: 1,
            integerMaxMika: 1,
            longMika: 1,
            longRequiredMika: 1,
            longMinMika: 1,
            longMaxMika: 1,
            floatMika: 1,
            floatRequiredMika: 1,
            floatMinMika: 1,
            floatMaxMika: 1,
            doubleRequiredMika: 1,
            doubleMinMika: 1,
            doubleMaxMika: 1,
            bigDecimalRequiredMika: 1,
            bigDecimalMinMika: 1,
            bigDecimalMaxMika: 1,
            localDateMika: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredMika: dayjs(currentDate).format(DATE_FORMAT),
            instantMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationMika: 'PT2S',
            durationRequiredMika: 'PT2S',
            booleanMika: true,
            booleanRequiredMika: true,
            enumMika: 'BBBBBB',
            enumRequiredMika: 'BBBBBB',
            uuidMika: 'BBBBBB',
            uuidRequiredMika: 'BBBBBB',
            byteImageMika: 'BBBBBB',
            byteImageRequiredMika: 'BBBBBB',
            byteImageMinbytesMika: 'BBBBBB',
            byteImageMaxbytesMika: 'BBBBBB',
            byteAnyMika: 'BBBBBB',
            byteAnyRequiredMika: 'BBBBBB',
            byteAnyMinbytesMika: 'BBBBBB',
            byteAnyMaxbytesMika: 'BBBBBB',
            byteTextMika: 'BBBBBB',
            byteTextRequiredMika: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            localDateMika: currentDate,
            localDateRequiredMika: currentDate,
            instantMika: currentDate,
            instanteRequiredMika: currentDate,
            zonedDateTimeMika: currentDate,
            zonedDateTimeRequiredMika: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a FieldTestServiceImplEntity', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a FieldTestServiceImplEntity', async () => {
        const patchObject = Object.assign(
          {
            stringMika: 'BBBBBB',
            stringMaxlengthMika: 'BBBBBB',
            integerRequiredMika: 1,
            integerMinMika: 1,
            integerMaxMika: 1,
            longMika: 1,
            longMinMika: 1,
            longMaxMika: 1,
            floatMika: 1,
            floatRequiredMika: 1,
            doubleMinMika: 1,
            bigDecimalRequiredMika: 1,
            bigDecimalMaxMika: 1,
            localDateRequiredMika: dayjs(currentDate).format(DATE_FORMAT),
            zonedDateTimeMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            booleanMika: true,
            enumRequiredMika: 'BBBBBB',
            uuidRequiredMika: 'BBBBBB',
            byteImageMinbytesMika: 'BBBBBB',
            byteAnyRequiredMika: 'BBBBBB',
            byteAnyMinbytesMika: 'BBBBBB',
            byteAnyMaxbytesMika: 'BBBBBB',
            byteTextMika: 'BBBBBB',
            byteTextRequiredMika: 'BBBBBB',
          },
          new FieldTestServiceImplEntity()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            localDateMika: currentDate,
            localDateRequiredMika: currentDate,
            instantMika: currentDate,
            instanteRequiredMika: currentDate,
            zonedDateTimeMika: currentDate,
            zonedDateTimeRequiredMika: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a FieldTestServiceImplEntity', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of FieldTestServiceImplEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringMika: 'BBBBBB',
            stringRequiredMika: 'BBBBBB',
            stringMinlengthMika: 'BBBBBB',
            stringMaxlengthMika: 'BBBBBB',
            stringPatternMika: 'BBBBBB',
            integerMika: 1,
            integerRequiredMika: 1,
            integerMinMika: 1,
            integerMaxMika: 1,
            longMika: 1,
            longRequiredMika: 1,
            longMinMika: 1,
            longMaxMika: 1,
            floatMika: 1,
            floatRequiredMika: 1,
            floatMinMika: 1,
            floatMaxMika: 1,
            doubleRequiredMika: 1,
            doubleMinMika: 1,
            doubleMaxMika: 1,
            bigDecimalRequiredMika: 1,
            bigDecimalMinMika: 1,
            bigDecimalMaxMika: 1,
            localDateMika: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredMika: dayjs(currentDate).format(DATE_FORMAT),
            instantMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredMika: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationMika: 'PT2S',
            durationRequiredMika: 'PT2S',
            booleanMika: true,
            booleanRequiredMika: true,
            enumMika: 'BBBBBB',
            enumRequiredMika: 'BBBBBB',
            uuidMika: 'BBBBBB',
            uuidRequiredMika: 'BBBBBB',
            byteImageMika: 'BBBBBB',
            byteImageRequiredMika: 'BBBBBB',
            byteImageMinbytesMika: 'BBBBBB',
            byteImageMaxbytesMika: 'BBBBBB',
            byteAnyMika: 'BBBBBB',
            byteAnyRequiredMika: 'BBBBBB',
            byteAnyMinbytesMika: 'BBBBBB',
            byteAnyMaxbytesMika: 'BBBBBB',
            byteTextMika: 'BBBBBB',
            byteTextRequiredMika: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateMika: currentDate,
            localDateRequiredMika: currentDate,
            instantMika: currentDate,
            instanteRequiredMika: currentDate,
            zonedDateTimeMika: currentDate,
            zonedDateTimeRequiredMika: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of FieldTestServiceImplEntity', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a FieldTestServiceImplEntity', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a FieldTestServiceImplEntity', async () => {
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
