import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IEntityWithServiceImplAndDTO } from '@/shared/model/entity-with-service-impl-and-dto.model';

import EntityWithServiceImplAndDTOService from './entity-with-service-impl-and-dto.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class EntityWithServiceImplAndDTO extends Vue {
  @Inject('entityWithServiceImplAndDTOService') private entityWithServiceImplAndDTOService: () => EntityWithServiceImplAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public entityWithServiceImplAndDTOS: IEntityWithServiceImplAndDTO[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllEntityWithServiceImplAndDTOs();
  }

  public clear(): void {
    this.retrieveAllEntityWithServiceImplAndDTOs();
  }

  public retrieveAllEntityWithServiceImplAndDTOs(): void {
    this.isFetching = true;
    this.entityWithServiceImplAndDTOService()
      .retrieve()
      .then(
        res => {
          this.entityWithServiceImplAndDTOS = res.data;
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

  public prepareRemove(instance: IEntityWithServiceImplAndDTO): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeEntityWithServiceImplAndDTO(): void {
    this.entityWithServiceImplAndDTOService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.entityWithServiceImplAndDTO.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllEntityWithServiceImplAndDTOs();
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
