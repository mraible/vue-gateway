import { mixins } from 'vue-class-component';
import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IFieldTestServiceImplEntity } from '@/shared/model/field-test-service-impl-entity.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import FieldTestServiceImplEntityService from './field-test-service-impl-entity.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class FieldTestServiceImplEntity extends mixins(JhiDataUtils) {
  @Inject('fieldTestServiceImplEntityService') private fieldTestServiceImplEntityService: () => FieldTestServiceImplEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public fieldTestServiceImplEntities: IFieldTestServiceImplEntity[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllFieldTestServiceImplEntitys();
  }

  public clear(): void {
    this.retrieveAllFieldTestServiceImplEntitys();
  }

  public retrieveAllFieldTestServiceImplEntitys(): void {
    this.isFetching = true;
    this.fieldTestServiceImplEntityService()
      .retrieve()
      .then(
        res => {
          this.fieldTestServiceImplEntities = res.data;
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

  public prepareRemove(instance: IFieldTestServiceImplEntity): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeFieldTestServiceImplEntity(): void {
    this.fieldTestServiceImplEntityService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.fieldTestServiceImplEntity.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllFieldTestServiceImplEntitys();
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
