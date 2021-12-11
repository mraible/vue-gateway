<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="entityWithServiceImplPaginationAndDTO">
        <h2 class="jh-entity-heading" data-cy="entityWithServiceImplPaginationAndDTODetailsHeading">
          <span v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.detail.title')">EntityWithServiceImplPaginationAndDTO</span>
          {{ entityWithServiceImplPaginationAndDTO.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.theo')">Theo</span>
          </dt>
          <dd>
            <span>{{ entityWithServiceImplPaginationAndDTO.theo }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="entityWithServiceImplPaginationAndDTO.id"
          :to="{
            name: 'EntityWithServiceImplPaginationAndDTOEdit',
            params: { entityWithServiceImplPaginationAndDTOId: entityWithServiceImplPaginationAndDTO.id },
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

<script lang="ts" src="./entity-with-service-impl-pagination-and-dto-details.component.ts"></script>
