import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, minLength, maxLength, numeric, minValue, maxValue, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';

import {
  IFieldTestMapstructAndServiceClassEntity,
  FieldTestMapstructAndServiceClassEntity,
} from '@/shared/model/field-test-mapstruct-and-service-class-entity.model';
import FieldTestMapstructAndServiceClassEntityService from './field-test-mapstruct-and-service-class-entity.service';
import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';

const validations: any = {
  fieldTestMapstructAndServiceClassEntity: {
    stringEva: {},
    stringRequiredEva: {
      required,
    },
    stringMinlengthEva: {
      minLength: minLength(0),
    },
    stringMaxlengthEva: {
      maxLength: maxLength(20),
    },
    stringPatternEva: {},
    integerEva: {},
    integerRequiredEva: {
      required,
      numeric,
    },
    integerMinEva: {
      numeric,
      min: minValue(0),
    },
    integerMaxEva: {
      numeric,
      max: maxValue(100),
    },
    longEva: {},
    longRequiredEva: {
      required,
      numeric,
    },
    longMinEva: {
      numeric,
      min: minValue(0),
    },
    longMaxEva: {
      numeric,
      max: maxValue(100),
    },
    floatEva: {},
    floatRequiredEva: {
      required,
      decimal,
    },
    floatMinEva: {
      decimal,
      min: minValue(0),
    },
    floatMaxEva: {
      decimal,
      max: maxValue(100),
    },
    doubleRequiredEva: {
      required,
      decimal,
    },
    doubleMinEva: {
      decimal,
      min: minValue(0),
    },
    doubleMaxEva: {
      decimal,
      max: maxValue(100),
    },
    bigDecimalRequiredEva: {
      required,
      decimal,
    },
    bigDecimalMinEva: {
      decimal,
      min: minValue(0),
    },
    bigDecimalMaxEva: {
      decimal,
      max: maxValue(100),
    },
    localDateEva: {},
    localDateRequiredEva: {
      required,
    },
    instantEva: {},
    instanteRequiredEva: {
      required,
    },
    zonedDateTimeEva: {},
    zonedDateTimeRequiredEva: {
      required,
    },
    durationEva: {},
    durationRequiredEva: {
      required,
    },
    booleanEva: {},
    booleanRequiredEva: {
      required,
    },
    enumEva: {},
    enumRequiredEva: {
      required,
    },
    uuidEva: {},
    uuidRequiredEva: {
      required,
    },
    byteImageEva: {},
    byteImageRequiredEva: {
      required,
    },
    byteImageMinbytesEva: {},
    byteImageMaxbytesEva: {},
    byteAnyEva: {},
    byteAnyRequiredEva: {
      required,
    },
    byteAnyMinbytesEva: {},
    byteAnyMaxbytesEva: {},
    byteTextEva: {},
    byteTextRequiredEva: {
      required,
    },
  },
};

@Component({
  validations,
})
export default class FieldTestMapstructAndServiceClassEntityUpdate extends mixins(JhiDataUtils) {
  @Inject('fieldTestMapstructAndServiceClassEntityService')
  private fieldTestMapstructAndServiceClassEntityService: () => FieldTestMapstructAndServiceClassEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestMapstructAndServiceClassEntity: IFieldTestMapstructAndServiceClassEntity = new FieldTestMapstructAndServiceClassEntity();
  public enumFieldClassValues: string[] = Object.keys(EnumFieldClass);
  public enumRequiredFieldClassValues: string[] = Object.keys(EnumRequiredFieldClass);
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestMapstructAndServiceClassEntityId) {
        vm.retrieveFieldTestMapstructAndServiceClassEntity(to.params.fieldTestMapstructAndServiceClassEntityId);
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
    if (this.fieldTestMapstructAndServiceClassEntity.id) {
      this.fieldTestMapstructAndServiceClassEntityService()
        .update(this.fieldTestMapstructAndServiceClassEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.updated', { param: param.id });
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
      this.fieldTestMapstructAndServiceClassEntityService()
        .create(this.fieldTestMapstructAndServiceClassEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.created', { param: param.id });
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
      this.fieldTestMapstructAndServiceClassEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestMapstructAndServiceClassEntity[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.fieldTestMapstructAndServiceClassEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestMapstructAndServiceClassEntity[field] = null;
    }
  }

  public retrieveFieldTestMapstructAndServiceClassEntity(fieldTestMapstructAndServiceClassEntityId): void {
    this.fieldTestMapstructAndServiceClassEntityService()
      .find(fieldTestMapstructAndServiceClassEntityId)
      .then(res => {
        res.instantEva = new Date(res.instantEva);
        res.instanteRequiredEva = new Date(res.instanteRequiredEva);
        res.zonedDateTimeEva = new Date(res.zonedDateTimeEva);
        res.zonedDateTimeRequiredEva = new Date(res.zonedDateTimeRequiredEva);
        this.fieldTestMapstructAndServiceClassEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.fieldTestMapstructAndServiceClassEntity && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.fieldTestMapstructAndServiceClassEntity, field)) {
        this.fieldTestMapstructAndServiceClassEntity[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.fieldTestMapstructAndServiceClassEntity, fieldContentType)) {
        this.fieldTestMapstructAndServiceClassEntity[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
