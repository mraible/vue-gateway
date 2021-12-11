import { Component, Vue, Inject } from 'vue-property-decorator';

import AlertService from '@/shared/alert/alert.service';

import {
  IEntityWithServiceImplAndPagination,
  EntityWithServiceImplAndPagination,
} from '@/shared/model/entity-with-service-impl-and-pagination.model';
import EntityWithServiceImplAndPaginationService from './entity-with-service-impl-and-pagination.service';

const validations: any = {
  entityWithServiceImplAndPagination: {
    hugo: {},
  },
};

@Component({
  validations,
})
export default class EntityWithServiceImplAndPaginationUpdate extends Vue {
  @Inject('entityWithServiceImplAndPaginationService')
  private entityWithServiceImplAndPaginationService: () => EntityWithServiceImplAndPaginationService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithServiceImplAndPagination: IEntityWithServiceImplAndPagination = new EntityWithServiceImplAndPagination();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithServiceImplAndPaginationId) {
        vm.retrieveEntityWithServiceImplAndPagination(to.params.entityWithServiceImplAndPaginationId);
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
    if (this.entityWithServiceImplAndPagination.id) {
      this.entityWithServiceImplAndPaginationService()
        .update(this.entityWithServiceImplAndPagination)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceImplAndPagination.updated', { param: param.id });
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
      this.entityWithServiceImplAndPaginationService()
        .create(this.entityWithServiceImplAndPagination)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterApp.entityWithServiceImplAndPagination.created', { param: param.id });
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

  public retrieveEntityWithServiceImplAndPagination(entityWithServiceImplAndPaginationId): void {
    this.entityWithServiceImplAndPaginationService()
      .find(entityWithServiceImplAndPaginationId)
      .then(res => {
        this.entityWithServiceImplAndPagination = res;
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
