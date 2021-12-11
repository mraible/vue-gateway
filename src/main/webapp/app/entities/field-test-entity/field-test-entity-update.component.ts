import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, minLength, maxLength, numeric, minValue, maxValue, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';

import { IFieldTestEntity, FieldTestEntity } from '@/shared/model/field-test-entity.model';
import FieldTestEntityService from './field-test-entity.service';
import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';

const validations: any = {
  fieldTestEntity: {
    stringTom: {},
    stringRequiredTom: {
      required,
    },
    stringMinlengthTom: {
      minLength: minLength(0),
    },
    stringMaxlengthTom: {
      maxLength: maxLength(20),
    },
    stringPatternTom: {},
    numberPatternTom: {},
    numberPatternRequiredTom: {
      required,
    },
    integerTom: {},
    integerRequiredTom: {
      required,
      numeric,
    },
    integerMinTom: {
      numeric,
      min: minValue(0),
    },
    integerMaxTom: {
      numeric,
      max: maxValue(100),
    },
    longTom: {},
    longRequiredTom: {
      required,
      numeric,
    },
    longMinTom: {
      numeric,
      min: minValue(0),
    },
    longMaxTom: {
      numeric,
      max: maxValue(100),
    },
    floatTom: {},
    floatRequiredTom: {
      required,
      decimal,
    },
    floatMinTom: {
      decimal,
      min: minValue(0),
    },
    floatMaxTom: {
      decimal,
      max: maxValue(100),
    },
    doubleRequiredTom: {
      required,
      decimal,
    },
    doubleMinTom: {
      decimal,
      min: minValue(0),
    },
    doubleMaxTom: {
      decimal,
      max: maxValue(100),
    },
    bigDecimalRequiredTom: {
      required,
      decimal,
    },
    bigDecimalMinTom: {
      decimal,
      min: minValue(0),
    },
    bigDecimalMaxTom: {
      decimal,
      max: maxValue(100),
    },
    localDateTom: {},
    localDateRequiredTom: {
      required,
    },
    instantTom: {},
    instantRequiredTom: {
      required,
    },
    zonedDateTimeTom: {},
    zonedDateTimeRequiredTom: {
      required,
    },
    durationTom: {},
    durationRequiredTom: {
      required,
    },
    booleanTom: {},
    booleanRequiredTom: {
      required,
    },
    enumTom: {},
    enumRequiredTom: {
      required,
    },
    uuidTom: {},
    uuidRequiredTom: {
      required,
    },
    byteImageTom: {},
    byteImageRequiredTom: {
      required,
    },
    byteImageMinbytesTom: {},
    byteImageMaxbytesTom: {},
    byteAnyTom: {},
    byteAnyRequiredTom: {
      required,
    },
    byteAnyMinbytesTom: {},
    byteAnyMaxbytesTom: {},
    byteTextTom: {},
    byteTextRequiredTom: {
      required,
    },
  },
};

@Component({
  validations,
})
export default class FieldTestEntityUpdate extends mixins(JhiDataUtils) {
  @Inject('fieldTestEntityService') private fieldTestEntityService: () => FieldTestEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestEntity: IFieldTestEntity = new FieldTestEntity();
  public enumFieldClassValues: string[] = Object.keys(EnumFieldClass);
  public enumRequiredFieldClassValues: string[] = Object.keys(EnumRequiredFieldClass);
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestEntityId) {
        vm.retrieveFieldTestEntity(to.params.fieldTestEntityId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.fieldTestEntity.id) {
      this.fieldTestEntityService()
        .update(this.fieldTestEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestEntity.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    } else {
      this.fieldTestEntityService()
        .create(this.fieldTestEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestEntity.created', { param: param.id });
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        })
        .catch(error => {
          this.isSaving = false;
          this.alertService().showHttpError(this, error.response);
        });
    }
  }

  public convertDateTimeFromServer(date: Date): string {
    if (date && dayjs(date).isValid()) {
      return dayjs(date).format(DATE_TIME_LONG_FORMAT);
    }
    return null;
  }

  public updateInstantField(field, event) {
    if (event.target.value) {
      this.fieldTestEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestEntity[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.fieldTestEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestEntity[field] = null;
    }
  }

  public retrieveFieldTestEntity(fieldTestEntityId): void {
    this.fieldTestEntityService()
      .find(fieldTestEntityId)
      .then(res => {
        res.instantTom = new Date(res.instantTom);
        res.instantRequiredTom = new Date(res.instantRequiredTom);
        res.zonedDateTimeTom = new Date(res.zonedDateTimeTom);
        res.zonedDateTimeRequiredTom = new Date(res.zonedDateTimeRequiredTom);
        this.fieldTestEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.fieldTestEntity && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.fieldTestEntity, field)) {
        this.fieldTestEntity[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.fieldTestEntity, fieldContentType)) {
        this.fieldTestEntity[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
