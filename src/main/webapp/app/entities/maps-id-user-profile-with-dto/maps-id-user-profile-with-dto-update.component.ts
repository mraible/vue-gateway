import { Component, Vue, Inject } from 'vue-property-decorator';

import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';

import UserService from '@/admin/user-management/user-management.service';

import { IMapsIdUserProfileWithDTO, MapsIdUserProfileWithDTO } from '@/shared/model/maps-id-user-profile-with-dto.model';
import MapsIdUserProfileWithDTOService from './maps-id-user-profile-with-dto.service';

const validations: any = {
  mapsIdUserProfileWithDTO: {
    dateOfBirth: {},
  },
};

@Component({
  validations,
})
export default class MapsIdUserProfileWithDTOUpdate extends Vue {
  @Inject('mapsIdUserProfileWithDTOService') private mapsIdUserProfileWithDTOService: () => MapsIdUserProfileWithDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public mapsIdUserProfileWithDTO: IMapsIdUserProfileWithDTO = new MapsIdUserProfileWithDTO();

  @Inject('userService') private userService: () => UserService;

  public users: Array<any> = [];
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.mapsIdUserProfileWithDTOId) {
        vm.retrieveMapsIdUserProfileWithDTO(to.params.mapsIdUserProfileWithDTOId);
      }
      vm.initRelationships();
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
    if (this.mapsIdUserProfileWithDTO.id) {
      this.mapsIdUserProfileWithDTOService()
        .update(this.mapsIdUserProfileWithDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.mapsIdUserProfileWithDTO.updated', { param: param.id });
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
      this.mapsIdUserProfileWithDTOService()
        .create(this.mapsIdUserProfileWithDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.mapsIdUserProfileWithDTO.created', { param: param.id });
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
      this.mapsIdUserProfileWithDTO[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.mapsIdUserProfileWithDTO[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.mapsIdUserProfileWithDTO[field] = dayjs(event.target.value, DATE_TIME_LONG_FORMAT);
    } else {
      this.mapsIdUserProfileWithDTO[field] = null;
    }
  }

  public retrieveMapsIdUserProfileWithDTO(mapsIdUserProfileWithDTOId): void {
    this.mapsIdUserProfileWithDTOService()
      .find(mapsIdUserProfileWithDTOId)
      .then(res => {
        res.dateOfBirth = new Date(res.dateOfBirth);
        this.mapsIdUserProfileWithDTO = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.userService()
      .retrieve()
      .then(res => {
        this.users = res.data;
      });
  }
}
