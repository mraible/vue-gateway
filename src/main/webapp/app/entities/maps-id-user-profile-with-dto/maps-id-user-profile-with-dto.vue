<template>
  <div>
    <h2 id="page-heading" data-cy="MapsIdUserProfileWithDTOHeading">
      <span v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.home.title')" id="maps-id-user-profile-with-dto-heading"
        >Maps Id User Profile With DTOS</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'MapsIdUserProfileWithDTOCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-maps-id-user-profile-with-dto"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.home.createLabel')"> Create a new Maps Id User Profile With DTO </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && mapsIdUserProfileWithDTOS && mapsIdUserProfileWithDTOS.length === 0">
      <span v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.home.notFound')">No mapsIdUserProfileWithDTOS found</span>
    </div>
    <div class="table-responsive" v-if="mapsIdUserProfileWithDTOS && mapsIdUserProfileWithDTOS.length > 0">
      <table class="table table-striped" aria-describedby="mapsIdUserProfileWithDTOS">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.dateOfBirth')">Date Of Birth</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.user')">User</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="mapsIdUserProfileWithDTO in mapsIdUserProfileWithDTOS" :key="mapsIdUserProfileWithDTO.id" data-cy="entityTable">
            <td>
              <router-link
                :to="{ name: 'MapsIdUserProfileWithDTOView', params: { mapsIdUserProfileWithDTOId: mapsIdUserProfileWithDTO.id } }"
                >{{ mapsIdUserProfileWithDTO.id }}</router-link
              >
            </td>
            <td>{{ mapsIdUserProfileWithDTO.dateOfBirth ? $d(Date.parse(mapsIdUserProfileWithDTO.dateOfBirth), 'short') : '' }}</td>
            <td>
              {{ mapsIdUserProfileWithDTO.user ? mapsIdUserProfileWithDTO.user.login : '' }}
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'MapsIdUserProfileWithDTOView', params: { mapsIdUserProfileWithDTOId: mapsIdUserProfileWithDTO.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'MapsIdUserProfileWithDTOEdit', params: { mapsIdUserProfileWithDTOId: mapsIdUserProfileWithDTO.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(mapsIdUserProfileWithDTO)"
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
          id="jhipsterApp.mapsIdUserProfileWithDTO.delete.question"
          data-cy="mapsIdUserProfileWithDTODeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-mapsIdUserProfileWithDTO-heading"
          v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Maps Id User Profile With DTO?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-mapsIdUserProfileWithDTO"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeMapsIdUserProfileWithDTO()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./maps-id-user-profile-with-dto.component.ts"></script>
