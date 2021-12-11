import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IEntityWithServiceClassPaginationAndDTO } from '@/shared/model/entity-with-service-class-pagination-and-dto.model';

const baseApiUrl = 'api/entity-with-service-class-pagination-and-dtos';

export default class EntityWithServiceClassPaginationAndDTOService {
  public find(id: number): Promise<IEntityWithServiceClassPaginationAndDTO> {
    return new Promise<IEntityWithServiceClassPaginationAndDTO>((resolve, reject) => {
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

  public create(entity: IEntityWithServiceClassPaginationAndDTO): Promise<IEntityWithServiceClassPaginationAndDTO> {
    return new Promise<IEntityWithServiceClassPaginationAndDTO>((resolve, reject) => {
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

  public update(entity: IEntityWithServiceClassPaginationAndDTO): Promise<IEntityWithServiceClassPaginationAndDTO> {
    return new Promise<IEntityWithServiceClassPaginationAndDTO>((resolve, reject) => {
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

  public partialUpdate(entity: IEntityWithServiceClassPaginationAndDTO): Promise<IEntityWithServiceClassPaginationAndDTO> {
    return new Promise<IEntityWithServiceClassPaginationAndDTO>((resolve, reject) => {
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
