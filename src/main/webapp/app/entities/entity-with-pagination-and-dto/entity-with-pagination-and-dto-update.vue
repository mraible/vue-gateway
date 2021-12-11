<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.entityWithPaginationAndDTO.home.createOrEditLabel"
          data-cy="EntityWithPaginationAndDTOCreateUpdateHeading"
          v-text="$t('jhipsterApp.entityWithPaginationAndDTO.home.createOrEditLabel')"
        >
          Create or edit a EntityWithPaginationAndDTO
        </h2>
        <div>
          <div class="form-group" v-if="entityWithPaginationAndDTO.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="entityWithPaginationAndDTO.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.entityWithPaginationAndDTO.lea')"
              for="entity-with-pagination-and-dto-lea"
              >Lea</label
            >
            <input
              type="text"
              class="form-control"
              name="lea"
              id="entity-with-pagination-and-dto-lea"
              data-cy="lea"
              :class="{ valid: !$v.entityWithPaginationAndDTO.lea.$invalid, invalid: $v.entityWithPaginationAndDTO.lea.$invalid }"
              v-model="$v.entityWithPaginationAndDTO.lea.$model"
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
            :disabled="$v.entityWithPaginationAndDTO.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./entity-with-pagination-and-dto-update.component.ts"></script>
