<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="entityWithServiceImplAndDTO">
        <h2 class="jh-entity-heading" data-cy="entityWithServiceImplAndDTODetailsHeading">
          <span v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.detail.title')">EntityWithServiceImplAndDTO</span>
          {{ entityWithServiceImplAndDTO.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.entityWithServiceImplAndDTO.louis')">Louis</span>
          </dt>
          <dd>
            <span>{{ entityWithServiceImplAndDTO.louis }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="entityWithServiceImplAndDTO.id"
          :to="{ name: 'EntityWithServiceImplAndDTOEdit', params: { entityWithServiceImplAndDTOId: entityWithServiceImplAndDTO.id } }"
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

<script lang="ts" src="./entity-with-service-impl-and-dto-details.component.ts"></script>
