export interface IEntityWithServiceImplAndPagination {
  id?: number;
  hugo?: string | null;
}

export class EntityWithServiceImplAndPagination implements IEntityWithServiceImplAndPagination {
  constructor(public id?: number, public hugo?: string | null) {}
}
