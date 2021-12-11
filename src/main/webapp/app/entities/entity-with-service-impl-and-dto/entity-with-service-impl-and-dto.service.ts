import axios from 'axios';

import { IEntityWithServiceImplAndDTO } from '@/shared/model/entity-with-service-impl-and-dto.model';

const baseApiUrl = 'api/entity-with-service-impl-and-dtos';

export default class EntityWithServiceImplAndDTOService {
  public find(id: number): Promise<IEntityWithServiceImplAndDTO> {
    return new Promise<IEntityWithServiceImplAndDTO>((resolve, reject) => {
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

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
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

  public create(entity: IEntityWithServiceImplAndDTO): Promise<IEntityWithServiceImplAndDTO> {
    return new Promise<IEntityWithServiceImplAndDTO>((resolve, reject) => {
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

  public update(entity: IEntityWithServiceImplAndDTO): Promise<IEntityWithServiceImplAndDTO> {
    return new Promise<IEntityWithServiceImplAndDTO>((resolve, reject) => {
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

  public partialUpdate(entity: IEntityWithServiceImplAndDTO): Promise<IEntityWithServiceImplAndDTO> {
    return new Promise<IEntityWithServiceImplAndDTO>((resolve, reject) => {
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
