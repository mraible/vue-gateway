<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fieldTestEntity">
        <h2 class="jh-entity-heading" data-cy="fieldTestEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.fieldTestEntity.detail.title')">FieldTestEntity</span> {{ fieldTestEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.stringTom')">String Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.stringTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.stringRequiredTom')">String Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.stringRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.stringMinlengthTom')">String Minlength Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.stringMinlengthTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.stringMaxlengthTom')">String Maxlength Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.stringMaxlengthTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.stringPatternTom')">String Pattern Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.stringPatternTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.numberPatternTom')">Number Pattern Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.numberPatternTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.numberPatternRequiredTom')">Number Pattern Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.numberPatternRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.integerTom')">Integer Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.integerTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.integerRequiredTom')">Integer Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.integerRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.integerMinTom')">Integer Min Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.integerMinTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.integerMaxTom')">Integer Max Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.integerMaxTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.longTom')">Long Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.longTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.longRequiredTom')">Long Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.longRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.longMinTom')">Long Min Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.longMinTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.longMaxTom')">Long Max Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.longMaxTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.floatTom')">Float Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.floatTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.floatRequiredTom')">Float Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.floatRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.floatMinTom')">Float Min Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.floatMinTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.floatMaxTom')">Float Max Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.floatMaxTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.doubleRequiredTom')">Double Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.doubleRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.doubleMinTom')">Double Min Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.doubleMinTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.doubleMaxTom')">Double Max Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.doubleMaxTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalRequiredTom')">Big Decimal Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.bigDecimalRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalMinTom')">Big Decimal Min Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.bigDecimalMinTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalMaxTom')">Big Decimal Max Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.bigDecimalMaxTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.localDateTom')">Local Date Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.localDateTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.localDateRequiredTom')">Local Date Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.localDateRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.instantTom')">Instant Tom</span>
          </dt>
          <dd>
            <span v-if="fieldTestEntity.instantTom">{{ $d(Date.parse(fieldTestEntity.instantTom), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.instantRequiredTom')">Instant Required Tom</span>
          </dt>
          <dd>
            <span v-if="fieldTestEntity.instantRequiredTom">{{ $d(Date.parse(fieldTestEntity.instantRequiredTom), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.zonedDateTimeTom')">Zoned Date Time Tom</span>
          </dt>
          <dd>
            <span v-if="fieldTestEntity.zonedDateTimeTom">{{ $d(Date.parse(fieldTestEntity.zonedDateTimeTom), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.zonedDateTimeRequiredTom')">Zoned Date Time Required Tom</span>
          </dt>
          <dd>
            <span v-if="fieldTestEntity.zonedDateTimeRequiredTom">{{
              $d(Date.parse(fieldTestEntity.zonedDateTimeRequiredTom), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.durationTom')">Duration Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.durationTom | duration }} ({{ fieldTestEntity.durationTom }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.durationRequiredTom')">Duration Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.durationRequiredTom | duration }} ({{ fieldTestEntity.durationRequiredTom }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.booleanTom')">Boolean Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.booleanTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.booleanRequiredTom')">Boolean Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.booleanRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.enumTom')">Enum Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestEntity.enumTom)">{{ fieldTestEntity.enumTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.enumRequiredTom')">Enum Required Tom</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestEntity.enumRequiredTom)">{{
              fieldTestEntity.enumRequiredTom
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.uuidTom')">Uuid Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.uuidTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.uuidRequiredTom')">Uuid Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.uuidRequiredTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteImageTom')">Byte Image Tom</span>
          </dt>
          <dd>
            <div v-if="fieldTestEntity.byteImageTom">
              <a v-on:click="openFile(fieldTestEntity.byteImageTomContentType, fieldTestEntity.byteImageTom)">
                <img
                  v-bind:src="'data:' + fieldTestEntity.byteImageTomContentType + ';base64,' + fieldTestEntity.byteImageTom"
                  style="max-width: 100%"
                  alt="fieldTestEntity image"
                />
              </a>
              {{ fieldTestEntity.byteImageTomContentType }}, {{ byteSize(fieldTestEntity.byteImageTom) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteImageRequiredTom')">Byte Image Required Tom</span>
          </dt>
          <dd>
            <div v-if="fieldTestEntity.byteImageRequiredTom">
              <a v-on:click="openFile(fieldTestEntity.byteImageRequiredTomContentType, fieldTestEntity.byteImageRequiredTom)">
                <img
                  v-bind:src="'data:' + fieldTestEntity.byteImageRequiredTomContentType + ';base64,' + fieldTestEntity.byteImageRequiredTom"
                  style="max-width: 100%"
                  alt="fieldTestEntity image"
                />
              </a>
              {{ fieldTestEntity.byteImageRequiredTomContentType }}, {{ byteSize(fieldTestEntity.byteImageRequiredTom) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteImageMinbytesTom')">Byte Image Minbytes Tom</span>
          </dt>
          <dd>
            <div v-if="fieldTestEntity.byteImageMinbytesTom">
              <a v-on:click="openFile(fieldTestEntity.byteImageMinbytesTomContentType, fieldTestEntity.byteImageMinbytesTom)">
                <img
                  v-bind:src="'data:' + fieldTestEntity.byteImageMinbytesTomContentType + ';base64,' + fieldTestEntity.byteImageMinbytesTom"
                  style="max-width: 100%"
                  alt="fieldTestEntity image"
                />
              </a>
              {{ fieldTestEntity.byteImageMinbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteImageMinbytesTom) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteImageMaxbytesTom')">Byte Image Maxbytes Tom</span>
          </dt>
          <dd>
            <div v-if="fieldTestEntity.byteImageMaxbytesTom">
              <a v-on:click="openFile(fieldTestEntity.byteImageMaxbytesTomContentType, fieldTestEntity.byteImageMaxbytesTom)">
                <img
                  v-bind:src="'data:' + fieldTestEntity.byteImageMaxbytesTomContentType + ';base64,' + fieldTestEntity.byteImageMaxbytesTom"
                  style="max-width: 100%"
                  alt="fieldTestEntity image"
                />
              </a>
              {{ fieldTestEntity.byteImageMaxbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteImageMaxbytesTom) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteAnyTom')">Byte Any Tom</span>
          </dt>
          <dd>
            <div v-if="fieldTestEntity.byteAnyTom">
              <a v-on:click="openFile(fieldTestEntity.byteAnyTomContentType, fieldTestEntity.byteAnyTom)" v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestEntity.byteAnyTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyTom) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteAnyRequiredTom')">Byte Any Required Tom</span>
          </dt>
          <dd>
            <div v-if="fieldTestEntity.byteAnyRequiredTom">
              <a
                v-on:click="openFile(fieldTestEntity.byteAnyRequiredTomContentType, fieldTestEntity.byteAnyRequiredTom)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestEntity.byteAnyRequiredTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyRequiredTom) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteAnyMinbytesTom')">Byte Any Minbytes Tom</span>
          </dt>
          <dd>
            <div v-if="fieldTestEntity.byteAnyMinbytesTom">
              <a
                v-on:click="openFile(fieldTestEntity.byteAnyMinbytesTomContentType, fieldTestEntity.byteAnyMinbytesTom)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestEntity.byteAnyMinbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyMinbytesTom) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteAnyMaxbytesTom')">Byte Any Maxbytes Tom</span>
          </dt>
          <dd>
            <div v-if="fieldTestEntity.byteAnyMaxbytesTom">
              <a
                v-on:click="openFile(fieldTestEntity.byteAnyMaxbytesTomContentType, fieldTestEntity.byteAnyMaxbytesTom)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestEntity.byteAnyMaxbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyMaxbytesTom) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteTextTom')">Byte Text Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.byteTextTom }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestEntity.byteTextRequiredTom')">Byte Text Required Tom</span>
          </dt>
          <dd>
            <span>{{ fieldTestEntity.byteTextRequiredTom }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="fieldTestEntity.id"
          :to="{ name: 'FieldTestEntityEdit', params: { fieldTestEntityId: fieldTestEntity.id } }"
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

<script lang="ts" src="./field-test-entity-details.component.ts"></script>
