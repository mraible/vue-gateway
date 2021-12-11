<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fieldTestInfiniteScrollEntity">
        <h2 class="jh-entity-heading" data-cy="fieldTestInfiniteScrollEntityDetailsHeading">
          <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.detail.title')">FieldTestInfiniteScrollEntity</span>
          {{ fieldTestInfiniteScrollEntity.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringHugo')">String Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.stringHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringRequiredHugo')">String Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.stringRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringMinlengthHugo')">String Minlength Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.stringMinlengthHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringMaxlengthHugo')">String Maxlength Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.stringMaxlengthHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.stringPatternHugo')">String Pattern Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.stringPatternHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.integerHugo')">Integer Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.integerHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.integerRequiredHugo')">Integer Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.integerRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.integerMinHugo')">Integer Min Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.integerMinHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.integerMaxHugo')">Integer Max Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.integerMaxHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.longHugo')">Long Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.longHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.longRequiredHugo')">Long Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.longRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.longMinHugo')">Long Min Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.longMinHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.longMaxHugo')">Long Max Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.longMaxHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.floatHugo')">Float Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.floatHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.floatRequiredHugo')">Float Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.floatRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.floatMinHugo')">Float Min Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.floatMinHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.floatMaxHugo')">Float Max Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.floatMaxHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.doubleRequiredHugo')">Double Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.doubleRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.doubleMinHugo')">Double Min Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.doubleMinHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.doubleMaxHugo')">Double Max Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.doubleMaxHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.bigDecimalRequiredHugo')">Big Decimal Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.bigDecimalRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.bigDecimalMinHugo')">Big Decimal Min Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.bigDecimalMinHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.bigDecimalMaxHugo')">Big Decimal Max Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.bigDecimalMaxHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.localDateHugo')">Local Date Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.localDateHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.localDateRequiredHugo')">Local Date Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.localDateRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.instantHugo')">Instant Hugo</span>
          </dt>
          <dd>
            <span v-if="fieldTestInfiniteScrollEntity.instantHugo">{{
              $d(Date.parse(fieldTestInfiniteScrollEntity.instantHugo), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.instanteRequiredHugo')">Instante Required Hugo</span>
          </dt>
          <dd>
            <span v-if="fieldTestInfiniteScrollEntity.instanteRequiredHugo">{{
              $d(Date.parse(fieldTestInfiniteScrollEntity.instanteRequiredHugo), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.zonedDateTimeHugo')">Zoned Date Time Hugo</span>
          </dt>
          <dd>
            <span v-if="fieldTestInfiniteScrollEntity.zonedDateTimeHugo">{{
              $d(Date.parse(fieldTestInfiniteScrollEntity.zonedDateTimeHugo), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.zonedDateTimeRequiredHugo')">Zoned Date Time Required Hugo</span>
          </dt>
          <dd>
            <span v-if="fieldTestInfiniteScrollEntity.zonedDateTimeRequiredHugo">{{
              $d(Date.parse(fieldTestInfiniteScrollEntity.zonedDateTimeRequiredHugo), 'long')
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.durationHugo')">Duration Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.durationHugo | duration }} ({{ fieldTestInfiniteScrollEntity.durationHugo }})</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.durationRequiredHugo')">Duration Required Hugo</span>
          </dt>
          <dd>
            <span
              >{{ fieldTestInfiniteScrollEntity.durationRequiredHugo | duration }} ({{
                fieldTestInfiniteScrollEntity.durationRequiredHugo
              }})</span
            >
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.booleanHugo')">Boolean Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.booleanHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.booleanRequiredHugo')">Boolean Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.booleanRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.enumHugo')">Enum Hugo</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumFieldClass.' + fieldTestInfiniteScrollEntity.enumHugo)">{{
              fieldTestInfiniteScrollEntity.enumHugo
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.enumRequiredHugo')">Enum Required Hugo</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterApp.EnumRequiredFieldClass.' + fieldTestInfiniteScrollEntity.enumRequiredHugo)">{{
              fieldTestInfiniteScrollEntity.enumRequiredHugo
            }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.uuidHugo')">Uuid Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.uuidHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.uuidRequiredHugo')">Uuid Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.uuidRequiredHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteImageHugo')">Byte Image Hugo</span>
          </dt>
          <dd>
            <div v-if="fieldTestInfiniteScrollEntity.byteImageHugo">
              <a v-on:click="openFile(fieldTestInfiniteScrollEntity.byteImageHugoContentType, fieldTestInfiniteScrollEntity.byteImageHugo)">
                <img
                  v-bind:src="
                    'data:' +
                    fieldTestInfiniteScrollEntity.byteImageHugoContentType +
                    ';base64,' +
                    fieldTestInfiniteScrollEntity.byteImageHugo
                  "
                  style="max-width: 100%"
                  alt="fieldTestInfiniteScrollEntity image"
                />
              </a>
              {{ fieldTestInfiniteScrollEntity.byteImageHugoContentType }}, {{ byteSize(fieldTestInfiniteScrollEntity.byteImageHugo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteImageRequiredHugo')">Byte Image Required Hugo</span>
          </dt>
          <dd>
            <div v-if="fieldTestInfiniteScrollEntity.byteImageRequiredHugo">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestInfiniteScrollEntity image"
                />
              </a>
              {{ fieldTestInfiniteScrollEntity.byteImageRequiredHugoContentType }},
              {{ byteSize(fieldTestInfiniteScrollEntity.byteImageRequiredHugo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteImageMinbytesHugo')">Byte Image Minbytes Hugo</span>
          </dt>
          <dd>
            <div v-if="fieldTestInfiniteScrollEntity.byteImageMinbytesHugo">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestInfiniteScrollEntity image"
                />
              </a>
              {{ fieldTestInfiniteScrollEntity.byteImageMinbytesHugoContentType }},
              {{ byteSize(fieldTestInfiniteScrollEntity.byteImageMinbytesHugo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo')">Byte Image Maxbytes Hugo</span>
          </dt>
          <dd>
            <div v-if="fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo">
              <a
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
                  style="max-width: 100%"
                  alt="fieldTestInfiniteScrollEntity image"
                />
              </a>
              {{ fieldTestInfiniteScrollEntity.byteImageMaxbytesHugoContentType }},
              {{ byteSize(fieldTestInfiniteScrollEntity.byteImageMaxbytesHugo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteAnyHugo')">Byte Any Hugo</span>
          </dt>
          <dd>
            <div v-if="fieldTestInfiniteScrollEntity.byteAnyHugo">
              <a
                v-on:click="openFile(fieldTestInfiniteScrollEntity.byteAnyHugoContentType, fieldTestInfiniteScrollEntity.byteAnyHugo)"
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestInfiniteScrollEntity.byteAnyHugoContentType }}, {{ byteSize(fieldTestInfiniteScrollEntity.byteAnyHugo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteAnyRequiredHugo')">Byte Any Required Hugo</span>
          </dt>
          <dd>
            <div v-if="fieldTestInfiniteScrollEntity.byteAnyRequiredHugo">
              <a
                v-on:click="
                  openFile(fieldTestInfiniteScrollEntity.byteAnyRequiredHugoContentType, fieldTestInfiniteScrollEntity.byteAnyRequiredHugo)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestInfiniteScrollEntity.byteAnyRequiredHugoContentType }},
              {{ byteSize(fieldTestInfiniteScrollEntity.byteAnyRequiredHugo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo')">Byte Any Minbytes Hugo</span>
          </dt>
          <dd>
            <div v-if="fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo">
              <a
                v-on:click="
                  openFile(fieldTestInfiniteScrollEntity.byteAnyMinbytesHugoContentType, fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestInfiniteScrollEntity.byteAnyMinbytesHugoContentType }},
              {{ byteSize(fieldTestInfiniteScrollEntity.byteAnyMinbytesHugo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo')">Byte Any Maxbytes Hugo</span>
          </dt>
          <dd>
            <div v-if="fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo">
              <a
                v-on:click="
                  openFile(fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugoContentType, fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo)
                "
                v-text="$t('entity.action.open')"
                >open</a
              >
              {{ fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugoContentType }},
              {{ byteSize(fieldTestInfiniteScrollEntity.byteAnyMaxbytesHugo) }}
            </div>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteTextHugo')">Byte Text Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.byteTextHugo }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterApp.fieldTestInfiniteScrollEntity.byteTextRequiredHugo')">Byte Text Required Hugo</span>
          </dt>
          <dd>
            <span>{{ fieldTestInfiniteScrollEntity.byteTextRequiredHugo }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="fieldTestInfiniteScrollEntity.id"
          :to="{ name: 'FieldTestInfiniteScrollEntityEdit', params: { fieldTestInfiniteScrollEntityId: fieldTestInfiniteScrollEntity.id } }"
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

<script lang="ts" src="./field-test-infinite-scroll-entity-details.component.ts"></script>
