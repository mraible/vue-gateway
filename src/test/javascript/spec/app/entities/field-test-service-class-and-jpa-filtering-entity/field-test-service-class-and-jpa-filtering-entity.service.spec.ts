/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT, DATE_TIME_FORMAT } from '@/shared/date/filters';
import FieldTestServiceClassAndJpaFilteringEntityService from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity.service';
import { FieldTestServiceClassAndJpaFilteringEntity } from '@/shared/model/field-test-service-class-and-jpa-filtering-entity.model';
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
  describe('FieldTestServiceClassAndJpaFilteringEntity Service', () => {
    let service: FieldTestServiceClassAndJpaFilteringEntityService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new FieldTestServiceClassAndJpaFilteringEntityService();
      currentDate = new Date();
      elemDefault = new FieldTestServiceClassAndJpaFilteringEntity(
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
            localDateBob: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredBob: dayjs(currentDate).format(DATE_FORMAT),
            instantBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
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

      it('should create a FieldTestServiceClassAndJpaFilteringEntity', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            localDateBob: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredBob: dayjs(currentDate).format(DATE_FORMAT),
            instantBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateBob: currentDate,
            localDateRequiredBob: currentDate,
            instantBob: currentDate,
            instanteRequiredBob: currentDate,
            zonedDateTimeBob: currentDate,
            zonedDateTimeRequiredBob: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a FieldTestServiceClassAndJpaFilteringEntity', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a FieldTestServiceClassAndJpaFilteringEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringBob: 'BBBBBB',
            stringRequiredBob: 'BBBBBB',
            stringMinlengthBob: 'BBBBBB',
            stringMaxlengthBob: 'BBBBBB',
            stringPatternBob: 'BBBBBB',
            integerBob: 1,
            integerRequiredBob: 1,
            integerMinBob: 1,
            integerMaxBob: 1,
            longBob: 1,
            longRequiredBob: 1,
            longMinBob: 1,
            longMaxBob: 1,
            floatBob: 1,
            floatRequiredBob: 1,
            floatMinBob: 1,
            floatMaxBob: 1,
            doubleRequiredBob: 1,
            doubleMinBob: 1,
            doubleMaxBob: 1,
            bigDecimalRequiredBob: 1,
            bigDecimalMinBob: 1,
            bigDecimalMaxBob: 1,
            localDateBob: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredBob: dayjs(currentDate).format(DATE_FORMAT),
            instantBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationBob: 'PT2S',
            durationRequiredBob: 'PT2S',
            booleanBob: true,
            booleanRequiredBob: true,
            enumBob: 'BBBBBB',
            enumRequiredBob: 'BBBBBB',
            uuidBob: 'BBBBBB',
            uuidRequiredBob: 'BBBBBB',
            byteImageBob: 'BBBBBB',
            byteImageRequiredBob: 'BBBBBB',
            byteImageMinbytesBob: 'BBBBBB',
            byteImageMaxbytesBob: 'BBBBBB',
            byteAnyBob: 'BBBBBB',
            byteAnyRequiredBob: 'BBBBBB',
            byteAnyMinbytesBob: 'BBBBBB',
            byteAnyMaxbytesBob: 'BBBBBB',
            byteTextBob: 'BBBBBB',
            byteTextRequiredBob: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            localDateBob: currentDate,
            localDateRequiredBob: currentDate,
            instantBob: currentDate,
            instanteRequiredBob: currentDate,
            zonedDateTimeBob: currentDate,
            zonedDateTimeRequiredBob: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a FieldTestServiceClassAndJpaFilteringEntity', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a FieldTestServiceClassAndJpaFilteringEntity', async () => {
        const patchObject = Object.assign(
          {
            stringRequiredBob: 'BBBBBB',
            stringMaxlengthBob: 'BBBBBB',
            integerBob: 1,
            integerRequiredBob: 1,
            integerMaxBob: 1,
            longBob: 1,
            longMaxBob: 1,
            floatBob: 1,
            floatMinBob: 1,
            floatMaxBob: 1,
            doubleRequiredBob: 1,
            doubleMinBob: 1,
            doubleMaxBob: 1,
            bigDecimalRequiredBob: 1,
            bigDecimalMaxBob: 1,
            localDateBob: dayjs(currentDate).format(DATE_FORMAT),
            instantBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationBob: 'PT2S',
            booleanBob: true,
            booleanRequiredBob: true,
            enumBob: 'BBBBBB',
            uuidBob: 'BBBBBB',
            byteImageRequiredBob: 'BBBBBB',
            byteImageMinbytesBob: 'BBBBBB',
            byteImageMaxbytesBob: 'BBBBBB',
            byteAnyMinbytesBob: 'BBBBBB',
            byteAnyMaxbytesBob: 'BBBBBB',
            byteTextRequiredBob: 'BBBBBB',
          },
          new FieldTestServiceClassAndJpaFilteringEntity()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            localDateBob: currentDate,
            localDateRequiredBob: currentDate,
            instantBob: currentDate,
            instanteRequiredBob: currentDate,
            zonedDateTimeBob: currentDate,
            zonedDateTimeRequiredBob: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a FieldTestServiceClassAndJpaFilteringEntity', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of FieldTestServiceClassAndJpaFilteringEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringBob: 'BBBBBB',
            stringRequiredBob: 'BBBBBB',
            stringMinlengthBob: 'BBBBBB',
            stringMaxlengthBob: 'BBBBBB',
            stringPatternBob: 'BBBBBB',
            integerBob: 1,
            integerRequiredBob: 1,
            integerMinBob: 1,
            integerMaxBob: 1,
            longBob: 1,
            longRequiredBob: 1,
            longMinBob: 1,
            longMaxBob: 1,
            floatBob: 1,
            floatRequiredBob: 1,
            floatMinBob: 1,
            floatMaxBob: 1,
            doubleRequiredBob: 1,
            doubleMinBob: 1,
            doubleMaxBob: 1,
            bigDecimalRequiredBob: 1,
            bigDecimalMinBob: 1,
            bigDecimalMaxBob: 1,
            localDateBob: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredBob: dayjs(currentDate).format(DATE_FORMAT),
            instantBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredBob: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationBob: 'PT2S',
            durationRequiredBob: 'PT2S',
            booleanBob: true,
            booleanRequiredBob: true,
            enumBob: 'BBBBBB',
            enumRequiredBob: 'BBBBBB',
            uuidBob: 'BBBBBB',
            uuidRequiredBob: 'BBBBBB',
            byteImageBob: 'BBBBBB',
            byteImageRequiredBob: 'BBBBBB',
            byteImageMinbytesBob: 'BBBBBB',
            byteImageMaxbytesBob: 'BBBBBB',
            byteAnyBob: 'BBBBBB',
            byteAnyRequiredBob: 'BBBBBB',
            byteAnyMinbytesBob: 'BBBBBB',
            byteAnyMaxbytesBob: 'BBBBBB',
            byteTextBob: 'BBBBBB',
            byteTextRequiredBob: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateBob: currentDate,
            localDateRequiredBob: currentDate,
            instantBob: currentDate,
            instanteRequiredBob: currentDate,
            zonedDateTimeBob: currentDate,
            zonedDateTimeRequiredBob: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of FieldTestServiceClassAndJpaFilteringEntity', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a FieldTestServiceClassAndJpaFilteringEntity', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a FieldTestServiceClassAndJpaFilteringEntity', async () => {
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
