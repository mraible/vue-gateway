import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IFieldTestServiceClassAndJpaFilteringEntity } from '@/shared/model/field-test-service-class-and-jpa-filtering-entity.model';
import FieldTestServiceClassAndJpaFilteringEntityService from './field-test-service-class-and-jpa-filtering-entity.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class FieldTestServiceClassAndJpaFilteringEntityDetails extends mixins(JhiDataUtils) {
  @Inject('fieldTestServiceClassAndJpaFilteringEntityService')
  private fieldTestServiceClassAndJpaFilteringEntityService: () => FieldTestServiceClassAndJpaFilteringEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestServiceClassAndJpaFilteringEntity: IFieldTestServiceClassAndJpaFilteringEntity = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestServiceClassAndJpaFilteringEntityId) {
        vm.retrieveFieldTestServiceClassAndJpaFilteringEntity(to.params.fieldTestServiceClassAndJpaFilteringEntityId);
      }
    });
  }

  public retrieveFieldTestServiceClassAndJpaFilteringEntity(fieldTestServiceClassAndJpaFilteringEntityId) {
    this.fieldTestServiceClassAndJpaFilteringEntityService()
      .find(fieldTestServiceClassAndJpaFilteringEntityId)
      .then(res => {
        this.fieldTestServiceClassAndJpaFilteringEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
