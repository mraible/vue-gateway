import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import {
  IEntityWithServiceImplPaginationAndDTO,
  EntityWithServiceImplPaginationAndDTO,
} from '@/shared/model/entity-with-service-impl-pagination-and-dto.model';
import EntityWithServiceImplPaginationAndDTOService from './entity-with-service-impl-pagination-and-dto.service';

const validations: any = {
  entityWithServiceImplPaginationAndDTO: {
    theo: {},
  },
};

@Component({
  validations,
})
export default class EntityWithServiceImplPaginationAndDTOUpdate extends Vue {
  @Inject('entityWithServiceImplPaginationAndDTOService')
  private entityWithServiceImplPaginationAndDTOService: () => EntityWithServiceImplPaginationAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithServiceImplPaginationAndDTO: IEntityWithServiceImplPaginationAndDTO = new EntityWithServiceImplPaginationAndDTO();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithServiceImplPaginationAndDTOId) {
        vm.retrieveEntityWithServiceImplPaginationAndDTO(to.params.entityWithServiceImplPaginationAndDTOId);
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
    if (this.entityWithServiceImplPaginationAndDTO.id) {
      this.entityWithServiceImplPaginationAndDTOService()
        .update(this.entityWithServiceImplPaginationAndDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.updated', { param: param.id });
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
      this.entityWithServiceImplPaginationAndDTOService()
        .create(this.entityWithServiceImplPaginationAndDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.created', { param: param.id });
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

  public retrieveEntityWithServiceImplPaginationAndDTO(entityWithServiceImplPaginationAndDTOId): void {
    this.entityWithServiceImplPaginationAndDTOService()
      .find(entityWithServiceImplPaginationAndDTOId)
      .then(res => {
        this.entityWithServiceImplPaginationAndDTO = res;
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
