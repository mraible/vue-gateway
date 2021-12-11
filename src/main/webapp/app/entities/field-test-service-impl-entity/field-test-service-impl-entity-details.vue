<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fieldTestServiceImplEntity">
        <h2 class="jh-entity-heading" data-cy="fieldTestServiceImplEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.detail.title')">FieldTestServiceImplEntity</span>
          {{ fieldTestServiceImplEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringMika')">String Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.stringMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringRequiredMika')">String Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.stringRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringMinlengthMika')">String Minlength Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.stringMinlengthMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringMaxlengthMika')">String Maxlength Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.stringMaxlengthMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringPatternMika')">String Pattern Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.stringPatternMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.integerMika')">Integer Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.integerMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.integerRequiredMika')">Integer Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.integerRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.integerMinMika')">Integer Min Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.integerMinMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.integerMaxMika')">Integer Max Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.integerMaxMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.longMika')">Long Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.longMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.longRequiredMika')">Long Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.longRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.longMinMika')">Long Min Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.longMinMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.longMaxMika')">Long Max Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.longMaxMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.floatMika')">Float Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.floatMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.floatRequiredMika')">Float Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.floatRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.floatMinMika')">Float Min Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.floatMinMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.floatMaxMika')">Float Max Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.floatMaxMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.doubleRequiredMika')">Double Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.doubleRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.doubleMinMika')">Double Min Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.doubleMinMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.doubleMaxMika')">Double Max Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.doubleMaxMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.bigDecimalRequiredMika')">Big Decimal Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.bigDecimalRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.bigDecimalMinMika')">Big Decimal Min Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.bigDecimalMinMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.bigDecimalMaxMika')">Big Decimal Max Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.bigDecimalMaxMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.localDateMika')">Local Date Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.localDateMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.localDateRequiredMika')">Local Date Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.localDateRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.instantMika')">Instant Mika</span>
          </dt>
          <dd>
            <span v-if="fieldTestServiceImplEntity.instantMika">{{ $d(Date.parse(fieldTestServiceImplEntity.instantMika), 'long') }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.instanteRequiredMika')">Instante Required Mika</span>
          </dt>
          <dd>
            <span v-if="fieldTestServiceImplEntity.instanteRequiredMika">{{
              $d(Date.parse(fieldTestServiceImplEntity.instanteRequiredMika), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.zonedDateTimeMika')">Zoned Date Time Mika</span>
          </dt>
          <dd>
            <span v-if="fieldTestServiceImplEntity.zonedDateTimeMika">{{
              $d(Date.parse(fieldTestServiceImplEntity.zonedDateTimeMika), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.zonedDateTimeRequiredMika')">Zoned Date Time Required Mika</span>
          </dt>
          <dd>
            <span v-if="fieldTestServiceImplEntity.zonedDateTimeRequiredMika">{{
              $d(Date.parse(fieldTestServiceImplEntity.zonedDateTimeRequiredMika), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.durationMika')">Duration Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.durationMika | duration }} ({{ fieldTestServiceImplEntity.durationMika }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.durationRequiredMika')">Duration Required Mika</span>
          </dt>
          <dd>
            <span
              >{{ fieldTestServiceImplEntity.durationRequiredMika | duration }} ({{
                fieldTestServiceImplEntity.durationRequiredMika
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.booleanMika')">Boolean Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.booleanMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.booleanRequiredMika')">Boolean Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.booleanRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.enumMika')">Enum Mika</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestServiceImplEntity.enumMika)">{{
              fieldTestServiceImplEntity.enumMika
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.enumRequiredMika')">Enum Required Mika</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestServiceImplEntity.enumRequiredMika)">{{
              fieldTestServiceImplEntity.enumRequiredMika
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.uuidMika')">Uuid Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.uuidMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.uuidRequiredMika')">Uuid Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.uuidRequiredMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteImageMika')">Byte Image Mika</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceImplEntity.byteImageMika">
              <a v-on:click="openFile(fieldTestServiceImplEntity.byteImageMikaContentType, fieldTestServiceImplEntity.byteImageMika)">
                <img
                  v-bind:src="
                    'data:' + fieldTestServiceImplEntity.byteImageMikaContentType + ';base64,' + fieldTestServiceImplEntity.byteImageMika
                  "
                  style="max-width: 100%"
                  alt="fieldTestServiceImplEntity image"
                />
              </a>
              {{ fieldTestServiceImplEntity.byteImageMikaContentType }}, {{ byteSize(fieldTestServiceImplEntity.byteImageMika) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteImageRequiredMika')">Byte Image Required Mika</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceImplEntity.byteImageRequiredMika">
              <a
                v-on:click="
                  openFile(fieldTestServiceImplEntity.byteImageRequiredMikaContentType, fieldTestServiceImplEntity.byteImageRequiredMika)
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestServiceImplEntity.byteImageRequiredMikaContentType +
                    ';base64,' +
                    fieldTestServiceImplEntity.byteImageRequiredMika
                  "
                  style="max-width: 100%"
                  alt="fieldTestServiceImplEntity image"
                />
              </a>
              {{ fieldTestServiceImplEntity.byteImageRequiredMikaContentType }},
              {{ byteSize(fieldTestServiceImplEntity.byteImageRequiredMika) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteImageMinbytesMika')">Byte Image Minbytes Mika</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceImplEntity.byteImageMinbytesMika">
              <a
                v-on:click="
                  openFile(fieldTestServiceImplEntity.byteImageMinbytesMikaContentType, fieldTestServiceImplEntity.byteImageMinbytesMika)
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestServiceImplEntity.byteImageMinbytesMikaContentType +
                    ';base64,' +
                    fieldTestServiceImplEntity.byteImageMinbytesMika
                  "
                  style="max-width: 100%"
                  alt="fieldTestServiceImplEntity image"
                />
              </a>
              {{ fieldTestServiceImplEntity.byteImageMinbytesMikaContentType }},
              {{ byteSize(fieldTestServiceImplEntity.byteImageMinbytesMika) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteImageMaxbytesMika')">Byte Image Maxbytes Mika</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceImplEntity.byteImageMaxbytesMika">
              <a
                v-on:click="
                  openFile(fieldTestServiceImplEntity.byteImageMaxbytesMikaContentType, fieldTestServiceImplEntity.byteImageMaxbytesMika)
                "
              >
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestServiceImplEntity.byteImageMaxbytesMikaContentType +
                    ';base64,' +
                    fieldTestServiceImplEntity.byteImageMaxbytesMika
                  "
                  style="max-width: 100%"
                  alt="fieldTestServiceImplEntity image"
                />
              </a>
              {{ fieldTestServiceImplEntity.byteImageMaxbytesMikaContentType }},
              {{ byteSize(fieldTestServiceImplEntity.byteImageMaxbytesMika) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteAnyMika')">Byte Any Mika</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceImplEntity.byteAnyMika">
              <a
                v-on:click="openFile(fieldTestServiceImplEntity.byteAnyMikaContentType, fieldTestServiceImplEntity.byteAnyMika)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestServiceImplEntity.byteAnyMikaContentType }}, {{ byteSize(fieldTestServiceImplEntity.byteAnyMika) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteAnyRequiredMika')">Byte Any Required Mika</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceImplEntity.byteAnyRequiredMika">
              <a
                v-on:click="
                  openFile(fieldTestServiceImplEntity.byteAnyRequiredMikaContentType, fieldTestServiceImplEntity.byteAnyRequiredMika)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestServiceImplEntity.byteAnyRequiredMikaContentType }},
              {{ byteSize(fieldTestServiceImplEntity.byteAnyRequiredMika) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteAnyMinbytesMika')">Byte Any Minbytes Mika</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceImplEntity.byteAnyMinbytesMika">
              <a
                v-on:click="
                  openFile(fieldTestServiceImplEntity.byteAnyMinbytesMikaContentType, fieldTestServiceImplEntity.byteAnyMinbytesMika)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestServiceImplEntity.byteAnyMinbytesMikaContentType }},
              {{ byteSize(fieldTestServiceImplEntity.byteAnyMinbytesMika) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteAnyMaxbytesMika')">Byte Any Maxbytes Mika</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceImplEntity.byteAnyMaxbytesMika">
              <a
                v-on:click="
                  openFile(fieldTestServiceImplEntity.byteAnyMaxbytesMikaContentType, fieldTestServiceImplEntity.byteAnyMaxbytesMika)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestServiceImplEntity.byteAnyMaxbytesMikaContentType }},
              {{ byteSize(fieldTestServiceImplEntity.byteAnyMaxbytesMika) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteTextMika')">Byte Text Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.byteTextMika }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteTextRequiredMika')">Byte Text Required Mika</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceImplEntity.byteTextRequiredMika }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="fieldTestServiceImplEntity.id"
          :to="{ name: 'FieldTestServiceImplEntityEdit', params: { fieldTestServiceImplEntityId: fieldTestServiceImplEntity.id } }"
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

<script lang="ts" src="./field-test-service-impl-entity-details.component.ts"></script>
