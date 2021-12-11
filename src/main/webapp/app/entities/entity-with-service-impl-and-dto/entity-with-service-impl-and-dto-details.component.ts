import { Component, Vue, Inject } from 'vue-property-decorator';

import { IEntityWithServiceImplAndDTO } from '@/shared/model/entity-with-service-impl-and-dto.model';
import EntityWithServiceImplAndDTOService from './entity-with-service-impl-and-dto.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class EntityWithServiceImplAndDTODetails extends Vue {
  @Inject('entityWithServiceImplAndDTOService') private entityWithServiceImplAndDTOService: () => EntityWithServiceImplAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  public entityWithServiceImplAndDTO: IEntityWithServiceImplAndDTO = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.entityWithServiceImplAndDTOId) {
        vm.retrieveEntityWithServiceImplAndDTO(to.params.entityWithServiceImplAndDTOId);
      }
    });
  }

  public retrieveEntityWithServiceImplAndDTO(entityWithServiceImplAndDTOId) {
    this.entityWithServiceImplAndDTOService()
      .find(entityWithServiceImplAndDTOId)
      .then(res => {
        this.entityWithServiceImplAndDTO = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
