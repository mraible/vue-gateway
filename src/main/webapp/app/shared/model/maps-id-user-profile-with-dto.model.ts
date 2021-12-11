import { IUser } from '@/shared/model/user.model';

export interface IMapsIdUserProfileWithDTO {
  id?: number;
  dateOfBirth?: Date | null;
  user?: IUser | null;
}

export class MapsIdUserProfileWithDTO implements IMapsIdUserProfileWithDTO {
  constructor(public id?: number, public dateOfBirth?: Date | null, public user?: IUser | null) {}
}
