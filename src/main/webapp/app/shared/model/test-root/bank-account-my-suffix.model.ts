import { IUser } from '@/shared/model/user.model';
import { IOperation } from '@/shared/model/test-root/operation.model';

import { BankAccountType } from '@/shared/model/enumerations/bank-account-type.model';
export interface IBankAccountMySuffix {
  id?: number;
  name?: string;
  guid?: string | null;
  bankNumber?: number | null;
  agencyNumber?: number | null;
  lastOperationDuration?: number | null;
  meanOperationDuration?: number | null;
  meanQueueDuration?: string | null;
  balance?: number;
  openingDay?: Date | null;
  lastOperationDate?: Date | null;
  active?: boolean | null;
  accountType?: BankAccountType | null;
  attachmentContentType?: string | null;
  attachment?: string | null;
  description?: string | null;
  user?: IUser | null;
  operations?: IOperation[] | null;
}

export class BankAccountMySuffix implements IBankAccountMySuffix {
  constructor(
    public id?: number,
    public name?: string,
    public guid?: string | null,
    public bankNumber?: number | null,
    public agencyNumber?: number | null,
    public lastOperationDuration?: number | null,
    public meanOperationDuration?: number | null,
    public meanQueueDuration?: string | null,
    public balance?: number,
    public openingDay?: Date | null,
    public lastOperationDate?: Date | null,
    public active?: boolean | null,
    public accountType?: BankAccountType | null,
    public attachmentContentType?: string | null,
    public attachment?: string | null,
    public description?: string | null,
    public user?: IUser | null,
    public operations?: IOperation[] | null
  ) {
    this.active = this.active ?? false;
  }
}
