import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IFieldTestPaginationEntity } from '@/shared/model/field-test-pagination-entity.model';

const baseApiUrl = 'api/field-test-pagination-entities';

export default class FieldTestPaginationEntityService {
  public find(id: number): Promise<IFieldTestPaginationEntity> {
    return new Promise<IFieldTestPaginationEntity>((resolve, reject) => {
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

  public create(entity: IFieldTestPaginationEntity): Promise<IFieldTestPaginationEntity> {
    return new Promise<IFieldTestPaginationEntity>((resolve, reject) => {
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

  public update(entity: IFieldTestPaginationEntity): Promise<IFieldTestPaginationEntity> {
    return new Promise<IFieldTestPaginationEntity>((resolve, reject) => {
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

  public partialUpdate(entity: IFieldTestPaginationEntity): Promise<IFieldTestPaginationEntity> {
    return new Promise<IFieldTestPaginationEntity>((resolve, reject) => {
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
