import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IFieldTestServiceImplEntity } from '@/shared/model/field-test-service-impl-entity.model';
import FieldTestServiceImplEntityService from './field-test-service-impl-entity.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class FieldTestServiceImplEntityDetails extends mixins(JhiDataUtils) {
  @Inject('fieldTestServiceImplEntityService') private fieldTestServiceImplEntityService: () => FieldTestServiceImplEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestServiceImplEntity: IFieldTestServiceImplEntity = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestServiceImplEntityId) {
        vm.retrieveFieldTestServiceImplEntity(to.params.fieldTestServiceImplEntityId);
      }
    });
  }

  public retrieveFieldTestServiceImplEntity(fieldTestServiceImplEntityId) {
    this.fieldTestServiceImplEntityService()
      .find(fieldTestServiceImplEntityId)
      .then(res => {
        this.fieldTestServiceImplEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
