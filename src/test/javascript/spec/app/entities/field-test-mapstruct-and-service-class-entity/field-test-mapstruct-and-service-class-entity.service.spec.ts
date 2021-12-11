/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT, DATE_TIME_FORMAT } from '@/shared/date/filters';
import FieldTestMapstructAndServiceClassEntityService from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity.service';
import { FieldTestMapstructAndServiceClassEntity } from '@/shared/model/field-test-mapstruct-and-service-class-entity.model';
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
  describe('FieldTestMapstructAndServiceClassEntity Service', () => {
    let service: FieldTestMapstructAndServiceClassEntityService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new FieldTestMapstructAndServiceClassEntityService();
      currentDate = new Date();
      elemDefault = new FieldTestMapstructAndServiceClassEntity(
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
            localDateEva: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredEva: dayjs(currentDate).format(DATE_FORMAT),
            instantEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
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

      it('should create a FieldTestMapstructAndServiceClassEntity', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            localDateEva: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredEva: dayjs(currentDate).format(DATE_FORMAT),
            instantEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateEva: currentDate,
            localDateRequiredEva: currentDate,
            instantEva: currentDate,
            instanteRequiredEva: currentDate,
            zonedDateTimeEva: currentDate,
            zonedDateTimeRequiredEva: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a FieldTestMapstructAndServiceClassEntity', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a FieldTestMapstructAndServiceClassEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringEva: 'BBBBBB',
            stringRequiredEva: 'BBBBBB',
            stringMinlengthEva: 'BBBBBB',
            stringMaxlengthEva: 'BBBBBB',
            stringPatternEva: 'BBBBBB',
            integerEva: 1,
            integerRequiredEva: 1,
            integerMinEva: 1,
            integerMaxEva: 1,
            longEva: 1,
            longRequiredEva: 1,
            longMinEva: 1,
            longMaxEva: 1,
            floatEva: 1,
            floatRequiredEva: 1,
            floatMinEva: 1,
            floatMaxEva: 1,
            doubleRequiredEva: 1,
            doubleMinEva: 1,
            doubleMaxEva: 1,
            bigDecimalRequiredEva: 1,
            bigDecimalMinEva: 1,
            bigDecimalMaxEva: 1,
            localDateEva: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredEva: dayjs(currentDate).format(DATE_FORMAT),
            instantEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationEva: 'PT2S',
            durationRequiredEva: 'PT2S',
            booleanEva: true,
            booleanRequiredEva: true,
            enumEva: 'BBBBBB',
            enumRequiredEva: 'BBBBBB',
            uuidEva: 'BBBBBB',
            uuidRequiredEva: 'BBBBBB',
            byteImageEva: 'BBBBBB',
            byteImageRequiredEva: 'BBBBBB',
            byteImageMinbytesEva: 'BBBBBB',
            byteImageMaxbytesEva: 'BBBBBB',
            byteAnyEva: 'BBBBBB',
            byteAnyRequiredEva: 'BBBBBB',
            byteAnyMinbytesEva: 'BBBBBB',
            byteAnyMaxbytesEva: 'BBBBBB',
            byteTextEva: 'BBBBBB',
            byteTextRequiredEva: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            localDateEva: currentDate,
            localDateRequiredEva: currentDate,
            instantEva: currentDate,
            instanteRequiredEva: currentDate,
            zonedDateTimeEva: currentDate,
            zonedDateTimeRequiredEva: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a FieldTestMapstructAndServiceClassEntity', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a FieldTestMapstructAndServiceClassEntity', async () => {
        const patchObject = Object.assign(
          {
            stringMinlengthEva: 'BBBBBB',
            stringMaxlengthEva: 'BBBBBB',
            integerRequiredEva: 1,
            integerMaxEva: 1,
            longEva: 1,
            longMinEva: 1,
            floatEva: 1,
            floatRequiredEva: 1,
            floatMinEva: 1,
            floatMaxEva: 1,
            doubleRequiredEva: 1,
            doubleMinEva: 1,
            doubleMaxEva: 1,
            localDateRequiredEva: dayjs(currentDate).format(DATE_FORMAT),
            instantEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationEva: 'PT2S',
            durationRequiredEva: 'PT2S',
            booleanRequiredEva: true,
            uuidRequiredEva: 'BBBBBB',
            byteImageRequiredEva: 'BBBBBB',
            byteImageMinbytesEva: 'BBBBBB',
            byteTextEva: 'BBBBBB',
          },
          new FieldTestMapstructAndServiceClassEntity()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            localDateEva: currentDate,
            localDateRequiredEva: currentDate,
            instantEva: currentDate,
            instanteRequiredEva: currentDate,
            zonedDateTimeEva: currentDate,
            zonedDateTimeRequiredEva: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a FieldTestMapstructAndServiceClassEntity', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of FieldTestMapstructAndServiceClassEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringEva: 'BBBBBB',
            stringRequiredEva: 'BBBBBB',
            stringMinlengthEva: 'BBBBBB',
            stringMaxlengthEva: 'BBBBBB',
            stringPatternEva: 'BBBBBB',
            integerEva: 1,
            integerRequiredEva: 1,
            integerMinEva: 1,
            integerMaxEva: 1,
            longEva: 1,
            longRequiredEva: 1,
            longMinEva: 1,
            longMaxEva: 1,
            floatEva: 1,
            floatRequiredEva: 1,
            floatMinEva: 1,
            floatMaxEva: 1,
            doubleRequiredEva: 1,
            doubleMinEva: 1,
            doubleMaxEva: 1,
            bigDecimalRequiredEva: 1,
            bigDecimalMinEva: 1,
            bigDecimalMaxEva: 1,
            localDateEva: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredEva: dayjs(currentDate).format(DATE_FORMAT),
            instantEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredEva: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationEva: 'PT2S',
            durationRequiredEva: 'PT2S',
            booleanEva: true,
            booleanRequiredEva: true,
            enumEva: 'BBBBBB',
            enumRequiredEva: 'BBBBBB',
            uuidEva: 'BBBBBB',
            uuidRequiredEva: 'BBBBBB',
            byteImageEva: 'BBBBBB',
            byteImageRequiredEva: 'BBBBBB',
            byteImageMinbytesEva: 'BBBBBB',
            byteImageMaxbytesEva: 'BBBBBB',
            byteAnyEva: 'BBBBBB',
            byteAnyRequiredEva: 'BBBBBB',
            byteAnyMinbytesEva: 'BBBBBB',
            byteAnyMaxbytesEva: 'BBBBBB',
            byteTextEva: 'BBBBBB',
            byteTextRequiredEva: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateEva: currentDate,
            localDateRequiredEva: currentDate,
            instantEva: currentDate,
            instanteRequiredEva: currentDate,
            zonedDateTimeEva: currentDate,
            zonedDateTimeRequiredEva: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of FieldTestMapstructAndServiceClassEntity', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a FieldTestMapstructAndServiceClassEntity', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a FieldTestMapstructAndServiceClassEntity', async () => {
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
