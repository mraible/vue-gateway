import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IFieldTestInfiniteScrollEntity } from '@/shared/model/field-test-infinite-scroll-entity.model';

const baseApiUrl = 'api/field-test-infinite-scroll-entities';

export default class FieldTestInfiniteScrollEntityService {
  public find(id: number): Promise<IFieldTestInfiniteScrollEntity> {
    return new Promise<IFieldTestInfiniteScrollEntity>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(paginationQuery?: any): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl + `?${buildPaginationQueryOpts(paginationQuery)}`)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public delete(id: number): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .delete(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: IFieldTestInfiniteScrollEntity): Promise<IFieldTestInfiniteScrollEntity> {
    return new Promise<IFieldTestInfiniteScrollEntity>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public update(entity: IFieldTestInfiniteScrollEntity): Promise<IFieldTestInfiniteScrollEntity> {
    return new Promise<IFieldTestInfiniteScrollEntity>((resolve, reject) => {
      axios
        .put(`${baseApiUrl}/${entity.id}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public partialUpdate(entity: IFieldTestInfiniteScrollEntity): Promise<IFieldTestInfiniteScrollEntity> {
    return new Promise<IFieldTestInfiniteScrollEntity>((resolve, reject) => {
      axios
        .patch(`${baseApiUrl}/${entity.id}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
