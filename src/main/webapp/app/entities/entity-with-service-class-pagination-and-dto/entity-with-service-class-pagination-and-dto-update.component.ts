import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import {
  IEntityWithServiceClassPaginationAndDTO,
  EntityWithServiceClassPaginationAndDTO,
} from '@/shared/model/entity-with-service-class-pagination-and-dto.model';
import EntityWithServiceClassPaginationAndDTOService from './entity-with-service-class-pagination-and-dto.service';

const validations: any = {
  entityWithServiceClassPaginationAndDTO: {
    lena: {},
  },
};

@Component({
  validations,
})
export default class EntityWithServiceClassPaginationAndDTOUpdate extends Vue {
  @Inject('entityWithServiceClassPaginationAndDTOService')
  private entityWithServiceClassPaginationAndDTOService: () => EntityWithServiceClassPaginationAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithServiceClassPaginationAndDTO: IEntityWithServiceClassPaginationAndDTO = new EntityWithServiceClassPaginationAndDTO();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithServiceClassPaginationAndDTOId) {
        vm.retrieveEntityWithServiceClassPaginationAndDTO(to.params.entityWithServiceClassPaginationAndDTOId);
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
    if (this.entityWithServiceClassPaginationAndDTO.id) {
      this.entityWithServiceClassPaginationAndDTOService()
        .update(this.entityWithServiceClassPaginationAndDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceClassPaginationAndDTO.updated', { param: param.id });
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
      this.entityWithServiceClassPaginationAndDTOService()
        .create(this.entityWithServiceClassPaginationAndDTO)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceClassPaginationAndDTO.created', { param: param.id });
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

  public retrieveEntityWithServiceClassPaginationAndDTO(entityWithServiceClassPaginationAndDTOId): void {
    this.entityWithServiceClassPaginationAndDTOService()
      .find(entityWithServiceClassPaginationAndDTOId)
      .then(res => {
        this.entityWithServiceClassPaginationAndDTO = res;
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
