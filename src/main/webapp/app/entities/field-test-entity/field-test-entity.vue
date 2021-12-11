<template>
  <div>
    <h2 id="page-heading" data-cy="FieldTestEntityHeading">
      <span v-text="$t('jhipsterApp.fieldTestEntity.home.title')" id="field-test-entity-heading">Field Test Entities</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.fieldTestEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FieldTestEntityCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-field-test-entity"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.fieldTestEntity.home.createLabel')"> Create a new Field Test Entity </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && fieldTestEntities && fieldTestEntities.length === 0">
      <span v-text="$t('jhipsterApp.fieldTestEntity.home.notFound')">No fieldTestEntities found</span>
    </div>
    <div class="table-responsive" v-if="fieldTestEntities && fieldTestEntities.length > 0">
      <table class="table table-striped" aria-describedby="fieldTestEntities">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.stringTom')">String Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.stringRequiredTom')">String Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.stringMinlengthTom')">String Minlength Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.stringMaxlengthTom')">String Maxlength Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.stringPatternTom')">String Pattern Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.numberPatternTom')">Number Pattern Tom</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestEntity.numberPatternRequiredTom')">Number Pattern Required Tom</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.integerTom')">Integer Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.integerRequiredTom')">Integer Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.integerMinTom')">Integer Min Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.integerMaxTom')">Integer Max Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.longTom')">Long Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.longRequiredTom')">Long Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.longMinTom')">Long Min Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.longMaxTom')">Long Max Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.floatTom')">Float Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.floatRequiredTom')">Float Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.floatMinTom')">Float Min Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.floatMaxTom')">Float Max Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.doubleRequiredTom')">Double Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.doubleMinTom')">Double Min Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.doubleMaxTom')">Double Max Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalRequiredTom')">Big Decimal Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalMinTom')">Big Decimal Min Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalMaxTom')">Big Decimal Max Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.localDateTom')">Local Date Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.localDateRequiredTom')">Local Date Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.instantTom')">Instant Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.instantRequiredTom')">Instant Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.zonedDateTimeTom')">Zoned Date Time Tom</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestEntity.zonedDateTimeRequiredTom')">Zoned Date Time Required Tom</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.durationTom')">Duration Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.durationRequiredTom')">Duration Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.booleanTom')">Boolean Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.booleanRequiredTom')">Boolean Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.enumTom')">Enum Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.enumRequiredTom')">Enum Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.uuidTom')">Uuid Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.uuidRequiredTom')">Uuid Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteImageTom')">Byte Image Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteImageRequiredTom')">Byte Image Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteImageMinbytesTom')">Byte Image Minbytes Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteImageMaxbytesTom')">Byte Image Maxbytes Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteAnyTom')">Byte Any Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteAnyRequiredTom')">Byte Any Required Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteAnyMinbytesTom')">Byte Any Minbytes Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteAnyMaxbytesTom')">Byte Any Maxbytes Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteTextTom')">Byte Text Tom</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestEntity.byteTextRequiredTom')">Byte Text Required Tom</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="fieldTestEntity in fieldTestEntities" :key="fieldTestEntity.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'FieldTestEntityView', params: { fieldTestEntityId: fieldTestEntity.id } }">{{
                fieldTestEntity.id
              }}</router-link>
            </td>
            <td>{{ fieldTestEntity.stringTom }}</td>
            <td>{{ fieldTestEntity.stringRequiredTom }}</td>
            <td>{{ fieldTestEntity.stringMinlengthTom }}</td>
            <td>{{ fieldTestEntity.stringMaxlengthTom }}</td>
            <td>{{ fieldTestEntity.stringPatternTom }}</td>
            <td>{{ fieldTestEntity.numberPatternTom }}</td>
            <td>{{ fieldTestEntity.numberPatternRequiredTom }}</td>
            <td>{{ fieldTestEntity.integerTom }}</td>
            <td>{{ fieldTestEntity.integerRequiredTom }}</td>
            <td>{{ fieldTestEntity.integerMinTom }}</td>
            <td>{{ fieldTestEntity.integerMaxTom }}</td>
            <td>{{ fieldTestEntity.longTom }}</td>
            <td>{{ fieldTestEntity.longRequiredTom }}</td>
            <td>{{ fieldTestEntity.longMinTom }}</td>
            <td>{{ fieldTestEntity.longMaxTom }}</td>
            <td>{{ fieldTestEntity.floatTom }}</td>
            <td>{{ fieldTestEntity.floatRequiredTom }}</td>
            <td>{{ fieldTestEntity.floatMinTom }}</td>
            <td>{{ fieldTestEntity.floatMaxTom }}</td>
            <td>{{ fieldTestEntity.doubleRequiredTom }}</td>
            <td>{{ fieldTestEntity.doubleMinTom }}</td>
            <td>{{ fieldTestEntity.doubleMaxTom }}</td>
            <td>{{ fieldTestEntity.bigDecimalRequiredTom }}</td>
            <td>{{ fieldTestEntity.bigDecimalMinTom }}</td>
            <td>{{ fieldTestEntity.bigDecimalMaxTom }}</td>
            <td>{{ fieldTestEntity.localDateTom }}</td>
            <td>{{ fieldTestEntity.localDateRequiredTom }}</td>
            <td>{{ fieldTestEntity.instantTom ? $d(Date.parse(fieldTestEntity.instantTom), 'short') : '' }}</td>
            <td>{{ fieldTestEntity.instantRequiredTom ? $d(Date.parse(fieldTestEntity.instantRequiredTom), 'short') : '' }}</td>
            <td>{{ fieldTestEntity.zonedDateTimeTom ? $d(Date.parse(fieldTestEntity.zonedDateTimeTom), 'short') : '' }}</td>
            <td>{{ fieldTestEntity.zonedDateTimeRequiredTom ? $d(Date.parse(fieldTestEntity.zonedDateTimeRequiredTom), 'short') : '' }}</td>
            <td>{{ fieldTestEntity.durationTom | duration }}</td>
            <td>{{ fieldTestEntity.durationRequiredTom | duration }}</td>
            <td>{{ fieldTestEntity.booleanTom }}</td>
            <td>{{ fieldTestEntity.booleanRequiredTom }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestEntity.enumTom)">{{ fieldTestEntity.enumTom }}</td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestEntity.enumRequiredTom)">
              {{ fieldTestEntity.enumRequiredTom }}
            </td>
            <td>{{ fieldTestEntity.uuidTom }}</td>
            <td>{{ fieldTestEntity.uuidRequiredTom }}</td>
            <td>
              <a
                v-if="fieldTestEntity.byteImageTom"
                v-on:click="openFile(fieldTestEntity.byteImageTomContentType, fieldTestEntity.byteImageTom)"
              >
                <img
                  v-bind:src="'data:' + fieldTestEntity.byteImageTomContentType + ';base64,' + fieldTestEntity.byteImageTom"
                  style="max-height: 30px"
                  alt="fieldTestEntity image"
                />
              </a>
              <span v-if="fieldTestEntity.byteImageTom"
                >{{ fieldTestEntity.byteImageTomContentType }}, {{ byteSize(fieldTestEntity.byteImageTom) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestEntity.byteImageRequiredTom"
                v-on:click="openFile(fieldTestEntity.byteImageRequiredTomContentType, fieldTestEntity.byteImageRequiredTom)"
              >
                <img
                  v-bind:src="'data:' + fieldTestEntity.byteImageRequiredTomContentType + ';base64,' + fieldTestEntity.byteImageRequiredTom"
                  style="max-height: 30px"
                  alt="fieldTestEntity image"
                />
              </a>
              <span v-if="fieldTestEntity.byteImageRequiredTom"
                >{{ fieldTestEntity.byteImageRequiredTomContentType }}, {{ byteSize(fieldTestEntity.byteImageRequiredTom) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestEntity.byteImageMinbytesTom"
                v-on:click="openFile(fieldTestEntity.byteImageMinbytesTomContentType, fieldTestEntity.byteImageMinbytesTom)"
              >
                <img
                  v-bind:src="'data:' + fieldTestEntity.byteImageMinbytesTomContentType + ';base64,' + fieldTestEntity.byteImageMinbytesTom"
                  style="max-height: 30px"
                  alt="fieldTestEntity image"
                />
              </a>
              <span v-if="fieldTestEntity.byteImageMinbytesTom"
                >{{ fieldTestEntity.byteImageMinbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteImageMinbytesTom) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestEntity.byteImageMaxbytesTom"
                v-on:click="openFile(fieldTestEntity.byteImageMaxbytesTomContentType, fieldTestEntity.byteImageMaxbytesTom)"
              >
                <img
                  v-bind:src="'data:' + fieldTestEntity.byteImageMaxbytesTomContentType + ';base64,' + fieldTestEntity.byteImageMaxbytesTom"
                  style="max-height: 30px"
                  alt="fieldTestEntity image"
                />
              </a>
              <span v-if="fieldTestEntity.byteImageMaxbytesTom"
                >{{ fieldTestEntity.byteImageMaxbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteImageMaxbytesTom) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestEntity.byteAnyTom"
                v-on:click="openFile(fieldTestEntity.byteAnyTomContentType, fieldTestEntity.byteAnyTom)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestEntity.byteAnyTom"
                >{{ fieldTestEntity.byteAnyTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyTom) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestEntity.byteAnyRequiredTom"
                v-on:click="openFile(fieldTestEntity.byteAnyRequiredTomContentType, fieldTestEntity.byteAnyRequiredTom)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestEntity.byteAnyRequiredTom"
                >{{ fieldTestEntity.byteAnyRequiredTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyRequiredTom) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestEntity.byteAnyMinbytesTom"
                v-on:click="openFile(fieldTestEntity.byteAnyMinbytesTomContentType, fieldTestEntity.byteAnyMinbytesTom)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestEntity.byteAnyMinbytesTom"
                >{{ fieldTestEntity.byteAnyMinbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyMinbytesTom) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestEntity.byteAnyMaxbytesTom"
                v-on:click="openFile(fieldTestEntity.byteAnyMaxbytesTomContentType, fieldTestEntity.byteAnyMaxbytesTom)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestEntity.byteAnyMaxbytesTom"
                >{{ fieldTestEntity.byteAnyMaxbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyMaxbytesTom) }}</span
              >
            </td>
            <td>{{ fieldTestEntity.byteTextTom }}</td>
            <td>{{ fieldTestEntity.byteTextRequiredTom }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'FieldTestEntityView', params: { fieldTestEntityId: fieldTestEntity.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'FieldTestEntityEdit', params: { fieldTestEntityId: fieldTestEntity.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(fieldTestEntity)"
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
          id="jhipsterApp.fieldTestEntity.delete.question"
          data-cy="fieldTestEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="-delete-fieldTestEntity-heading" v-text="$t('jhipsterApp.fieldTestEntity.delete.question', { id: removeId })">
          Are you sure you want to delete this Field Test Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-fieldTestEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFieldTestEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./field-test-entity.component.ts"></script>
