import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import {
  IEntityWithServiceClassAndPagination,
  EntityWithServiceClassAndPagination,
} from '@/shared/model/entity-with-service-class-and-pagination.model';
import EntityWithServiceClassAndPaginationService from './entity-with-service-class-and-pagination.service';

const validations: any = {
  entityWithServiceClassAndPagination: {
    enzo: {},
  },
};

@Component({
  validations,
})
export default class EntityWithServiceClassAndPaginationUpdate extends Vue {
  @Inject('entityWithServiceClassAndPaginationService')
  private entityWithServiceClassAndPaginationService: () => EntityWithServiceClassAndPaginationService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithServiceClassAndPagination: IEntityWithServiceClassAndPagination = new EntityWithServiceClassAndPagination();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithServiceClassAndPaginationId) {
        vm.retrieveEntityWithServiceClassAndPagination(to.params.entityWithServiceClassAndPaginationId);
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
    if (this.entityWithServiceClassAndPagination.id) {
      this.entityWithServiceClassAndPaginationService()
        .update(this.entityWithServiceClassAndPagination)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceClassAndPagination.updated', { param: param.id });
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
      this.entityWithServiceClassAndPaginationService()
        .create(this.entityWithServiceClassAndPagination)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceClassAndPagination.created', { param: param.id });
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

  public retrieveEntityWithServiceClassAndPagination(entityWithServiceClassAndPaginationId): void {
    this.entityWithServiceClassAndPaginationService()
      .find(entityWithServiceClassAndPaginationId)
      .then(res => {
        this.entityWithServiceClassAndPagination = res;
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
