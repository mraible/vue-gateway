<template>
  <div>
    <h2 id="page-heading" data-cy="FieldTestEnumWithValueHeading">
      <span v-text="$t('jhipsterApp.fieldTestEnumWithValue.home.title')" id="field-test-enum-with-value-heading"
        >Field Test Enum With Values</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.fieldTestEnumWithValue.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FieldTestEnumWithValueCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-field-test-enum-with-value"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.fieldTestEnumWithValue.home.createLabel')"> Create a new Field Test Enum With Value </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && fieldTestEnumWithValues && fieldTestEnumWithValues.length === 0">
      <span v-text="$t('jhipsterApp.fieldTestEnumWithValue.home.notFound')">No fieldTestEnumWithValues found</span>
    </div>
    <div class="table-responsive" v-if="fieldTestEnumWithValues && fieldTestEnumWithValues.length > 0">
      <table class="table table-striped" aria-describedby="fieldTestEnumWithValues">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldA')">My Field A</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldB')">My Field B</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEnumWithValue.myFieldC')">My Field C</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="fieldTestEnumWithValue in fieldTestEnumWithValues" :key="fieldTestEnumWithValue.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'FieldTestEnumWithValueView', params: { fieldTestEnumWithValueId: fieldTestEnumWithValue.id } }">{{
                fieldTestEnumWithValue.id
              }}</router-link>
            </td>
            <td v-text="$t('jhipsterApp.MyEnumA.' + fieldTestEnumWithValue.myFieldA)">{{ fieldTestEnumWithValue.myFieldA }}</td>
            <td v-text="$t('jhipsterApp.MyEnumB.' + fieldTestEnumWithValue.myFieldB)">{{ fieldTestEnumWithValue.myFieldB }}</td>
            <td v-text="$t('jhipsterApp.MyEnumC.' + fieldTestEnumWithValue.myFieldC)">{{ fieldTestEnumWithValue.myFieldC }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'FieldTestEnumWithValueView', params: { fieldTestEnumWithValueId: fieldTestEnumWithValue.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'FieldTestEnumWithValueEdit', params: { fieldTestEnumWithValueId: fieldTestEnumWithValue.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(fieldTestEnumWithValue)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="jhipsterApp.fieldTestEnumWithValue.delete.question"
          data-cy="fieldTestEnumWithValueDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="-delete-fieldTestEnumWithValue-heading" v-text="$t('jhipsterApp.fieldTestEnumWithValue.delete.question', { id: removeId })">
          Are you sure you want to delete this Field Test Enum With Value?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-fieldTestEnumWithValue"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFieldTestEnumWithValue()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./field-test-enum-with-value.component.ts"></script>
