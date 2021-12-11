export interface IEntityWithServiceImplPaginationAndDTO {
  id?: number;
  theo?: string | null;
}

export class EntityWithServiceImplPaginationAndDTO implements IEntityWithServiceImplPaginationAndDTO {
  constructor(public id?: number, public theo?: string | null) {}
}
