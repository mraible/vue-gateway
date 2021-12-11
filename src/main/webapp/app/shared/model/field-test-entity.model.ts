import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';
export interface IFieldTestEntity {
  id?: number;
  stringTom?: string | null;
  stringRequiredTom?: string;
  stringMinlengthTom?: string | null;
  stringMaxlengthTom?: string | null;
  stringPatternTom?: string | null;
  numberPatternTom?: string | null;
  numberPatternRequiredTom?: string;
  integerTom?: number | null;
  integerRequiredTom?: number;
  integerMinTom?: number | null;
  integerMaxTom?: number | null;
  longTom?: number | null;
  longRequiredTom?: number;
  longMinTom?: number | null;
  longMaxTom?: number | null;
  floatTom?: number | null;
  floatRequiredTom?: number;
  floatMinTom?: number | null;
  floatMaxTom?: number | null;
  doubleRequiredTom?: number;
  doubleMinTom?: number | null;
  doubleMaxTom?: number | null;
  bigDecimalRequiredTom?: number;
  bigDecimalMinTom?: number | null;
  bigDecimalMaxTom?: number | null;
  localDateTom?: Date | null;
  localDateRequiredTom?: Date;
  instantTom?: Date | null;
  instantRequiredTom?: Date;
  zonedDateTimeTom?: Date | null;
  zonedDateTimeRequiredTom?: Date;
  durationTom?: string | null;
  durationRequiredTom?: string;
  booleanTom?: boolean | null;
  booleanRequiredTom?: boolean;
  enumTom?: EnumFieldClass | null;
  enumRequiredTom?: EnumRequiredFieldClass;
  uuidTom?: string | null;
  uuidRequiredTom?: string;
  byteImageTomContentType?: string | null;
  byteImageTom?: string | null;
  byteImageRequiredTomContentType?: string;
  byteImageRequiredTom?: string;
  byteImageMinbytesTomContentType?: string | null;
  byteImageMinbytesTom?: string | null;
  byteImageMaxbytesTomContentType?: string | null;
  byteImageMaxbytesTom?: string | null;
  byteAnyTomContentType?: string | null;
  byteAnyTom?: string | null;
  byteAnyRequiredTomContentType?: string;
  byteAnyRequiredTom?: string;
  byteAnyMinbytesTomContentType?: string | null;
  byteAnyMinbytesTom?: string | null;
  byteAnyMaxbytesTomContentType?: string | null;
  byteAnyMaxbytesTom?: string | null;
  byteTextTom?: string | null;
  byteTextRequiredTom?: string;
}

export class FieldTestEntity implements IFieldTestEntity {
  constructor(
    public id?: number,
    public stringTom?: string | null,
    public stringRequiredTom?: string,
    public stringMinlengthTom?: string | null,
    public stringMaxlengthTom?: string | null,
    public stringPatternTom?: string | null,
    public numberPatternTom?: string | null,
    public numberPatternRequiredTom?: string,
    public integerTom?: number | null,
    public integerRequiredTom?: number,
    public integerMinTom?: number | null,
    public integerMaxTom?: number | null,
    public longTom?: number | null,
    public longRequiredTom?: number,
    public longMinTom?: number | null,
    public longMaxTom?: number | null,
    public floatTom?: number | null,
    public floatRequiredTom?: number,
    public floatMinTom?: number | null,
    public floatMaxTom?: number | null,
    public doubleRequiredTom?: number,
    public doubleMinTom?: number | null,
    public doubleMaxTom?: number | null,
    public bigDecimalRequiredTom?: number,
    public bigDecimalMinTom?: number | null,
    public bigDecimalMaxTom?: number | null,
    public localDateTom?: Date | null,
    public localDateRequiredTom?: Date,
    public instantTom?: Date | null,
    public instantRequiredTom?: Date,
    public zonedDateTimeTom?: Date | null,
    public zonedDateTimeRequiredTom?: Date,
    public durationTom?: string | null,
    public durationRequiredTom?: string,
    public booleanTom?: boolean | null,
    public booleanRequiredTom?: boolean,
    public enumTom?: EnumFieldClass | null,
    public enumRequiredTom?: EnumRequiredFieldClass,
    public uuidTom?: string | null,
    public uuidRequiredTom?: string,
    public byteImageTomContentType?: string | null,
    public byteImageTom?: string | null,
    public byteImageRequiredTomContentType?: string,
    public byteImageRequiredTom?: string,
    public byteImageMinbytesTomContentType?: string | null,
    public byteImageMinbytesTom?: string | null,
    public byteImageMaxbytesTomContentType?: string | null,
    public byteImageMaxbytesTom?: string | null,
    public byteAnyTomContentType?: string | null,
    public byteAnyTom?: string | null,
    public byteAnyRequiredTomContentType?: string,
    public byteAnyRequiredTom?: string,
    public byteAnyMinbytesTomContentType?: string | null,
    public byteAnyMinbytesTom?: string | null,
    public byteAnyMaxbytesTomContentType?: string | null,
    public byteAnyMaxbytesTom?: string | null,
    public byteTextTom?: string | null,
    public byteTextRequiredTom?: string
  ) {
    this.booleanTom = this.booleanTom ?? false;
    this.booleanRequiredTom = this.booleanRequiredTom ?? false;
  }
}
