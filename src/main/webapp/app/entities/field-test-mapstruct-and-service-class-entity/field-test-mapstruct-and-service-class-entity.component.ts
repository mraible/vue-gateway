import { mixins } from 'vue-class-component';
import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IFieldTestMapstructAndServiceClassEntity } from '@/shared/model/field-test-mapstruct-and-service-class-entity.model';

import JhiDataUtils from '@/shared/data/data-utils.service';

import FieldTestMapstructAndServiceClassEntityService from './field-test-mapstruct-and-service-class-entity.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class FieldTestMapstructAndServiceClassEntity extends mixins(JhiDataUtils) {
  @Inject('fieldTestMapstructAndServiceClassEntityService')
  private fieldTestMapstructAndServiceClassEntityService: () => FieldTestMapstructAndServiceClassEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public fieldTestMapstructAndServiceClassEntities: IFieldTestMapstructAndServiceClassEntity[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllFieldTestMapstructAndServiceClassEntitys();
  }

  public clear(): void {
    this.retrieveAllFieldTestMapstructAndServiceClassEntitys();
  }

  public retrieveAllFieldTestMapstructAndServiceClassEntitys(): void {
    this.isFetching = true;
    this.fieldTestMapstructAndServiceClassEntityService()
      .retrieve()
      .then(
        res => {
          this.fieldTestMapstructAndServiceClassEntities = res.data;
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

  public prepareRemove(instance: IFieldTestMapstructAndServiceClassEntity): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeFieldTestMapstructAndServiceClassEntity(): void {
    this.fieldTestMapstructAndServiceClassEntityService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllFieldTestMapstructAndServiceClassEntitys();
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
