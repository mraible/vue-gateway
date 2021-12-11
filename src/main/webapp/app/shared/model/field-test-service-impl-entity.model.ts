import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';
export interface IFieldTestServiceImplEntity {
  id?: number;
  stringMika?: string | null;
  stringRequiredMika?: string;
  stringMinlengthMika?: string | null;
  stringMaxlengthMika?: string | null;
  stringPatternMika?: string | null;
  integerMika?: number | null;
  integerRequiredMika?: number;
  integerMinMika?: number | null;
  integerMaxMika?: number | null;
  longMika?: number | null;
  longRequiredMika?: number;
  longMinMika?: number | null;
  longMaxMika?: number | null;
  floatMika?: number | null;
  floatRequiredMika?: number;
  floatMinMika?: number | null;
  floatMaxMika?: number | null;
  doubleRequiredMika?: number;
  doubleMinMika?: number | null;
  doubleMaxMika?: number | null;
  bigDecimalRequiredMika?: number;
  bigDecimalMinMika?: number | null;
  bigDecimalMaxMika?: number | null;
  localDateMika?: Date | null;
  localDateRequiredMika?: Date;
  instantMika?: Date | null;
  instanteRequiredMika?: Date;
  zonedDateTimeMika?: Date | null;
  zonedDateTimeRequiredMika?: Date;
  durationMika?: string | null;
  durationRequiredMika?: string;
  booleanMika?: boolean | null;
  booleanRequiredMika?: boolean;
  enumMika?: EnumFieldClass | null;
  enumRequiredMika?: EnumRequiredFieldClass;
  uuidMika?: string | null;
  uuidRequiredMika?: string;
  byteImageMikaContentType?: string | null;
  byteImageMika?: string | null;
  byteImageRequiredMikaContentType?: string;
  byteImageRequiredMika?: string;
  byteImageMinbytesMikaContentType?: string | null;
  byteImageMinbytesMika?: string | null;
  byteImageMaxbytesMikaContentType?: string | null;
  byteImageMaxbytesMika?: string | null;
  byteAnyMikaContentType?: string | null;
  byteAnyMika?: string | null;
  byteAnyRequiredMikaContentType?: string;
  byteAnyRequiredMika?: string;
  byteAnyMinbytesMikaContentType?: string | null;
  byteAnyMinbytesMika?: string | null;
  byteAnyMaxbytesMikaContentType?: string | null;
  byteAnyMaxbytesMika?: string | null;
  byteTextMika?: string | null;
  byteTextRequiredMika?: string;
}

export class FieldTestServiceImplEntity implements IFieldTestServiceImplEntity {
  constructor(
    public id?: number,
    public stringMika?: string | null,
    public stringRequiredMika?: string,
    public stringMinlengthMika?: string | null,
    public stringMaxlengthMika?: string | null,
    public stringPatternMika?: string | null,
    public integerMika?: number | null,
    public integerRequiredMika?: number,
    public integerMinMika?: number | null,
    public integerMaxMika?: number | null,
    public longMika?: number | null,
    public longRequiredMika?: number,
    public longMinMika?: number | null,
    public longMaxMika?: number | null,
    public floatMika?: number | null,
    public floatRequiredMika?: number,
    public floatMinMika?: number | null,
    public floatMaxMika?: number | null,
    public doubleRequiredMika?: number,
    public doubleMinMika?: number | null,
    public doubleMaxMika?: number | null,
    public bigDecimalRequiredMika?: number,
    public bigDecimalMinMika?: number | null,
    public bigDecimalMaxMika?: number | null,
    public localDateMika?: Date | null,
    public localDateRequiredMika?: Date,
    public instantMika?: Date | null,
    public instanteRequiredMika?: Date,
    public zonedDateTimeMika?: Date | null,
    public zonedDateTimeRequiredMika?: Date,
    public durationMika?: string | null,
    public durationRequiredMika?: string,
    public booleanMika?: boolean | null,
    public booleanRequiredMika?: boolean,
    public enumMika?: EnumFieldClass | null,
    public enumRequiredMika?: EnumRequiredFieldClass,
    public uuidMika?: string | null,
    public uuidRequiredMika?: string,
    public byteImageMikaContentType?: string | null,
    public byteImageMika?: string | null,
    public byteImageRequiredMikaContentType?: string,
    public byteImageRequiredMika?: string,
    public byteImageMinbytesMikaContentType?: string | null,
    public byteImageMinbytesMika?: string | null,
    public byteImageMaxbytesMikaContentType?: string | null,
    public byteImageMaxbytesMika?: string | null,
    public byteAnyMikaContentType?: string | null,
    public byteAnyMika?: string | null,
    public byteAnyRequiredMikaContentType?: string,
    public byteAnyRequiredMika?: string,
    public byteAnyMinbytesMikaContentType?: string | null,
    public byteAnyMinbytesMika?: string | null,
    public byteAnyMaxbytesMikaContentType?: string | null,
    public byteAnyMaxbytesMika?: string | null,
    public byteTextMika?: string | null,
    public byteTextRequiredMika?: string
  ) {
    this.booleanMika = this.booleanMika ?? false;
    this.booleanRequiredMika = this.booleanRequiredMika ?? false;
  }
}
