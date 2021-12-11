import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IEntityWithDTO, EntityWithDTO } from '@/shared/model/entity-with-dto.model';
import EntityWithDTOService from './entity-with-dto.service';

const validations: any = {
  entityWithDTO: {
    emma: {},
  },
};

@Component({
  validations,
})
export default class EntityWithDTOUpdate extends Vue {
  @Inject('entityWithDTOService') private entityWithDTOService: () => EntityWithDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithDTO: IEntityWithDTO = new EntityWithDTO();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithDTOId) {
        vm.retrieveEntityWithDTO(to.params.entityWithDTOId);
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
    if (this.entityWithDTO.id) {
      this.entityWithDTOService()
        .update(this.entityWithDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithDTO.updated', { param: param.id });
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
      this.entityWithDTOService()
        .create(this.entityWithDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithDTO.created', { param: param.id });
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

  public retrieveEntityWithDTO(entityWithDTOId): void {
    this.entityWithDTOService()
      .find(entityWithDTOId)
      .then(res => {
        this.entityWithDTO = res;
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
