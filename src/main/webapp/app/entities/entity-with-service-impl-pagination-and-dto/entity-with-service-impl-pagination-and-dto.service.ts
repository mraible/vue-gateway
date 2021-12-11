import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { IEntityWithServiceImplPaginationAndDTO } from '@/shared/model/entity-with-service-impl-pagination-and-dto.model';

const baseApiUrl = 'api/entity-with-service-impl-pagination-and-dtos';

export default class EntityWithServiceImplPaginationAndDTOService {
  public find(id: number): Promise<IEntityWithServiceImplPaginationAndDTO> {
    return new Promise<IEntityWithServiceImplPaginationAndDTO>((resolve, reject) => {
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

  public create(entity: IEntityWithServiceImplPaginationAndDTO): Promise<IEntityWithServiceImplPaginationAndDTO> {
    return new Promise<IEntityWithServiceImplPaginationAndDTO>((resolve, reject) => {
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

  public update(entity: IEntityWithServiceImplPaginationAndDTO): Promise<IEntityWithServiceImplPaginationAndDTO> {
    return new Promise<IEntityWithServiceImplPaginationAndDTO>((resolve, reject) => {
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

  public partialUpdate(entity: IEntityWithServiceImplPaginationAndDTO): Promise<IEntityWithServiceImplPaginationAndDTO> {
    return new Promise<IEntityWithServiceImplPaginationAndDTO>((resolve, reject) => {
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
