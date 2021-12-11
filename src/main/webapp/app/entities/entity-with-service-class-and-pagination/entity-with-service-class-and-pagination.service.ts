import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IEntityWithServiceClassAndPagination } from '@/shared/model/entity-with-service-class-and-pagination.model';

const baseApiUrl = 'api/entity-with-service-class-and-paginations';

export default class EntityWithServiceClassAndPaginationService {
  public find(id: number): Promise<IEntityWithServiceClassAndPagination> {
    return new Promise<IEntityWithServiceClassAndPagination>((resolve, reject) => {
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

  public create(entity: IEntityWithServiceClassAndPagination): Promise<IEntityWithServiceClassAndPagination> {
    return new Promise<IEntityWithServiceClassAndPagination>((resolve, reject) => {
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

  public update(entity: IEntityWithServiceClassAndPagination): Promise<IEntityWithServiceClassAndPagination> {
    return new Promise<IEntityWithServiceClassAndPagination>((resolve, reject) => {
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

  public partialUpdate(entity: IEntityWithServiceClassAndPagination): Promise<IEntityWithServiceClassAndPagination> {
    return new Promise<IEntityWithServiceClassAndPagination>((resolve, reject) => {
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
