import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IFieldTestPaginationEntity } from '@/shared/model/field-test-pagination-entity.model';
import FieldTestPaginationEntityService from './field-test-pagination-entity.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class FieldTestPaginationEntityDetails extends mixins(JhiDataUtils) {
  @Inject('fieldTestPaginationEntityService') private fieldTestPaginationEntityService: () => FieldTestPaginationEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestPaginationEntity: IFieldTestPaginationEntity = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestPaginationEntityId) {
        vm.retrieveFieldTestPaginationEntity(to.params.fieldTestPaginationEntityId);
      }
    });
  }

  public retrieveFieldTestPaginationEntity(fieldTestPaginationEntityId) {
    this.fieldTestPaginationEntityService()
      .find(fieldTestPaginationEntityId)
      .then(res => {
        this.fieldTestPaginationEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
