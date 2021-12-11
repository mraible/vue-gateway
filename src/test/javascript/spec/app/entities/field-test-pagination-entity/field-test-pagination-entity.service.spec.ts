/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT, DATE_TIME_FORMAT } from '@/shared/date/filters';
import FieldTestPaginationEntityService from '@/entities/field-test-pagination-entity/field-test-pagination-entity.service';
import { FieldTestPaginationEntity } from '@/shared/model/field-test-pagination-entity.model';
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
  describe('FieldTestPaginationEntity Service', () => {
    let service: FieldTestPaginationEntityService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new FieldTestPaginationEntityService();
      currentDate = new Date();
      elemDefault = new FieldTestPaginationEntity(
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
            localDateAlice: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredAlice: dayjs(currentDate).format(DATE_FORMAT),
            instantAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
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

      it('should create a FieldTestPaginationEntity', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            localDateAlice: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredAlice: dayjs(currentDate).format(DATE_FORMAT),
            instantAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateAlice: currentDate,
            localDateRequiredAlice: currentDate,
            instantAlice: currentDate,
            instanteRequiredAlice: currentDate,
            zonedDateTimeAlice: currentDate,
            zonedDateTimeRequiredAlice: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a FieldTestPaginationEntity', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a FieldTestPaginationEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringAlice: 'BBBBBB',
            stringRequiredAlice: 'BBBBBB',
            stringMinlengthAlice: 'BBBBBB',
            stringMaxlengthAlice: 'BBBBBB',
            stringPatternAlice: 'BBBBBB',
            integerAlice: 1,
            integerRequiredAlice: 1,
            integerMinAlice: 1,
            integerMaxAlice: 1,
            longAlice: 1,
            longRequiredAlice: 1,
            longMinAlice: 1,
            longMaxAlice: 1,
            floatAlice: 1,
            floatRequiredAlice: 1,
            floatMinAlice: 1,
            floatMaxAlice: 1,
            doubleRequiredAlice: 1,
            doubleMinAlice: 1,
            doubleMaxAlice: 1,
            bigDecimalRequiredAlice: 1,
            bigDecimalMinAlice: 1,
            bigDecimalMaxAlice: 1,
            localDateAlice: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredAlice: dayjs(currentDate).format(DATE_FORMAT),
            instantAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationAlice: 'PT2S',
            durationRequiredAlice: 'PT2S',
            booleanAlice: true,
            booleanRequiredAlice: true,
            enumAlice: 'BBBBBB',
            enumRequiredAlice: 'BBBBBB',
            uuidAlice: 'BBBBBB',
            uuidRequiredAlice: 'BBBBBB',
            byteImageAlice: 'BBBBBB',
            byteImageRequiredAlice: 'BBBBBB',
            byteImageMinbytesAlice: 'BBBBBB',
            byteImageMaxbytesAlice: 'BBBBBB',
            byteAnyAlice: 'BBBBBB',
            byteAnyRequiredAlice: 'BBBBBB',
            byteAnyMinbytesAlice: 'BBBBBB',
            byteAnyMaxbytesAlice: 'BBBBBB',
            byteTextAlice: 'BBBBBB',
            byteTextRequiredAlice: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            localDateAlice: currentDate,
            localDateRequiredAlice: currentDate,
            instantAlice: currentDate,
            instanteRequiredAlice: currentDate,
            zonedDateTimeAlice: currentDate,
            zonedDateTimeRequiredAlice: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a FieldTestPaginationEntity', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a FieldTestPaginationEntity', async () => {
        const patchObject = Object.assign(
          {
            stringRequiredAlice: 'BBBBBB',
            stringMinlengthAlice: 'BBBBBB',
            integerAlice: 1,
            integerRequiredAlice: 1,
            integerMaxAlice: 1,
            longAlice: 1,
            longRequiredAlice: 1,
            longMaxAlice: 1,
            floatAlice: 1,
            floatRequiredAlice: 1,
            floatMinAlice: 1,
            floatMaxAlice: 1,
            doubleMinAlice: 1,
            bigDecimalRequiredAlice: 1,
            bigDecimalMinAlice: 1,
            bigDecimalMaxAlice: 1,
            localDateRequiredAlice: dayjs(currentDate).format(DATE_FORMAT),
            durationAlice: 'PT2S',
            durationRequiredAlice: 'PT2S',
            enumAlice: 'BBBBBB',
            uuidRequiredAlice: 'BBBBBB',
            byteImageRequiredAlice: 'BBBBBB',
            byteImageMinbytesAlice: 'BBBBBB',
            byteAnyMinbytesAlice: 'BBBBBB',
            byteTextAlice: 'BBBBBB',
            byteTextRequiredAlice: 'BBBBBB',
          },
          new FieldTestPaginationEntity()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            localDateAlice: currentDate,
            localDateRequiredAlice: currentDate,
            instantAlice: currentDate,
            instanteRequiredAlice: currentDate,
            zonedDateTimeAlice: currentDate,
            zonedDateTimeRequiredAlice: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a FieldTestPaginationEntity', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of FieldTestPaginationEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringAlice: 'BBBBBB',
            stringRequiredAlice: 'BBBBBB',
            stringMinlengthAlice: 'BBBBBB',
            stringMaxlengthAlice: 'BBBBBB',
            stringPatternAlice: 'BBBBBB',
            integerAlice: 1,
            integerRequiredAlice: 1,
            integerMinAlice: 1,
            integerMaxAlice: 1,
            longAlice: 1,
            longRequiredAlice: 1,
            longMinAlice: 1,
            longMaxAlice: 1,
            floatAlice: 1,
            floatRequiredAlice: 1,
            floatMinAlice: 1,
            floatMaxAlice: 1,
            doubleRequiredAlice: 1,
            doubleMinAlice: 1,
            doubleMaxAlice: 1,
            bigDecimalRequiredAlice: 1,
            bigDecimalMinAlice: 1,
            bigDecimalMaxAlice: 1,
            localDateAlice: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredAlice: dayjs(currentDate).format(DATE_FORMAT),
            instantAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredAlice: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationAlice: 'PT2S',
            durationRequiredAlice: 'PT2S',
            booleanAlice: true,
            booleanRequiredAlice: true,
            enumAlice: 'BBBBBB',
            enumRequiredAlice: 'BBBBBB',
            uuidAlice: 'BBBBBB',
            uuidRequiredAlice: 'BBBBBB',
            byteImageAlice: 'BBBBBB',
            byteImageRequiredAlice: 'BBBBBB',
            byteImageMinbytesAlice: 'BBBBBB',
            byteImageMaxbytesAlice: 'BBBBBB',
            byteAnyAlice: 'BBBBBB',
            byteAnyRequiredAlice: 'BBBBBB',
            byteAnyMinbytesAlice: 'BBBBBB',
            byteAnyMaxbytesAlice: 'BBBBBB',
            byteTextAlice: 'BBBBBB',
            byteTextRequiredAlice: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateAlice: currentDate,
            localDateRequiredAlice: currentDate,
            instantAlice: currentDate,
            instanteRequiredAlice: currentDate,
            zonedDateTimeAlice: currentDate,
            zonedDateTimeRequiredAlice: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of FieldTestPaginationEntity', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a FieldTestPaginationEntity', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a FieldTestPaginationEntity', async () => {
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
