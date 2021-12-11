import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { ILabel } from '@/shared/model/test-root/label.model';

const baseApiUrl = 'api/labels';

export default class LabelService {
  public find(id: number): Promise<ILabel> {
    return new Promise<ILabel>((resolve, reject) => {
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
}
