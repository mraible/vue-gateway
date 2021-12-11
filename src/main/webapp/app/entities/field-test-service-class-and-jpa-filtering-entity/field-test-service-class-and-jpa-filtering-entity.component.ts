import { mixins } from 'vue-class-component';
import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IFieldTestServiceClassAndJpaFilteringEntity } from '@/shared/model/field-test-service-class-and-jpa-filtering-entity.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import FieldTestServiceClassAndJpaFilteringEntityService from './field-test-service-class-and-jpa-filtering-entity.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class FieldTestServiceClassAndJpaFilteringEntity extends mixins(JhiDataUtils) {
  @Inject('fieldTestServiceClassAndJpaFilteringEntityService')
  private fieldTestServiceClassAndJpaFilteringEntityService: () => FieldTestServiceClassAndJpaFilteringEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public fieldTestServiceClassAndJpaFilteringEntities: IFieldTestServiceClassAndJpaFilteringEntity[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllFieldTestServiceClassAndJpaFilteringEntitys();
  }

  public clear(): void {
    this.retrieveAllFieldTestServiceClassAndJpaFilteringEntitys();
  }

  public retrieveAllFieldTestServiceClassAndJpaFilteringEntitys(): void {
    this.isFetching = true;
    this.fieldTestServiceClassAndJpaFilteringEntityService()
      .retrieve()
      .then(
        res => {
          this.fieldTestServiceClassAndJpaFilteringEntities = res.data;
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

  public prepareRemove(instance: IFieldTestServiceClassAndJpaFilteringEntity): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeFieldTestServiceClassAndJpaFilteringEntity(): void {
    this.fieldTestServiceClassAndJpaFilteringEntityService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllFieldTestServiceClassAndJpaFilteringEntitys();
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
