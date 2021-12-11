import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';
export interface IFieldTestPaginationEntity {
  id?: number;
  stringAlice?: string | null;
  stringRequiredAlice?: string;
  stringMinlengthAlice?: string | null;
  stringMaxlengthAlice?: string | null;
  stringPatternAlice?: string | null;
  integerAlice?: number | null;
  integerRequiredAlice?: number;
  integerMinAlice?: number | null;
  integerMaxAlice?: number | null;
  longAlice?: number | null;
  longRequiredAlice?: number;
  longMinAlice?: number | null;
  longMaxAlice?: number | null;
  floatAlice?: number | null;
  floatRequiredAlice?: number;
  floatMinAlice?: number | null;
  floatMaxAlice?: number | null;
  doubleRequiredAlice?: number;
  doubleMinAlice?: number | null;
  doubleMaxAlice?: number | null;
  bigDecimalRequiredAlice?: number;
  bigDecimalMinAlice?: number | null;
  bigDecimalMaxAlice?: number | null;
  localDateAlice?: Date | null;
  localDateRequiredAlice?: Date;
  instantAlice?: Date | null;
  instanteRequiredAlice?: Date;
  zonedDateTimeAlice?: Date | null;
  zonedDateTimeRequiredAlice?: Date;
  durationAlice?: string | null;
  durationRequiredAlice?: string;
  booleanAlice?: boolean | null;
  booleanRequiredAlice?: boolean;
  enumAlice?: EnumFieldClass | null;
  enumRequiredAlice?: EnumRequiredFieldClass;
  uuidAlice?: string | null;
  uuidRequiredAlice?: string;
  byteImageAliceContentType?: string | null;
  byteImageAlice?: string | null;
  byteImageRequiredAliceContentType?: string;
  byteImageRequiredAlice?: string;
  byteImageMinbytesAliceContentType?: string | null;
  byteImageMinbytesAlice?: string | null;
  byteImageMaxbytesAliceContentType?: string | null;
  byteImageMaxbytesAlice?: string | null;
  byteAnyAliceContentType?: string | null;
  byteAnyAlice?: string | null;
  byteAnyRequiredAliceContentType?: string;
  byteAnyRequiredAlice?: string;
  byteAnyMinbytesAliceContentType?: string | null;
  byteAnyMinbytesAlice?: string | null;
  byteAnyMaxbytesAliceContentType?: string | null;
  byteAnyMaxbytesAlice?: string | null;
  byteTextAlice?: string | null;
  byteTextRequiredAlice?: string;
}

export class FieldTestPaginationEntity implements IFieldTestPaginationEntity {
  constructor(
    public id?: number,
    public stringAlice?: string | null,
    public stringRequiredAlice?: string,
    public stringMinlengthAlice?: string | null,
    public stringMaxlengthAlice?: string | null,
    public stringPatternAlice?: string | null,
    public integerAlice?: number | null,
    public integerRequiredAlice?: number,
    public integerMinAlice?: number | null,
    public integerMaxAlice?: number | null,
    public longAlice?: number | null,
    public longRequiredAlice?: number,
    public longMinAlice?: number | null,
    public longMaxAlice?: number | null,
    public floatAlice?: number | null,
    public floatRequiredAlice?: number,
    public floatMinAlice?: number | null,
    public floatMaxAlice?: number | null,
    public doubleRequiredAlice?: number,
    public doubleMinAlice?: number | null,
    public doubleMaxAlice?: number | null,
    public bigDecimalRequiredAlice?: number,
    public bigDecimalMinAlice?: number | null,
    public bigDecimalMaxAlice?: number | null,
    public localDateAlice?: Date | null,
    public localDateRequiredAlice?: Date,
    public instantAlice?: Date | null,
    public instanteRequiredAlice?: Date,
    public zonedDateTimeAlice?: Date | null,
    public zonedDateTimeRequiredAlice?: Date,
    public durationAlice?: string | null,
    public durationRequiredAlice?: string,
    public booleanAlice?: boolean | null,
    public booleanRequiredAlice?: boolean,
    public enumAlice?: EnumFieldClass | null,
    public enumRequiredAlice?: EnumRequiredFieldClass,
    public uuidAlice?: string | null,
    public uuidRequiredAlice?: string,
    public byteImageAliceContentType?: string | null,
    public byteImageAlice?: string | null,
    public byteImageRequiredAliceContentType?: string,
    public byteImageRequiredAlice?: string,
    public byteImageMinbytesAliceContentType?: string | null,
    public byteImageMinbytesAlice?: string | null,
    public byteImageMaxbytesAliceContentType?: string | null,
    public byteImageMaxbytesAlice?: string | null,
    public byteAnyAliceContentType?: string | null,
    public byteAnyAlice?: string | null,
    public byteAnyRequiredAliceContentType?: string,
    public byteAnyRequiredAlice?: string,
    public byteAnyMinbytesAliceContentType?: string | null,
    public byteAnyMinbytesAlice?: string | null,
    public byteAnyMaxbytesAliceContentType?: string | null,
    public byteAnyMaxbytesAlice?: string | null,
    public byteTextAlice?: string | null,
    public byteTextRequiredAlice?: string
  ) {
    this.booleanAlice = this.booleanAlice ?? false;
    this.booleanRequiredAlice = this.booleanRequiredAlice ?? false;
  }
}
