<template>
  <div>
    <h2 id="page-heading" data-cy="FieldTestServiceClassAndJpaFilteringEntityHeading">
      <span
        v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.home.title')"
        id="field-test-service-class-and-jpa-filtering-entity-heading"
        >Field Test Service Class And Jpa Filtering Entities</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FieldTestServiceClassAndJpaFilteringEntityCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-field-test-service-class-and-jpa-filtering-entity"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.home.createLabel')">
              Create a new Field Test Service Class And Jpa Filtering Entity
            </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div
      class="alert alert-warning"
      v-if="!isFetching && fieldTestServiceClassAndJpaFilteringEntities && fieldTestServiceClassAndJpaFilteringEntities.length === 0"
    >
      <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.home.notFound')"
        >No fieldTestServiceClassAndJpaFilteringEntities found</span
      >
    </div>
    <div
      class="table-responsive"
      v-if="fieldTestServiceClassAndJpaFilteringEntities && fieldTestServiceClassAndJpaFilteringEntities.length > 0"
    >
      <table class="table table-striped" aria-describedby="fieldTestServiceClassAndJpaFilteringEntities">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringBob')">String Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob')">String Required Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob')">String Minlength Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob')">String Maxlength Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob')">String Pattern Bob</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerBob')">Integer Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob')">Integer Required Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob')">Integer Min Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob')">Integer Max Bob</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longBob')">Long Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob')">Long Required Bob</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longMinBob')">Long Min Bob</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob')">Long Max Bob</span></th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatBob')">Float Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob')">Float Required Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob')">Float Min Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob')">Float Max Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob')">Double Required Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob')">Double Min Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob')">Double Max Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob')"
                >Big Decimal Required Bob</span
              >
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob')">Big Decimal Min Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob')">Big Decimal Max Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.localDateBob')">Local Date Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob')"
                >Local Date Required Bob</span
              >
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.instantBob')">Instant Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob')">Instante Required Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob')">Zoned Date Time Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob')"
                >Zoned Date Time Required Bob</span
              >
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.durationBob')">Duration Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob')">Duration Required Bob</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.booleanBob')">Boolean Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob')">Boolean Required Bob</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.enumBob')">Enum Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob')">Enum Required Bob</span>
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.uuidBob')">Uuid Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob')">Uuid Required Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageBob')">Byte Image Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob')"
                >Byte Image Required Bob</span
              >
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob')"
                >Byte Image Minbytes Bob</span
              >
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob')"
                >Byte Image Maxbytes Bob</span
              >
            </th>
            <th scope="row"><span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob')">Byte Any Bob</span></th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob')">Byte Any Required Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob')">Byte Any Minbytes Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob')">Byte Any Maxbytes Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteTextBob')">Byte Text Bob</span>
            </th>
            <th scope="row">
              <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob')">Byte Text Required Bob</span>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="fieldTestServiceClassAndJpaFilteringEntity in fieldTestServiceClassAndJpaFilteringEntities"
            :key="fieldTestServiceClassAndJpaFilteringEntity.id"
            data-cy="entityTable"
          >
            <td>
              <router-link
                :to="{
                  name: 'FieldTestServiceClassAndJpaFilteringEntityView',
                  params: { fieldTestServiceClassAndJpaFilteringEntityId: fieldTestServiceClassAndJpaFilteringEntity.id },
                }"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.id }}</router-link
              >
            </td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.stringBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.integerBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.integerMinBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.longBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.longMinBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.longMaxBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.floatBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.floatMinBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.localDateBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob }}</td>
            <td>
              {{
                fieldTestServiceClassAndJpaFilteringEntity.instantBob
                  ? $d(Date.parse(fieldTestServiceClassAndJpaFilteringEntity.instantBob), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob
                  ? $d(Date.parse(fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob
                  ? $d(Date.parse(fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob
                  ? $d(Date.parse(fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob), 'short')
                  : ''
              }}
            </td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.durationBob | duration }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob | duration }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.booleanBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestServiceClassAndJpaFilteringEntity.enumBob)">
              {{ fieldTestServiceClassAndJpaFilteringEntity.enumBob }}
            </td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob)">
              {{ fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob }}
            </td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.uuidBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob }}</td>
            <td>
              <a
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageBob"
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageBob
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageBobContentType +
                    ';base64,' +
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageBob
                  "
                  style="max-height: 30px"
                  alt="fieldTestServiceClassAndJpaFilteringEntity image"
                />
              </a>
              <span v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageBob"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.byteImageBobContentType }},
                {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageBob) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob"
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBobContentType +
                    ';base64,' +
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob
                  "
                  style="max-height: 30px"
                  alt="fieldTestServiceClassAndJpaFilteringEntity image"
                />
              </a>
              <span v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBobContentType }},
                {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob"
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBobContentType +
                    ';base64,' +
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob
                  "
                  style="max-height: 30px"
                  alt="fieldTestServiceClassAndJpaFilteringEntity image"
                />
              </a>
              <span v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBobContentType }},
                {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob"
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBobContentType +
                    ';base64,' +
                    fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob
                  "
                  style="max-height: 30px"
                  alt="fieldTestServiceClassAndJpaFilteringEntity image"
                />
              </a>
              <span v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBobContentType }},
                {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob"
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyBobContentType }},
                {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob"
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBobContentType }},
                {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob"
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBobContentType }},
                {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob"
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob"
                >{{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBobContentType }},
                {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob) }}</span
              >
            </td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.byteTextBob }}</td>
            <td>{{ fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{
                    name: 'FieldTestServiceClassAndJpaFilteringEntityView',
                    params: { fieldTestServiceClassAndJpaFilteringEntityId: fieldTestServiceClassAndJpaFilteringEntity.id },
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
                    name: 'FieldTestServiceClassAndJpaFilteringEntityEdit',
                    params: { fieldTestServiceClassAndJpaFilteringEntityId: fieldTestServiceClassAndJpaFilteringEntity.id },
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
                  v-on:click="prepareRemove(fieldTestServiceClassAndJpaFilteringEntity)"
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
          id="jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.delete.question"
          data-cy="fieldTestServiceClassAndJpaFilteringEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-fieldTestServiceClassAndJpaFilteringEntity-heading"
          v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Field Test Service Class And Jpa Filtering Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-fieldTestServiceClassAndJpaFilteringEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFieldTestServiceClassAndJpaFilteringEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./field-test-service-class-and-jpa-filtering-entity.component.ts"></script>
