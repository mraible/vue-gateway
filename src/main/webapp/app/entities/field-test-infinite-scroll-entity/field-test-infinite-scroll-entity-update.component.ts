import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { required, minLength, maxLength, numeric, minValue, maxValue, decimal } from 'vuelidate/lib/validators';
import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';

import { IFieldTestInfiniteScrollEntity, FieldTestInfiniteScrollEntity } from '@/shared/model/field-test-infinite-scroll-entity.model';
import FieldTestInfiniteScrollEntityService from './field-test-infinite-scroll-entity.service';
import { EnumFieldClass } from '@/shared/model/enumerations/enum-field-class.model';
import { EnumRequiredFieldClass } from '@/shared/model/enumerations/enum-required-field-class.model';

const validations: any = {
  fieldTestInfiniteScrollEntity: {
    stringHugo: {},
    stringRequiredHugo: {
      required,
    },
    stringMinlengthHugo: {
      minLength: minLength(0),
    },
    stringMaxlengthHugo: {
      maxLength: maxLength(20),
    },
    stringPatternHugo: {},
    integerHugo: {},
    integerRequiredHugo: {
      required,
      numeric,
    },
    integerMinHugo: {
      numeric,
      min: minValue(0),
    },
    integerMaxHugo: {
      numeric,
      max: maxValue(100),
    },
    longHugo: {},
    longRequiredHugo: {
      required,
      numeric,
    },
    longMinHugo: {
      numeric,
      min: minValue(0),
    },
    longMaxHugo: {
      numeric,
      max: maxValue(100),
    },
    floatHugo: {},
    floatRequiredHugo: {
      required,
      decimal,
    },
    floatMinHugo: {
      decimal,
      min: minValue(0),
    },
    floatMaxHugo: {
      decimal,
      max: maxValue(100),
    },
    doubleRequiredHugo: {
      required,
      decimal,
    },
    doubleMinHugo: {
      decimal,
      min: minValue(0),
    },
    doubleMaxHugo: {
      decimal,
      max: maxValue(100),
    },
    bigDecimalRequiredHugo: {
      required,
      decimal,
    },
    bigDecimalMinHugo: {
      decimal,
      min: minValue(0),
    },
    bigDecimalMaxHugo: {
      decimal,
      max: maxValue(100),
    },
    localDateHugo: {},
    localDateRequiredHugo: {
      required,
    },
    instantHugo: {},
    instanteRequiredHugo: {
      required,
    },
    zonedDateTimeHugo: {},
    zonedDateTimeRequiredHugo: {
      required,
    },
    durationHugo: {},
    durationRequiredHugo: {
      required,
    },
    booleanHugo: {},
    booleanRequiredHugo: {
      required,
    },
    enumHugo: {},
    enumRequiredHugo: {
      required,
    },
    uuidHugo: {},
    uuidRequiredHugo: {
      required,
    },
    byteImageHugo: {},
    byteImageRequiredHugo: {
      required,
    },
    byteImageMinbytesHugo: {},
    byteImageMaxbytesHugo: {},
    byteAnyHugo: {},
    byteAnyRequiredHugo: {
      required,
    },
    byteAnyMinbytesHugo: {},
    byteAnyMaxbytesHugo: {},
    byteTextHugo: {},
    byteTextRequiredHugo: {
      required,
    },
  },
};

@Component({
  validations,
})
export default class FieldTestInfiniteScrollEntityUpdate extends mixins(JhiDataUtils) {
  @Inject('fieldTestInfiniteScrollEntityService') private fieldTestInfiniteScrollEntityService: () => FieldTestInfiniteScrollEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestInfiniteScrollEntity: IFieldTestInfiniteScrollEntity = new FieldTestInfiniteScrollEntity();
  public enumFieldClassValues: string[] = Object.keys(EnumFieldClass);
  public enumRequiredFieldClassValues: string[] = Object.keys(EnumRequiredFieldClass);
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestInfiniteScrollEntityId) {
        vm.retrieveFieldTestInfiniteScrollEntity(to.params.fieldTestInfiniteScrollEntityId);
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
    if (this.fieldTestInfiniteScrollEntity.id) {
      this.fieldTestInfiniteScrollEntityService()
        .update(this.fieldTestInfiniteScrollEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestInfiniteScrollEntity.updated', { param: param.id });
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
      this.fieldTestInfiniteScrollEntityService()
        .create(this.fieldTestInfiniteScrollEntity)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestInfiniteScrollEntity.created', { param: param.id });
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
      this.fieldTestInfiniteScrollEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestInfiniteScrollEntity[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.fieldTestInfiniteScrollEntity[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.fieldTestInfiniteScrollEntity[field] = null;
    }
  }

  public retrieveFieldTestInfiniteScrollEntity(fieldTestInfiniteScrollEntityId): void {
    this.fieldTestInfiniteScrollEntityService()
      .find(fieldTestInfiniteScrollEntityId)
      .then(res => {
        res.instantHugo = new Date(res.instantHugo);
        res.instanteRequiredHugo = new Date(res.instanteRequiredHugo);
        res.zonedDateTimeHugo = new Date(res.zonedDateTimeHugo);
        res.zonedDateTimeRequiredHugo = new Date(res.zonedDateTimeRequiredHugo);
        this.fieldTestInfiniteScrollEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public clearInputImage(field, fieldContentType, idInput): void {
    if (this.fieldTestInfiniteScrollEntity && field && fieldContentType) {
      if (Object.prototype.hasOwnProperty.call(this.fieldTestInfiniteScrollEntity, field)) {
        this.fieldTestInfiniteScrollEntity[field] = null;
      }
      if (Object.prototype.hasOwnProperty.call(this.fieldTestInfiniteScrollEntity, fieldContentType)) {
        this.fieldTestInfiniteScrollEntity[fieldContentType] = null;
      }
      if (idInput) {
        (<any>this).$refs[idInput] = null;
      }
    }
  }

  public initRelationships(): void {}
}
