<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="entityWithPaginationAndDTO">
        <h2 class="jh-entity-heading" data-cy="entityWithPaginationAndDTODetailsHeading">
          <span v-text="$t('jhipsterApp.entityWithPaginationAndDTO.detail.title')">EntityWithPaginationAndDTO</span>
          {{ entityWithPaginationAndDTO.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.entityWithPaginationAndDTO.lea')">Lea</span>
          </dt>
          <dd>
            <span>{{ entityWithPaginationAndDTO.lea }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="entityWithPaginationAndDTO.id"
          :to="{ name: 'EntityWithPaginationAndDTOEdit', params: { entityWithPaginationAndDTOId: entityWithPaginationAndDTO.id } }"
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

<script lang="ts" src="./entity-with-pagination-and-dto-details.component.ts"></script>
