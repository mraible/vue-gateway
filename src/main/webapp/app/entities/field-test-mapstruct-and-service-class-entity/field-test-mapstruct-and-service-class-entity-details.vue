<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fieldTestMapstructAndServiceClassEntity">
        <h2 class="jh-entity-heading" data-cy="fieldTestMapstructAndServiceClassEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.detail.title')"
            >FieldTestMapstructAndServiceClassEntity</span
          >
          {{ fieldTestMapstructAndServiceClassEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringEva')">String Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.stringEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringRequiredEva')">String Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.stringRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva')">String Minlength Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.stringMinlengthEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva')">String Maxlength Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringPatternEva')">String Pattern Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.stringPatternEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerEva')">Integer Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.integerEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerRequiredEva')">Integer Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.integerRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerMinEva')">Integer Min Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.integerMinEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerMaxEva')">Integer Max Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.integerMaxEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longEva')">Long Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.longEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longRequiredEva')">Long Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.longRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longMinEva')">Long Min Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.longMinEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longMaxEva')">Long Max Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.longMaxEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatEva')">Float Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.floatEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatRequiredEva')">Float Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.floatRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatMinEva')">Float Min Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.floatMinEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatMaxEva')">Float Max Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.floatMaxEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva')">Double Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.doubleRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleMinEva')">Double Min Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.doubleMinEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleMaxEva')">Double Max Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.doubleMaxEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva')">Big Decimal Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva')">Big Decimal Min Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva')">Big Decimal Max Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.localDateEva')">Local Date Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.localDateEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva')">Local Date Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.localDateRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.instantEva')">Instant Eva</span>
          </dt>
          <dd>
            <span v-if="fieldTestMapstructAndServiceClassEntity.instantEva">{{
              $d(Date.parse(fieldTestMapstructAndServiceClassEntity.instantEva), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva')">Instante Required Eva</span>
          </dt>
          <dd>
            <span v-if="fieldTestMapstructAndServiceClassEntity.instanteRequiredEva">{{
              $d(Date.parse(fieldTestMapstructAndServiceClassEntity.instanteRequiredEva), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva')">Zoned Date Time Eva</span>
          </dt>
          <dd>
            <span v-if="fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva">{{
              $d(Date.parse(fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva')"
              >Zoned Date Time Required Eva</span
            >
          </dt>
          <dd>
            <span v-if="fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva">{{
              $d(Date.parse(fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.durationEva')">Duration Eva</span>
          </dt>
          <dd>
            <span
              >{{ fieldTestMapstructAndServiceClassEntity.durationEva | duration }} ({{
                fieldTestMapstructAndServiceClassEntity.durationEva
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.durationRequiredEva')">Duration Required Eva</span>
          </dt>
          <dd>
            <span
              >{{ fieldTestMapstructAndServiceClassEntity.durationRequiredEva | duration }} ({{
                fieldTestMapstructAndServiceClassEntity.durationRequiredEva
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.booleanEva')">Boolean Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.booleanEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva')">Boolean Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.booleanRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.enumEva')">Enum Eva</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestMapstructAndServiceClassEntity.enumEva)">{{
              fieldTestMapstructAndServiceClassEntity.enumEva
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.enumRequiredEva')">Enum Required Eva</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestMapstructAndServiceClassEntity.enumRequiredEva)">{{
              fieldTestMapstructAndServiceClassEntity.enumRequiredEva
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.uuidEva')">Uuid Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.uuidEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva')">Uuid Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.uuidRequiredEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageEva')">Byte Image Eva</span>
          </dt>
          <dd>
            <div v-if="fieldTestMapstructAndServiceClassEntity.byteImageEva">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestMapstructAndServiceClassEntity image"
                />
              </a>
              {{ fieldTestMapstructAndServiceClassEntity.byteImageEvaContentType }},
              {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageEva) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva')">Byte Image Required Eva</span>
          </dt>
          <dd>
            <div v-if="fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestMapstructAndServiceClassEntity image"
                />
              </a>
              {{ fieldTestMapstructAndServiceClassEntity.byteImageRequiredEvaContentType }},
              {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva')">Byte Image Minbytes Eva</span>
          </dt>
          <dd>
            <div v-if="fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestMapstructAndServiceClassEntity image"
                />
              </a>
              {{ fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEvaContentType }},
              {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva')">Byte Image Maxbytes Eva</span>
          </dt>
          <dd>
            <div v-if="fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestMapstructAndServiceClassEntity image"
                />
              </a>
              {{ fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEvaContentType }},
              {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyEva')">Byte Any Eva</span>
          </dt>
          <dd>
            <div v-if="fieldTestMapstructAndServiceClassEntity.byteAnyEva">
              <a
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteAnyEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteAnyEva
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestMapstructAndServiceClassEntity.byteAnyEvaContentType }},
              {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyEva) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva')">Byte Any Required Eva</span>
          </dt>
          <dd>
            <div v-if="fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva">
              <a
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEvaContentType }},
              {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva')">Byte Any Minbytes Eva</span>
          </dt>
          <dd>
            <div v-if="fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva">
              <a
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEvaContentType }},
              {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva')">Byte Any Maxbytes Eva</span>
          </dt>
          <dd>
            <div v-if="fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva">
              <a
                v-on:click="
                  openFile(
                    fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEvaContentType,
                    fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEvaContentType }},
              {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteTextEva')">Byte Text Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.byteTextEva }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva')">Byte Text Required Eva</span>
          </dt>
          <dd>
            <span>{{ fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="fieldTestMapstructAndServiceClassEntity.id"
          :to="{
            name: 'FieldTestMapstructAndServiceClassEntityEdit',
            params: { fieldTestMapstructAndServiceClassEntityId: fieldTestMapstructAndServiceClassEntity.id },
          }"
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

<script lang="ts" src="./field-test-mapstruct-and-service-class-entity-details.component.ts"></script>
