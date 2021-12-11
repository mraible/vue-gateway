import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import { IEntityWithPaginationAndDTO, EntityWithPaginationAndDTO } from '@/shared/model/entity-with-pagination-and-dto.model';
import EntityWithPaginationAndDTOService from './entity-with-pagination-and-dto.service';

const validations: any = {
  entityWithPaginationAndDTO: {
    lea: {},
  },
};

@Component({
  validations,
})
export default class EntityWithPaginationAndDTOUpdate extends Vue {
  @Inject('entityWithPaginationAndDTOService') private entityWithPaginationAndDTOService: () => EntityWithPaginationAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithPaginationAndDTO: IEntityWithPaginationAndDTO = new EntityWithPaginationAndDTO();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithPaginationAndDTOId) {
        vm.retrieveEntityWithPaginationAndDTO(to.params.entityWithPaginationAndDTOId);
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
    if (this.entityWithPaginationAndDTO.id) {
      this.entityWithPaginationAndDTOService()
        .update(this.entityWithPaginationAndDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithPaginationAndDTO.updated', { param: param.id });
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
      this.entityWithPaginationAndDTOService()
        .create(this.entityWithPaginationAndDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithPaginationAndDTO.created', { param: param.id });
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

  public retrieveEntityWithPaginationAndDTO(entityWithPaginationAndDTOId): void {
    this.entityWithPaginationAndDTOService()
      .find(entityWithPaginationAndDTOId)
      .then(res => {
        this.entityWithPaginationAndDTO = res;
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
