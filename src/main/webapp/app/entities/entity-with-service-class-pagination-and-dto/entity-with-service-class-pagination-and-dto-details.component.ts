import { Component, Vue, Inject } from 'vue-property-decorator';

import { IEntityWithServiceClassPaginationAndDTO } from '@/shared/model/entity-with-service-class-pagination-and-dto.model';
import EntityWithServiceClassPaginationAndDTOService from './entity-with-service-class-pagination-and-dto.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class EntityWithServiceClassPaginationAndDTODetails extends Vue {
  @Inject('entityWithServiceClassPaginationAndDTOService')
  private entityWithServiceClassPaginationAndDTOService: () => EntityWithServiceClassPaginationAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithServiceClassPaginationAndDTO: IEntityWithServiceClassPaginationAndDTO = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithServiceClassPaginationAndDTOId) {
        vm.retrieveEntityWithServiceClassPaginationAndDTO(to.params.entityWithServiceClassPaginationAndDTOId);
      }
    });
  }

  public retrieveEntityWithServiceClassPaginationAndDTO(entityWithServiceClassPaginationAndDTOId) {
    this.entityWithServiceClassPaginationAndDTOService()
      .find(entityWithServiceClassPaginationAndDTOId)
      .then(res => {
        this.entityWithServiceClassPaginationAndDTO = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
