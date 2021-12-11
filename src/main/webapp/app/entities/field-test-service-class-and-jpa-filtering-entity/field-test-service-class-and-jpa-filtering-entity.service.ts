import axios from 'axios';

import { IFieldTestServiceClassAndJpaFilteringEntity } from '@/shared/model/field-test-service-class-and-jpa-filtering-entity.model';

const baseApiUrl = 'api/field-test-service-class-and-jpa-filtering-entities';

export default class FieldTestServiceClassAndJpaFilteringEntityService {
  public find(id: number): Promise<IFieldTestServiceClassAndJpaFilteringEntity> {
    return new Promise<IFieldTestServiceClassAndJpaFilteringEntity>((resolve, reject) => {
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

  public create(entity: IFieldTestServiceClassAndJpaFilteringEntity): Promise<IFieldTestServiceClassAndJpaFilteringEntity> {
    return new Promise<IFieldTestServiceClassAndJpaFilteringEntity>((resolve, reject) => {
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

  public update(entity: IFieldTestServiceClassAndJpaFilteringEntity): Promise<IFieldTestServiceClassAndJpaFilteringEntity> {
    return new Promise<IFieldTestServiceClassAndJpaFilteringEntity>((resolve, reject) => {
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

  public partialUpdate(entity: IFieldTestServiceClassAndJpaFilteringEntity): Promise<IFieldTestServiceClassAndJpaFilteringEntity> {
    return new Promise<IFieldTestServiceClassAndJpaFilteringEntity>((resolve, reject) => {
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
