import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFieldTestEnumWithValue } from '@/shared/model/field-test-enum-with-value.model';
import FieldTestEnumWithValueService from './field-test-enum-with-value.service';
import AlertService from '@/shared/alert/alert.service';

@Component
export default class FieldTestEnumWithValueDetails extends Vue {
  @Inject('fieldTestEnumWithValueService') private fieldTestEnumWithValueService: () => FieldTestEnumWithValueService;
  @Inject('alertService') private alertService: () => AlertService;

  public fieldTestEnumWithValue: IFieldTestEnumWithValue = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fieldTestEnumWithValueId) {
        vm.retrieveFieldTestEnumWithValue(to.params.fieldTestEnumWithValueId);
      }
    });
  }

  public retrieveFieldTestEnumWithValue(fieldTestEnumWithValueId) {
    this.fieldTestEnumWithValueService()
      .find(fieldTestEnumWithValueId)
      .then(res => {
        this.fieldTestEnumWithValue = res;
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
