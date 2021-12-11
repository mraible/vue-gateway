import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IFieldTestMapstructAndServiceClassEntity } from '@/shared/model/field-test-mapstruct-and-service-class-entity.model';
import FieldTestMapstructAndServiceClassEntityService from './field-test-mapstruct-and-service-class-entity.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class FieldTestMapstructAndServiceClassEntityDetails extends mixins(JhiDataUtils) {
  @Inject('fieldTestMapstructAndServiceClassEntityService')
  private fieldTestMapstructAndServiceClassEntityService: () => FieldTestMapstructAndServiceClassEntityService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestMapstructAndServiceClassEntity: IFieldTestMapstructAndServiceClassEntity = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestMapstructAndServiceClassEntityId) {
        vm.retrieveFieldTestMapstructAndServiceClassEntity(to.params.fieldTestMapstructAndServiceClassEntityId);
      }
    });
  }

  public retrieveFieldTestMapstructAndServiceClassEntity(fieldTestMapstructAndServiceClassEntityId) {
    this.fieldTestMapstructAndServiceClassEntityService()
      .find(fieldTestMapstructAndServiceClassEntityId)
      .then(res => {
        this.fieldTestMapstructAndServiceClassEntity = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
