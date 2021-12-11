<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.entityWithServiceClassAndPagination.home.createOrEditLabel"
          data-cy="EntityWithServiceClassAndPaginationCreateUpdateHeading"
          v-text="$t('jhipsterApp.entityWithServiceClassAndPagination.home.createOrEditLabel')"
        >
          Create or edit a EntityWithServiceClassAndPagination
        </h2>
        <div>
          <div class="form-group" v-if="entityWithServiceClassAndPagination.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="entityWithServiceClassAndPagination.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.entityWithServiceClassAndPagination.enzo')"
              for="entity-with-service-class-and-pagination-enzo"
              >Enzo</label
            >
            <input
              type="text"
              class="form-control"
              name="enzo"
              id="entity-with-service-class-and-pagination-enzo"
              data-cy="enzo"
              :class="{
                valid: !$v.entityWithServiceClassAndPagination.enzo.$invalid,
                invalid: $v.entityWithServiceClassAndPagination.enzo.$invalid,
              }"
              v-model="$v.entityWithServiceClassAndPagination.enzo.$model"
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
            :disabled="$v.entityWithServiceClassAndPagination.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./entity-with-service-class-and-pagination-update.component.ts"></script>
