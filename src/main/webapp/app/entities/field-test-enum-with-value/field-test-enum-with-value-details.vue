<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fieldTestEnumWithValue">
        <h2 class="jh-entity-heading" data-cy="fieldTestEnumWithValueDetailsHeading">
          <span v-text="$t('jhipsterApp.fieldTestEnumWithValue.detail.title')">FieldTestEnumWithValue</span> {{ fieldTestEnumWithValue.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldA')">My Field A</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.MyEnumA.' + fieldTestEnumWithValue.myFieldA)">{{ fieldTestEnumWithValue.myFieldA }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldB')">My Field B</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.MyEnumB.' + fieldTestEnumWithValue.myFieldB)">{{ fieldTestEnumWithValue.myFieldB }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldC')">My Field C</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.MyEnumC.' + fieldTestEnumWithValue.myFieldC)">{{ fieldTestEnumWithValue.myFieldC }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="fieldTestEnumWithValue.id"
          :to="{ name: 'FieldTestEnumWithValueEdit', params: { fieldTestEnumWithValueId: fieldTestEnumWithValue.id } }"
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

<script lang="ts" src="./field-test-enum-with-value-details.component.ts"></script>
