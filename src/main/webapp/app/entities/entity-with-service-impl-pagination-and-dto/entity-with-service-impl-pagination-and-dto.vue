<template>
  <div>
    <h2 id="page-heading" data-cy="EntityWithServiceImplPaginationAndDTOHeading">
      <span
        v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.home.title')"
        id="entity-with-service-impl-pagination-and-dto-heading"
        >Entity With Service Impl Pagination And DTOS</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'EntityWithServiceImplPaginationAndDTOCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-entity-with-service-impl-pagination-and-dto"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.home.createLabel')">
              Create a new Entity With Service Impl Pagination And DTO
            </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div
      class="alert alert-warning"
      v-if="!isFetching && entityWithServiceImplPaginationAndDTOS && entityWithServiceImplPaginationAndDTOS.length === 0"
    >
      <span v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.home.notFound')"
        >No entityWithServiceImplPaginationAndDTOS found</span
      >
    </div>
    <div class="table-responsive" v-if="entityWithServiceImplPaginationAndDTOS && entityWithServiceImplPaginationAndDTOS.length > 0">
      <table class="table table-striped" aria-describedby="entityWithServiceImplPaginationAndDTOS">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('theo')">
              <span v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.theo')">Theo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'theo'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="entityWithServiceImplPaginationAndDTO in entityWithServiceImplPaginationAndDTOS"
            :key="entityWithServiceImplPaginationAndDTO.id"
            data-cy="entityTable"
          >
            <td>
              <router-link
                :to="{
                  name: 'EntityWithServiceImplPaginationAndDTOView',
                  params: { entityWithServiceImplPaginationAndDTOId: entityWithServiceImplPaginationAndDTO.id },
                }"
                >{{ entityWithServiceImplPaginationAndDTO.id }}</router-link
              >
            </td>
            <td>{{ entityWithServiceImplPaginationAndDTO.theo }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{
                    name: 'EntityWithServiceImplPaginationAndDTOView',
                    params: { entityWithServiceImplPaginationAndDTOId: entityWithServiceImplPaginationAndDTO.id },
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
                    name: 'EntityWithServiceImplPaginationAndDTOEdit',
                    params: { entityWithServiceImplPaginationAndDTOId: entityWithServiceImplPaginationAndDTO.id },
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
                  v-on:click="prepareRemove(entityWithServiceImplPaginationAndDTO)"
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
          id="jhipsterApp.entityWithServiceImplPaginationAndDTO.delete.question"
          data-cy="entityWithServiceImplPaginationAndDTODeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-entityWithServiceImplPaginationAndDTO-heading"
          v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Entity With Service Impl Pagination And DTO?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-entityWithServiceImplPaginationAndDTO"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeEntityWithServiceImplPaginationAndDTO()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="entityWithServiceImplPaginationAndDTOS && entityWithServiceImplPaginationAndDTOS.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./entity-with-service-impl-pagination-and-dto.component.ts"></script>
