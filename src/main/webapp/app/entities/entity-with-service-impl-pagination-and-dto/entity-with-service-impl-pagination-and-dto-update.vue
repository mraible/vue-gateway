<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.entityWithServiceImplPaginationAndDTO.home.createOrEditLabel"
          data-cy="EntityWithServiceImplPaginationAndDTOCreateUpdateHeading"
          v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.home.createOrEditLabel')"
        >
          Create or edit a EntityWithServiceImplPaginationAndDTO
        </h2>
        <div>
          <div class="form-group" v-if="entityWithServiceImplPaginationAndDTO.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="entityWithServiceImplPaginationAndDTO.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.theo')"
              for="entity-with-service-impl-pagination-and-dto-theo"
              >Theo</label
            >
            <input
              type="text"
              class="form-control"
              name="theo"
              id="entity-with-service-impl-pagination-and-dto-theo"
              data-cy="theo"
              :class="{
                valid: !$v.entityWithServiceImplPaginationAndDTO.theo.$invalid,
                invalid: $v.entityWithServiceImplPaginationAndDTO.theo.$invalid,
              }"
              v-model="$v.entityWithServiceImplPaginationAndDTO.theo.$model"
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
            :disabled="$v.entityWithServiceImplPaginationAndDTO.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./entity-with-service-impl-pagination-and-dto-update.component.ts"></script>
