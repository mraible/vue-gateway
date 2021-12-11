import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore
const Entities = () => import('@/entities/entities.vue');

const Operation = () => import('@/entities/test-root/operation/operation.vue');
const OperationUpdate = () => import('@/entities/test-root/operation/operation-update.vue');
const OperationDetails = () => import('@/entities/test-root/operation/operation-details.vue');

const FieldTestEntity = () => import('@/entities/field-test-entity/field-test-entity.vue');
const FieldTestEntityUpdate = () => import('@/entities/field-test-entity/field-test-entity-update.vue');
const FieldTestEntityDetails = () => import('@/entities/field-test-entity/field-test-entity-details.vue');

const FieldTestInfiniteScrollEntity = () => import('@/entities/field-test-infinite-scroll-entity/field-test-infinite-scroll-entity.vue');
const FieldTestInfiniteScrollEntityUpdate = () =>
  import('@/entities/field-test-infinite-scroll-entity/field-test-infinite-scroll-entity-update.vue');
const FieldTestInfiniteScrollEntityDetails = () =>
  import('@/entities/field-test-infinite-scroll-entity/field-test-infinite-scroll-entity-details.vue');

const FieldTestMapstructAndServiceClassEntity = () =>
  import('@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity.vue');
const FieldTestMapstructAndServiceClassEntityUpdate = () =>
  import('@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity-update.vue');
const FieldTestMapstructAndServiceClassEntityDetails = () =>
  import('@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity-details.vue');

const FieldTestPaginationEntity = () => import('@/entities/field-test-pagination-entity/field-test-pagination-entity.vue');
const FieldTestPaginationEntityUpdate = () => import('@/entities/field-test-pagination-entity/field-test-pagination-entity-update.vue');
const FieldTestPaginationEntityDetails = () => import('@/entities/field-test-pagination-entity/field-test-pagination-entity-details.vue');

const FieldTestServiceClassAndJpaFilteringEntity = () =>
  import('@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity.vue');
const FieldTestServiceClassAndJpaFilteringEntityUpdate = () =>
  import('@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity-update.vue');
const FieldTestServiceClassAndJpaFilteringEntityDetails = () =>
  import('@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity-details.vue');

const FieldTestServiceImplEntity = () => import('@/entities/field-test-service-impl-entity/field-test-service-impl-entity.vue');
const FieldTestServiceImplEntityUpdate = () =>
  import('@/entities/field-test-service-impl-entity/field-test-service-impl-entity-update.vue');
const FieldTestServiceImplEntityDetails = () =>
  import('@/entities/field-test-service-impl-entity/field-test-service-impl-entity-details.vue');

const EntityWithDTO = () => import('@/entities/entity-with-dto/entity-with-dto.vue');
const EntityWithDTOUpdate = () => import('@/entities/entity-with-dto/entity-with-dto-update.vue');
const EntityWithDTODetails = () => import('@/entities/entity-with-dto/entity-with-dto-details.vue');

const EntityWithServiceClassAndPagination = () =>
  import('@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination.vue');
const EntityWithServiceClassAndPaginationUpdate = () =>
  import('@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination-update.vue');
const EntityWithServiceClassAndPaginationDetails = () =>
  import('@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination-details.vue');

const EntityWithServiceImplAndPagination = () =>
  import('@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination.vue');
const EntityWithServiceImplAndPaginationUpdate = () =>
  import('@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination-update.vue');
const EntityWithServiceImplAndPaginationDetails = () =>
  import('@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination-details.vue');

const EntityWithServiceImplAndDTO = () => import('@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto.vue');
const EntityWithServiceImplAndDTOUpdate = () =>
  import('@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto-update.vue');
const EntityWithServiceImplAndDTODetails = () =>
  import('@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto-details.vue');

const EntityWithPaginationAndDTO = () => import('@/entities/entity-with-pagination-and-dto/entity-with-pagination-and-dto.vue');
const EntityWithPaginationAndDTOUpdate = () =>
  import('@/entities/entity-with-pagination-and-dto/entity-with-pagination-and-dto-update.vue');
const EntityWithPaginationAndDTODetails = () =>
  import('@/entities/entity-with-pagination-and-dto/entity-with-pagination-and-dto-details.vue');

const EntityWithServiceClassPaginationAndDTO = () =>
  import('@/entities/entity-with-service-class-pagination-and-dto/entity-with-service-class-pagination-and-dto.vue');
const EntityWithServiceClassPaginationAndDTOUpdate = () =>
  import('@/entities/entity-with-service-class-pagination-and-dto/entity-with-service-class-pagination-and-dto-update.vue');
const EntityWithServiceClassPaginationAndDTODetails = () =>
  import('@/entities/entity-with-service-class-pagination-and-dto/entity-with-service-class-pagination-and-dto-details.vue');

const EntityWithServiceImplPaginationAndDTO = () =>
  import('@/entities/entity-with-service-impl-pagination-and-dto/entity-with-service-impl-pagination-and-dto.vue');
const EntityWithServiceImplPaginationAndDTOUpdate = () =>
  import('@/entities/entity-with-service-impl-pagination-and-dto/entity-with-service-impl-pagination-and-dto-update.vue');
const EntityWithServiceImplPaginationAndDTODetails = () =>
  import('@/entities/entity-with-service-impl-pagination-and-dto/entity-with-service-impl-pagination-and-dto-details.vue');

const MapsIdUserProfileWithDTO = () => import('@/entities/maps-id-user-profile-with-dto/maps-id-user-profile-with-dto.vue');
const MapsIdUserProfileWithDTOUpdate = () => import('@/entities/maps-id-user-profile-with-dto/maps-id-user-profile-with-dto-update.vue');
const MapsIdUserProfileWithDTODetails = () => import('@/entities/maps-id-user-profile-with-dto/maps-id-user-profile-with-dto-details.vue');

const FieldTestEnumWithValue = () => import('@/entities/field-test-enum-with-value/field-test-enum-with-value.vue');
const FieldTestEnumWithValueUpdate = () => import('@/entities/field-test-enum-with-value/field-test-enum-with-value-update.vue');
const FieldTestEnumWithValueDetails = () => import('@/entities/field-test-enum-with-value/field-test-enum-with-value-details.vue');

const BankAccountMySuffix = () => import('@/entities/test-root/bank-account-my-suffix/bank-account-my-suffix.vue');
const BankAccountMySuffixUpdate = () => import('@/entities/test-root/bank-account-my-suffix/bank-account-my-suffix-update.vue');
const BankAccountMySuffixDetails = () => import('@/entities/test-root/bank-account-my-suffix/bank-account-my-suffix-details.vue');

const Label = () => import('@/entities/test-root/label/label.vue');
const LabelDetails = () => import('@/entities/test-root/label/label-details.vue');

// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default {
  path: '/',
  component: Entities,
  children: [
    {
      path: 'operation',
      name: 'Operation',
      component: Operation,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'operation/new',
      name: 'OperationCreate',
      component: OperationUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'operation/:operationId/edit',
      name: 'OperationEdit',
      component: OperationUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'operation/:operationId/view',
      name: 'OperationView',
      component: OperationDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-entity',
      name: 'FieldTestEntity',
      component: FieldTestEntity,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-entity/new',
      name: 'FieldTestEntityCreate',
      component: FieldTestEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-entity/:fieldTestEntityId/edit',
      name: 'FieldTestEntityEdit',
      component: FieldTestEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-entity/:fieldTestEntityId/view',
      name: 'FieldTestEntityView',
      component: FieldTestEntityDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-infinite-scroll-entity',
      name: 'FieldTestInfiniteScrollEntity',
      component: FieldTestInfiniteScrollEntity,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-infinite-scroll-entity/new',
      name: 'FieldTestInfiniteScrollEntityCreate',
      component: FieldTestInfiniteScrollEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-infinite-scroll-entity/:fieldTestInfiniteScrollEntityId/edit',
      name: 'FieldTestInfiniteScrollEntityEdit',
      component: FieldTestInfiniteScrollEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-infinite-scroll-entity/:fieldTestInfiniteScrollEntityId/view',
      name: 'FieldTestInfiniteScrollEntityView',
      component: FieldTestInfiniteScrollEntityDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-mapstruct-and-service-class-entity',
      name: 'FieldTestMapstructAndServiceClassEntity',
      component: FieldTestMapstructAndServiceClassEntity,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-mapstruct-and-service-class-entity/new',
      name: 'FieldTestMapstructAndServiceClassEntityCreate',
      component: FieldTestMapstructAndServiceClassEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-mapstruct-and-service-class-entity/:fieldTestMapstructAndServiceClassEntityId/edit',
      name: 'FieldTestMapstructAndServiceClassEntityEdit',
      component: FieldTestMapstructAndServiceClassEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-mapstruct-and-service-class-entity/:fieldTestMapstructAndServiceClassEntityId/view',
      name: 'FieldTestMapstructAndServiceClassEntityView',
      component: FieldTestMapstructAndServiceClassEntityDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-pagination-entity',
      name: 'FieldTestPaginationEntity',
      component: FieldTestPaginationEntity,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-pagination-entity/new',
      name: 'FieldTestPaginationEntityCreate',
      component: FieldTestPaginationEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-pagination-entity/:fieldTestPaginationEntityId/edit',
      name: 'FieldTestPaginationEntityEdit',
      component: FieldTestPaginationEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-pagination-entity/:fieldTestPaginationEntityId/view',
      name: 'FieldTestPaginationEntityView',
      component: FieldTestPaginationEntityDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-service-class-and-jpa-filtering-entity',
      name: 'FieldTestServiceClassAndJpaFilteringEntity',
      component: FieldTestServiceClassAndJpaFilteringEntity,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-service-class-and-jpa-filtering-entity/new',
      name: 'FieldTestServiceClassAndJpaFilteringEntityCreate',
      component: FieldTestServiceClassAndJpaFilteringEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-service-class-and-jpa-filtering-entity/:fieldTestServiceClassAndJpaFilteringEntityId/edit',
      name: 'FieldTestServiceClassAndJpaFilteringEntityEdit',
      component: FieldTestServiceClassAndJpaFilteringEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-service-class-and-jpa-filtering-entity/:fieldTestServiceClassAndJpaFilteringEntityId/view',
      name: 'FieldTestServiceClassAndJpaFilteringEntityView',
      component: FieldTestServiceClassAndJpaFilteringEntityDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-service-impl-entity',
      name: 'FieldTestServiceImplEntity',
      component: FieldTestServiceImplEntity,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-service-impl-entity/new',
      name: 'FieldTestServiceImplEntityCreate',
      component: FieldTestServiceImplEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-service-impl-entity/:fieldTestServiceImplEntityId/edit',
      name: 'FieldTestServiceImplEntityEdit',
      component: FieldTestServiceImplEntityUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-service-impl-entity/:fieldTestServiceImplEntityId/view',
      name: 'FieldTestServiceImplEntityView',
      component: FieldTestServiceImplEntityDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-dto',
      name: 'EntityWithDTO',
      component: EntityWithDTO,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-dto/new',
      name: 'EntityWithDTOCreate',
      component: EntityWithDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-dto/:entityWithDTOId/edit',
      name: 'EntityWithDTOEdit',
      component: EntityWithDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-dto/:entityWithDTOId/view',
      name: 'EntityWithDTOView',
      component: EntityWithDTODetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-class-and-pagination',
      name: 'EntityWithServiceClassAndPagination',
      component: EntityWithServiceClassAndPagination,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-class-and-pagination/new',
      name: 'EntityWithServiceClassAndPaginationCreate',
      component: EntityWithServiceClassAndPaginationUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-class-and-pagination/:entityWithServiceClassAndPaginationId/edit',
      name: 'EntityWithServiceClassAndPaginationEdit',
      component: EntityWithServiceClassAndPaginationUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-class-and-pagination/:entityWithServiceClassAndPaginationId/view',
      name: 'EntityWithServiceClassAndPaginationView',
      component: EntityWithServiceClassAndPaginationDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-and-pagination',
      name: 'EntityWithServiceImplAndPagination',
      component: EntityWithServiceImplAndPagination,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-and-pagination/new',
      name: 'EntityWithServiceImplAndPaginationCreate',
      component: EntityWithServiceImplAndPaginationUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-and-pagination/:entityWithServiceImplAndPaginationId/edit',
      name: 'EntityWithServiceImplAndPaginationEdit',
      component: EntityWithServiceImplAndPaginationUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-and-pagination/:entityWithServiceImplAndPaginationId/view',
      name: 'EntityWithServiceImplAndPaginationView',
      component: EntityWithServiceImplAndPaginationDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-and-dto',
      name: 'EntityWithServiceImplAndDTO',
      component: EntityWithServiceImplAndDTO,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-and-dto/new',
      name: 'EntityWithServiceImplAndDTOCreate',
      component: EntityWithServiceImplAndDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-and-dto/:entityWithServiceImplAndDTOId/edit',
      name: 'EntityWithServiceImplAndDTOEdit',
      component: EntityWithServiceImplAndDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-and-dto/:entityWithServiceImplAndDTOId/view',
      name: 'EntityWithServiceImplAndDTOView',
      component: EntityWithServiceImplAndDTODetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-pagination-and-dto',
      name: 'EntityWithPaginationAndDTO',
      component: EntityWithPaginationAndDTO,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-pagination-and-dto/new',
      name: 'EntityWithPaginationAndDTOCreate',
      component: EntityWithPaginationAndDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-pagination-and-dto/:entityWithPaginationAndDTOId/edit',
      name: 'EntityWithPaginationAndDTOEdit',
      component: EntityWithPaginationAndDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-pagination-and-dto/:entityWithPaginationAndDTOId/view',
      name: 'EntityWithPaginationAndDTOView',
      component: EntityWithPaginationAndDTODetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-class-pagination-and-dto',
      name: 'EntityWithServiceClassPaginationAndDTO',
      component: EntityWithServiceClassPaginationAndDTO,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-class-pagination-and-dto/new',
      name: 'EntityWithServiceClassPaginationAndDTOCreate',
      component: EntityWithServiceClassPaginationAndDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-class-pagination-and-dto/:entityWithServiceClassPaginationAndDTOId/edit',
      name: 'EntityWithServiceClassPaginationAndDTOEdit',
      component: EntityWithServiceClassPaginationAndDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-class-pagination-and-dto/:entityWithServiceClassPaginationAndDTOId/view',
      name: 'EntityWithServiceClassPaginationAndDTOView',
      component: EntityWithServiceClassPaginationAndDTODetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-pagination-and-dto',
      name: 'EntityWithServiceImplPaginationAndDTO',
      component: EntityWithServiceImplPaginationAndDTO,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-pagination-and-dto/new',
      name: 'EntityWithServiceImplPaginationAndDTOCreate',
      component: EntityWithServiceImplPaginationAndDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-pagination-and-dto/:entityWithServiceImplPaginationAndDTOId/edit',
      name: 'EntityWithServiceImplPaginationAndDTOEdit',
      component: EntityWithServiceImplPaginationAndDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'entity-with-service-impl-pagination-and-dto/:entityWithServiceImplPaginationAndDTOId/view',
      name: 'EntityWithServiceImplPaginationAndDTOView',
      component: EntityWithServiceImplPaginationAndDTODetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'maps-id-user-profile-with-dto',
      name: 'MapsIdUserProfileWithDTO',
      component: MapsIdUserProfileWithDTO,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'maps-id-user-profile-with-dto/new',
      name: 'MapsIdUserProfileWithDTOCreate',
      component: MapsIdUserProfileWithDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'maps-id-user-profile-with-dto/:mapsIdUserProfileWithDTOId/edit',
      name: 'MapsIdUserProfileWithDTOEdit',
      component: MapsIdUserProfileWithDTOUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'maps-id-user-profile-with-dto/:mapsIdUserProfileWithDTOId/view',
      name: 'MapsIdUserProfileWithDTOView',
      component: MapsIdUserProfileWithDTODetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-enum-with-value',
      name: 'FieldTestEnumWithValue',
      component: FieldTestEnumWithValue,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-enum-with-value/new',
      name: 'FieldTestEnumWithValueCreate',
      component: FieldTestEnumWithValueUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-enum-with-value/:fieldTestEnumWithValueId/edit',
      name: 'FieldTestEnumWithValueEdit',
      component: FieldTestEnumWithValueUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'field-test-enum-with-value/:fieldTestEnumWithValueId/view',
      name: 'FieldTestEnumWithValueView',
      component: FieldTestEnumWithValueDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'bank-account-my-suffix',
      name: 'BankAccountMySuffix',
      component: BankAccountMySuffix,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'bank-account-my-suffix/new',
      name: 'BankAccountMySuffixCreate',
      component: BankAccountMySuffixUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'bank-account-my-suffix/:bankAccountId/edit',
      name: 'BankAccountMySuffixEdit',
      component: BankAccountMySuffixUpdate,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'bank-account-my-suffix/:bankAccountId/view',
      name: 'BankAccountMySuffixView',
      component: BankAccountMySuffixDetails,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'label',
      name: 'Label',
      component: Label,
      meta: { authorities: [Authority.USER] },
    },
    {
      path: 'label/:labelId/view',
      name: 'LabelView',
      component: LabelDetails,
      meta: { authorities: [Authority.USER] },
    },
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ],
};
