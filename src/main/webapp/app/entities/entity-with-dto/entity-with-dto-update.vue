<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.entityWithDTO.home.createOrEditLabel"
          data-cy="EntityWithDTOCreateUpdateHeading"
          v-text="$t('jhipsterApp.entityWithDTO.home.createOrEditLabel')"
        >
          Create or edit a EntityWithDTO
        </h2>
        <div>
          <div class="form-group" v-if="entityWithDTO.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="entityWithDTO.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.entityWithDTO.emma')" for="entity-with-dto-emma">Emma</label>
            <input
              type="text"
              class="form-control"
              name="emma"
              id="entity-with-dto-emma"
              data-cy="emma"
              :class="{ valid: !$v.entityWithDTO.emma.$invalid, invalid: $v.entityWithDTO.emma.$invalid }"
              v-model="$v.entityWithDTO.emma.$model"
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
            :disabled="$v.entityWithDTO.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./entity-with-dto-update.component.ts"></script>
