<template>
  <div>
    <h2 id="page-heading" data-cy="EntityWithServiceImplAndPaginationHeading">
      <span v-text="$t('jhipsterApp.entityWithServiceImplAndPagination.home.title')" id="entity-with-service-impl-and-pagination-heading"
        >Entity With Service Impl And Paginations</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.entityWithServiceImplAndPagination.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'EntityWithServiceImplAndPaginationCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-entity-with-service-impl-and-pagination"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.entityWithServiceImplAndPagination.home.createLabel')">
              Create a new Entity With Service Impl And Pagination
            </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div
      class="alert alert-warning"
      v-if="!isFetching && entityWithServiceImplAndPaginations && entityWithServiceImplAndPaginations.length === 0"
    >
      <span v-text="$t('jhipsterApp.entityWithServiceImplAndPagination.home.notFound')">No entityWithServiceImplAndPaginations found</span>
    </div>
    <div class="table-responsive" v-if="entityWithServiceImplAndPaginations && entityWithServiceImplAndPaginations.length > 0">
      <table class="table table-striped" aria-describedby="entityWithServiceImplAndPaginations">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('hugo')">
              <span v-text="$t('jhipsterApp.entityWithServiceImplAndPagination.hugo')">Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'hugo'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="entityWithServiceImplAndPagination in entityWithServiceImplAndPaginations"
            :key="entityWithServiceImplAndPagination.id"
            data-cy="entityTable"
          >
            <td>
              <router-link
                :to="{
                  name: 'EntityWithServiceImplAndPaginationView',
                  params: { entityWithServiceImplAndPaginationId: entityWithServiceImplAndPagination.id },
                }"
                >{{ entityWithServiceImplAndPagination.id }}</router-link
              >
            </td>
            <td>{{ entityWithServiceImplAndPagination.hugo }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{
                    name: 'EntityWithServiceImplAndPaginationView',
                    params: { entityWithServiceImplAndPaginationId: entityWithServiceImplAndPagination.id },
                  }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{
                    name: 'EntityWithServiceImplAndPaginationEdit',
                    params: { entityWithServiceImplAndPaginationId: entityWithServiceImplAndPagination.id },
                  }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(entityWithServiceImplAndPagination)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="jhipsterApp.entityWithServiceImplAndPagination.delete.question"
          data-cy="entityWithServiceImplAndPaginationDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-entityWithServiceImplAndPagination-heading"
          v-text="$t('jhipsterApp.entityWithServiceImplAndPagination.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Entity With Service Impl And Pagination?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-entityWithServiceImplAndPagination"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeEntityWithServiceImplAndPagination()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="entityWithServiceImplAndPaginations && entityWithServiceImplAndPaginations.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./entity-with-service-impl-and-pagination.component.ts"></script>
