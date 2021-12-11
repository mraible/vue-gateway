import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, minLength, maxLength, numeric, minValue, maxValue, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';

import {
  IFieldTestServiceClassAndJpaFilteringEntity,
  FieldTestServiceClassAndJpaFilteringEntity,
} from '@/shared/model/field-test-service-class-and-jpa-filtering-entity.model';
import FieldTestServiceClassAndJpaFilteringEntityService from './field-test-service-class-and-jpa-filtering-entity.service';
import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';

const validations: any = {
  fieldTestServiceClassAndJpaFilteringEntity: {
    stringBob: {},
    stringRequiredBob: {
      required,
    },
    stringMinlengthBob: {
      minLength: minLength(0),
    },
    stringMaxlengthBob: {
      maxLength: maxLength(20),
    },
    stringPatternBob: {},
    integerBob: {},
    integerRequiredBob: {
      required,
      numeric,
    },
    integerMinBob: {
      numeric,
      min: minValue(0),
    },
    integerMaxBob: {
      numeric,
      max: maxValue(100),
    },
    longBob: {},
    longRequiredBob: {
      required,
      numeric,
    },
    longMinBob: {
      numeric,
      min: minValue(0),
    },
    longMaxBob: {
      numeric,
      max: maxValue(100),
    },
    floatBob: {},
    floatRequiredBob: {
      required,
      decimal,
    },
    floatMinBob: {
      decimal,
      min: minValue(0),
    },
    floatMaxBob: {
      decimal,
      max: maxValue(100),
    },
    doubleRequiredBob: {
      required,
      decimal,
    },
    doubleMinBob: {
      decimal,
      min: minValue(0),
    },
    doubleMaxBob: {
      decimal,
      max: maxValue(100),
    },
    bigDecimalRequiredBob: {
      required,
      decimal,
    },
    bigDecimalMinBob: {
      decimal,
      min: minValue(0),
    },
    bigDecimalMaxBob: {
      decimal,
      max: maxValue(100),
    },
    localDateBob: {},
    localDateRequiredBob: {
      required,
    },
    instantBob: {},
    instanteRequiredBob: {
      required,
    },
    zonedDateTimeBob: {},
    zonedDateTimeRequiredBob: {
      required,
    },
    durationBob: {},
    durationRequiredBob: {
      required,
    },
    booleanBob: {},
    booleanRequiredBob: {
      required,
    },
    enumBob: {},
    enumRequiredBob: {
      required,
    },
    uuidBob: {},
    uuidRequiredBob: {
      required,
    },
    byteImageBob: {},
    byteImageRequiredBob: {
      required,
    },
    byteImageMinbytesBob: {},
    byteImageMaxbytesBob: {},
    byteAnyBob: {},
    byteAnyRequiredBob: {
      required,
    },
    byteAnyMinbytesBob: {},
    byteAnyMaxbytesBob: {},
    byteTextBob: {},
    byteTextRequiredBob: {
      required,
    },
  },
};

@Component({
  validations,
})
export default class FieldTestServiceClassAndJpaFilteringEntityUpdate extends mixins(JhiDataUtils) {
  @Inject('fieldTestServiceClassAndJpaFilteringEntityService')
  private fieldTestServiceClassAndJpaFilteringEntityService: () => FieldTestServiceClassAndJpaFilteringEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestServiceClassAndJpaFilteringEntity: IFieldTestServiceClassAndJpaFilteringEntity =
    new FieldTestServiceClassAndJpaFilteringEntity();
  public enumFieldClassValues: string[] = Object.keys(EnumFieldClass);
  public enumRequiredFieldClassValues: string[] = Object.keys(EnumRequiredFieldClass);
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestServiceClassAndJpaFilteringEntityId) {
        vm.retrieveFieldTestServiceClassAndJpaFilteringEntity(to.params.fieldTestServiceClassAndJpaFilteringEntityId);
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
    if (this.fieldTestServiceClassAndJpaFilteringEntity.id) {
      this.fieldTestServiceClassAndJpaFilteringEntityService()
        .update(this.fieldTestServiceClassAndJpaFilteringEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.updated', { param: param.id });
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
      this.fieldTestServiceClassAndJpaFilteringEntityService()
        .create(this.fieldTestServiceClassAndJpaFilteringEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.created', { param: param.id });
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
      this.fieldTestServiceClassAndJpaFilteringEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestServiceClassAndJpaFilteringEntity[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.fieldTestServiceClassAndJpaFilteringEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestServiceClassAndJpaFilteringEntity[field] = null;
    }
  }

  public retrieveFieldTestServiceClassAndJpaFilteringEntity(fieldTestServiceClassAndJpaFilteringEntityId): void {
    this.fieldTestServiceClassAndJpaFilteringEntityService()
      .find(fieldTestServiceClassAndJpaFilteringEntityId)
      .then(res => {
        res.instantBob = new Date(res.instantBob);
        res.instanteRequiredBob = new Date(res.instanteRequiredBob);
        res.zonedDateTimeBob = new Date(res.zonedDateTimeBob);
        res.zonedDateTimeRequiredBob = new Date(res.zonedDateTimeRequiredBob);
        this.fieldTestServiceClassAndJpaFilteringEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.fieldTestServiceClassAndJpaFilteringEntity && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.fieldTestServiceClassAndJpaFilteringEntity, field)) {
        this.fieldTestServiceClassAndJpaFilteringEntity[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.fieldTestServiceClassAndJpaFilteringEntity, fieldContentType)) {
        this.fieldTestServiceClassAndJpaFilteringEntity[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
