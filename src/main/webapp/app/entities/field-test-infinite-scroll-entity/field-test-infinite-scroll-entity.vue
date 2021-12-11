<template>
  <div>
    <h2 id="page-heading" data-cy="FieldTestInfiniteScrollEntityHeading">
      <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.home.title')" id="field-test-infinite-scroll-entity-heading"
        >Field Test Infinite Scroll Entities</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FieldTestInfiniteScrollEntityCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-field-test-infinite-scroll-entity"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.home.createLabel')">
              Create a new Field Test Infinite Scroll Entity
            </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && fieldTestInfiniteScrollEntities && fieldTestInfiniteScrollEntities.length === 0">
      <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.home.notFound')">No fieldTestInfiniteScrollEntities found</span>
    </div>
    <div class="table-responsive" v-if="fieldTestInfiniteScrollEntities && fieldTestInfiniteScrollEntities.length > 0">
      <table class="table table-striped" aria-describedby="fieldTestInfiniteScrollEntities">
        <thead>
          <tr>
            <th scope="row" v-on:click="changeOrder('id')">
              <span v-text="$t('global.field.id')">ID</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringHugo')">String Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringRequiredHugo')">String Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringMinlengthHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringMinlengthHugo')">String Minlength Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringMinlengthHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringMaxlengthHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringMaxlengthHugo')">String Maxlength Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringMaxlengthHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('stringPatternHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringPatternHugo')">String Pattern Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'stringPatternHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('integerHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.integerHugo')">Integer Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'integerHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('integerRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.integerRequiredHugo')">Integer Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'integerRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('integerMinHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.integerMinHugo')">Integer Min Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'integerMinHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('integerMaxHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.integerMaxHugo')">Integer Max Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'integerMaxHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.longHugo')">Long Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.longRequiredHugo')">Long Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longMinHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.longMinHugo')">Long Min Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longMinHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('longMaxHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.longMaxHugo')">Long Max Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'longMaxHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floatHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.floatHugo')">Float Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floatHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floatRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.floatRequiredHugo')">Float Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floatRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floatMinHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.floatMinHugo')">Float Min Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floatMinHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('floatMaxHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.floatMaxHugo')">Float Max Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'floatMaxHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('doubleRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.doubleRequiredHugo')">Double Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'doubleRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('doubleMinHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.doubleMinHugo')">Double Min Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'doubleMinHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('doubleMaxHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.doubleMaxHugo')">Double Max Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'doubleMaxHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bigDecimalRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.bigDecimalRequiredHugo')">Big Decimal Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bigDecimalRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bigDecimalMinHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.bigDecimalMinHugo')">Big Decimal Min Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bigDecimalMinHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('bigDecimalMaxHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.bigDecimalMaxHugo')">Big Decimal Max Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'bigDecimalMaxHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('localDateHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.localDateHugo')">Local Date Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'localDateHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('localDateRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.localDateRequiredHugo')">Local Date Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'localDateRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('instantHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.instantHugo')">Instant Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'instantHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('instanteRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.instanteRequiredHugo')">Instante Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'instanteRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('zonedDateTimeHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.zonedDateTimeHugo')">Zoned Date Time Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'zonedDateTimeHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('zonedDateTimeRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.zonedDateTimeRequiredHugo')">Zoned Date Time Required Hugo</span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'zonedDateTimeRequiredHugo'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('durationHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.durationHugo')">Duration Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'durationHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('durationRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.durationRequiredHugo')">Duration Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'durationRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('booleanHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.booleanHugo')">Boolean Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'booleanHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('booleanRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.booleanRequiredHugo')">Boolean Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'booleanRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('enumHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.enumHugo')">Enum Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'enumHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('enumRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.enumRequiredHugo')">Enum Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'enumRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('uuidHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.uuidHugo')">Uuid Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uuidHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('uuidRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.uuidRequiredHugo')">Uuid Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'uuidRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteImageHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteImageHugo')">Byte Image Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteImageHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteImageRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteImageRequiredHugo')">Byte Image Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteImageRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteImageMinbytesHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteImageMinbytesHugo')">Byte Image Minbytes Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteImageMinbytesHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteImageMaxbytesHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo')">Byte Image Maxbytes Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteImageMaxbytesHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteAnyHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteAnyHugo')">Byte Any Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteAnyHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteAnyRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteAnyRequiredHugo')">Byte Any Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteAnyRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteAnyMinbytesHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo')">Byte Any Minbytes Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteAnyMinbytesHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteAnyMaxbytesHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo')">Byte Any Maxbytes Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteAnyMaxbytesHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteTextHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteTextHugo')">Byte Text Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteTextHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row" v-on:click="changeOrder('byteTextRequiredHugo')">
              <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteTextRequiredHugo')">Byte Text Required Hugo</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'byteTextRequiredHugo'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="fieldTestInfiniteScrollEntity in fieldTestInfiniteScrollEntities"
            :key="fieldTestInfiniteScrollEntity.id"
            data-cy="entityTable"
          >
            <td>
              <router-link
                :to="{
                  name: 'FieldTestInfiniteScrollEntityView',
                  params: { fieldTestInfiniteScrollEntityId: fieldTestInfiniteScrollEntity.id },
                }"
                >{{ fieldTestInfiniteScrollEntity.id }}</router-link
              >
            </td>
            <td>{{ fieldTestInfiniteScrollEntity.stringHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.stringRequiredHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.stringMinlengthHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.stringMaxlengthHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.stringPatternHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.integerHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.integerRequiredHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.integerMinHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.integerMaxHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.longHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.longRequiredHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.longMinHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.longMaxHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.floatHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.floatRequiredHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.floatMinHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.floatMaxHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.doubleRequiredHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.doubleMinHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.doubleMaxHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.bigDecimalRequiredHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.bigDecimalMinHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.bigDecimalMaxHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.localDateHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.localDateRequiredHugo }}</td>
            <td>
              {{ fieldTestInfiniteScrollEntity.instantHugo ? $d(Date.parse(fieldTestInfiniteScrollEntity.instantHugo), 'short') : '' }}
            </td>
            <td>
              {{
                fieldTestInfiniteScrollEntity.instanteRequiredHugo
                  ? $d(Date.parse(fieldTestInfiniteScrollEntity.instanteRequiredHugo), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestInfiniteScrollEntity.zonedDateTimeHugo
                  ? $d(Date.parse(fieldTestInfiniteScrollEntity.zonedDateTimeHugo), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                fieldTestInfiniteScrollEntity.zonedDateTimeRequiredHugo
                  ? $d(Date.parse(fieldTestInfiniteScrollEntity.zonedDateTimeRequiredHugo), 'short')
                  : ''
              }}
            </td>
            <td>{{ fieldTestInfiniteScrollEntity.durationHugo | duration }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.durationRequiredHugo | duration }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.booleanHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.booleanRequiredHugo }}</td>
            <td v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestInfiniteScrollEntity.enumHugo)">
              {{ fieldTestInfiniteScrollEntity.enumHugo }}
            </td>
            <td v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestInfiniteScrollEntity.enumRequiredHugo)">
              {{ fieldTestInfiniteScrollEntity.enumRequiredHugo }}
            </td>
            <td>{{ fieldTestInfiniteScrollEntity.uuidHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.uuidRequiredHugo }}</td>
            <td>
              <a
                v-if="fieldTestInfiniteScrollEntity.byteImageHugo"
                v-on:click="openFile(fieldTestInfiniteScrollEntity.byteImageHugoContentType, fieldTestInfiniteScrollEntity.byteImageHugo)"
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestInfiniteScrollEntity.byteImageHugoContentType +
                    ';base64,' +
                    fieldTestInfiniteScrollEntity.byteImageHugo
                  "
                  style="max-height: 30px"
                  alt="fieldTestInfiniteScrollEntity image"
                />
              </a>
              <span v-if="fieldTestInfiniteScrollEntity.byteImageHugo"
                >{{ fieldTestInfiniteScrollEntity.byteImageHugoContentType }},
                {{ byteSize(fieldTestInfiniteScrollEntity.byteImageHugo) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestInfiniteScrollEntity.byteImageRequiredHugo"
                v-on:click="
                  openFile(
                    fieldTestInfiniteScrollEntity.byteImageRequiredHugoContentType,
                    fieldTestInfiniteScrollEntity.byteImageRequiredHugo
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestInfiniteScrollEntity.byteImageRequiredHugoContentType +
                    ';base64,' +
                    fieldTestInfiniteScrollEntity.byteImageRequiredHugo
                  "
                  style="max-height: 30px"
                  alt="fieldTestInfiniteScrollEntity image"
                />
              </a>
              <span v-if="fieldTestInfiniteScrollEntity.byteImageRequiredHugo"
                >{{ fieldTestInfiniteScrollEntity.byteImageRequiredHugoContentType }},
                {{ byteSize(fieldTestInfiniteScrollEntity.byteImageRequiredHugo) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestInfiniteScrollEntity.byteImageMinbytesHugo"
                v-on:click="
                  openFile(
                    fieldTestInfiniteScrollEntity.byteImageMinbytesHugoContentType,
                    fieldTestInfiniteScrollEntity.byteImageMinbytesHugo
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestInfiniteScrollEntity.byteImageMinbytesHugoContentType +
                    ';base64,' +
                    fieldTestInfiniteScrollEntity.byteImageMinbytesHugo
                  "
                  style="max-height: 30px"
                  alt="fieldTestInfiniteScrollEntity image"
                />
              </a>
              <span v-if="fieldTestInfiniteScrollEntity.byteImageMinbytesHugo"
                >{{ fieldTestInfiniteScrollEntity.byteImageMinbytesHugoContentType }},
                {{ byteSize(fieldTestInfiniteScrollEntity.byteImageMinbytesHugo) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo"
                v-on:click="
                  openFile(
                    fieldTestInfiniteScrollEntity.byteImageMaxbytesHugoContentType,
                    fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo
                  )
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestInfiniteScrollEntity.byteImageMaxbytesHugoContentType +
                    ';base64,' +
                    fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo
                  "
                  style="max-height: 30px"
                  alt="fieldTestInfiniteScrollEntity image"
                />
              </a>
              <span v-if="fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo"
                >{{ fieldTestInfiniteScrollEntity.byteImageMaxbytesHugoContentType }},
                {{ byteSize(fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestInfiniteScrollEntity.byteAnyHugo"
                v-on:click="openFile(fieldTestInfiniteScrollEntity.byteAnyHugoContentType, fieldTestInfiniteScrollEntity.byteAnyHugo)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestInfiniteScrollEntity.byteAnyHugo"
                >{{ fieldTestInfiniteScrollEntity.byteAnyHugoContentType }}, {{ byteSize(fieldTestInfiniteScrollEntity.byteAnyHugo) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestInfiniteScrollEntity.byteAnyRequiredHugo"
                v-on:click="
                  openFile(fieldTestInfiniteScrollEntity.byteAnyRequiredHugoContentType, fieldTestInfiniteScrollEntity.byteAnyRequiredHugo)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestInfiniteScrollEntity.byteAnyRequiredHugo"
                >{{ fieldTestInfiniteScrollEntity.byteAnyRequiredHugoContentType }},
                {{ byteSize(fieldTestInfiniteScrollEntity.byteAnyRequiredHugo) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo"
                v-on:click="
                  openFile(fieldTestInfiniteScrollEntity.byteAnyMinbytesHugoContentType, fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo"
                >{{ fieldTestInfiniteScrollEntity.byteAnyMinbytesHugoContentType }},
                {{ byteSize(fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo) }}</span
              >
            </td>
            <td>
              <a
                v-if="fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo"
                v-on:click="
                  openFile(fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugoContentType, fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              <span v-if="fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo"
                >{{ fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugoContentType }},
                {{ byteSize(fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo) }}</span
              >
            </td>
            <td>{{ fieldTestInfiniteScrollEntity.byteTextHugo }}</td>
            <td>{{ fieldTestInfiniteScrollEntity.byteTextRequiredHugo }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{
                    name: 'FieldTestInfiniteScrollEntityView',
                    params: { fieldTestInfiniteScrollEntityId: fieldTestInfiniteScrollEntity.id },
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
                    name: 'FieldTestInfiniteScrollEntityEdit',
                    params: { fieldTestInfiniteScrollEntityId: fieldTestInfiniteScrollEntity.id },
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
                  v-on:click="prepareRemove(fieldTestInfiniteScrollEntity)"
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
        <infinite-loading
          ref="infiniteLoading"
          v-if="totalItems > itemsPerPage"
          :identifier="infiniteId"
          slot="append"
          @infinite="loadMore"
          force-use-infinite-wrapper=".el-table__body-wrapper"
          :distance="20"
        >
        </infinite-loading>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="jhipsterApp.fieldTestInfiniteScrollEntity.delete.question"
          data-cy="fieldTestInfiniteScrollEntityDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="-delete-fieldTestInfiniteScrollEntity-heading"
          v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Field Test Infinite Scroll Entity?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="-confirm-delete-fieldTestInfiniteScrollEntity"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFieldTestInfiniteScrollEntity()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./field-test-infinite-scroll-entity.component.ts"></script>
