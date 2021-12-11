<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.entityWithServiceClassPaginationAndDTO.home.createOrEditLabel"
          data-cy="EntityWithServiceClassPaginationAndDTOCreateUpdateHeading"
          v-text="$t('jhipsterApp.entityWithServiceClassPaginationAndDTO.home.createOrEditLabel')"
        >
          Create or edit a EntityWithServiceClassPaginationAndDTO
        </h2>
        <div>
          <div class="form-group" v-if="entityWithServiceClassPaginationAndDTO.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="entityWithServiceClassPaginationAndDTO.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.entityWithServiceClassPaginationAndDTO.lena')"
              for="entity-with-service-class-pagination-and-dto-lena"
              >Lena</label
            >
            <input
              type="text"
              class="form-control"
              name="lena"
              id="entity-with-service-class-pagination-and-dto-lena"
              data-cy="lena"
              :class="{
                valid: !$v.entityWithServiceClassPaginationAndDTO.lena.$invalid,
                invalid: $v.entityWithServiceClassPaginationAndDTO.lena.$invalid,
              }"
              v-model="$v.entityWithServiceClassPaginationAndDTO.lena.$model"
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
            :disabled="$v.entityWithServiceClassPaginationAndDTO.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./entity-with-service-class-pagination-and-dto-update.component.ts"></script>
