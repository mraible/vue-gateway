<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="entityWithServiceClassPaginationAndDTO">
        <h2 class="jh-entity-heading" data-cy="entityWithServiceClassPaginationAndDTODetailsHeading">
          <span v-text="$t('jhipsterApp.entityWithServiceClassPaginationAndDTO.detail.title')">EntityWithServiceClassPaginationAndDTO</span>
          {{ entityWithServiceClassPaginationAndDTO.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.entityWithServiceClassPaginationAndDTO.lena')">Lena</span>
          </dt>
          <dd>
            <span>{{ entityWithServiceClassPaginationAndDTO.lena }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="entityWithServiceClassPaginationAndDTO.id"
          :to="{
            name: 'EntityWithServiceClassPaginationAndDTOEdit',
            params: { entityWithServiceClassPaginationAndDTOId: entityWithServiceClassPaginationAndDTO.id },
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

<script lang="ts" src="./entity-with-service-class-pagination-and-dto-details.component.ts"></script>
