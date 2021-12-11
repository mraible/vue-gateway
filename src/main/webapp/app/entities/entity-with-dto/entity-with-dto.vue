<template>
  <div>
    <h2 id="page-heading" data-cy="EntityWithDTOHeading">
      <span v-text="$t('jhipsterApp.entityWithDTO.home.title')" id="entity-with-dto-heading">Entity With DTOS</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.entityWithDTO.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'EntityWithDTOCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-entity-with-dto"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.entityWithDTO.home.createLabel')"> Create a new Entity With DTO </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && entityWithDTOS && entityWithDTOS.length === 0">
      <span v-text="$t('jhipsterApp.entityWithDTO.home.notFound')">No entityWithDTOS found</span>
    </div>
    <div class="table-responsive" v-if="entityWithDTOS && entityWithDTOS.length > 0">
      <table class="table table-striped" aria-describedby="entityWithDTOS">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.entityWithDTO.emma')">Emma</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="entityWithDTO in entityWithDTOS" :key="entityWithDTO.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'EntityWithDTOView', params: { entityWithDTOId: entityWithDTO.id } }">{{
                entityWithDTO.id
              }}</router-link>
            </td>
            <td>{{ entityWithDTO.emma }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'EntityWithDTOView', params: { entityWithDTOId: entityWithDTO.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'EntityWithDTOEdit', params: { entityWithDTOId: entityWithDTO.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(entityWithDTO)"
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
        ><span id="jhipsterApp.entityWithDTO.delete.question" data-cy="entityWithDTODeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="-delete-entityWithDTO-heading" v-text="$t('jhipsterApp.entityWithDTO.delete.question', { id: removeId })">
          Are you sure you want to delete this Entity With DTO?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-entityWithDTO"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeEntityWithDTO()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./entity-with-dto.component.ts"></script>
