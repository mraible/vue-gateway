import { Component, Vue, Inject } from 'vue-property-decorator';

import { IEntityWithServiceImplAndPagination } from '@/shared/model/entity-with-service-impl-and-pagination.model';
import EntityWithServiceImplAndPaginationService from './entity-with-service-impl-and-pagination.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class EntityWithServiceImplAndPaginationDetails extends Vue {
  @Inject('entityWithServiceImplAndPaginationService')
  private entityWithServiceImplAndPaginationService: () => EntityWithServiceImplAndPaginationService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithServiceImplAndPagination: IEntityWithServiceImplAndPagination = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithServiceImplAndPaginationId) {
        vm.retrieveEntityWithServiceImplAndPagination(to.params.entityWithServiceImplAndPaginationId);
      }
    });
  }

  public retrieveEntityWithServiceImplAndPagination(entityWithServiceImplAndPaginationId) {
    this.entityWithServiceImplAndPaginationService()
      .find(entityWithServiceImplAndPaginationId)
      .then(res => {
        this.entityWithServiceImplAndPagination = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
