import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, minLength, maxLength, numeric, minValue, maxValue, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';

import { IFieldTestPaginationEntity, FieldTestPaginationEntity } from '@/shared/model/field-test-pagination-entity.model';
import FieldTestPaginationEntityService from './field-test-pagination-entity.service';
import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';

const validations: any = {
  fieldTestPaginationEntity: {
    stringAlice: {},
    stringRequiredAlice: {
      required,
    },
    stringMinlengthAlice: {
      minLength: minLength(0),
    },
    stringMaxlengthAlice: {
      maxLength: maxLength(20),
    },
    stringPatternAlice: {},
    integerAlice: {},
    integerRequiredAlice: {
      required,
      numeric,
    },
    integerMinAlice: {
      numeric,
      min: minValue(0),
    },
    integerMaxAlice: {
      numeric,
      max: maxValue(100),
    },
    longAlice: {},
    longRequiredAlice: {
      required,
      numeric,
    },
    longMinAlice: {
      numeric,
      min: minValue(0),
    },
    longMaxAlice: {
      numeric,
      max: maxValue(100),
    },
    floatAlice: {},
    floatRequiredAlice: {
      required,
      decimal,
    },
    floatMinAlice: {
      decimal,
      min: minValue(0),
    },
    floatMaxAlice: {
      decimal,
      max: maxValue(100),
    },
    doubleRequiredAlice: {
      required,
      decimal,
    },
    doubleMinAlice: {
      decimal,
      min: minValue(0),
    },
    doubleMaxAlice: {
      decimal,
      max: maxValue(100),
    },
    bigDecimalRequiredAlice: {
      required,
      decimal,
    },
    bigDecimalMinAlice: {
      decimal,
      min: minValue(0),
    },
    bigDecimalMaxAlice: {
      decimal,
      max: maxValue(100),
    },
    localDateAlice: {},
    localDateRequiredAlice: {
      required,
    },
    instantAlice: {},
    instanteRequiredAlice: {
      required,
    },
    zonedDateTimeAlice: {},
    zonedDateTimeRequiredAlice: {
      required,
    },
    durationAlice: {},
    durationRequiredAlice: {
      required,
    },
    booleanAlice: {},
    booleanRequiredAlice: {
      required,
    },
    enumAlice: {},
    enumRequiredAlice: {
      required,
    },
    uuidAlice: {},
    uuidRequiredAlice: {
      required,
    },
    byteImageAlice: {},
    byteImageRequiredAlice: {
      required,
    },
    byteImageMinbytesAlice: {},
    byteImageMaxbytesAlice: {},
    byteAnyAlice: {},
    byteAnyRequiredAlice: {
      required,
    },
    byteAnyMinbytesAlice: {},
    byteAnyMaxbytesAlice: {},
    byteTextAlice: {},
    byteTextRequiredAlice: {
      required,
    },
  },
};

@Component({
  validations,
})
export default class FieldTestPaginationEntityUpdate extends mixins(JhiDataUtils) {
  @Inject('fieldTestPaginationEntityService') private fieldTestPaginationEntityService: () => FieldTestPaginationEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestPaginationEntity: IFieldTestPaginationEntity = new FieldTestPaginationEntity();
  public enumFieldClassValues: string[] = Object.keys(EnumFieldClass);
  public enumRequiredFieldClassValues: string[] = Object.keys(EnumRequiredFieldClass);
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestPaginationEntityId) {
        vm.retrieveFieldTestPaginationEntity(to.params.fieldTestPaginationEntityId);
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
    if (this.fieldTestPaginationEntity.id) {
      this.fieldTestPaginationEntityService()
        .update(this.fieldTestPaginationEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestPaginationEntity.updated', { param: param.id });
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
      this.fieldTestPaginationEntityService()
        .create(this.fieldTestPaginationEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestPaginationEntity.created', { param: param.id });
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
      this.fieldTestPaginationEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestPaginationEntity[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.fieldTestPaginationEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestPaginationEntity[field] = null;
    }
  }

  public retrieveFieldTestPaginationEntity(fieldTestPaginationEntityId): void {
    this.fieldTestPaginationEntityService()
      .find(fieldTestPaginationEntityId)
      .then(res => {
        res.instantAlice = new Date(res.instantAlice);
        res.instanteRequiredAlice = new Date(res.instanteRequiredAlice);
        res.zonedDateTimeAlice = new Date(res.zonedDateTimeAlice);
        res.zonedDateTimeRequiredAlice = new Date(res.zonedDateTimeRequiredAlice);
        this.fieldTestPaginationEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.fieldTestPaginationEntity && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.fieldTestPaginationEntity, field)) {
        this.fieldTestPaginationEntity[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.fieldTestPaginationEntity, fieldContentType)) {
        this.fieldTestPaginationEntity[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
