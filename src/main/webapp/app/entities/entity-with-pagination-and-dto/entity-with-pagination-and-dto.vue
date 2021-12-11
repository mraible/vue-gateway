<template>
  <div>
    <h2 id="page-heading" data-cy="EntityWithPaginationAndDTOHeading">
      <span v-text="$t('jhipsterApp.entityWithPaginationAndDTO.home.title')" id="entity-with-pagination-and-dto-heading"
        >Entity With Pagination And DTOS</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.entityWithPaginationAndDTO.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'EntityWithPaginationAndDTOCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-entity-with-pagination-and-dto"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.entityWithPaginationAndDTO.home.createLabel')">
              Create a new Entity With Pagination And DTO
            </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && entityWithPaginationAndDTOS && entityWithPaginationAndDTOS.length === 0">
      <span v-text="$t('jhipsterApp.entityWithPaginationAndDTO.home.notFound')">No entityWithPaginationAndDTOS found</span>
    </div>
    <div class="table-responsive" v-if="entityWithPaginationAndDTOS && entityWithPaginationAndDTOS.length > 0">
      <table class="table table-striped" aria-describedby="entityWithPaginationAndDTOS">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('lea')">
              <span v-text="$t('jhipsterApp.entityWithPaginationAndDTO.lea')">Lea</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'lea'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="entityWithPaginationAndDTO in entityWithPaginationAndDTOS" :key="entityWithPaginationAndDTO.id" data-cy="entityTable">
            <td>
              <router-link
                :to="{ name: 'EntityWithPaginationAndDTOView', params: { entityWithPaginationAndDTOId: entityWithPaginationAndDTO.id } }"
                >{{ entityWithPaginationAndDTO.id }}</router-link
              >
            </td>
            <td>{{ entityWithPaginationAndDTO.lea }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'EntityWithPaginationAndDTOView', params: { entityWithPaginationAndDTOId: entityWithPaginationAndDTO.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'EntityWithPaginationAndDTOEdit', params: { entityWithPaginationAndDTOId: entityWithPaginationAndDTO.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(entityWithPaginationAndDTO)"
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
          id="jhipsterApp.entityWithPaginationAndDTO.delete.question"
          data-cy="entityWithPaginationAndDTODeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-entityWithPaginationAndDTO-heading"
          v-text="$t('jhipsterApp.entityWithPaginationAndDTO.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Entity With Pagination And DTO?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-entityWithPaginationAndDTO"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeEntityWithPaginationAndDTO()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="entityWithPaginationAndDTOS && entityWithPaginationAndDTOS.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./entity-with-pagination-and-dto.component.ts"></script>
