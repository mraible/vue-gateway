<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="entityWithDTO">
        <h2 class="jh-entity-heading" data-cy="entityWithDTODetailsHeading">
          <span v-text="$t('jhipsterApp.entityWithDTO.detail.title')">EntityWithDTO</span> {{ entityWithDTO.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.entityWithDTO.emma')">Emma</span>
          </dt>
          <dd>
            <span>{{ entityWithDTO.emma }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="entityWithDTO.id"
          :to="{ name: 'EntityWithDTOEdit', params: { entityWithDTOId: entityWithDTO.id } }"
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

<script lang="ts" src="./entity-with-dto-details.component.ts"></script>
