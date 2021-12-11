<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.fieldTestServiceImplEntity.home.createOrEditLabel"
          data-cy="FieldTestServiceImplEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.fieldTestServiceImplEntity.home.createOrEditLabel')"
        >
          Create or edit a FieldTestServiceImplEntity
        </h2>
        <div>
          <div class="form-group" v-if="fieldTestServiceImplEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="fieldTestServiceImplEntity.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringMika')"
              for="field-test-service-impl-entity-stringMika"
              >String Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMika"
              id="field-test-service-impl-entity-stringMika"
              data-cy="stringMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.stringMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.stringMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.stringMika.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringRequiredMika')"
              for="field-test-service-impl-entity-stringRequiredMika"
              >String Required Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredMika"
              id="field-test-service-impl-entity-stringRequiredMika"
              data-cy="stringRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.stringRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.stringRequiredMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.stringRequiredMika.$model"
              required
            />
            <div
              v-if="$v.fieldTestServiceImplEntity.stringRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.stringRequiredMika.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.stringRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringMinlengthMika')"
              for="field-test-service-impl-entity-stringMinlengthMika"
              >String Minlength Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthMika"
              id="field-test-service-impl-entity-stringMinlengthMika"
              data-cy="stringMinlengthMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.stringMinlengthMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.stringMinlengthMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.stringMinlengthMika.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.stringMinlengthMika.$anyDirty && $v.fieldTestServiceImplEntity.stringMinlengthMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.stringMinlengthMika.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringMaxlengthMika')"
              for="field-test-service-impl-entity-stringMaxlengthMika"
              >String Maxlength Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthMika"
              id="field-test-service-impl-entity-stringMaxlengthMika"
              data-cy="stringMaxlengthMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.stringMaxlengthMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.stringMaxlengthMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.stringMaxlengthMika.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.stringMaxlengthMika.$anyDirty && $v.fieldTestServiceImplEntity.stringMaxlengthMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.stringMaxlengthMika.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.stringPatternMika')"
              for="field-test-service-impl-entity-stringPatternMika"
              >String Pattern Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternMika"
              id="field-test-service-impl-entity-stringPatternMika"
              data-cy="stringPatternMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.stringPatternMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.stringPatternMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.stringPatternMika.$model"
            />
            <div
              v-if="$v.fieldTestServiceImplEntity.stringPatternMika.$anyDirty && $v.fieldTestServiceImplEntity.stringPatternMika.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.stringPatternMika.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Mika' })"
              >
                This field should follow pattern for "String Pattern Mika".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.integerMika')"
              for="field-test-service-impl-entity-integerMika"
              >Integer Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMika"
              id="field-test-service-impl-entity-integerMika"
              data-cy="integerMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.integerMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.integerMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.integerMika.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.integerRequiredMika')"
              for="field-test-service-impl-entity-integerRequiredMika"
              >Integer Required Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredMika"
              id="field-test-service-impl-entity-integerRequiredMika"
              data-cy="integerRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.integerRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.integerRequiredMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.integerRequiredMika.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.integerRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.integerRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.integerRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.integerRequiredMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.integerMinMika')"
              for="field-test-service-impl-entity-integerMinMika"
              >Integer Min Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinMika"
              id="field-test-service-impl-entity-integerMinMika"
              data-cy="integerMinMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.integerMinMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.integerMinMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.integerMinMika.$model"
            />
            <div v-if="$v.fieldTestServiceImplEntity.integerMinMika.$anyDirty && $v.fieldTestServiceImplEntity.integerMinMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.integerMinMika.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.integerMinMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.integerMaxMika')"
              for="field-test-service-impl-entity-integerMaxMika"
              >Integer Max Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxMika"
              id="field-test-service-impl-entity-integerMaxMika"
              data-cy="integerMaxMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.integerMaxMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.integerMaxMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.integerMaxMika.$model"
            />
            <div v-if="$v.fieldTestServiceImplEntity.integerMaxMika.$anyDirty && $v.fieldTestServiceImplEntity.integerMaxMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.integerMaxMika.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.integerMaxMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.longMika')"
              for="field-test-service-impl-entity-longMika"
              >Long Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="longMika"
              id="field-test-service-impl-entity-longMika"
              data-cy="longMika"
              :class="{ valid: !$v.fieldTestServiceImplEntity.longMika.$invalid, invalid: $v.fieldTestServiceImplEntity.longMika.$invalid }"
              v-model.number="$v.fieldTestServiceImplEntity.longMika.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.longRequiredMika')"
              for="field-test-service-impl-entity-longRequiredMika"
              >Long Required Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredMika"
              id="field-test-service-impl-entity-longRequiredMika"
              data-cy="longRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.longRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.longRequiredMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.longRequiredMika.$model"
              required
            />
            <div v-if="$v.fieldTestServiceImplEntity.longRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.longRequiredMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.longRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.longRequiredMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.longMinMika')"
              for="field-test-service-impl-entity-longMinMika"
              >Long Min Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinMika"
              id="field-test-service-impl-entity-longMinMika"
              data-cy="longMinMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.longMinMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.longMinMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.longMinMika.$model"
            />
            <div v-if="$v.fieldTestServiceImplEntity.longMinMika.$anyDirty && $v.fieldTestServiceImplEntity.longMinMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.longMinMika.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.longMinMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.longMaxMika')"
              for="field-test-service-impl-entity-longMaxMika"
              >Long Max Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxMika"
              id="field-test-service-impl-entity-longMaxMika"
              data-cy="longMaxMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.longMaxMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.longMaxMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.longMaxMika.$model"
            />
            <div v-if="$v.fieldTestServiceImplEntity.longMaxMika.$anyDirty && $v.fieldTestServiceImplEntity.longMaxMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.longMaxMika.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.longMaxMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.floatMika')"
              for="field-test-service-impl-entity-floatMika"
              >Float Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMika"
              id="field-test-service-impl-entity-floatMika"
              data-cy="floatMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.floatMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.floatMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.floatMika.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.floatRequiredMika')"
              for="field-test-service-impl-entity-floatRequiredMika"
              >Float Required Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredMika"
              id="field-test-service-impl-entity-floatRequiredMika"
              data-cy="floatRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.floatRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.floatRequiredMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.floatRequiredMika.$model"
              required
            />
            <div
              v-if="$v.fieldTestServiceImplEntity.floatRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.floatRequiredMika.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.floatRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.floatRequiredMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.floatMinMika')"
              for="field-test-service-impl-entity-floatMinMika"
              >Float Min Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinMika"
              id="field-test-service-impl-entity-floatMinMika"
              data-cy="floatMinMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.floatMinMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.floatMinMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.floatMinMika.$model"
            />
            <div v-if="$v.fieldTestServiceImplEntity.floatMinMika.$anyDirty && $v.fieldTestServiceImplEntity.floatMinMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.floatMinMika.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.floatMinMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.floatMaxMika')"
              for="field-test-service-impl-entity-floatMaxMika"
              >Float Max Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxMika"
              id="field-test-service-impl-entity-floatMaxMika"
              data-cy="floatMaxMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.floatMaxMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.floatMaxMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.floatMaxMika.$model"
            />
            <div v-if="$v.fieldTestServiceImplEntity.floatMaxMika.$anyDirty && $v.fieldTestServiceImplEntity.floatMaxMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.floatMaxMika.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.floatMaxMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.doubleRequiredMika')"
              for="field-test-service-impl-entity-doubleRequiredMika"
              >Double Required Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredMika"
              id="field-test-service-impl-entity-doubleRequiredMika"
              data-cy="doubleRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.doubleRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.doubleRequiredMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.doubleRequiredMika.$model"
              required
            />
            <div
              v-if="$v.fieldTestServiceImplEntity.doubleRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.doubleRequiredMika.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.doubleRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.doubleRequiredMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.doubleMinMika')"
              for="field-test-service-impl-entity-doubleMinMika"
              >Double Min Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinMika"
              id="field-test-service-impl-entity-doubleMinMika"
              data-cy="doubleMinMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.doubleMinMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.doubleMinMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.doubleMinMika.$model"
            />
            <div v-if="$v.fieldTestServiceImplEntity.doubleMinMika.$anyDirty && $v.fieldTestServiceImplEntity.doubleMinMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.doubleMinMika.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.doubleMinMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.doubleMaxMika')"
              for="field-test-service-impl-entity-doubleMaxMika"
              >Double Max Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxMika"
              id="field-test-service-impl-entity-doubleMaxMika"
              data-cy="doubleMaxMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.doubleMaxMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.doubleMaxMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.doubleMaxMika.$model"
            />
            <div v-if="$v.fieldTestServiceImplEntity.doubleMaxMika.$anyDirty && $v.fieldTestServiceImplEntity.doubleMaxMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.doubleMaxMika.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.doubleMaxMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.bigDecimalRequiredMika')"
              for="field-test-service-impl-entity-bigDecimalRequiredMika"
              >Big Decimal Required Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredMika"
              id="field-test-service-impl-entity-bigDecimalRequiredMika"
              data-cy="bigDecimalRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.bigDecimalRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.bigDecimalRequiredMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.bigDecimalRequiredMika.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.bigDecimalRequiredMika.$anyDirty &&
                $v.fieldTestServiceImplEntity.bigDecimalRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.bigDecimalRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.bigDecimalRequiredMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.bigDecimalMinMika')"
              for="field-test-service-impl-entity-bigDecimalMinMika"
              >Big Decimal Min Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinMika"
              id="field-test-service-impl-entity-bigDecimalMinMika"
              data-cy="bigDecimalMinMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.bigDecimalMinMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.bigDecimalMinMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.bigDecimalMinMika.$model"
            />
            <div
              v-if="$v.fieldTestServiceImplEntity.bigDecimalMinMika.$anyDirty && $v.fieldTestServiceImplEntity.bigDecimalMinMika.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.bigDecimalMinMika.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.bigDecimalMinMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.bigDecimalMaxMika')"
              for="field-test-service-impl-entity-bigDecimalMaxMika"
              >Big Decimal Max Mika</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxMika"
              id="field-test-service-impl-entity-bigDecimalMaxMika"
              data-cy="bigDecimalMaxMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.bigDecimalMaxMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.bigDecimalMaxMika.$invalid,
              }"
              v-model.number="$v.fieldTestServiceImplEntity.bigDecimalMaxMika.$model"
            />
            <div
              v-if="$v.fieldTestServiceImplEntity.bigDecimalMaxMika.$anyDirty && $v.fieldTestServiceImplEntity.bigDecimalMaxMika.$invalid"
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.bigDecimalMaxMika.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.bigDecimalMaxMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.localDateMika')"
              for="field-test-service-impl-entity-localDateMika"
              >Local Date Mika</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-service-impl-entity-localDateMika"
                  v-model="$v.fieldTestServiceImplEntity.localDateMika.$model"
                  name="localDateMika"
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
                id="field-test-service-impl-entity-localDateMika"
                data-cy="localDateMika"
                type="text"
                class="form-control"
                name="localDateMika"
                :class="{
                  valid: !$v.fieldTestServiceImplEntity.localDateMika.$invalid,
                  invalid: $v.fieldTestServiceImplEntity.localDateMika.$invalid,
                }"
                v-model="$v.fieldTestServiceImplEntity.localDateMika.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.localDateRequiredMika')"
              for="field-test-service-impl-entity-localDateRequiredMika"
              >Local Date Required Mika</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-service-impl-entity-localDateRequiredMika"
                  v-model="$v.fieldTestServiceImplEntity.localDateRequiredMika.$model"
                  name="localDateRequiredMika"
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
                id="field-test-service-impl-entity-localDateRequiredMika"
                data-cy="localDateRequiredMika"
                type="text"
                class="form-control"
                name="localDateRequiredMika"
                :class="{
                  valid: !$v.fieldTestServiceImplEntity.localDateRequiredMika.$invalid,
                  invalid: $v.fieldTestServiceImplEntity.localDateRequiredMika.$invalid,
                }"
                v-model="$v.fieldTestServiceImplEntity.localDateRequiredMika.$model"
                required
              />
            </b-input-group>
            <div
              v-if="
                $v.fieldTestServiceImplEntity.localDateRequiredMika.$anyDirty &&
                $v.fieldTestServiceImplEntity.localDateRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.localDateRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.instantMika')"
              for="field-test-service-impl-entity-instantMika"
              >Instant Mika</label
            >
            <div class="d-flex">
              <input
                id="field-test-service-impl-entity-instantMika"
                data-cy="instantMika"
                type="datetime-local"
                class="form-control"
                name="instantMika"
                :class="{
                  valid: !$v.fieldTestServiceImplEntity.instantMika.$invalid,
                  invalid: $v.fieldTestServiceImplEntity.instantMika.$invalid,
                }"
                :value="convertDateTimeFromServer($v.fieldTestServiceImplEntity.instantMika.$model)"
                @change="updateInstantField('instantMika', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.instanteRequiredMika')"
              for="field-test-service-impl-entity-instanteRequiredMika"
              >Instante Required Mika</label
            >
            <div class="d-flex">
              <input
                id="field-test-service-impl-entity-instanteRequiredMika"
                data-cy="instanteRequiredMika"
                type="datetime-local"
                class="form-control"
                name="instanteRequiredMika"
                :class="{
                  valid: !$v.fieldTestServiceImplEntity.instanteRequiredMika.$invalid,
                  invalid: $v.fieldTestServiceImplEntity.instanteRequiredMika.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestServiceImplEntity.instanteRequiredMika.$model)"
                @change="updateInstantField('instanteRequiredMika', $event)"
              />
            </div>
            <div
              v-if="
                $v.fieldTestServiceImplEntity.instanteRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.instanteRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.instanteRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.instanteRequiredMika.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.zonedDateTimeMika')"
              for="field-test-service-impl-entity-zonedDateTimeMika"
              >Zoned Date Time Mika</label
            >
            <div class="d-flex">
              <input
                id="field-test-service-impl-entity-zonedDateTimeMika"
                data-cy="zonedDateTimeMika"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeMika"
                :class="{
                  valid: !$v.fieldTestServiceImplEntity.zonedDateTimeMika.$invalid,
                  invalid: $v.fieldTestServiceImplEntity.zonedDateTimeMika.$invalid,
                }"
                :value="convertDateTimeFromServer($v.fieldTestServiceImplEntity.zonedDateTimeMika.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeMika', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.zonedDateTimeRequiredMika')"
              for="field-test-service-impl-entity-zonedDateTimeRequiredMika"
              >Zoned Date Time Required Mika</label
            >
            <div class="d-flex">
              <input
                id="field-test-service-impl-entity-zonedDateTimeRequiredMika"
                data-cy="zonedDateTimeRequiredMika"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredMika"
                :class="{
                  valid: !$v.fieldTestServiceImplEntity.zonedDateTimeRequiredMika.$invalid,
                  invalid: $v.fieldTestServiceImplEntity.zonedDateTimeRequiredMika.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestServiceImplEntity.zonedDateTimeRequiredMika.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredMika', $event)"
              />
            </div>
            <div
              v-if="
                $v.fieldTestServiceImplEntity.zonedDateTimeRequiredMika.$anyDirty &&
                $v.fieldTestServiceImplEntity.zonedDateTimeRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.zonedDateTimeRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.zonedDateTimeRequiredMika.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.durationMika')"
              for="field-test-service-impl-entity-durationMika"
              >Duration Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="durationMika"
              id="field-test-service-impl-entity-durationMika"
              data-cy="durationMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.durationMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.durationMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.durationMika.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.durationRequiredMika')"
              for="field-test-service-impl-entity-durationRequiredMika"
              >Duration Required Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredMika"
              id="field-test-service-impl-entity-durationRequiredMika"
              data-cy="durationRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.durationRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.durationRequiredMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.durationRequiredMika.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.durationRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.durationRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.durationRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.durationRequiredMika.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.booleanMika')"
              for="field-test-service-impl-entity-booleanMika"
              >Boolean Mika</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanMika"
              id="field-test-service-impl-entity-booleanMika"
              data-cy="booleanMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.booleanMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.booleanMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.booleanMika.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.booleanRequiredMika')"
              for="field-test-service-impl-entity-booleanRequiredMika"
              >Boolean Required Mika</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredMika"
              id="field-test-service-impl-entity-booleanRequiredMika"
              data-cy="booleanRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.booleanRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.booleanRequiredMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.booleanRequiredMika.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.booleanRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.booleanRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.booleanRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.enumMika')"
              for="field-test-service-impl-entity-enumMika"
              >Enum Mika</label
            >
            <select
              class="form-control"
              name="enumMika"
              :class="{ valid: !$v.fieldTestServiceImplEntity.enumMika.$invalid, invalid: $v.fieldTestServiceImplEntity.enumMika.$invalid }"
              v-model="$v.fieldTestServiceImplEntity.enumMika.$model"
              id="field-test-service-impl-entity-enumMika"
              data-cy="enumMika"
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
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.enumRequiredMika')"
              for="field-test-service-impl-entity-enumRequiredMika"
              >Enum Required Mika</label
            >
            <select
              class="form-control"
              name="enumRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.enumRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.enumRequiredMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.enumRequiredMika.$model"
              id="field-test-service-impl-entity-enumRequiredMika"
              data-cy="enumRequiredMika"
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
            <div v-if="$v.fieldTestServiceImplEntity.enumRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.enumRequiredMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.enumRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.uuidMika')"
              for="field-test-service-impl-entity-uuidMika"
              >Uuid Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidMika"
              id="field-test-service-impl-entity-uuidMika"
              data-cy="uuidMika"
              :class="{ valid: !$v.fieldTestServiceImplEntity.uuidMika.$invalid, invalid: $v.fieldTestServiceImplEntity.uuidMika.$invalid }"
              v-model="$v.fieldTestServiceImplEntity.uuidMika.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.uuidRequiredMika')"
              for="field-test-service-impl-entity-uuidRequiredMika"
              >Uuid Required Mika</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidRequiredMika"
              id="field-test-service-impl-entity-uuidRequiredMika"
              data-cy="uuidRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.uuidRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.uuidRequiredMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.uuidRequiredMika.$model"
              required
            />
            <div v-if="$v.fieldTestServiceImplEntity.uuidRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.uuidRequiredMika.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.uuidRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteImageMika')"
              for="field-test-service-impl-entity-byteImageMika"
              >Byte Image Mika</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' + fieldTestServiceImplEntity.byteImageMikaContentType + ';base64,' + fieldTestServiceImplEntity.byteImageMika
                "
                style="max-height: 100px"
                v-if="fieldTestServiceImplEntity.byteImageMika"
                alt="fieldTestServiceImplEntity image"
              />
              <div v-if="fieldTestServiceImplEntity.byteImageMika" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestServiceImplEntity.byteImageMikaContentType }}, {{ byteSize(fieldTestServiceImplEntity.byteImageMika) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMika', 'byteImageMikaContentType', 'file_byteImageMika')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMika"
                id="file_byteImageMika"
                data-cy="byteImageMika"
                v-on:change="setFileData($event, fieldTestServiceImplEntity, 'byteImageMika', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMika"
              id="field-test-service-impl-entity-byteImageMika"
              data-cy="byteImageMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteImageMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteImageMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteImageMika.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMikaContentType"
              id="field-test-service-impl-entity-byteImageMikaContentType"
              v-model="fieldTestServiceImplEntity.byteImageMikaContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteImageRequiredMika')"
              for="field-test-service-impl-entity-byteImageRequiredMika"
              >Byte Image Required Mika</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestServiceImplEntity.byteImageRequiredMikaContentType +
                  ';base64,' +
                  fieldTestServiceImplEntity.byteImageRequiredMika
                "
                style="max-height: 100px"
                v-if="fieldTestServiceImplEntity.byteImageRequiredMika"
                alt="fieldTestServiceImplEntity image"
              />
              <div v-if="fieldTestServiceImplEntity.byteImageRequiredMika" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestServiceImplEntity.byteImageRequiredMikaContentType }},
                  {{ byteSize(fieldTestServiceImplEntity.byteImageRequiredMika) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageRequiredMika', 'byteImageRequiredMikaContentType', 'file_byteImageRequiredMika')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageRequiredMika"
                id="file_byteImageRequiredMika"
                data-cy="byteImageRequiredMika"
                v-on:change="setFileData($event, fieldTestServiceImplEntity, 'byteImageRequiredMika', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredMika"
              id="field-test-service-impl-entity-byteImageRequiredMika"
              data-cy="byteImageRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteImageRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteImageRequiredMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteImageRequiredMika.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredMikaContentType"
              id="field-test-service-impl-entity-byteImageRequiredMikaContentType"
              v-model="fieldTestServiceImplEntity.byteImageRequiredMikaContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.byteImageRequiredMika.$anyDirty &&
                $v.fieldTestServiceImplEntity.byteImageRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.byteImageRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteImageMinbytesMika')"
              for="field-test-service-impl-entity-byteImageMinbytesMika"
              >Byte Image Minbytes Mika</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestServiceImplEntity.byteImageMinbytesMikaContentType +
                  ';base64,' +
                  fieldTestServiceImplEntity.byteImageMinbytesMika
                "
                style="max-height: 100px"
                v-if="fieldTestServiceImplEntity.byteImageMinbytesMika"
                alt="fieldTestServiceImplEntity image"
              />
              <div v-if="fieldTestServiceImplEntity.byteImageMinbytesMika" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestServiceImplEntity.byteImageMinbytesMikaContentType }},
                  {{ byteSize(fieldTestServiceImplEntity.byteImageMinbytesMika) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMinbytesMika', 'byteImageMinbytesMikaContentType', 'file_byteImageMinbytesMika')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMinbytesMika"
                id="file_byteImageMinbytesMika"
                data-cy="byteImageMinbytesMika"
                v-on:change="setFileData($event, fieldTestServiceImplEntity, 'byteImageMinbytesMika', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesMika"
              id="field-test-service-impl-entity-byteImageMinbytesMika"
              data-cy="byteImageMinbytesMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteImageMinbytesMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteImageMinbytesMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteImageMinbytesMika.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesMikaContentType"
              id="field-test-service-impl-entity-byteImageMinbytesMikaContentType"
              v-model="fieldTestServiceImplEntity.byteImageMinbytesMikaContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.byteImageMinbytesMika.$anyDirty &&
                $v.fieldTestServiceImplEntity.byteImageMinbytesMika.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteImageMaxbytesMika')"
              for="field-test-service-impl-entity-byteImageMaxbytesMika"
              >Byte Image Maxbytes Mika</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestServiceImplEntity.byteImageMaxbytesMikaContentType +
                  ';base64,' +
                  fieldTestServiceImplEntity.byteImageMaxbytesMika
                "
                style="max-height: 100px"
                v-if="fieldTestServiceImplEntity.byteImageMaxbytesMika"
                alt="fieldTestServiceImplEntity image"
              />
              <div v-if="fieldTestServiceImplEntity.byteImageMaxbytesMika" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestServiceImplEntity.byteImageMaxbytesMikaContentType }},
                  {{ byteSize(fieldTestServiceImplEntity.byteImageMaxbytesMika) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMaxbytesMika', 'byteImageMaxbytesMikaContentType', 'file_byteImageMaxbytesMika')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMaxbytesMika"
                id="file_byteImageMaxbytesMika"
                data-cy="byteImageMaxbytesMika"
                v-on:change="setFileData($event, fieldTestServiceImplEntity, 'byteImageMaxbytesMika', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesMika"
              id="field-test-service-impl-entity-byteImageMaxbytesMika"
              data-cy="byteImageMaxbytesMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteImageMaxbytesMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteImageMaxbytesMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteImageMaxbytesMika.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesMikaContentType"
              id="field-test-service-impl-entity-byteImageMaxbytesMikaContentType"
              v-model="fieldTestServiceImplEntity.byteImageMaxbytesMikaContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.byteImageMaxbytesMika.$anyDirty &&
                $v.fieldTestServiceImplEntity.byteImageMaxbytesMika.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteAnyMika')"
              for="field-test-service-impl-entity-byteAnyMika"
              >Byte Any Mika</label
            >
            <div>
              <div v-if="fieldTestServiceImplEntity.byteAnyMika" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="openFile(fieldTestServiceImplEntity.byteAnyMikaContentType, fieldTestServiceImplEntity.byteAnyMika)"
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestServiceImplEntity.byteAnyMikaContentType }}, {{ byteSize(fieldTestServiceImplEntity.byteAnyMika) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestServiceImplEntity.byteAnyMika = null;
                    fieldTestServiceImplEntity.byteAnyMikaContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMika"
                id="file_byteAnyMika"
                data-cy="byteAnyMika"
                v-on:change="setFileData($event, fieldTestServiceImplEntity, 'byteAnyMika', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMika"
              id="field-test-service-impl-entity-byteAnyMika"
              data-cy="byteAnyMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteAnyMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteAnyMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteAnyMika.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMikaContentType"
              id="field-test-service-impl-entity-byteAnyMikaContentType"
              v-model="fieldTestServiceImplEntity.byteAnyMikaContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteAnyRequiredMika')"
              for="field-test-service-impl-entity-byteAnyRequiredMika"
              >Byte Any Required Mika</label
            >
            <div>
              <div v-if="fieldTestServiceImplEntity.byteAnyRequiredMika" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(fieldTestServiceImplEntity.byteAnyRequiredMikaContentType, fieldTestServiceImplEntity.byteAnyRequiredMika)
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestServiceImplEntity.byteAnyRequiredMikaContentType }},
                  {{ byteSize(fieldTestServiceImplEntity.byteAnyRequiredMika) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestServiceImplEntity.byteAnyRequiredMika = null;
                    fieldTestServiceImplEntity.byteAnyRequiredMikaContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyRequiredMika"
                id="file_byteAnyRequiredMika"
                data-cy="byteAnyRequiredMika"
                v-on:change="setFileData($event, fieldTestServiceImplEntity, 'byteAnyRequiredMika', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredMika"
              id="field-test-service-impl-entity-byteAnyRequiredMika"
              data-cy="byteAnyRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteAnyRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteAnyRequiredMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteAnyRequiredMika.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredMikaContentType"
              id="field-test-service-impl-entity-byteAnyRequiredMikaContentType"
              v-model="fieldTestServiceImplEntity.byteAnyRequiredMikaContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.byteAnyRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.byteAnyRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.byteAnyRequiredMika.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteAnyMinbytesMika')"
              for="field-test-service-impl-entity-byteAnyMinbytesMika"
              >Byte Any Minbytes Mika</label
            >
            <div>
              <div v-if="fieldTestServiceImplEntity.byteAnyMinbytesMika" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(fieldTestServiceImplEntity.byteAnyMinbytesMikaContentType, fieldTestServiceImplEntity.byteAnyMinbytesMika)
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestServiceImplEntity.byteAnyMinbytesMikaContentType }},
                  {{ byteSize(fieldTestServiceImplEntity.byteAnyMinbytesMika) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestServiceImplEntity.byteAnyMinbytesMika = null;
                    fieldTestServiceImplEntity.byteAnyMinbytesMikaContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMinbytesMika"
                id="file_byteAnyMinbytesMika"
                data-cy="byteAnyMinbytesMika"
                v-on:change="setFileData($event, fieldTestServiceImplEntity, 'byteAnyMinbytesMika', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesMika"
              id="field-test-service-impl-entity-byteAnyMinbytesMika"
              data-cy="byteAnyMinbytesMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteAnyMinbytesMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteAnyMinbytesMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteAnyMinbytesMika.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesMikaContentType"
              id="field-test-service-impl-entity-byteAnyMinbytesMikaContentType"
              v-model="fieldTestServiceImplEntity.byteAnyMinbytesMikaContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.byteAnyMinbytesMika.$anyDirty && $v.fieldTestServiceImplEntity.byteAnyMinbytesMika.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteAnyMaxbytesMika')"
              for="field-test-service-impl-entity-byteAnyMaxbytesMika"
              >Byte Any Maxbytes Mika</label
            >
            <div>
              <div v-if="fieldTestServiceImplEntity.byteAnyMaxbytesMika" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(fieldTestServiceImplEntity.byteAnyMaxbytesMikaContentType, fieldTestServiceImplEntity.byteAnyMaxbytesMika)
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestServiceImplEntity.byteAnyMaxbytesMikaContentType }},
                  {{ byteSize(fieldTestServiceImplEntity.byteAnyMaxbytesMika) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestServiceImplEntity.byteAnyMaxbytesMika = null;
                    fieldTestServiceImplEntity.byteAnyMaxbytesMikaContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMaxbytesMika"
                id="file_byteAnyMaxbytesMika"
                data-cy="byteAnyMaxbytesMika"
                v-on:change="setFileData($event, fieldTestServiceImplEntity, 'byteAnyMaxbytesMika', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesMika"
              id="field-test-service-impl-entity-byteAnyMaxbytesMika"
              data-cy="byteAnyMaxbytesMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteAnyMaxbytesMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteAnyMaxbytesMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteAnyMaxbytesMika.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesMikaContentType"
              id="field-test-service-impl-entity-byteAnyMaxbytesMikaContentType"
              v-model="fieldTestServiceImplEntity.byteAnyMaxbytesMikaContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceImplEntity.byteAnyMaxbytesMika.$anyDirty && $v.fieldTestServiceImplEntity.byteAnyMaxbytesMika.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteTextMika')"
              for="field-test-service-impl-entity-byteTextMika"
              >Byte Text Mika</label
            >
            <textarea
              class="form-control"
              name="byteTextMika"
              id="field-test-service-impl-entity-byteTextMika"
              data-cy="byteTextMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteTextMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteTextMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteTextMika.$model"
            ></textarea>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceImplEntity.byteTextRequiredMika')"
              for="field-test-service-impl-entity-byteTextRequiredMika"
              >Byte Text Required Mika</label
            >
            <textarea
              class="form-control"
              name="byteTextRequiredMika"
              id="field-test-service-impl-entity-byteTextRequiredMika"
              data-cy="byteTextRequiredMika"
              :class="{
                valid: !$v.fieldTestServiceImplEntity.byteTextRequiredMika.$invalid,
                invalid: $v.fieldTestServiceImplEntity.byteTextRequiredMika.$invalid,
              }"
              v-model="$v.fieldTestServiceImplEntity.byteTextRequiredMika.$model"
              required
            ></textarea>
            <div
              v-if="
                $v.fieldTestServiceImplEntity.byteTextRequiredMika.$anyDirty && $v.fieldTestServiceImplEntity.byteTextRequiredMika.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceImplEntity.byteTextRequiredMika.required"
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
            :disabled="$v.fieldTestServiceImplEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./field-test-service-impl-entity-update.component.ts"></script>
