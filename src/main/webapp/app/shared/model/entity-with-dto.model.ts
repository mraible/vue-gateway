export interface IEntityWithDTO {
  id?: number;
  emma?: string | null;
}

export class EntityWithDTO implements IEntityWithDTO {
  constructor(public id?: number, public emma?: string | null) {}
}
