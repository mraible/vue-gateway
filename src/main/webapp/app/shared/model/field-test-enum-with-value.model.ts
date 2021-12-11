import { MyEnumA } from '@/shared/model/enumerations/my-enum-a.model';
import { MyEnumB } from '@/shared/model/enumerations/my-enum-b.model';
import { MyEnumC } from '@/shared/model/enumerations/my-enum-c.model';
export interface IFieldTestEnumWithValue {
  id?: number;
  myFieldA?: MyEnumA | null;
  myFieldB?: MyEnumB | null;
  myFieldC?: MyEnumC | null;
}

export class FieldTestEnumWithValue implements IFieldTestEnumWithValue {
  constructor(public id?: number, public myFieldA?: MyEnumA | null, public myFieldB?: MyEnumB | null, public myFieldC?: MyEnumC | null) {}
}
