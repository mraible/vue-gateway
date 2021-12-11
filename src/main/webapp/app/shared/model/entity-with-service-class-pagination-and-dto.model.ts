export interface IEntityWithServiceClassPaginationAndDTO {
  id?: number;
  lena?: string | null;
}

export class EntityWithServiceClassPaginationAndDTO implements IEntityWithServiceClassPaginationAndDTO {
  constructor(public id?: number, public lena?: string | null) {}
}
