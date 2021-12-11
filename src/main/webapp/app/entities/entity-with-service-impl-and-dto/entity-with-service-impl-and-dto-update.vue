<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.entityWithServiceImplAndDTO.home.createOrEditLabel"
          data-cy="EntityWithServiceImplAndDTOCreateUpdateHeading"
          v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.home.createOrEditLabel')"
        >
          Create or edit a EntityWithServiceImplAndDTO
        </h2>
        <div>
          <div class="form-group" v-if="entityWithServiceImplAndDTO.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="entityWithServiceImplAndDTO.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.louis')"
              for="entity-with-service-impl-and-dto-louis"
              >Louis</label
            >
            <input
              type="text"
              class="form-control"
              name="louis"
              id="entity-with-service-impl-and-dto-louis"
              data-cy="louis"
              :class="{ valid: !$v.entityWithServiceImplAndDTO.louis.$invalid, invalid: $v.entityWithServiceImplAndDTO.louis.$invalid }"
              v-model="$v.entityWithServiceImplAndDTO.louis.$model"
            />
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
            :disabled="$v.entityWithServiceImplAndDTO.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./entity-with-service-impl-and-dto-update.component.ts"></script>
