<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fieldTestServiceClassAndJpaFilteringEntity">
        <h2 class="jh-entity-heading" data-cy="fieldTestServiceClassAndJpaFilteringEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.detail.title')"
            >FieldTestServiceClassAndJpaFilteringEntity</span
          >
          {{ fieldTestServiceClassAndJpaFilteringEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringBob')">String Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.stringBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob')">String Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob')">String Minlength Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob')">String Maxlength Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob')">String Pattern Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerBob')">Integer Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.integerBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob')">Integer Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob')">Integer Min Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.integerMinBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob')">Integer Max Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longBob')">Long Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.longBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob')">Long Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longMinBob')">Long Min Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.longMinBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob')">Long Max Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.longMaxBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatBob')">Float Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.floatBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob')">Float Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob')">Float Min Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.floatMinBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob')">Float Max Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob')">Double Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob')">Double Min Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob')">Double Max Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob')"
              >Big Decimal Required Bob</span
            >
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob')">Big Decimal Min Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob')">Big Decimal Max Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.localDateBob')">Local Date Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.localDateBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob')">Local Date Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.instantBob')">Instant Bob</span>
          </dt>
          <dd>
            <span v-if="fieldTestServiceClassAndJpaFilteringEntity.instantBob">{{
              $d(Date.parse(fieldTestServiceClassAndJpaFilteringEntity.instantBob), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob')">Instante Required Bob</span>
          </dt>
          <dd>
            <span v-if="fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob">{{
              $d(Date.parse(fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob')">Zoned Date Time Bob</span>
          </dt>
          <dd>
            <span v-if="fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob">{{
              $d(Date.parse(fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob')"
              >Zoned Date Time Required Bob</span
            >
          </dt>
          <dd>
            <span v-if="fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob">{{
              $d(Date.parse(fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.durationBob')">Duration Bob</span>
          </dt>
          <dd>
            <span
              >{{ fieldTestServiceClassAndJpaFilteringEntity.durationBob | duration }} ({{
                fieldTestServiceClassAndJpaFilteringEntity.durationBob
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob')">Duration Required Bob</span>
          </dt>
          <dd>
            <span
              >{{ fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob | duration }} ({{
                fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.booleanBob')">Boolean Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.booleanBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob')">Boolean Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.enumBob')">Enum Bob</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestServiceClassAndJpaFilteringEntity.enumBob)">{{
              fieldTestServiceClassAndJpaFilteringEntity.enumBob
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob')">Enum Required Bob</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob)">{{
              fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.uuidBob')">Uuid Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.uuidBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob')">Uuid Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageBob')">Byte Image Bob</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageBob">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestServiceClassAndJpaFilteringEntity image"
                />
              </a>
              {{ fieldTestServiceClassAndJpaFilteringEntity.byteImageBobContentType }},
              {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageBob) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob')">Byte Image Required Bob</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestServiceClassAndJpaFilteringEntity image"
                />
              </a>
              {{ fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBobContentType }},
              {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob')">Byte Image Minbytes Bob</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestServiceClassAndJpaFilteringEntity image"
                />
              </a>
              {{ fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBobContentType }},
              {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob')">Byte Image Maxbytes Bob</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestServiceClassAndJpaFilteringEntity image"
                />
              </a>
              {{ fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBobContentType }},
              {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob')">Byte Any Bob</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob">
              <a
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyBobContentType }},
              {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob')">Byte Any Required Bob</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob">
              <a
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBobContentType }},
              {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob')">Byte Any Minbytes Bob</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob">
              <a
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBobContentType }},
              {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob')">Byte Any Maxbytes Bob</span>
          </dt>
          <dd>
            <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob">
              <a
                v-on:click="
                  openFile(
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBobContentType,
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob
                  )
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBobContentType }},
              {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteTextBob')">Byte Text Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.byteTextBob }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob')">Byte Text Required Bob</span>
          </dt>
          <dd>
            <span>{{ fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="fieldTestServiceClassAndJpaFilteringEntity.id"
          :to="{
            name: 'FieldTestServiceClassAndJpaFilteringEntityEdit',
            params: { fieldTestServiceClassAndJpaFilteringEntityId: fieldTestServiceClassAndJpaFilteringEntity.id },
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

<script lang="ts" src="./field-test-service-class-and-jpa-filtering-entity-details.component.ts"></script>
