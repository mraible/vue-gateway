import { mixins } from 'vue-class-component';
import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IFieldTestEntity } from '@/shared/model/field-test-entity.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import FieldTestEntityService from './field-test-entity.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class FieldTestEntity extends mixins(JhiDataUtils) {
  @Inject('fieldTestEntityService') private fieldTestEntityService: () => FieldTestEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public fieldTestEntities: IFieldTestEntity[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllFieldTestEntitys();
  }

  public clear(): void {
    this.retrieveAllFieldTestEntitys();
  }

  public retrieveAllFieldTestEntitys(): void {
    this.isFetching = true;
    this.fieldTestEntityService()
      .retrieve()
      .then(
        res => {
          this.fieldTestEntities = res.data;
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

  public prepareRemove(instance: IFieldTestEntity): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeFieldTestEntity(): void {
    this.fieldTestEntityService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.fieldTestEntity.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllFieldTestEntitys();
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
