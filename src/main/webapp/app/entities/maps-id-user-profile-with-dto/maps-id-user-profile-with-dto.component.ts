import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IMapsIdUserProfileWithDTO } from '@/shared/model/maps-id-user-profile-with-dto.model';

import MapsIdUserProfileWithDTOService from './maps-id-user-profile-with-dto.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class MapsIdUserProfileWithDTO extends Vue {
  @Inject('mapsIdUserProfileWithDTOService') private mapsIdUserProfileWithDTOService: () => MapsIdUserProfileWithDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;

  public mapsIdUserProfileWithDTOS: IMapsIdUserProfileWithDTO[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllMapsIdUserProfileWithDTOs();
  }

  public clear(): void {
    this.retrieveAllMapsIdUserProfileWithDTOs();
  }

  public retrieveAllMapsIdUserProfileWithDTOs(): void {
    this.isFetching = true;
    this.mapsIdUserProfileWithDTOService()
      .retrieve()
      .then(
        res => {
          this.mapsIdUserProfileWithDTOS = res.data;
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

  public prepareRemove(instance: IMapsIdUserProfileWithDTO): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeMapsIdUserProfileWithDTO(): void {
    this.mapsIdUserProfileWithDTOService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.mapsIdUserProfileWithDTO.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllMapsIdUserProfileWithDTOs();
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
