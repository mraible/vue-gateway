<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.mapsIdUserProfileWithDTO.home.createOrEditLabel"
          data-cy="MapsIdUserProfileWithDTOCreateUpdateHeading"
          v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.home.createOrEditLabel')"
        >
          Create or edit a MapsIdUserProfileWithDTO
        </h2>
        <div>
          <div class="form-group" v-if="mapsIdUserProfileWithDTO.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="mapsIdUserProfileWithDTO.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.dateOfBirth')"
              for="maps-id-user-profile-with-dto-dateOfBirth"
              >Date Of Birth</label
            >
            <div class="d-flex">
              <input
                id="maps-id-user-profile-with-dto-dateOfBirth"
                data-cy="dateOfBirth"
                type="datetime-local"
                class="form-control"
                name="dateOfBirth"
                :class="{
                  valid: !$v.mapsIdUserProfileWithDTO.dateOfBirth.$invalid,
                  invalid: $v.mapsIdUserProfileWithDTO.dateOfBirth.$invalid,
                }"
                :value="convertDateTimeFromServer($v.mapsIdUserProfileWithDTO.dateOfBirth.$model)"
                @change="updateInstantField('dateOfBirth', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.mapsIdUserProfileWithDTO.user')"
              for="maps-id-user-profile-with-dto-user"
              >User</label
            >
            <select
              class="form-control"
              id="maps-id-user-profile-with-dto-user"
              data-cy="user"
              name="user"
              v-model="mapsIdUserProfileWithDTO.user"
            >
              <option v-bind:value="null"></option>
              <option
                v-bind:value="
                  mapsIdUserProfileWithDTO.user && userOption.id === mapsIdUserProfileWithDTO.user.id
                    ? mapsIdUserProfileWithDTO.user
                    : userOption
                "
                v-for="userOption in users"
                :key="userOption.id"
              >
                {{ userOption.login }}
              </option>
            </select>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.mapsIdUserProfileWithDTO.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./maps-id-user-profile-with-dto-update.component.ts"></script>
