/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT, DATE_TIME_FORMAT } from '@/shared/date/filters';
import FieldTestInfiniteScrollEntityService from '@/entities/field-test-infinite-scroll-entity/field-test-infinite-scroll-entity.service';
import { FieldTestInfiniteScrollEntity } from '@/shared/model/field-test-infinite-scroll-entity.model';
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
  describe('FieldTestInfiniteScrollEntity Service', () => {
    let service: FieldTestInfiniteScrollEntityService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new FieldTestInfiniteScrollEntityService();
      currentDate = new Date();
      elemDefault = new FieldTestInfiniteScrollEntity(
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
            localDateHugo: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredHugo: dayjs(currentDate).format(DATE_FORMAT),
            instantHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
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

      it('should create a FieldTestInfiniteScrollEntity', async () => {
        const returnedFromService = Object.assign(
          {
            id: 123,
            localDateHugo: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredHugo: dayjs(currentDate).format(DATE_FORMAT),
            instantHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateHugo: currentDate,
            localDateRequiredHugo: currentDate,
            instantHugo: currentDate,
            instanteRequiredHugo: currentDate,
            zonedDateTimeHugo: currentDate,
            zonedDateTimeRequiredHugo: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a FieldTestInfiniteScrollEntity', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a FieldTestInfiniteScrollEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringHugo: 'BBBBBB',
            stringRequiredHugo: 'BBBBBB',
            stringMinlengthHugo: 'BBBBBB',
            stringMaxlengthHugo: 'BBBBBB',
            stringPatternHugo: 'BBBBBB',
            integerHugo: 1,
            integerRequiredHugo: 1,
            integerMinHugo: 1,
            integerMaxHugo: 1,
            longHugo: 1,
            longRequiredHugo: 1,
            longMinHugo: 1,
            longMaxHugo: 1,
            floatHugo: 1,
            floatRequiredHugo: 1,
            floatMinHugo: 1,
            floatMaxHugo: 1,
            doubleRequiredHugo: 1,
            doubleMinHugo: 1,
            doubleMaxHugo: 1,
            bigDecimalRequiredHugo: 1,
            bigDecimalMinHugo: 1,
            bigDecimalMaxHugo: 1,
            localDateHugo: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredHugo: dayjs(currentDate).format(DATE_FORMAT),
            instantHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationHugo: 'PT2S',
            durationRequiredHugo: 'PT2S',
            booleanHugo: true,
            booleanRequiredHugo: true,
            enumHugo: 'BBBBBB',
            enumRequiredHugo: 'BBBBBB',
            uuidHugo: 'BBBBBB',
            uuidRequiredHugo: 'BBBBBB',
            byteImageHugo: 'BBBBBB',
            byteImageRequiredHugo: 'BBBBBB',
            byteImageMinbytesHugo: 'BBBBBB',
            byteImageMaxbytesHugo: 'BBBBBB',
            byteAnyHugo: 'BBBBBB',
            byteAnyRequiredHugo: 'BBBBBB',
            byteAnyMinbytesHugo: 'BBBBBB',
            byteAnyMaxbytesHugo: 'BBBBBB',
            byteTextHugo: 'BBBBBB',
            byteTextRequiredHugo: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            localDateHugo: currentDate,
            localDateRequiredHugo: currentDate,
            instantHugo: currentDate,
            instanteRequiredHugo: currentDate,
            zonedDateTimeHugo: currentDate,
            zonedDateTimeRequiredHugo: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a FieldTestInfiniteScrollEntity', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a FieldTestInfiniteScrollEntity', async () => {
        const patchObject = Object.assign(
          {
            integerHugo: 1,
            integerMaxHugo: 1,
            longHugo: 1,
            floatHugo: 1,
            floatRequiredHugo: 1,
            floatMinHugo: 1,
            floatMaxHugo: 1,
            doubleRequiredHugo: 1,
            bigDecimalRequiredHugo: 1,
            localDateRequiredHugo: dayjs(currentDate).format(DATE_FORMAT),
            instanteRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationHugo: 'PT2S',
            enumHugo: 'BBBBBB',
            uuidHugo: 'BBBBBB',
            uuidRequiredHugo: 'BBBBBB',
            byteImageHugo: 'BBBBBB',
            byteImageMinbytesHugo: 'BBBBBB',
            byteImageMaxbytesHugo: 'BBBBBB',
            byteAnyRequiredHugo: 'BBBBBB',
            byteAnyMinbytesHugo: 'BBBBBB',
            byteTextHugo: 'BBBBBB',
            byteTextRequiredHugo: 'BBBBBB',
          },
          new FieldTestInfiniteScrollEntity()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            localDateHugo: currentDate,
            localDateRequiredHugo: currentDate,
            instantHugo: currentDate,
            instanteRequiredHugo: currentDate,
            zonedDateTimeHugo: currentDate,
            zonedDateTimeRequiredHugo: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a FieldTestInfiniteScrollEntity', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of FieldTestInfiniteScrollEntity', async () => {
        const returnedFromService = Object.assign(
          {
            stringHugo: 'BBBBBB',
            stringRequiredHugo: 'BBBBBB',
            stringMinlengthHugo: 'BBBBBB',
            stringMaxlengthHugo: 'BBBBBB',
            stringPatternHugo: 'BBBBBB',
            integerHugo: 1,
            integerRequiredHugo: 1,
            integerMinHugo: 1,
            integerMaxHugo: 1,
            longHugo: 1,
            longRequiredHugo: 1,
            longMinHugo: 1,
            longMaxHugo: 1,
            floatHugo: 1,
            floatRequiredHugo: 1,
            floatMinHugo: 1,
            floatMaxHugo: 1,
            doubleRequiredHugo: 1,
            doubleMinHugo: 1,
            doubleMaxHugo: 1,
            bigDecimalRequiredHugo: 1,
            bigDecimalMinHugo: 1,
            bigDecimalMaxHugo: 1,
            localDateHugo: dayjs(currentDate).format(DATE_FORMAT),
            localDateRequiredHugo: dayjs(currentDate).format(DATE_FORMAT),
            instantHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            instanteRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            zonedDateTimeRequiredHugo: dayjs(currentDate).format(DATE_TIME_FORMAT),
            durationHugo: 'PT2S',
            durationRequiredHugo: 'PT2S',
            booleanHugo: true,
            booleanRequiredHugo: true,
            enumHugo: 'BBBBBB',
            enumRequiredHugo: 'BBBBBB',
            uuidHugo: 'BBBBBB',
            uuidRequiredHugo: 'BBBBBB',
            byteImageHugo: 'BBBBBB',
            byteImageRequiredHugo: 'BBBBBB',
            byteImageMinbytesHugo: 'BBBBBB',
            byteImageMaxbytesHugo: 'BBBBBB',
            byteAnyHugo: 'BBBBBB',
            byteAnyRequiredHugo: 'BBBBBB',
            byteAnyMinbytesHugo: 'BBBBBB',
            byteAnyMaxbytesHugo: 'BBBBBB',
            byteTextHugo: 'BBBBBB',
            byteTextRequiredHugo: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            localDateHugo: currentDate,
            localDateRequiredHugo: currentDate,
            instantHugo: currentDate,
            instanteRequiredHugo: currentDate,
            zonedDateTimeHugo: currentDate,
            zonedDateTimeRequiredHugo: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of FieldTestInfiniteScrollEntity', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a FieldTestInfiniteScrollEntity', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a FieldTestInfiniteScrollEntity', async () => {
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
