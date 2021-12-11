<template>
  <div>
    <b-dropdown-item to="/operation">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.testRootOperation')">Operation</span>
    </b-dropdown-item>
    <b-dropdown-item to="/field-test-entity">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.fieldTestEntity')">Field Test Entity</span>
    </b-dropdown-item>
    <b-dropdown-item to="/field-test-infinite-scroll-entity">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.fieldTestInfiniteScrollEntity')">Field Test Infinite Scroll Entity</span>
    </b-dropdown-item>
    <b-dropdown-item to="/field-test-mapstruct-and-service-class-entity">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.fieldTestMapstructAndServiceClassEntity')">Field Test Mapstruct And Service Class Entity</span>
    </b-dropdown-item>
    <b-dropdown-item to="/field-test-pagination-entity">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.fieldTestPaginationEntity')">Field Test Pagination Entity</span>
    </b-dropdown-item>
    <b-dropdown-item to="/field-test-service-class-and-jpa-filtering-entity">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.fieldTestServiceClassAndJpaFilteringEntity')"
        >Field Test Service Class And Jpa Filtering Entity</span
      >
    </b-dropdown-item>
    <b-dropdown-item to="/field-test-service-impl-entity">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.fieldTestServiceImplEntity')">Field Test Service Impl Entity</span>
    </b-dropdown-item>
    <b-dropdown-item to="/entity-with-dto">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.entityWithDto')">Entity With DTO</span>
    </b-dropdown-item>
    <b-dropdown-item to="/entity-with-service-class-and-pagination">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.entityWithServiceClassAndPagination')">Entity With Service Class And Pagination</span>
    </b-dropdown-item>
    <b-dropdown-item to="/entity-with-service-impl-and-pagination">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.entityWithServiceImplAndPagination')">Entity With Service Impl And Pagination</span>
    </b-dropdown-item>
    <b-dropdown-item to="/entity-with-service-impl-and-dto">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.entityWithServiceImplAndDto')">Entity With Service Impl And DTO</span>
    </b-dropdown-item>
    <b-dropdown-item to="/entity-with-pagination-and-dto">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.entityWithPaginationAndDto')">Entity With Pagination And DTO</span>
    </b-dropdown-item>
    <b-dropdown-item to="/entity-with-service-class-pagination-and-dto">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.entityWithServiceClassPaginationAndDto')">Entity With Service Class Pagination And DTO</span>
    </b-dropdown-item>
    <b-dropdown-item to="/entity-with-service-impl-pagination-and-dto">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.entityWithServiceImplPaginationAndDto')">Entity With Service Impl Pagination And DTO</span>
    </b-dropdown-item>
    <b-dropdown-item to="/maps-id-user-profile-with-dto">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.mapsIdUserProfileWithDto')">Maps Id User Profile With DTO</span>
    </b-dropdown-item>
    <b-dropdown-item to="/field-test-enum-with-value">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.fieldTestEnumWithValue')">Field Test Enum With Value</span>
    </b-dropdown-item>
    <b-dropdown-item to="/bank-account-my-suffix">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.testRootBankAccountMySuffix')">Bank Account</span>
    </b-dropdown-item>
    <b-dropdown-item to="/label">
      <font-awesome-icon icon="asterisk" />
      <span v-text="$t('global.menu.entities.testRootLabel')">Label</span>
    </b-dropdown-item>
    <!-- jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here -->
  </div>
</template>

<script lang="ts" src="./entities-menu.component.ts"></script>
