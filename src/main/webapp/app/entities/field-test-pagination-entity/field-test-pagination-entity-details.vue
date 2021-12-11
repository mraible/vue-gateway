<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fieldTestPaginationEntity">
        <h2 class="jh-entity-heading" data-cy="fieldTestPaginationEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.detail.title')">FieldTestPaginationEntity</span>
          {{ fieldTestPaginationEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringAlice')">String Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.stringAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringRequiredAlice')">String Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.stringRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringMinlengthAlice')">String Minlength Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.stringMinlengthAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringMaxlengthAlice')">String Maxlength Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.stringMaxlengthAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringPatternAlice')">String Pattern Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.stringPatternAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerAlice')">Integer Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.integerAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerRequiredAlice')">Integer Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.integerRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerMinAlice')">Integer Min Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.integerMinAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerMaxAlice')">Integer Max Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.integerMaxAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.longAlice')">Long Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.longAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.longRequiredAlice')">Long Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.longRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.longMinAlice')">Long Min Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.longMinAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.longMaxAlice')">Long Max Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.longMaxAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatAlice')">Float Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.floatAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatRequiredAlice')">Float Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.floatRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatMinAlice')">Float Min Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.floatMinAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatMaxAlice')">Float Max Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.floatMaxAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleRequiredAlice')">Double Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.doubleRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleMinAlice')">Double Min Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.doubleMinAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleMaxAlice')">Double Max Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.doubleMaxAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalRequiredAlice')">Big Decimal Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.bigDecimalRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalMinAlice')">Big Decimal Min Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.bigDecimalMinAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalMaxAlice')">Big Decimal Max Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.bigDecimalMaxAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.localDateAlice')">Local Date Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.localDateAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.localDateRequiredAlice')">Local Date Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.localDateRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.instantAlice')">Instant Alice</span>
          </dt>
          <dd>
            <span v-if="fieldTestPaginationEntity.instantAlice">{{ $d(Date.parse(fieldTestPaginationEntity.instantAlice), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.instanteRequiredAlice')">Instante Required Alice</span>
          </dt>
          <dd>
            <span v-if="fieldTestPaginationEntity.instanteRequiredAlice">{{
              $d(Date.parse(fieldTestPaginationEntity.instanteRequiredAlice), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.zonedDateTimeAlice')">Zoned Date Time Alice</span>
          </dt>
          <dd>
            <span v-if="fieldTestPaginationEntity.zonedDateTimeAlice">{{
              $d(Date.parse(fieldTestPaginationEntity.zonedDateTimeAlice), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.zonedDateTimeRequiredAlice')">Zoned Date Time Required Alice</span>
          </dt>
          <dd>
            <span v-if="fieldTestPaginationEntity.zonedDateTimeRequiredAlice">{{
              $d(Date.parse(fieldTestPaginationEntity.zonedDateTimeRequiredAlice), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.durationAlice')">Duration Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.durationAlice | duration }} ({{ fieldTestPaginationEntity.durationAlice }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.durationRequiredAlice')">Duration Required Alice</span>
          </dt>
          <dd>
            <span
              >{{ fieldTestPaginationEntity.durationRequiredAlice | duration }} ({{
                fieldTestPaginationEntity.durationRequiredAlice
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.booleanAlice')">Boolean Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.booleanAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.booleanRequiredAlice')">Boolean Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.booleanRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.enumAlice')">Enum Alice</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestPaginationEntity.enumAlice)">{{
              fieldTestPaginationEntity.enumAlice
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.enumRequiredAlice')">Enum Required Alice</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestPaginationEntity.enumRequiredAlice)">{{
              fieldTestPaginationEntity.enumRequiredAlice
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.uuidAlice')">Uuid Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.uuidAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.uuidRequiredAlice')">Uuid Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.uuidRequiredAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageAlice')">Byte Image Alice</span>
          </dt>
          <dd>
            <div v-if="fieldTestPaginationEntity.byteImageAlice">
              <a v-on:click="openFile(fieldTestPaginationEntity.byteImageAliceContentType, fieldTestPaginationEntity.byteImageAlice)">
                <img
                  v-bind:src="
                    'data:' + fieldTestPaginationEntity.byteImageAliceContentType + ';base64,' + fieldTestPaginationEntity.byteImageAlice
                  "
                  style="max-width: 100%"
                  alt="fieldTestPaginationEntity image"
                />
              </a>
              {{ fieldTestPaginationEntity.byteImageAliceContentType }}, {{ byteSize(fieldTestPaginationEntity.byteImageAlice) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageRequiredAlice')">Byte Image Required Alice</span>
          </dt>
          <dd>
            <div v-if="fieldTestPaginationEntity.byteImageRequiredAlice">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestPaginationEntity image"
                />
              </a>
              {{ fieldTestPaginationEntity.byteImageRequiredAliceContentType }},
              {{ byteSize(fieldTestPaginationEntity.byteImageRequiredAlice) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageMinbytesAlice')">Byte Image Minbytes Alice</span>
          </dt>
          <dd>
            <div v-if="fieldTestPaginationEntity.byteImageMinbytesAlice">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestPaginationEntity image"
                />
              </a>
              {{ fieldTestPaginationEntity.byteImageMinbytesAliceContentType }},
              {{ byteSize(fieldTestPaginationEntity.byteImageMinbytesAlice) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageMaxbytesAlice')">Byte Image Maxbytes Alice</span>
          </dt>
          <dd>
            <div v-if="fieldTestPaginationEntity.byteImageMaxbytesAlice">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestPaginationEntity image"
                />
              </a>
              {{ fieldTestPaginationEntity.byteImageMaxbytesAliceContentType }},
              {{ byteSize(fieldTestPaginationEntity.byteImageMaxbytesAlice) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyAlice')">Byte Any Alice</span>
          </dt>
          <dd>
            <div v-if="fieldTestPaginationEntity.byteAnyAlice">
              <a
                v-on:click="openFile(fieldTestPaginationEntity.byteAnyAliceContentType, fieldTestPaginationEntity.byteAnyAlice)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestPaginationEntity.byteAnyAliceContentType }}, {{ byteSize(fieldTestPaginationEntity.byteAnyAlice) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyRequiredAlice')">Byte Any Required Alice</span>
          </dt>
          <dd>
            <div v-if="fieldTestPaginationEntity.byteAnyRequiredAlice">
              <a
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteAnyRequiredAliceContentType, fieldTestPaginationEntity.byteAnyRequiredAlice)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestPaginationEntity.byteAnyRequiredAliceContentType }},
              {{ byteSize(fieldTestPaginationEntity.byteAnyRequiredAlice) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyMinbytesAlice')">Byte Any Minbytes Alice</span>
          </dt>
          <dd>
            <div v-if="fieldTestPaginationEntity.byteAnyMinbytesAlice">
              <a
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteAnyMinbytesAliceContentType, fieldTestPaginationEntity.byteAnyMinbytesAlice)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestPaginationEntity.byteAnyMinbytesAliceContentType }},
              {{ byteSize(fieldTestPaginationEntity.byteAnyMinbytesAlice) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyMaxbytesAlice')">Byte Any Maxbytes Alice</span>
          </dt>
          <dd>
            <div v-if="fieldTestPaginationEntity.byteAnyMaxbytesAlice">
              <a
                v-on:click="
                  openFile(fieldTestPaginationEntity.byteAnyMaxbytesAliceContentType, fieldTestPaginationEntity.byteAnyMaxbytesAlice)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestPaginationEntity.byteAnyMaxbytesAliceContentType }},
              {{ byteSize(fieldTestPaginationEntity.byteAnyMaxbytesAlice) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteTextAlice')">Byte Text Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.byteTextAlice }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteTextRequiredAlice')">Byte Text Required Alice</span>
          </dt>
          <dd>
            <span>{{ fieldTestPaginationEntity.byteTextRequiredAlice }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="fieldTestPaginationEntity.id"
          :to="{ name: 'FieldTestPaginationEntityEdit', params: { fieldTestPaginationEntityId: fieldTestPaginationEntity.id } }"
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

<script lang="ts" src="./field-test-pagination-entity-details.component.ts"></script>
