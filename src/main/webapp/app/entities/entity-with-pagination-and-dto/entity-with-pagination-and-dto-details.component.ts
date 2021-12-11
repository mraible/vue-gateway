import { Component, Vue, Inject } from 'vue-property-decorator';

import { IEntityWithPaginationAndDTO } from '@/shared/model/entity-with-pagination-and-dto.model';
import EntityWithPaginationAndDTOService from './entity-with-pagination-and-dto.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class EntityWithPaginationAndDTODetails extends Vue {
  @Inject('entityWithPaginationAndDTOService') private entityWithPaginationAndDTOService: () => EntityWithPaginationAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithPaginationAndDTO: IEntityWithPaginationAndDTO = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithPaginationAndDTOId) {
        vm.retrieveEntityWithPaginationAndDTO(to.params.entityWithPaginationAndDTOId);
      }
    });
  }

  public retrieveEntityWithPaginationAndDTO(entityWithPaginationAndDTOId) {
    this.entityWithPaginationAndDTOService()
      .find(entityWithPaginationAndDTOId)
      .then(res => {
        this.entityWithPaginationAndDTO = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
