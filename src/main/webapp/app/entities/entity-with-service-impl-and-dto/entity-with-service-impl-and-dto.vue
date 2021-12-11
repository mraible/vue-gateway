<template>
  <div>
    <h2 id="page-heading" data-cy="EntityWithServiceImplAndDTOHeading">
      <span v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.home.title')" id="entity-with-service-impl-and-dto-heading"
        >Entity With Service Impl And DTOS</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'EntityWithServiceImplAndDTOCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-entity-with-service-impl-and-dto"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.home.createLabel')">
              Create a new Entity With Service Impl And DTO
            </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && entityWithServiceImplAndDTOS && entityWithServiceImplAndDTOS.length === 0">
      <span v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.home.notFound')">No entityWithServiceImplAndDTOS found</span>
    </div>
    <div class="table-responsive" v-if="entityWithServiceImplAndDTOS && entityWithServiceImplAndDTOS.length > 0">
      <table class="table table-striped" aria-describedby="entityWithServiceImplAndDTOS">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.louis')">Louis</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="entityWithServiceImplAndDTO in entityWithServiceImplAndDTOS"
            :key="entityWithServiceImplAndDTO.id"
            data-cy="entityTable"
          >
            <td>
              <router-link
                :to="{ name: 'EntityWithServiceImplAndDTOView', params: { entityWithServiceImplAndDTOId: entityWithServiceImplAndDTO.id } }"
                >{{ entityWithServiceImplAndDTO.id }}</router-link
              >
            </td>
            <td>{{ entityWithServiceImplAndDTO.louis }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{
                    name: 'EntityWithServiceImplAndDTOView',
                    params: { entityWithServiceImplAndDTOId: entityWithServiceImplAndDTO.id },
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
                    name: 'EntityWithServiceImplAndDTOEdit',
                    params: { entityWithServiceImplAndDTOId: entityWithServiceImplAndDTO.id },
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
                  v-on:click="prepareRemove(entityWithServiceImplAndDTO)"
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
          id="jhipsterApp.entityWithServiceImplAndDTO.delete.question"
          data-cy="entityWithServiceImplAndDTODeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-entityWithServiceImplAndDTO-heading"
          v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Entity With Service Impl And DTO?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-entityWithServiceImplAndDTO"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeEntityWithServiceImplAndDTO()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./entity-with-service-impl-and-dto.component.ts"></script>
