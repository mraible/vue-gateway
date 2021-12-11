import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IEntityWithServiceImplAndDTO, EntityWithServiceImplAndDTO } from '@/shared/model/entity-with-service-impl-and-dto.model';
import EntityWithServiceImplAndDTOService from './entity-with-service-impl-and-dto.service';

const validations: any = {
  entityWithServiceImplAndDTO: {
    louis: {},
  },
};

@Component({
  validations,
})
export default class EntityWithServiceImplAndDTOUpdate extends Vue {
  @Inject('entityWithServiceImplAndDTOService') private entityWithServiceImplAndDTOService: () => EntityWithServiceImplAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithServiceImplAndDTO: IEntityWithServiceImplAndDTO = new EntityWithServiceImplAndDTO();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithServiceImplAndDTOId) {
        vm.retrieveEntityWithServiceImplAndDTO(to.params.entityWithServiceImplAndDTOId);
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
    if (this.entityWithServiceImplAndDTO.id) {
      this.entityWithServiceImplAndDTOService()
        .update(this.entityWithServiceImplAndDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceImplAndDTO.updated', { param: param.id });
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
      this.entityWithServiceImplAndDTOService()
        .create(this.entityWithServiceImplAndDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceImplAndDTO.created', { param: param.id });
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

  public retrieveEntityWithServiceImplAndDTO(entityWithServiceImplAndDTOId): void {
    this.entityWithServiceImplAndDTOService()
      .find(entityWithServiceImplAndDTOId)
      .then(res => {
        this.entityWithServiceImplAndDTO = res;
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
