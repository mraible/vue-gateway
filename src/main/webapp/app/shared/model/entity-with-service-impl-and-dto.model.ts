export interface IEntityWithServiceImplAndDTO {
  id?: number;
  louis?: string | null;
}

export class EntityWithServiceImplAndDTO implements IEntityWithServiceImplAndDTO {
  constructor(public id?: number, public louis?: string | null) {}
}
