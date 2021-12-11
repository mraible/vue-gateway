import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IEntityWithDTO } from '@/shared/model/entity-with-dto.model';

import EntityWithDTOService from './entity-with-dto.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class EntityWithDTO extends Vue {
  @Inject('entityWithDTOService') private entityWithDTOService: () => EntityWithDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public entityWithDTOS: IEntityWithDTO[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllEntityWithDTOs();
  }

  public clear(): void {
    this.retrieveAllEntityWithDTOs();
  }

  public retrieveAllEntityWithDTOs(): void {
    this.isFetching = true;
    this.entityWithDTOService()
      .retrieve()
      .then(
        res => {
          this.entityWithDTOS = res.data;
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

  public prepareRemove(instance: IEntityWithDTO): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeEntityWithDTO(): void {
    this.entityWithDTOService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.entityWithDTO.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllEntityWithDTOs();
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
