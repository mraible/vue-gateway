<template>
  <div>
    <h2 id="page-heading" data-cy="FieldTestPaginationEntityHeading">
      <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.home.title')" id="field-test-pagination-entity-heading"
        >Field Test Pagination Entities</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FieldTestPaginationEntityCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-field-test-pagination-entity"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.home.createLabel')"> Create a new Field Test Pagination Entity </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && fieldTestPaginationEntities && fieldTestPaginationEntities.length === 0">
      <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.home.notFound')">No fieldTestPaginationEntities found</span>
    </div>
    <div class="table-responsive" v-if="fieldTestPaginationEntities && fieldTestPaginationEntities.length > 0">
      <table class="table table-striped" aria-describedby="fieldTestPaginationEntities">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringAlice')">String Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringRequiredAlice')">String Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringMinlengthAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringMinlengthAlice')">String Minlength Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringMinlengthAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringMaxlengthAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringMaxlengthAlice')">String Maxlength Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringMaxlengthAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringPatternAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringPatternAlice')">String Pattern Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringPatternAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('integerAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerAlice')">Integer Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'integerAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('integerRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerRequiredAlice')">Integer Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'integerRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('integerMinAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerMinAlice')">Integer Min Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'integerMinAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('integerMaxAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerMaxAlice')">Integer Max Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'integerMaxAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.longAlice')">Long Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.longRequiredAlice')">Long Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longMinAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.longMinAlice')">Long Min Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longMinAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longMaxAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.longMaxAlice')">Long Max Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longMaxAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floatAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatAlice')">Float Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floatAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floatRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatRequiredAlice')">Float Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floatRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floatMinAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatMinAlice')">Float Min Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floatMinAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floatMaxAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatMaxAlice')">Float Max Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floatMaxAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('doubleRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleRequiredAlice')">Double Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'doubleRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('doubleMinAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleMinAlice')">Double Min Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'doubleMinAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('doubleMaxAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleMaxAlice')">Double Max Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'doubleMaxAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bigDecimalRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalRequiredAlice')">Big Decimal Required Alice</span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'bigDecimalRequiredAlice'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bigDecimalMinAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalMinAlice')">Big Decimal Min Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bigDecimalMinAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bigDecimalMaxAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalMaxAlice')">Big Decimal Max Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bigDecimalMaxAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('localDateAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.localDateAlice')">Local Date Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'localDateAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('localDateRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.localDateRequiredAlice')">Local Date Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'localDateRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('instantAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.instantAlice')">Instant Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'instantAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('instanteRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.instanteRequiredAlice')">Instante Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'instanteRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('zonedDateTimeAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.zonedDateTimeAlice')">Zoned Date Time Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'zonedDateTimeAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('zonedDateTimeRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.zonedDateTimeRequiredAlice')">Zoned Date Time Required Alice</span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'zonedDateTimeRequiredAlice'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('durationAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.durationAlice')">Duration Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'durationAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('durationRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.durationRequiredAlice')">Duration Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'durationRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('booleanAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.booleanAlice')">Boolean Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'booleanAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('booleanRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.booleanRequiredAlice')">Boolean Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'booleanRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('enumAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.enumAlice')">Enum Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'enumAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('enumRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.enumRequiredAlice')">Enum Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'enumRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('uuidAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.uuidAlice')">Uuid Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uuidAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('uuidRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.uuidRequiredAlice')">Uuid Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uuidRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteImageAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageAlice')">Byte Image Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteImageAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteImageRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageRequiredAlice')">Byte Image Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteImageRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteImageMinbytesAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageMinbytesAlice')">Byte Image Minbytes Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteImageMinbytesAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteImageMaxbytesAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageMaxbytesAlice')">Byte Image Maxbytes Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteImageMaxbytesAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteAnyAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyAlice')">Byte Any Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteAnyAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteAnyRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyRequiredAlice')">Byte Any Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteAnyRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteAnyMinbytesAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyMinbytesAlice')">Byte Any Minbytes Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteAnyMinbytesAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteAnyMaxbytesAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyMaxbytesAlice')">Byte Any Maxbytes Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteAnyMaxbytesAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteTextAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteTextAlice')">Byte Text Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteTextAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteTextRequiredAlice')">
              <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteTextRequiredAlice')">Byte Text Required Alice</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteTextRequiredAlice'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="fieldTestPaginationEntity in fieldTestPaginationEntities" :key="fieldTestPaginationEntity.id" data-cy="entityTable">
            <td>
              <router-link
                :to="{ name: 'FieldTestPaginationEntityView', params: { fieldTestPaginationEntityId: fieldTestPaginationEntity.id } }"
                >{{ fieldTestPaginationEntity.id }}</router-link
              >
            </td>
            <td>{{ fieldTestPaginationEntity.stringAlice }}</td>
            <td>{{ fieldTestPaginationEntity.stringRequiredAlice }}</td>
            <td>{{ fieldTestPaginationEntity.stringMinlengthAlice }}</td>
            <td>{{ fieldTestPaginationEntity.stringMaxlengthAlice }}</td>
            <td>{{ fieldTestPaginationEntity.stringPatternAlice }}</td>
            <td>{{ fieldTestPaginationEntity.integerAlice }}</td>
            <td>{{ fieldTestPaginationEntity.integerRequiredAlice }}</td>
            <td>{{ fieldTestPaginationEntity.integerMinAlice }}</td>
            <td>{{ fieldTestPaginationEntity.integerMaxAlice }}</td>
            <td>{{ fieldTestPaginationEntity.longAlice }}</td>
            <td>{{ fieldTestPaginationEntity.longRequiredAlice }}</td>
            <td>{{ fieldTestPaginationEntity.longMinAlice }}</td>
            <td>{{ fieldTestPaginationEntity.longMaxAlice }}</td>
            <td>{{ fieldTestPaginationEntity.floatAlice }}</td>
            <td>{{ fieldTestPaginationEntity.floatRequiredAlice }}</td>
            <td>{{ fieldTestPaginationEntity.floatMinAlice }}</td>
            <td>{{ fieldTestPaginationEntity.floatMaxAlice }}</td>
            <td>{{ fieldTestPaginationEntity.doubleRequiredAlice }}</td>
            <td>{{ fieldTestPaginationEntity.doubleMinAlice }}</td>
            <td>{{ fieldTestPaginationEntity.doubleMaxAlice }}</td>
            <td>{{ fieldTestPaginationEntity.bigDecimalRequiredAlice }}</td>
            <td>{{ fieldTestPaginationEntity.bigDecimalMinAlice }}</td>
            <td>{{ fieldTestPaginationEntity.bigDecimalMaxAlice }}</td>
            <td>{{ fieldTestPaginationEntity.localDateAlice }}</td>
            <td>{{ fieldTestPaginationEntity.localDateRequiredAlice }}</td>
            <td>{{ fieldTestPaginationEntity.instantAlice ? $d(Date.parse(fieldTestPaginationEntity.instantAlice), 'short') : '' }}</td>
            <td>
              {{
                fieldTestPaginationEntity.instanteRequiredAlice
                  ? $d(Date.parse(fieldTestPaginationEntity.instanteRequiredAlice), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestPaginationEntity.zonedDateTimeAlice ? $d(Date.parse(fieldTestPaginationEntity.zonedDateTimeAlice), 'short') : ''
              }}
            </td>
            <td>
              {{
                fieldTestPaginationEntity.zonedDateTimeRequiredAlice
                  ? $d(Date.parse(fieldTestPaginationEntity.zonedDateTimeRequiredAlice), 'short')
                  : ''
              }}
            </td>
            <td>{{ fieldTestPaginationEntity.durationAlice | duration }}</td>
            <td>{{ fieldTestPaginationEntity.durationRequiredAlice | duration }}</td>
            <td>{{ fieldTestPaginationEntity.booleanAlice }}</td>
            <td>{{ fieldTestPaginationEntity.booleanRequiredAlice }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestPaginationEntity.enumAlice)">
              {{ fieldTestPaginationEntity.enumAlice }}
            </td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestPaginationEntity.enumRequiredAlice)">
              {{ fieldTestPaginationEntity.enumRequiredAlice }}
            </td>
            <td>{{ fieldTestPaginationEntity.uuidAlice }}</td>
            <td>{{ fieldTestPaginationEntity.uuidRequiredAlice }}</td>
            <td>
              <a
                v-if="fieldTestPaginationEntity.byteImageAlice"
                v-on:click="openFile(fieldTestPaginationEntity.byteImageAliceContentType, fieldTestPaginationEntity.byteImageAlice)"
              >
                <img
                  v-bind:src="
                    'data:' + fieldTestPaginationEntity.byteImageAliceContentType + ';base64,' + fieldTestPaginationEntity.byteImageAlice
                  "
                  style="max-height: 30px"
                  alt="fieldTestPaginationEntity image"
                />
              </a>
              <span v-if="fieldTestPaginationEntity.byteImageAlice"
                >{{ fieldTestPaginationEntity.byteImageAliceContentType }}, {{ byteSize(fieldTestPaginationEntity.byteImageAlice) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestPaginationEntity.byteImageRequiredAlice"
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteImageRequiredAliceContentType, fieldTestPaginationEntity.byteImageRequiredAlice)
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestPaginationEntity.byteImageRequiredAliceContentType +
                    ';base64,' +
                    fieldTestPaginationEntity.byteImageRequiredAlice
                  "
                  style="max-height: 30px"
                  alt="fieldTestPaginationEntity image"
                />
              </a>
              <span v-if="fieldTestPaginationEntity.byteImageRequiredAlice"
                >{{ fieldTestPaginationEntity.byteImageRequiredAliceContentType }},
                {{ byteSize(fieldTestPaginationEntity.byteImageRequiredAlice) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestPaginationEntity.byteImageMinbytesAlice"
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteImageMinbytesAliceContentType, fieldTestPaginationEntity.byteImageMinbytesAlice)
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestPaginationEntity.byteImageMinbytesAliceContentType +
                    ';base64,' +
                    fieldTestPaginationEntity.byteImageMinbytesAlice
                  "
                  style="max-height: 30px"
                  alt="fieldTestPaginationEntity image"
                />
              </a>
              <span v-if="fieldTestPaginationEntity.byteImageMinbytesAlice"
                >{{ fieldTestPaginationEntity.byteImageMinbytesAliceContentType }},
                {{ byteSize(fieldTestPaginationEntity.byteImageMinbytesAlice) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestPaginationEntity.byteImageMaxbytesAlice"
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteImageMaxbytesAliceContentType, fieldTestPaginationEntity.byteImageMaxbytesAlice)
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestPaginationEntity.byteImageMaxbytesAliceContentType +
                    ';base64,' +
                    fieldTestPaginationEntity.byteImageMaxbytesAlice
                  "
                  style="max-height: 30px"
                  alt="fieldTestPaginationEntity image"
                />
              </a>
              <span v-if="fieldTestPaginationEntity.byteImageMaxbytesAlice"
                >{{ fieldTestPaginationEntity.byteImageMaxbytesAliceContentType }},
                {{ byteSize(fieldTestPaginationEntity.byteImageMaxbytesAlice) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestPaginationEntity.byteAnyAlice"
                v-on:click="openFile(fieldTestPaginationEntity.byteAnyAliceContentType, fieldTestPaginationEntity.byteAnyAlice)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestPaginationEntity.byteAnyAlice"
                >{{ fieldTestPaginationEntity.byteAnyAliceContentType }}, {{ byteSize(fieldTestPaginationEntity.byteAnyAlice) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestPaginationEntity.byteAnyRequiredAlice"
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteAnyRequiredAliceContentType, fieldTestPaginationEntity.byteAnyRequiredAlice)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestPaginationEntity.byteAnyRequiredAlice"
                >{{ fieldTestPaginationEntity.byteAnyRequiredAliceContentType }},
                {{ byteSize(fieldTestPaginationEntity.byteAnyRequiredAlice) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestPaginationEntity.byteAnyMinbytesAlice"
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteAnyMinbytesAliceContentType, fieldTestPaginationEntity.byteAnyMinbytesAlice)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestPaginationEntity.byteAnyMinbytesAlice"
                >{{ fieldTestPaginationEntity.byteAnyMinbytesAliceContentType }},
                {{ byteSize(fieldTestPaginationEntity.byteAnyMinbytesAlice) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestPaginationEntity.byteAnyMaxbytesAlice"
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteAnyMaxbytesAliceContentType, fieldTestPaginationEntity.byteAnyMaxbytesAlice)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestPaginationEntity.byteAnyMaxbytesAlice"
                >{{ fieldTestPaginationEntity.byteAnyMaxbytesAliceContentType }},
                {{ byteSize(fieldTestPaginationEntity.byteAnyMaxbytesAlice) }}</span
              >
            </td>
            <td>{{ fieldTestPaginationEntity.byteTextAlice }}</td>
            <td>{{ fieldTestPaginationEntity.byteTextRequiredAlice }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'FieldTestPaginationEntityView', params: { fieldTestPaginationEntityId: fieldTestPaginationEntity.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'FieldTestPaginationEntityEdit', params: { fieldTestPaginationEntityId: fieldTestPaginationEntity.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(fieldTestPaginationEntity)"
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
          id="jhipsterApp.fieldTestPaginationEntity.delete.question"
          data-cy="fieldTestPaginationEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-fieldTestPaginationEntity-heading"
          v-text="$t('jhipsterApp.fieldTestPaginationEntity.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Field Test Pagination Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-fieldTestPaginationEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFieldTestPaginationEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
    <div v-show="fieldTestPaginationEntities && fieldTestPaginationEntities.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./field-test-pagination-entity.component.ts"></script>
