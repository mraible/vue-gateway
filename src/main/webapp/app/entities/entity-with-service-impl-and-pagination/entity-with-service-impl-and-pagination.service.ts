import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IEntityWithServiceImplAndPagination } from '@/shared/model/entity-with-service-impl-and-pagination.model';

const baseApiUrl = 'api/entity-with-service-impl-and-paginations';

export default class EntityWithServiceImplAndPaginationService {
  public find(id: number): Promise<IEntityWithServiceImplAndPagination> {
    return new Promise<IEntityWithServiceImplAndPagination>((resolve, reject) => {
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

  public create(entity: IEntityWithServiceImplAndPagination): Promise<IEntityWithServiceImplAndPagination> {
    return new Promise<IEntityWithServiceImplAndPagination>((resolve, reject) => {
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

  public update(entity: IEntityWithServiceImplAndPagination): Promise<IEntityWithServiceImplAndPagination> {
    return new Promise<IEntityWithServiceImplAndPagination>((resolve, reject) => {
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

  public partialUpdate(entity: IEntityWithServiceImplAndPagination): Promise<IEntityWithServiceImplAndPagination> {
    return new Promise<IEntityWithServiceImplAndPagination>((resolve, reject) => {
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
