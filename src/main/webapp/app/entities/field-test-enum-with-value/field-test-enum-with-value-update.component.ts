import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IFieldTestEnumWithValue, FieldTestEnumWithValue } from '@/shared/model/field-test-enum-with-value.model';
import FieldTestEnumWithValueService from './field-test-enum-with-value.service';
import { MyEnumA } from '@/shared/model/enumerations/my-enum-a.model';
import { MyEnumB } from '@/shared/model/enumerations/my-enum-b.model';
import { MyEnumC } from '@/shared/model/enumerations/my-enum-c.model';

const validations: any = {
  fieldTestEnumWithValue: {
    myFieldA: {},
    myFieldB: {},
    myFieldC: {},
  },
};

@Component({
  validations,
})
export default class FieldTestEnumWithValueUpdate extends Vue {
  @Inject('fieldTestEnumWithValueService') private fieldTestEnumWithValueService: () => FieldTestEnumWithValueService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestEnumWithValue: IFieldTestEnumWithValue = new FieldTestEnumWithValue();
  public myEnumAValues: string[] = Object.keys(MyEnumA);
  public myEnumBValues: string[] = Object.keys(MyEnumB);
  public myEnumCValues: string[] = Object.keys(MyEnumC);
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestEnumWithValueId) {
        vm.retrieveFieldTestEnumWithValue(to.params.fieldTestEnumWithValueId);
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
    if (this.fieldTestEnumWithValue.id) {
      this.fieldTestEnumWithValueService()
        .update(this.fieldTestEnumWithValue)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestEnumWithValue.updated', { param: param.id });
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
      this.fieldTestEnumWithValueService()
        .create(this.fieldTestEnumWithValue)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.fieldTestEnumWithValue.created', { param: param.id });
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

  public retrieveFieldTestEnumWithValue(fieldTestEnumWithValueId): void {
    this.fieldTestEnumWithValueService()
      .find(fieldTestEnumWithValueId)
      .then(res => {
        this.fieldTestEnumWithValue = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
