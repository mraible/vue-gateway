import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, minLength, maxLength, numeric, minValue, maxValue, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';

import { IFieldTestServiceImplEntity, FieldTestServiceImplEntity } from '@/shared/model/field-test-service-impl-entity.model';
import FieldTestServiceImplEntityService from './field-test-service-impl-entity.service';
import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';

const validations: any = {
  fieldTestServiceImplEntity: {
    stringMika: {},
    stringRequiredMika: {
      required,
    },
    stringMinlengthMika: {
      minLength: minLength(0),
    },
    stringMaxlengthMika: {
      maxLength: maxLength(20),
    },
    stringPatternMika: {},
    integerMika: {},
    integerRequiredMika: {
      required,
      numeric,
    },
    integerMinMika: {
      numeric,
      min: minValue(0),
    },
    integerMaxMika: {
      numeric,
      max: maxValue(100),
    },
    longMika: {},
    longRequiredMika: {
      required,
      numeric,
    },
    longMinMika: {
      numeric,
      min: minValue(0),
    },
    longMaxMika: {
      numeric,
      max: maxValue(100),
    },
    floatMika: {},
    floatRequiredMika: {
      required,
      decimal,
    },
    floatMinMika: {
      decimal,
      min: minValue(0),
    },
    floatMaxMika: {
      decimal,
      max: maxValue(100),
    },
    doubleRequiredMika: {
      required,
      decimal,
    },
    doubleMinMika: {
      decimal,
      min: minValue(0),
    },
    doubleMaxMika: {
      decimal,
      max: maxValue(100),
    },
    bigDecimalRequiredMika: {
      required,
      decimal,
    },
    bigDecimalMinMika: {
      decimal,
      min: minValue(0),
    },
    bigDecimalMaxMika: {
      decimal,
      max: maxValue(100),
    },
    localDateMika: {},
    localDateRequiredMika: {
      required,
    },
    instantMika: {},
    instanteRequiredMika: {
      required,
    },
    zonedDateTimeMika: {},
    zonedDateTimeRequiredMika: {
      required,
    },
    durationMika: {},
    durationRequiredMika: {
      required,
    },
    booleanMika: {},
    booleanRequiredMika: {
      required,
    },
    enumMika: {},
    enumRequiredMika: {
      required,
    },
    uuidMika: {},
    uuidRequiredMika: {
      required,
    },
    byteImageMika: {},
    byteImageRequiredMika: {
      required,
    },
    byteImageMinbytesMika: {},
    byteImageMaxbytesMika: {},
    byteAnyMika: {},
    byteAnyRequiredMika: {
      required,
    },
    byteAnyMinbytesMika: {},
    byteAnyMaxbytesMika: {},
    byteTextMika: {},
    byteTextRequiredMika: {
      required,
    },
  },
};

@Component({
  validations,
})
export default class FieldTestServiceImplEntityUpdate extends mixins(JhiDataUtils) {
  @Inject('fieldTestServiceImplEntityService') private fieldTestServiceImplEntityService: () => FieldTestServiceImplEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestServiceImplEntity: IFieldTestServiceImplEntity = new FieldTestServiceImplEntity();
  public enumFieldClassValues: string[] = Object.keys(EnumFieldClass);
  public enumRequiredFieldClassValues: string[] = Object.keys(EnumRequiredFieldClass);
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestServiceImplEntityId) {
        vm.retrieveFieldTestServiceImplEntity(to.params.fieldTestServiceImplEntityId);
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
    if (this.fieldTestServiceImplEntity.id) {
      this.fieldTestServiceImplEntityService()
        .update(this.fieldTestServiceImplEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestServiceImplEntity.updated', { param: param.id });
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
      this.fieldTestServiceImplEntityService()
        .create(this.fieldTestServiceImplEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestServiceImplEntity.created', { param: param.id });
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
      this.fieldTestServiceImplEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestServiceImplEntity[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.fieldTestServiceImplEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestServiceImplEntity[field] = null;
    }
  }

  public retrieveFieldTestServiceImplEntity(fieldTestServiceImplEntityId): void {
    this.fieldTestServiceImplEntityService()
      .find(fieldTestServiceImplEntityId)
      .then(res => {
        res.instantMika = new Date(res.instantMika);
        res.instanteRequiredMika = new Date(res.instanteRequiredMika);
        res.zonedDateTimeMika = new Date(res.zonedDateTimeMika);
        res.zonedDateTimeRequiredMika = new Date(res.zonedDateTimeRequiredMika);
        this.fieldTestServiceImplEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.fieldTestServiceImplEntity && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.fieldTestServiceImplEntity, field)) {
        this.fieldTestServiceImplEntity[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.fieldTestServiceImplEntity, fieldContentType)) {
        this.fieldTestServiceImplEntity[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
