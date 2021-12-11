<template>
  <div>
    <h2 id="page-heading" data-cy="FieldTestMapstructAndServiceClassEntityHeading">
      <span
        v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.home.title')"
        id="field-test-mapstruct-and-service-class-entity-heading"
        >Field Test Mapstruct And Service Class Entities</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FieldTestMapstructAndServiceClassEntityCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-field-test-mapstruct-and-service-class-entity"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.home.createLabel')">
              Create a new Field Test Mapstruct And Service Class Entity
            </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div
      class="alert alert-warning"
      v-if="!isFetching && fieldTestMapstructAndServiceClassEntities && fieldTestMapstructAndServiceClassEntities.length === 0"
    >
      <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.home.notFound')"
        >No fieldTestMapstructAndServiceClassEntities found</span
      >
    </div>
    <div class="table-responsive" v-if="fieldTestMapstructAndServiceClassEntities && fieldTestMapstructAndServiceClassEntities.length > 0">
      <table class="table table-striped" aria-describedby="fieldTestMapstructAndServiceClassEntities">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringEva')">String Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringRequiredEva')">String Required Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva')">String Minlength Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva')">String Maxlength Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringPatternEva')">String Pattern Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerEva')">Integer Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerRequiredEva')">Integer Required Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerMinEva')">Integer Min Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerMaxEva')">Integer Max Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longEva')">Long Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longRequiredEva')">Long Required Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longMinEva')">Long Min Eva</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longMaxEva')">Long Max Eva</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatEva')">Float Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatRequiredEva')">Float Required Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatMinEva')">Float Min Eva</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatMaxEva')">Float Max Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva')">Double Required Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleMinEva')">Double Min Eva</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleMaxEva')">Double Max Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva')">Big Decimal Required Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva')">Big Decimal Min Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva')">Big Decimal Max Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.localDateEva')">Local Date Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva')">Local Date Required Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.instantEva')">Instant Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva')">Instante Required Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva')">Zoned Date Time Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva')"
                >Zoned Date Time Required Eva</span
              >
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.durationEva')">Duration Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.durationRequiredEva')">Duration Required Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.booleanEva')">Boolean Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva')">Boolean Required Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.enumEva')">Enum Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.enumRequiredEva')">Enum Required Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.uuidEva')">Uuid Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva')">Uuid Required Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageEva')">Byte Image Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva')">Byte Image Required Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva')">Byte Image Minbytes Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva')">Byte Image Maxbytes Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyEva')">Byte Any Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva')">Byte Any Required Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva')">Byte Any Minbytes Eva</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva')">Byte Any Maxbytes Eva</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteTextEva')">Byte Text Eva</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva')">Byte Text Required Eva</span>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="fieldTestMapstructAndServiceClassEntity in fieldTestMapstructAndServiceClassEntities"
            :key="fieldTestMapstructAndServiceClassEntity.id"
            data-cy="entityTable"
          >
            <td>
              <router-link
                :to="{
                  name: 'FieldTestMapstructAndServiceClassEntityView',
                  params: { fieldTestMapstructAndServiceClassEntityId: fieldTestMapstructAndServiceClassEntity.id },
                }"
                >{{ fieldTestMapstructAndServiceClassEntity.id }}</router-link
              >
            </td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.stringEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.stringRequiredEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.stringMinlengthEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.stringPatternEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.integerEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.integerRequiredEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.integerMinEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.integerMaxEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.longEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.longRequiredEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.longMinEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.longMaxEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.floatEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.floatRequiredEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.floatMinEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.floatMaxEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.doubleRequiredEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.doubleMinEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.doubleMaxEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.localDateEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.localDateRequiredEva }}</td>
            <td>
              {{
                fieldTestMapstructAndServiceClassEntity.instantEva
                  ? $d(Date.parse(fieldTestMapstructAndServiceClassEntity.instantEva), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestMapstructAndServiceClassEntity.instanteRequiredEva
                  ? $d(Date.parse(fieldTestMapstructAndServiceClassEntity.instanteRequiredEva), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva
                  ? $d(Date.parse(fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva
                  ? $d(Date.parse(fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva), 'short')
                  : ''
              }}
            </td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.durationEva | duration }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.durationRequiredEva | duration }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.booleanEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.booleanRequiredEva }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestMapstructAndServiceClassEntity.enumEva)">
              {{ fieldTestMapstructAndServiceClassEntity.enumEva }}
            </td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestMapstructAndServiceClassEntity.enumRequiredEva)">
              {{ fieldTestMapstructAndServiceClassEntity.enumRequiredEva }}
            </td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.uuidEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.uuidRequiredEva }}</td>
            <td>
              <a
                v-if="fieldTestMapstructAndServiceClassEntity.byteImageEva"
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteImageEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteImageEva
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestMapstructAndServiceClassEntity.byteImageEvaContentType +
                    ';base64,' +
                    fieldTestMapstructAndServiceClassEntity.byteImageEva
                  "
                  style="max-height: 30px"
                  alt="fieldTestMapstructAndServiceClassEntity image"
                />
              </a>
              <span v-if="fieldTestMapstructAndServiceClassEntity.byteImageEva"
                >{{ fieldTestMapstructAndServiceClassEntity.byteImageEvaContentType }},
                {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageEva) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva"
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteImageRequiredEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestMapstructAndServiceClassEntity.byteImageRequiredEvaContentType +
                    ';base64,' +
                    fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva
                  "
                  style="max-height: 30px"
                  alt="fieldTestMapstructAndServiceClassEntity image"
                />
              </a>
              <span v-if="fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva"
                >{{ fieldTestMapstructAndServiceClassEntity.byteImageRequiredEvaContentType }},
                {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva"
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEvaContentType +
                    ';base64,' +
                    fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva
                  "
                  style="max-height: 30px"
                  alt="fieldTestMapstructAndServiceClassEntity image"
                />
              </a>
              <span v-if="fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva"
                >{{ fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEvaContentType }},
                {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva"
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEvaContentType +
                    ';base64,' +
                    fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva
                  "
                  style="max-height: 30px"
                  alt="fieldTestMapstructAndServiceClassEntity image"
                />
              </a>
              <span v-if="fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva"
                >{{ fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEvaContentType }},
                {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestMapstructAndServiceClassEntity.byteAnyEva"
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteAnyEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteAnyEva
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestMapstructAndServiceClassEntity.byteAnyEva"
                >{{ fieldTestMapstructAndServiceClassEntity.byteAnyEvaContentType }},
                {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyEva) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva"
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva"
                >{{ fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEvaContentType }},
                {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva"
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva"
                >{{ fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEvaContentType }},
                {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva"
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva"
                >{{ fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEvaContentType }},
                {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva) }}</span
              >
            </td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.byteTextEva }}</td>
            <td>{{ fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{
                    name: 'FieldTestMapstructAndServiceClassEntityView',
                    params: { fieldTestMapstructAndServiceClassEntityId: fieldTestMapstructAndServiceClassEntity.id },
                  }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{
                    name: 'FieldTestMapstructAndServiceClassEntityEdit',
                    params: { fieldTestMapstructAndServiceClassEntityId: fieldTestMapstructAndServiceClassEntity.id },
                  }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(fieldTestMapstructAndServiceClassEntity)"
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
          id="jhipsterApp.fieldTestMapstructAndServiceClassEntity.delete.question"
          data-cy="fieldTestMapstructAndServiceClassEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-fieldTestMapstructAndServiceClassEntity-heading"
          v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Field Test Mapstruct And Service Class Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-fieldTestMapstructAndServiceClassEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFieldTestMapstructAndServiceClassEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./field-test-mapstruct-and-service-class-entity.component.ts"></script>
