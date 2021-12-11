<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.fieldTestPaginationEntity.home.createOrEditLabel"
          data-cy="FieldTestPaginationEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.fieldTestPaginationEntity.home.createOrEditLabel')"
        >
          Create or edit a FieldTestPaginationEntity
        </h2>
        <div>
          <div class="form-group" v-if="fieldTestPaginationEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="fieldTestPaginationEntity.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringAlice')"
              for="field-test-pagination-entity-stringAlice"
              >String Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="stringAlice"
              id="field-test-pagination-entity-stringAlice"
              data-cy="stringAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.stringAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.stringAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.stringAlice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringRequiredAlice')"
              for="field-test-pagination-entity-stringRequiredAlice"
              >String Required Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredAlice"
              id="field-test-pagination-entity-stringRequiredAlice"
              data-cy="stringRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.stringRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.stringRequiredAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.stringRequiredAlice.$model"
              required
            />
            <div
              v-if="$v.fieldTestPaginationEntity.stringRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.stringRequiredAlice.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.stringRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringMinlengthAlice')"
              for="field-test-pagination-entity-stringMinlengthAlice"
              >String Minlength Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthAlice"
              id="field-test-pagination-entity-stringMinlengthAlice"
              data-cy="stringMinlengthAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.stringMinlengthAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.stringMinlengthAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.stringMinlengthAlice.$model"
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.stringMinlengthAlice.$anyDirty && $v.fieldTestPaginationEntity.stringMinlengthAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.stringMinlengthAlice.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringMaxlengthAlice')"
              for="field-test-pagination-entity-stringMaxlengthAlice"
              >String Maxlength Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthAlice"
              id="field-test-pagination-entity-stringMaxlengthAlice"
              data-cy="stringMaxlengthAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.stringMaxlengthAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.stringMaxlengthAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.stringMaxlengthAlice.$model"
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.stringMaxlengthAlice.$anyDirty && $v.fieldTestPaginationEntity.stringMaxlengthAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.stringMaxlengthAlice.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.stringPatternAlice')"
              for="field-test-pagination-entity-stringPatternAlice"
              >String Pattern Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternAlice"
              id="field-test-pagination-entity-stringPatternAlice"
              data-cy="stringPatternAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.stringPatternAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.stringPatternAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.stringPatternAlice.$model"
            />
            <div
              v-if="$v.fieldTestPaginationEntity.stringPatternAlice.$anyDirty && $v.fieldTestPaginationEntity.stringPatternAlice.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.stringPatternAlice.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Alice' })"
              >
                This field should follow pattern for "String Pattern Alice".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerAlice')"
              for="field-test-pagination-entity-integerAlice"
              >Integer Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="integerAlice"
              id="field-test-pagination-entity-integerAlice"
              data-cy="integerAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.integerAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.integerAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.integerAlice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerRequiredAlice')"
              for="field-test-pagination-entity-integerRequiredAlice"
              >Integer Required Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredAlice"
              id="field-test-pagination-entity-integerRequiredAlice"
              data-cy="integerRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.integerRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.integerRequiredAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.integerRequiredAlice.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.integerRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.integerRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.integerRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.integerRequiredAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerMinAlice')"
              for="field-test-pagination-entity-integerMinAlice"
              >Integer Min Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinAlice"
              id="field-test-pagination-entity-integerMinAlice"
              data-cy="integerMinAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.integerMinAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.integerMinAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.integerMinAlice.$model"
            />
            <div v-if="$v.fieldTestPaginationEntity.integerMinAlice.$anyDirty && $v.fieldTestPaginationEntity.integerMinAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.integerMinAlice.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.integerMinAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.integerMaxAlice')"
              for="field-test-pagination-entity-integerMaxAlice"
              >Integer Max Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxAlice"
              id="field-test-pagination-entity-integerMaxAlice"
              data-cy="integerMaxAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.integerMaxAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.integerMaxAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.integerMaxAlice.$model"
            />
            <div v-if="$v.fieldTestPaginationEntity.integerMaxAlice.$anyDirty && $v.fieldTestPaginationEntity.integerMaxAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.integerMaxAlice.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.integerMaxAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.longAlice')"
              for="field-test-pagination-entity-longAlice"
              >Long Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="longAlice"
              id="field-test-pagination-entity-longAlice"
              data-cy="longAlice"
              :class="{ valid: !$v.fieldTestPaginationEntity.longAlice.$invalid, invalid: $v.fieldTestPaginationEntity.longAlice.$invalid }"
              v-model.number="$v.fieldTestPaginationEntity.longAlice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.longRequiredAlice')"
              for="field-test-pagination-entity-longRequiredAlice"
              >Long Required Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredAlice"
              id="field-test-pagination-entity-longRequiredAlice"
              data-cy="longRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.longRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.longRequiredAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.longRequiredAlice.$model"
              required
            />
            <div v-if="$v.fieldTestPaginationEntity.longRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.longRequiredAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.longRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.longRequiredAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.longMinAlice')"
              for="field-test-pagination-entity-longMinAlice"
              >Long Min Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinAlice"
              id="field-test-pagination-entity-longMinAlice"
              data-cy="longMinAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.longMinAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.longMinAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.longMinAlice.$model"
            />
            <div v-if="$v.fieldTestPaginationEntity.longMinAlice.$anyDirty && $v.fieldTestPaginationEntity.longMinAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.longMinAlice.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.longMinAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.longMaxAlice')"
              for="field-test-pagination-entity-longMaxAlice"
              >Long Max Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxAlice"
              id="field-test-pagination-entity-longMaxAlice"
              data-cy="longMaxAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.longMaxAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.longMaxAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.longMaxAlice.$model"
            />
            <div v-if="$v.fieldTestPaginationEntity.longMaxAlice.$anyDirty && $v.fieldTestPaginationEntity.longMaxAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.longMaxAlice.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.longMaxAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatAlice')"
              for="field-test-pagination-entity-floatAlice"
              >Float Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="floatAlice"
              id="field-test-pagination-entity-floatAlice"
              data-cy="floatAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.floatAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.floatAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.floatAlice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatRequiredAlice')"
              for="field-test-pagination-entity-floatRequiredAlice"
              >Float Required Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredAlice"
              id="field-test-pagination-entity-floatRequiredAlice"
              data-cy="floatRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.floatRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.floatRequiredAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.floatRequiredAlice.$model"
              required
            />
            <div
              v-if="$v.fieldTestPaginationEntity.floatRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.floatRequiredAlice.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.floatRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.floatRequiredAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatMinAlice')"
              for="field-test-pagination-entity-floatMinAlice"
              >Float Min Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinAlice"
              id="field-test-pagination-entity-floatMinAlice"
              data-cy="floatMinAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.floatMinAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.floatMinAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.floatMinAlice.$model"
            />
            <div v-if="$v.fieldTestPaginationEntity.floatMinAlice.$anyDirty && $v.fieldTestPaginationEntity.floatMinAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.floatMinAlice.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.floatMinAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.floatMaxAlice')"
              for="field-test-pagination-entity-floatMaxAlice"
              >Float Max Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxAlice"
              id="field-test-pagination-entity-floatMaxAlice"
              data-cy="floatMaxAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.floatMaxAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.floatMaxAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.floatMaxAlice.$model"
            />
            <div v-if="$v.fieldTestPaginationEntity.floatMaxAlice.$anyDirty && $v.fieldTestPaginationEntity.floatMaxAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.floatMaxAlice.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.floatMaxAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleRequiredAlice')"
              for="field-test-pagination-entity-doubleRequiredAlice"
              >Double Required Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredAlice"
              id="field-test-pagination-entity-doubleRequiredAlice"
              data-cy="doubleRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.doubleRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.doubleRequiredAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.doubleRequiredAlice.$model"
              required
            />
            <div
              v-if="$v.fieldTestPaginationEntity.doubleRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.doubleRequiredAlice.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.doubleRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.doubleRequiredAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleMinAlice')"
              for="field-test-pagination-entity-doubleMinAlice"
              >Double Min Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinAlice"
              id="field-test-pagination-entity-doubleMinAlice"
              data-cy="doubleMinAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.doubleMinAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.doubleMinAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.doubleMinAlice.$model"
            />
            <div v-if="$v.fieldTestPaginationEntity.doubleMinAlice.$anyDirty && $v.fieldTestPaginationEntity.doubleMinAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.doubleMinAlice.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.doubleMinAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.doubleMaxAlice')"
              for="field-test-pagination-entity-doubleMaxAlice"
              >Double Max Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxAlice"
              id="field-test-pagination-entity-doubleMaxAlice"
              data-cy="doubleMaxAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.doubleMaxAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.doubleMaxAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.doubleMaxAlice.$model"
            />
            <div v-if="$v.fieldTestPaginationEntity.doubleMaxAlice.$anyDirty && $v.fieldTestPaginationEntity.doubleMaxAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.doubleMaxAlice.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.doubleMaxAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalRequiredAlice')"
              for="field-test-pagination-entity-bigDecimalRequiredAlice"
              >Big Decimal Required Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredAlice"
              id="field-test-pagination-entity-bigDecimalRequiredAlice"
              data-cy="bigDecimalRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.bigDecimalRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.bigDecimalRequiredAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.bigDecimalRequiredAlice.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.bigDecimalRequiredAlice.$anyDirty &&
                $v.fieldTestPaginationEntity.bigDecimalRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.bigDecimalRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.bigDecimalRequiredAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalMinAlice')"
              for="field-test-pagination-entity-bigDecimalMinAlice"
              >Big Decimal Min Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinAlice"
              id="field-test-pagination-entity-bigDecimalMinAlice"
              data-cy="bigDecimalMinAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.bigDecimalMinAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.bigDecimalMinAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.bigDecimalMinAlice.$model"
            />
            <div
              v-if="$v.fieldTestPaginationEntity.bigDecimalMinAlice.$anyDirty && $v.fieldTestPaginationEntity.bigDecimalMinAlice.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.bigDecimalMinAlice.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.bigDecimalMinAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.bigDecimalMaxAlice')"
              for="field-test-pagination-entity-bigDecimalMaxAlice"
              >Big Decimal Max Alice</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxAlice"
              id="field-test-pagination-entity-bigDecimalMaxAlice"
              data-cy="bigDecimalMaxAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.bigDecimalMaxAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.bigDecimalMaxAlice.$invalid,
              }"
              v-model.number="$v.fieldTestPaginationEntity.bigDecimalMaxAlice.$model"
            />
            <div
              v-if="$v.fieldTestPaginationEntity.bigDecimalMaxAlice.$anyDirty && $v.fieldTestPaginationEntity.bigDecimalMaxAlice.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.bigDecimalMaxAlice.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.bigDecimalMaxAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.localDateAlice')"
              for="field-test-pagination-entity-localDateAlice"
              >Local Date Alice</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-pagination-entity-localDateAlice"
                  v-model="$v.fieldTestPaginationEntity.localDateAlice.$model"
                  name="localDateAlice"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="field-test-pagination-entity-localDateAlice"
                data-cy="localDateAlice"
                type="text"
                class="form-control"
                name="localDateAlice"
                :class="{
                  valid: !$v.fieldTestPaginationEntity.localDateAlice.$invalid,
                  invalid: $v.fieldTestPaginationEntity.localDateAlice.$invalid,
                }"
                v-model="$v.fieldTestPaginationEntity.localDateAlice.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.localDateRequiredAlice')"
              for="field-test-pagination-entity-localDateRequiredAlice"
              >Local Date Required Alice</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-pagination-entity-localDateRequiredAlice"
                  v-model="$v.fieldTestPaginationEntity.localDateRequiredAlice.$model"
                  name="localDateRequiredAlice"
                  class="form-control"
                  :locale="currentLanguage"
                  button-only
                  today-button
                  reset-button
                  close-button
                >
                </b-form-datepicker>
              </b-input-group-prepend>
              <b-form-input
                id="field-test-pagination-entity-localDateRequiredAlice"
                data-cy="localDateRequiredAlice"
                type="text"
                class="form-control"
                name="localDateRequiredAlice"
                :class="{
                  valid: !$v.fieldTestPaginationEntity.localDateRequiredAlice.$invalid,
                  invalid: $v.fieldTestPaginationEntity.localDateRequiredAlice.$invalid,
                }"
                v-model="$v.fieldTestPaginationEntity.localDateRequiredAlice.$model"
                required
              />
            </b-input-group>
            <div
              v-if="
                $v.fieldTestPaginationEntity.localDateRequiredAlice.$anyDirty &&
                $v.fieldTestPaginationEntity.localDateRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.localDateRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.instantAlice')"
              for="field-test-pagination-entity-instantAlice"
              >Instant Alice</label
            >
            <div class="d-flex">
              <input
                id="field-test-pagination-entity-instantAlice"
                data-cy="instantAlice"
                type="datetime-local"
                class="form-control"
                name="instantAlice"
                :class="{
                  valid: !$v.fieldTestPaginationEntity.instantAlice.$invalid,
                  invalid: $v.fieldTestPaginationEntity.instantAlice.$invalid,
                }"
                :value="convertDateTimeFromServer($v.fieldTestPaginationEntity.instantAlice.$model)"
                @change="updateInstantField('instantAlice', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.instanteRequiredAlice')"
              for="field-test-pagination-entity-instanteRequiredAlice"
              >Instante Required Alice</label
            >
            <div class="d-flex">
              <input
                id="field-test-pagination-entity-instanteRequiredAlice"
                data-cy="instanteRequiredAlice"
                type="datetime-local"
                class="form-control"
                name="instanteRequiredAlice"
                :class="{
                  valid: !$v.fieldTestPaginationEntity.instanteRequiredAlice.$invalid,
                  invalid: $v.fieldTestPaginationEntity.instanteRequiredAlice.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestPaginationEntity.instanteRequiredAlice.$model)"
                @change="updateInstantField('instanteRequiredAlice', $event)"
              />
            </div>
            <div
              v-if="
                $v.fieldTestPaginationEntity.instanteRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.instanteRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.instanteRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.instanteRequiredAlice.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.zonedDateTimeAlice')"
              for="field-test-pagination-entity-zonedDateTimeAlice"
              >Zoned Date Time Alice</label
            >
            <div class="d-flex">
              <input
                id="field-test-pagination-entity-zonedDateTimeAlice"
                data-cy="zonedDateTimeAlice"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeAlice"
                :class="{
                  valid: !$v.fieldTestPaginationEntity.zonedDateTimeAlice.$invalid,
                  invalid: $v.fieldTestPaginationEntity.zonedDateTimeAlice.$invalid,
                }"
                :value="convertDateTimeFromServer($v.fieldTestPaginationEntity.zonedDateTimeAlice.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeAlice', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.zonedDateTimeRequiredAlice')"
              for="field-test-pagination-entity-zonedDateTimeRequiredAlice"
              >Zoned Date Time Required Alice</label
            >
            <div class="d-flex">
              <input
                id="field-test-pagination-entity-zonedDateTimeRequiredAlice"
                data-cy="zonedDateTimeRequiredAlice"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredAlice"
                :class="{
                  valid: !$v.fieldTestPaginationEntity.zonedDateTimeRequiredAlice.$invalid,
                  invalid: $v.fieldTestPaginationEntity.zonedDateTimeRequiredAlice.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestPaginationEntity.zonedDateTimeRequiredAlice.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredAlice', $event)"
              />
            </div>
            <div
              v-if="
                $v.fieldTestPaginationEntity.zonedDateTimeRequiredAlice.$anyDirty &&
                $v.fieldTestPaginationEntity.zonedDateTimeRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.zonedDateTimeRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.zonedDateTimeRequiredAlice.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.durationAlice')"
              for="field-test-pagination-entity-durationAlice"
              >Duration Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="durationAlice"
              id="field-test-pagination-entity-durationAlice"
              data-cy="durationAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.durationAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.durationAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.durationAlice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.durationRequiredAlice')"
              for="field-test-pagination-entity-durationRequiredAlice"
              >Duration Required Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredAlice"
              id="field-test-pagination-entity-durationRequiredAlice"
              data-cy="durationRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.durationRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.durationRequiredAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.durationRequiredAlice.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.durationRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.durationRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.durationRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.durationRequiredAlice.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.booleanAlice')"
              for="field-test-pagination-entity-booleanAlice"
              >Boolean Alice</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanAlice"
              id="field-test-pagination-entity-booleanAlice"
              data-cy="booleanAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.booleanAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.booleanAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.booleanAlice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.booleanRequiredAlice')"
              for="field-test-pagination-entity-booleanRequiredAlice"
              >Boolean Required Alice</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredAlice"
              id="field-test-pagination-entity-booleanRequiredAlice"
              data-cy="booleanRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.booleanRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.booleanRequiredAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.booleanRequiredAlice.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.booleanRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.booleanRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.booleanRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.enumAlice')"
              for="field-test-pagination-entity-enumAlice"
              >Enum Alice</label
            >
            <select
              class="form-control"
              name="enumAlice"
              :class="{ valid: !$v.fieldTestPaginationEntity.enumAlice.$invalid, invalid: $v.fieldTestPaginationEntity.enumAlice.$invalid }"
              v-model="$v.fieldTestPaginationEntity.enumAlice.$model"
              id="field-test-pagination-entity-enumAlice"
              data-cy="enumAlice"
            >
              <option
                v-for="enumFieldClass in enumFieldClassValues"
                :key="enumFieldClass"
                v-bind:value="enumFieldClass"
                v-bind:label="$t('jhipsterApp.EnumFieldClass.' + enumFieldClass)"
              >
                {{ enumFieldClass }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.enumRequiredAlice')"
              for="field-test-pagination-entity-enumRequiredAlice"
              >Enum Required Alice</label
            >
            <select
              class="form-control"
              name="enumRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.enumRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.enumRequiredAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.enumRequiredAlice.$model"
              id="field-test-pagination-entity-enumRequiredAlice"
              data-cy="enumRequiredAlice"
              required
            >
              <option
                v-for="enumRequiredFieldClass in enumRequiredFieldClassValues"
                :key="enumRequiredFieldClass"
                v-bind:value="enumRequiredFieldClass"
                v-bind:label="$t('jhipsterApp.EnumRequiredFieldClass.' + enumRequiredFieldClass)"
              >
                {{ enumRequiredFieldClass }}
              </option>
            </select>
            <div v-if="$v.fieldTestPaginationEntity.enumRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.enumRequiredAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.enumRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.uuidAlice')"
              for="field-test-pagination-entity-uuidAlice"
              >Uuid Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidAlice"
              id="field-test-pagination-entity-uuidAlice"
              data-cy="uuidAlice"
              :class="{ valid: !$v.fieldTestPaginationEntity.uuidAlice.$invalid, invalid: $v.fieldTestPaginationEntity.uuidAlice.$invalid }"
              v-model="$v.fieldTestPaginationEntity.uuidAlice.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.uuidRequiredAlice')"
              for="field-test-pagination-entity-uuidRequiredAlice"
              >Uuid Required Alice</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidRequiredAlice"
              id="field-test-pagination-entity-uuidRequiredAlice"
              data-cy="uuidRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.uuidRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.uuidRequiredAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.uuidRequiredAlice.$model"
              required
            />
            <div v-if="$v.fieldTestPaginationEntity.uuidRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.uuidRequiredAlice.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.uuidRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageAlice')"
              for="field-test-pagination-entity-byteImageAlice"
              >Byte Image Alice</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' + fieldTestPaginationEntity.byteImageAliceContentType + ';base64,' + fieldTestPaginationEntity.byteImageAlice
                "
                style="max-height: 100px"
                v-if="fieldTestPaginationEntity.byteImageAlice"
                alt="fieldTestPaginationEntity image"
              />
              <div v-if="fieldTestPaginationEntity.byteImageAlice" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestPaginationEntity.byteImageAliceContentType }}, {{ byteSize(fieldTestPaginationEntity.byteImageAlice) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageAlice', 'byteImageAliceContentType', 'file_byteImageAlice')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageAlice"
                id="file_byteImageAlice"
                data-cy="byteImageAlice"
                v-on:change="setFileData($event, fieldTestPaginationEntity, 'byteImageAlice', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageAlice"
              id="field-test-pagination-entity-byteImageAlice"
              data-cy="byteImageAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteImageAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteImageAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteImageAlice.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageAliceContentType"
              id="field-test-pagination-entity-byteImageAliceContentType"
              v-model="fieldTestPaginationEntity.byteImageAliceContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageRequiredAlice')"
              for="field-test-pagination-entity-byteImageRequiredAlice"
              >Byte Image Required Alice</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestPaginationEntity.byteImageRequiredAliceContentType +
                  ';base64,' +
                  fieldTestPaginationEntity.byteImageRequiredAlice
                "
                style="max-height: 100px"
                v-if="fieldTestPaginationEntity.byteImageRequiredAlice"
                alt="fieldTestPaginationEntity image"
              />
              <div v-if="fieldTestPaginationEntity.byteImageRequiredAlice" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestPaginationEntity.byteImageRequiredAliceContentType }},
                  {{ byteSize(fieldTestPaginationEntity.byteImageRequiredAlice) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageRequiredAlice', 'byteImageRequiredAliceContentType', 'file_byteImageRequiredAlice')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageRequiredAlice"
                id="file_byteImageRequiredAlice"
                data-cy="byteImageRequiredAlice"
                v-on:change="setFileData($event, fieldTestPaginationEntity, 'byteImageRequiredAlice', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredAlice"
              id="field-test-pagination-entity-byteImageRequiredAlice"
              data-cy="byteImageRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteImageRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteImageRequiredAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteImageRequiredAlice.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredAliceContentType"
              id="field-test-pagination-entity-byteImageRequiredAliceContentType"
              v-model="fieldTestPaginationEntity.byteImageRequiredAliceContentType"
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.byteImageRequiredAlice.$anyDirty &&
                $v.fieldTestPaginationEntity.byteImageRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.byteImageRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageMinbytesAlice')"
              for="field-test-pagination-entity-byteImageMinbytesAlice"
              >Byte Image Minbytes Alice</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestPaginationEntity.byteImageMinbytesAliceContentType +
                  ';base64,' +
                  fieldTestPaginationEntity.byteImageMinbytesAlice
                "
                style="max-height: 100px"
                v-if="fieldTestPaginationEntity.byteImageMinbytesAlice"
                alt="fieldTestPaginationEntity image"
              />
              <div v-if="fieldTestPaginationEntity.byteImageMinbytesAlice" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestPaginationEntity.byteImageMinbytesAliceContentType }},
                  {{ byteSize(fieldTestPaginationEntity.byteImageMinbytesAlice) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMinbytesAlice', 'byteImageMinbytesAliceContentType', 'file_byteImageMinbytesAlice')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMinbytesAlice"
                id="file_byteImageMinbytesAlice"
                data-cy="byteImageMinbytesAlice"
                v-on:change="setFileData($event, fieldTestPaginationEntity, 'byteImageMinbytesAlice', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesAlice"
              id="field-test-pagination-entity-byteImageMinbytesAlice"
              data-cy="byteImageMinbytesAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteImageMinbytesAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteImageMinbytesAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteImageMinbytesAlice.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesAliceContentType"
              id="field-test-pagination-entity-byteImageMinbytesAliceContentType"
              v-model="fieldTestPaginationEntity.byteImageMinbytesAliceContentType"
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.byteImageMinbytesAlice.$anyDirty &&
                $v.fieldTestPaginationEntity.byteImageMinbytesAlice.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteImageMaxbytesAlice')"
              for="field-test-pagination-entity-byteImageMaxbytesAlice"
              >Byte Image Maxbytes Alice</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestPaginationEntity.byteImageMaxbytesAliceContentType +
                  ';base64,' +
                  fieldTestPaginationEntity.byteImageMaxbytesAlice
                "
                style="max-height: 100px"
                v-if="fieldTestPaginationEntity.byteImageMaxbytesAlice"
                alt="fieldTestPaginationEntity image"
              />
              <div v-if="fieldTestPaginationEntity.byteImageMaxbytesAlice" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestPaginationEntity.byteImageMaxbytesAliceContentType }},
                  {{ byteSize(fieldTestPaginationEntity.byteImageMaxbytesAlice) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMaxbytesAlice', 'byteImageMaxbytesAliceContentType', 'file_byteImageMaxbytesAlice')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMaxbytesAlice"
                id="file_byteImageMaxbytesAlice"
                data-cy="byteImageMaxbytesAlice"
                v-on:change="setFileData($event, fieldTestPaginationEntity, 'byteImageMaxbytesAlice', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesAlice"
              id="field-test-pagination-entity-byteImageMaxbytesAlice"
              data-cy="byteImageMaxbytesAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteImageMaxbytesAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteImageMaxbytesAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteImageMaxbytesAlice.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesAliceContentType"
              id="field-test-pagination-entity-byteImageMaxbytesAliceContentType"
              v-model="fieldTestPaginationEntity.byteImageMaxbytesAliceContentType"
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.byteImageMaxbytesAlice.$anyDirty &&
                $v.fieldTestPaginationEntity.byteImageMaxbytesAlice.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyAlice')"
              for="field-test-pagination-entity-byteAnyAlice"
              >Byte Any Alice</label
            >
            <div>
              <div v-if="fieldTestPaginationEntity.byteAnyAlice" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="openFile(fieldTestPaginationEntity.byteAnyAliceContentType, fieldTestPaginationEntity.byteAnyAlice)"
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestPaginationEntity.byteAnyAliceContentType }}, {{ byteSize(fieldTestPaginationEntity.byteAnyAlice) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestPaginationEntity.byteAnyAlice = null;
                    fieldTestPaginationEntity.byteAnyAliceContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyAlice"
                id="file_byteAnyAlice"
                data-cy="byteAnyAlice"
                v-on:change="setFileData($event, fieldTestPaginationEntity, 'byteAnyAlice', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyAlice"
              id="field-test-pagination-entity-byteAnyAlice"
              data-cy="byteAnyAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteAnyAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteAnyAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteAnyAlice.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyAliceContentType"
              id="field-test-pagination-entity-byteAnyAliceContentType"
              v-model="fieldTestPaginationEntity.byteAnyAliceContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyRequiredAlice')"
              for="field-test-pagination-entity-byteAnyRequiredAlice"
              >Byte Any Required Alice</label
            >
            <div>
              <div v-if="fieldTestPaginationEntity.byteAnyRequiredAlice" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(fieldTestPaginationEntity.byteAnyRequiredAliceContentType, fieldTestPaginationEntity.byteAnyRequiredAlice)
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestPaginationEntity.byteAnyRequiredAliceContentType }},
                  {{ byteSize(fieldTestPaginationEntity.byteAnyRequiredAlice) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestPaginationEntity.byteAnyRequiredAlice = null;
                    fieldTestPaginationEntity.byteAnyRequiredAliceContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyRequiredAlice"
                id="file_byteAnyRequiredAlice"
                data-cy="byteAnyRequiredAlice"
                v-on:change="setFileData($event, fieldTestPaginationEntity, 'byteAnyRequiredAlice', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredAlice"
              id="field-test-pagination-entity-byteAnyRequiredAlice"
              data-cy="byteAnyRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteAnyRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteAnyRequiredAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteAnyRequiredAlice.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredAliceContentType"
              id="field-test-pagination-entity-byteAnyRequiredAliceContentType"
              v-model="fieldTestPaginationEntity.byteAnyRequiredAliceContentType"
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.byteAnyRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.byteAnyRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.byteAnyRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyMinbytesAlice')"
              for="field-test-pagination-entity-byteAnyMinbytesAlice"
              >Byte Any Minbytes Alice</label
            >
            <div>
              <div v-if="fieldTestPaginationEntity.byteAnyMinbytesAlice" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(fieldTestPaginationEntity.byteAnyMinbytesAliceContentType, fieldTestPaginationEntity.byteAnyMinbytesAlice)
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestPaginationEntity.byteAnyMinbytesAliceContentType }},
                  {{ byteSize(fieldTestPaginationEntity.byteAnyMinbytesAlice) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestPaginationEntity.byteAnyMinbytesAlice = null;
                    fieldTestPaginationEntity.byteAnyMinbytesAliceContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMinbytesAlice"
                id="file_byteAnyMinbytesAlice"
                data-cy="byteAnyMinbytesAlice"
                v-on:change="setFileData($event, fieldTestPaginationEntity, 'byteAnyMinbytesAlice', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesAlice"
              id="field-test-pagination-entity-byteAnyMinbytesAlice"
              data-cy="byteAnyMinbytesAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteAnyMinbytesAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteAnyMinbytesAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteAnyMinbytesAlice.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesAliceContentType"
              id="field-test-pagination-entity-byteAnyMinbytesAliceContentType"
              v-model="fieldTestPaginationEntity.byteAnyMinbytesAliceContentType"
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.byteAnyMinbytesAlice.$anyDirty && $v.fieldTestPaginationEntity.byteAnyMinbytesAlice.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteAnyMaxbytesAlice')"
              for="field-test-pagination-entity-byteAnyMaxbytesAlice"
              >Byte Any Maxbytes Alice</label
            >
            <div>
              <div v-if="fieldTestPaginationEntity.byteAnyMaxbytesAlice" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(fieldTestPaginationEntity.byteAnyMaxbytesAliceContentType, fieldTestPaginationEntity.byteAnyMaxbytesAlice)
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestPaginationEntity.byteAnyMaxbytesAliceContentType }},
                  {{ byteSize(fieldTestPaginationEntity.byteAnyMaxbytesAlice) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestPaginationEntity.byteAnyMaxbytesAlice = null;
                    fieldTestPaginationEntity.byteAnyMaxbytesAliceContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMaxbytesAlice"
                id="file_byteAnyMaxbytesAlice"
                data-cy="byteAnyMaxbytesAlice"
                v-on:change="setFileData($event, fieldTestPaginationEntity, 'byteAnyMaxbytesAlice', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesAlice"
              id="field-test-pagination-entity-byteAnyMaxbytesAlice"
              data-cy="byteAnyMaxbytesAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteAnyMaxbytesAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteAnyMaxbytesAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteAnyMaxbytesAlice.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesAliceContentType"
              id="field-test-pagination-entity-byteAnyMaxbytesAliceContentType"
              v-model="fieldTestPaginationEntity.byteAnyMaxbytesAliceContentType"
            />
            <div
              v-if="
                $v.fieldTestPaginationEntity.byteAnyMaxbytesAlice.$anyDirty && $v.fieldTestPaginationEntity.byteAnyMaxbytesAlice.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteTextAlice')"
              for="field-test-pagination-entity-byteTextAlice"
              >Byte Text Alice</label
            >
            <textarea
              class="form-control"
              name="byteTextAlice"
              id="field-test-pagination-entity-byteTextAlice"
              data-cy="byteTextAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteTextAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteTextAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteTextAlice.$model"
            ></textarea>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestPaginationEntity.byteTextRequiredAlice')"
              for="field-test-pagination-entity-byteTextRequiredAlice"
              >Byte Text Required Alice</label
            >
            <textarea
              class="form-control"
              name="byteTextRequiredAlice"
              id="field-test-pagination-entity-byteTextRequiredAlice"
              data-cy="byteTextRequiredAlice"
              :class="{
                valid: !$v.fieldTestPaginationEntity.byteTextRequiredAlice.$invalid,
                invalid: $v.fieldTestPaginationEntity.byteTextRequiredAlice.$invalid,
              }"
              v-model="$v.fieldTestPaginationEntity.byteTextRequiredAlice.$model"
              required
            ></textarea>
            <div
              v-if="
                $v.fieldTestPaginationEntity.byteTextRequiredAlice.$anyDirty && $v.fieldTestPaginationEntity.byteTextRequiredAlice.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestPaginationEntity.byteTextRequiredAlice.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.fieldTestPaginationEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./field-test-pagination-entity-update.component.ts"></script>
