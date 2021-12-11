<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.fieldTestEnumWithValue.home.createOrEditLabel"
          data-cy="FieldTestEnumWithValueCreateUpdateHeading"
          v-text="$t('jhipsterApp.fieldTestEnumWithValue.home.createOrEditLabel')"
        >
          Create or edit a FieldTestEnumWithValue
        </h2>
        <div>
          <div class="form-group" v-if="fieldTestEnumWithValue.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="fieldTestEnumWithValue.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldA')"
              for="field-test-enum-with-value-myFieldA"
              >My Field A</label
            >
            <select
              class="form-control"
              name="myFieldA"
              :class="{ valid: !$v.fieldTestEnumWithValue.myFieldA.$invalid, invalid: $v.fieldTestEnumWithValue.myFieldA.$invalid }"
              v-model="$v.fieldTestEnumWithValue.myFieldA.$model"
              id="field-test-enum-with-value-myFieldA"
              data-cy="myFieldA"
            >
              <option
                v-for="myEnumA in myEnumAValues"
                :key="myEnumA"
                v-bind:value="myEnumA"
                v-bind:label="$t('jhipsterApp.MyEnumA.' + myEnumA)"
              >
                {{ myEnumA }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldB')"
              for="field-test-enum-with-value-myFieldB"
              >My Field B</label
            >
            <select
              class="form-control"
              name="myFieldB"
              :class="{ valid: !$v.fieldTestEnumWithValue.myFieldB.$invalid, invalid: $v.fieldTestEnumWithValue.myFieldB.$invalid }"
              v-model="$v.fieldTestEnumWithValue.myFieldB.$model"
              id="field-test-enum-with-value-myFieldB"
              data-cy="myFieldB"
            >
              <option
                v-for="myEnumB in myEnumBValues"
                :key="myEnumB"
                v-bind:value="myEnumB"
                v-bind:label="$t('jhipsterApp.MyEnumB.' + myEnumB)"
              >
                {{ myEnumB }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldC')"
              for="field-test-enum-with-value-myFieldC"
              >My Field C</label
            >
            <select
              class="form-control"
              name="myFieldC"
              :class="{ valid: !$v.fieldTestEnumWithValue.myFieldC.$invalid, invalid: $v.fieldTestEnumWithValue.myFieldC.$invalid }"
              v-model="$v.fieldTestEnumWithValue.myFieldC.$model"
              id="field-test-enum-with-value-myFieldC"
              data-cy="myFieldC"
            >
              <option
                v-for="myEnumC in myEnumCValues"
                :key="myEnumC"
                v-bind:value="myEnumC"
                v-bind:label="$t('jhipsterApp.MyEnumC.' + myEnumC)"
              >
                {{ myEnumC }}
              </option>
            </select>
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
            :disabled="$v.fieldTestEnumWithValue.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./field-test-enum-with-value-update.component.ts"></script>
