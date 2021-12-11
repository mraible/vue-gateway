<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="entityWithServiceClassAndPagination">
        <h2 class="jh-entity-heading" data-cy="entityWithServiceClassAndPaginationDetailsHeading">
          <span v-text="$t('jhipsterApp.entityWithServiceClassAndPagination.detail.title')">EntityWithServiceClassAndPagination</span>
          {{ entityWithServiceClassAndPagination.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.entityWithServiceClassAndPagination.enzo')">Enzo</span>
          </dt>
          <dd>
            <span>{{ entityWithServiceClassAndPagination.enzo }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="entityWithServiceClassAndPagination.id"
          :to="{
            name: 'EntityWithServiceClassAndPaginationEdit',
            params: { entityWithServiceClassAndPaginationId: entityWithServiceClassAndPagination.id },
          }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./entity-with-service-class-and-pagination-details.component.ts"></script>
