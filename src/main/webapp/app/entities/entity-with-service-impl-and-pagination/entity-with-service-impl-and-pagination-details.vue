<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="entityWithServiceImplAndPagination">
        <h2 class="jh-entity-heading" data-cy="entityWithServiceImplAndPaginationDetailsHeading">
          <span v-text="$t('jhipsterApp.entityWithServiceImplAndPagination.detail.title')">EntityWithServiceImplAndPagination</span>
          {{ entityWithServiceImplAndPagination.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.entityWithServiceImplAndPagination.hugo')">Hugo</span>
          </dt>
          <dd>
            <span>{{ entityWithServiceImplAndPagination.hugo }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="entityWithServiceImplAndPagination.id"
          :to="{
            name: 'EntityWithServiceImplAndPaginationEdit',
            params: { entityWithServiceImplAndPaginationId: entityWithServiceImplAndPagination.id },
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

<script lang="ts" src="./entity-with-service-impl-and-pagination-details.component.ts"></script>
