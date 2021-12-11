import { Component, Provide, Vue } from 'vue-property-decorator';

import OperationService from './test-root/operation/operation.service';
import FieldTestEntityService from './field-test-entity/field-test-entity.service';
import FieldTestInfiniteScrollEntityService from './field-test-infinite-scroll-entity/field-test-infinite-scroll-entity.service';
import FieldTestMapstructAndServiceClassEntityService from './field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity.service';
import FieldTestPaginationEntityService from './field-test-pagination-entity/field-test-pagination-entity.service';
import FieldTestServiceClassAndJpaFilteringEntityService from './field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity.service';
import FieldTestServiceImplEntityService from './field-test-service-impl-entity/field-test-service-impl-entity.service';
import EntityWithDTOService from './entity-with-dto/entity-with-dto.service';
import EntityWithServiceClassAndPaginationService from './entity-with-service-class-and-pagination/entity-with-service-class-and-pagination.service';
import EntityWithServiceImplAndPaginationService from './entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination.service';
import EntityWithServiceImplAndDTOService from './entity-with-service-impl-and-dto/entity-with-service-impl-and-dto.service';
import EntityWithPaginationAndDTOService from './entity-with-pagination-and-dto/entity-with-pagination-and-dto.service';
import EntityWithServiceClassPaginationAndDTOService from './entity-with-service-class-pagination-and-dto/entity-with-service-class-pagination-and-dto.service';
import EntityWithServiceImplPaginationAndDTOService from './entity-with-service-impl-pagination-and-dto/entity-with-service-impl-pagination-and-dto.service';
import MapsIdUserProfileWithDTOService from './maps-id-user-profile-with-dto/maps-id-user-profile-with-dto.service';
import FieldTestEnumWithValueService from './field-test-enum-with-value/field-test-enum-with-value.service';
import BankAccountMySuffixService from './test-root/bank-account-my-suffix/bank-account-my-suffix.service';
import LabelService from './test-root/label/label.service';
// jhipster-needle-add-entity-service-to-entities-component-import - JHipster will import entities services here

@Component
export default class Entities extends Vue {
  @Provide('operationService') private operationService = () => new OperationService();
  @Provide('fieldTestEntityService') private fieldTestEntityService = () => new FieldTestEntityService();
  @Provide('fieldTestInfiniteScrollEntityService') private fieldTestInfiniteScrollEntityService = () =>
    new FieldTestInfiniteScrollEntityService();
  @Provide('fieldTestMapstructAndServiceClassEntityService') private fieldTestMapstructAndServiceClassEntityService = () =>
    new FieldTestMapstructAndServiceClassEntityService();
  @Provide('fieldTestPaginationEntityService') private fieldTestPaginationEntityService = () => new FieldTestPaginationEntityService();
  @Provide('fieldTestServiceClassAndJpaFilteringEntityService') private fieldTestServiceClassAndJpaFilteringEntityService = () =>
    new FieldTestServiceClassAndJpaFilteringEntityService();
  @Provide('fieldTestServiceImplEntityService') private fieldTestServiceImplEntityService = () => new FieldTestServiceImplEntityService();
  @Provide('entityWithDTOService') private entityWithDTOService = () => new EntityWithDTOService();
  @Provide('entityWithServiceClassAndPaginationService') private entityWithServiceClassAndPaginationService = () =>
    new EntityWithServiceClassAndPaginationService();
  @Provide('entityWithServiceImplAndPaginationService') private entityWithServiceImplAndPaginationService = () =>
    new EntityWithServiceImplAndPaginationService();
  @Provide('entityWithServiceImplAndDTOService') private entityWithServiceImplAndDTOService = () =>
    new EntityWithServiceImplAndDTOService();
  @Provide('entityWithPaginationAndDTOService') private entityWithPaginationAndDTOService = () => new EntityWithPaginationAndDTOService();
  @Provide('entityWithServiceClassPaginationAndDTOService') private entityWithServiceClassPaginationAndDTOService = () =>
    new EntityWithServiceClassPaginationAndDTOService();
  @Provide('entityWithServiceImplPaginationAndDTOService') private entityWithServiceImplPaginationAndDTOService = () =>
    new EntityWithServiceImplPaginationAndDTOService();
  @Provide('mapsIdUserProfileWithDTOService') private mapsIdUserProfileWithDTOService = () => new MapsIdUserProfileWithDTOService();
  @Provide('fieldTestEnumWithValueService') private fieldTestEnumWithValueService = () => new FieldTestEnumWithValueService();
  @Provide('bankAccountService') private bankAccountService = () => new BankAccountMySuffixService();
  @Provide('labelService') private labelService = () => new LabelService();
  // jhipster-needle-add-entity-service-to-entities-component - JHipster will import entities services here
}
