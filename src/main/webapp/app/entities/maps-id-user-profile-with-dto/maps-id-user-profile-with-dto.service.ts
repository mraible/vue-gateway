import axios from 'axios';

import { IMapsIdUserProfileWithDTO } from '@/shared/model/maps-id-user-profile-with-dto.model';

const baseApiUrl = 'api/maps-id-user-profile-with-dtos';

export default class MapsIdUserProfileWithDTOService {
  public find(id: number): Promise<IMapsIdUserProfileWithDTO> {
    return new Promise<IMapsIdUserProfileWithDTO>((resolve, reject) => {
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

  public create(entity: IMapsIdUserProfileWithDTO): Promise<IMapsIdUserProfileWithDTO> {
    return new Promise<IMapsIdUserProfileWithDTO>((resolve, reject) => {
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

  public update(entity: IMapsIdUserProfileWithDTO): Promise<IMapsIdUserProfileWithDTO> {
    return new Promise<IMapsIdUserProfileWithDTO>((resolve, reject) => {
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

  public partialUpdate(entity: IMapsIdUserProfileWithDTO): Promise<IMapsIdUserProfileWithDTO> {
    return new Promise<IMapsIdUserProfileWithDTO>((resolve, reject) => {
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
