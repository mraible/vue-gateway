import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IFieldTestEnumWithValue } from '@/shared/model/field-test-enum-with-value.model';

import FieldTestEnumWithValueService from './field-test-enum-with-value.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class FieldTestEnumWithValue extends Vue {
  @Inject('fieldTestEnumWithValueService') private fieldTestEnumWithValueService: () => FieldTestEnumWithValueService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public fieldTestEnumWithValues: IFieldTestEnumWithValue[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllFieldTestEnumWithValues();
  }

  public clear(): void {
    this.retrieveAllFieldTestEnumWithValues();
  }

  public retrieveAllFieldTestEnumWithValues(): void {
    this.isFetching = true;
    this.fieldTestEnumWithValueService()
      .retrieve()
      .then(
        res => {
          this.fieldTestEnumWithValues = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
          this.alertService().showHttpError(this, err.response);
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IFieldTestEnumWithValue): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeFieldTestEnumWithValue(): void {
    this.fieldTestEnumWithValueService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.fieldTestEnumWithValue.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllFieldTestEnumWithValues();
        this.closeDialog();
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
