<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.fieldTestEntity.home.createOrEditLabel"
          data-cy="FieldTestEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.fieldTestEntity.home.createOrEditLabel')"
        >
          Create or edit a FieldTestEntity
        </h2>
        <div>
          <div class="form-group" v-if="fieldTestEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="fieldTestEntity.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.stringTom')" for="field-test-entity-stringTom"
              >String Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="stringTom"
              id="field-test-entity-stringTom"
              data-cy="stringTom"
              :class="{ valid: !$v.fieldTestEntity.stringTom.$invalid, invalid: $v.fieldTestEntity.stringTom.$invalid }"
              v-model="$v.fieldTestEntity.stringTom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.stringRequiredTom')"
              for="field-test-entity-stringRequiredTom"
              >String Required Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredTom"
              id="field-test-entity-stringRequiredTom"
              data-cy="stringRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.stringRequiredTom.$invalid, invalid: $v.fieldTestEntity.stringRequiredTom.$invalid }"
              v-model="$v.fieldTestEntity.stringRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.stringRequiredTom.$anyDirty && $v.fieldTestEntity.stringRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.stringRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.stringMinlengthTom')"
              for="field-test-entity-stringMinlengthTom"
              >String Minlength Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthTom"
              id="field-test-entity-stringMinlengthTom"
              data-cy="stringMinlengthTom"
              :class="{ valid: !$v.fieldTestEntity.stringMinlengthTom.$invalid, invalid: $v.fieldTestEntity.stringMinlengthTom.$invalid }"
              v-model="$v.fieldTestEntity.stringMinlengthTom.$model"
            />
            <div v-if="$v.fieldTestEntity.stringMinlengthTom.$anyDirty && $v.fieldTestEntity.stringMinlengthTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.stringMinlengthTom.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.stringMaxlengthTom')"
              for="field-test-entity-stringMaxlengthTom"
              >String Maxlength Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthTom"
              id="field-test-entity-stringMaxlengthTom"
              data-cy="stringMaxlengthTom"
              :class="{ valid: !$v.fieldTestEntity.stringMaxlengthTom.$invalid, invalid: $v.fieldTestEntity.stringMaxlengthTom.$invalid }"
              v-model="$v.fieldTestEntity.stringMaxlengthTom.$model"
            />
            <div v-if="$v.fieldTestEntity.stringMaxlengthTom.$anyDirty && $v.fieldTestEntity.stringMaxlengthTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.stringMaxlengthTom.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.stringPatternTom')"
              for="field-test-entity-stringPatternTom"
              >String Pattern Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternTom"
              id="field-test-entity-stringPatternTom"
              data-cy="stringPatternTom"
              :class="{ valid: !$v.fieldTestEntity.stringPatternTom.$invalid, invalid: $v.fieldTestEntity.stringPatternTom.$invalid }"
              v-model="$v.fieldTestEntity.stringPatternTom.$model"
            />
            <div v-if="$v.fieldTestEntity.stringPatternTom.$anyDirty && $v.fieldTestEntity.stringPatternTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.stringPatternTom.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Tom' })"
              >
                This field should follow pattern for "String Pattern Tom".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.numberPatternTom')"
              for="field-test-entity-numberPatternTom"
              >Number Pattern Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="numberPatternTom"
              id="field-test-entity-numberPatternTom"
              data-cy="numberPatternTom"
              :class="{ valid: !$v.fieldTestEntity.numberPatternTom.$invalid, invalid: $v.fieldTestEntity.numberPatternTom.$invalid }"
              v-model="$v.fieldTestEntity.numberPatternTom.$model"
            />
            <div v-if="$v.fieldTestEntity.numberPatternTom.$anyDirty && $v.fieldTestEntity.numberPatternTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.numberPatternTom.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'Number Pattern Tom' })"
              >
                This field should follow pattern for "Number Pattern Tom".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.numberPatternRequiredTom')"
              for="field-test-entity-numberPatternRequiredTom"
              >Number Pattern Required Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="numberPatternRequiredTom"
              id="field-test-entity-numberPatternRequiredTom"
              data-cy="numberPatternRequiredTom"
              :class="{
                valid: !$v.fieldTestEntity.numberPatternRequiredTom.$invalid,
                invalid: $v.fieldTestEntity.numberPatternRequiredTom.$invalid,
              }"
              v-model="$v.fieldTestEntity.numberPatternRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.numberPatternRequiredTom.$anyDirty && $v.fieldTestEntity.numberPatternRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.numberPatternRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.numberPatternRequiredTom.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'Number Pattern Required Tom' })"
              >
                This field should follow pattern for "Number Pattern Required Tom".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.integerTom')" for="field-test-entity-integerTom"
              >Integer Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="integerTom"
              id="field-test-entity-integerTom"
              data-cy="integerTom"
              :class="{ valid: !$v.fieldTestEntity.integerTom.$invalid, invalid: $v.fieldTestEntity.integerTom.$invalid }"
              v-model.number="$v.fieldTestEntity.integerTom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.integerRequiredTom')"
              for="field-test-entity-integerRequiredTom"
              >Integer Required Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredTom"
              id="field-test-entity-integerRequiredTom"
              data-cy="integerRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.integerRequiredTom.$invalid, invalid: $v.fieldTestEntity.integerRequiredTom.$invalid }"
              v-model.number="$v.fieldTestEntity.integerRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.integerRequiredTom.$anyDirty && $v.fieldTestEntity.integerRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.integerRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.integerRequiredTom.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.integerMinTom')" for="field-test-entity-integerMinTom"
              >Integer Min Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinTom"
              id="field-test-entity-integerMinTom"
              data-cy="integerMinTom"
              :class="{ valid: !$v.fieldTestEntity.integerMinTom.$invalid, invalid: $v.fieldTestEntity.integerMinTom.$invalid }"
              v-model.number="$v.fieldTestEntity.integerMinTom.$model"
            />
            <div v-if="$v.fieldTestEntity.integerMinTom.$anyDirty && $v.fieldTestEntity.integerMinTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.integerMinTom.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small class="form-text text-danger" v-if="!$v.fieldTestEntity.integerMinTom.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.integerMaxTom')" for="field-test-entity-integerMaxTom"
              >Integer Max Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxTom"
              id="field-test-entity-integerMaxTom"
              data-cy="integerMaxTom"
              :class="{ valid: !$v.fieldTestEntity.integerMaxTom.$invalid, invalid: $v.fieldTestEntity.integerMaxTom.$invalid }"
              v-model.number="$v.fieldTestEntity.integerMaxTom.$model"
            />
            <div v-if="$v.fieldTestEntity.integerMaxTom.$anyDirty && $v.fieldTestEntity.integerMaxTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.integerMaxTom.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small class="form-text text-danger" v-if="!$v.fieldTestEntity.integerMaxTom.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.longTom')" for="field-test-entity-longTom"
              >Long Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="longTom"
              id="field-test-entity-longTom"
              data-cy="longTom"
              :class="{ valid: !$v.fieldTestEntity.longTom.$invalid, invalid: $v.fieldTestEntity.longTom.$invalid }"
              v-model.number="$v.fieldTestEntity.longTom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.longRequiredTom')"
              for="field-test-entity-longRequiredTom"
              >Long Required Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredTom"
              id="field-test-entity-longRequiredTom"
              data-cy="longRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.longRequiredTom.$invalid, invalid: $v.fieldTestEntity.longRequiredTom.$invalid }"
              v-model.number="$v.fieldTestEntity.longRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.longRequiredTom.$anyDirty && $v.fieldTestEntity.longRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.longRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.longRequiredTom.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.longMinTom')" for="field-test-entity-longMinTom"
              >Long Min Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinTom"
              id="field-test-entity-longMinTom"
              data-cy="longMinTom"
              :class="{ valid: !$v.fieldTestEntity.longMinTom.$invalid, invalid: $v.fieldTestEntity.longMinTom.$invalid }"
              v-model.number="$v.fieldTestEntity.longMinTom.$model"
            />
            <div v-if="$v.fieldTestEntity.longMinTom.$anyDirty && $v.fieldTestEntity.longMinTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.longMinTom.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small class="form-text text-danger" v-if="!$v.fieldTestEntity.longMinTom.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.longMaxTom')" for="field-test-entity-longMaxTom"
              >Long Max Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxTom"
              id="field-test-entity-longMaxTom"
              data-cy="longMaxTom"
              :class="{ valid: !$v.fieldTestEntity.longMaxTom.$invalid, invalid: $v.fieldTestEntity.longMaxTom.$invalid }"
              v-model.number="$v.fieldTestEntity.longMaxTom.$model"
            />
            <div v-if="$v.fieldTestEntity.longMaxTom.$anyDirty && $v.fieldTestEntity.longMaxTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.longMaxTom.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small class="form-text text-danger" v-if="!$v.fieldTestEntity.longMaxTom.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.floatTom')" for="field-test-entity-floatTom"
              >Float Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="floatTom"
              id="field-test-entity-floatTom"
              data-cy="floatTom"
              :class="{ valid: !$v.fieldTestEntity.floatTom.$invalid, invalid: $v.fieldTestEntity.floatTom.$invalid }"
              v-model.number="$v.fieldTestEntity.floatTom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.floatRequiredTom')"
              for="field-test-entity-floatRequiredTom"
              >Float Required Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredTom"
              id="field-test-entity-floatRequiredTom"
              data-cy="floatRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.floatRequiredTom.$invalid, invalid: $v.fieldTestEntity.floatRequiredTom.$invalid }"
              v-model.number="$v.fieldTestEntity.floatRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.floatRequiredTom.$anyDirty && $v.fieldTestEntity.floatRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.floatRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.floatRequiredTom.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.floatMinTom')" for="field-test-entity-floatMinTom"
              >Float Min Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinTom"
              id="field-test-entity-floatMinTom"
              data-cy="floatMinTom"
              :class="{ valid: !$v.fieldTestEntity.floatMinTom.$invalid, invalid: $v.fieldTestEntity.floatMinTom.$invalid }"
              v-model.number="$v.fieldTestEntity.floatMinTom.$model"
            />
            <div v-if="$v.fieldTestEntity.floatMinTom.$anyDirty && $v.fieldTestEntity.floatMinTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.floatMinTom.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small class="form-text text-danger" v-if="!$v.fieldTestEntity.floatMinTom.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.floatMaxTom')" for="field-test-entity-floatMaxTom"
              >Float Max Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxTom"
              id="field-test-entity-floatMaxTom"
              data-cy="floatMaxTom"
              :class="{ valid: !$v.fieldTestEntity.floatMaxTom.$invalid, invalid: $v.fieldTestEntity.floatMaxTom.$invalid }"
              v-model.number="$v.fieldTestEntity.floatMaxTom.$model"
            />
            <div v-if="$v.fieldTestEntity.floatMaxTom.$anyDirty && $v.fieldTestEntity.floatMaxTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.floatMaxTom.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small class="form-text text-danger" v-if="!$v.fieldTestEntity.floatMaxTom.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.doubleRequiredTom')"
              for="field-test-entity-doubleRequiredTom"
              >Double Required Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredTom"
              id="field-test-entity-doubleRequiredTom"
              data-cy="doubleRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.doubleRequiredTom.$invalid, invalid: $v.fieldTestEntity.doubleRequiredTom.$invalid }"
              v-model.number="$v.fieldTestEntity.doubleRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.doubleRequiredTom.$anyDirty && $v.fieldTestEntity.doubleRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.doubleRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.doubleRequiredTom.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.doubleMinTom')" for="field-test-entity-doubleMinTom"
              >Double Min Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinTom"
              id="field-test-entity-doubleMinTom"
              data-cy="doubleMinTom"
              :class="{ valid: !$v.fieldTestEntity.doubleMinTom.$invalid, invalid: $v.fieldTestEntity.doubleMinTom.$invalid }"
              v-model.number="$v.fieldTestEntity.doubleMinTom.$model"
            />
            <div v-if="$v.fieldTestEntity.doubleMinTom.$anyDirty && $v.fieldTestEntity.doubleMinTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.doubleMinTom.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small class="form-text text-danger" v-if="!$v.fieldTestEntity.doubleMinTom.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.doubleMaxTom')" for="field-test-entity-doubleMaxTom"
              >Double Max Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxTom"
              id="field-test-entity-doubleMaxTom"
              data-cy="doubleMaxTom"
              :class="{ valid: !$v.fieldTestEntity.doubleMaxTom.$invalid, invalid: $v.fieldTestEntity.doubleMaxTom.$invalid }"
              v-model.number="$v.fieldTestEntity.doubleMaxTom.$model"
            />
            <div v-if="$v.fieldTestEntity.doubleMaxTom.$anyDirty && $v.fieldTestEntity.doubleMaxTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.doubleMaxTom.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small class="form-text text-danger" v-if="!$v.fieldTestEntity.doubleMaxTom.numeric" v-text="$t('entity.validation.number')">
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalRequiredTom')"
              for="field-test-entity-bigDecimalRequiredTom"
              >Big Decimal Required Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredTom"
              id="field-test-entity-bigDecimalRequiredTom"
              data-cy="bigDecimalRequiredTom"
              :class="{
                valid: !$v.fieldTestEntity.bigDecimalRequiredTom.$invalid,
                invalid: $v.fieldTestEntity.bigDecimalRequiredTom.$invalid,
              }"
              v-model.number="$v.fieldTestEntity.bigDecimalRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.bigDecimalRequiredTom.$anyDirty && $v.fieldTestEntity.bigDecimalRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.bigDecimalRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.bigDecimalRequiredTom.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalMinTom')"
              for="field-test-entity-bigDecimalMinTom"
              >Big Decimal Min Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinTom"
              id="field-test-entity-bigDecimalMinTom"
              data-cy="bigDecimalMinTom"
              :class="{ valid: !$v.fieldTestEntity.bigDecimalMinTom.$invalid, invalid: $v.fieldTestEntity.bigDecimalMinTom.$invalid }"
              v-model.number="$v.fieldTestEntity.bigDecimalMinTom.$model"
            />
            <div v-if="$v.fieldTestEntity.bigDecimalMinTom.$anyDirty && $v.fieldTestEntity.bigDecimalMinTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.bigDecimalMinTom.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.bigDecimalMinTom.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.bigDecimalMaxTom')"
              for="field-test-entity-bigDecimalMaxTom"
              >Big Decimal Max Tom</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxTom"
              id="field-test-entity-bigDecimalMaxTom"
              data-cy="bigDecimalMaxTom"
              :class="{ valid: !$v.fieldTestEntity.bigDecimalMaxTom.$invalid, invalid: $v.fieldTestEntity.bigDecimalMaxTom.$invalid }"
              v-model.number="$v.fieldTestEntity.bigDecimalMaxTom.$model"
            />
            <div v-if="$v.fieldTestEntity.bigDecimalMaxTom.$anyDirty && $v.fieldTestEntity.bigDecimalMaxTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.bigDecimalMaxTom.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.bigDecimalMaxTom.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.localDateTom')" for="field-test-entity-localDateTom"
              >Local Date Tom</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-entity-localDateTom"
                  v-model="$v.fieldTestEntity.localDateTom.$model"
                  name="localDateTom"
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
                id="field-test-entity-localDateTom"
                data-cy="localDateTom"
                type="text"
                class="form-control"
                name="localDateTom"
                :class="{ valid: !$v.fieldTestEntity.localDateTom.$invalid, invalid: $v.fieldTestEntity.localDateTom.$invalid }"
                v-model="$v.fieldTestEntity.localDateTom.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.localDateRequiredTom')"
              for="field-test-entity-localDateRequiredTom"
              >Local Date Required Tom</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-entity-localDateRequiredTom"
                  v-model="$v.fieldTestEntity.localDateRequiredTom.$model"
                  name="localDateRequiredTom"
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
                id="field-test-entity-localDateRequiredTom"
                data-cy="localDateRequiredTom"
                type="text"
                class="form-control"
                name="localDateRequiredTom"
                :class="{
                  valid: !$v.fieldTestEntity.localDateRequiredTom.$invalid,
                  invalid: $v.fieldTestEntity.localDateRequiredTom.$invalid,
                }"
                v-model="$v.fieldTestEntity.localDateRequiredTom.$model"
                required
              />
            </b-input-group>
            <div v-if="$v.fieldTestEntity.localDateRequiredTom.$anyDirty && $v.fieldTestEntity.localDateRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.localDateRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.instantTom')" for="field-test-entity-instantTom"
              >Instant Tom</label
            >
            <div class="d-flex">
              <input
                id="field-test-entity-instantTom"
                data-cy="instantTom"
                type="datetime-local"
                class="form-control"
                name="instantTom"
                :class="{ valid: !$v.fieldTestEntity.instantTom.$invalid, invalid: $v.fieldTestEntity.instantTom.$invalid }"
                :value="convertDateTimeFromServer($v.fieldTestEntity.instantTom.$model)"
                @change="updateInstantField('instantTom', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.instantRequiredTom')"
              for="field-test-entity-instantRequiredTom"
              >Instant Required Tom</label
            >
            <div class="d-flex">
              <input
                id="field-test-entity-instantRequiredTom"
                data-cy="instantRequiredTom"
                type="datetime-local"
                class="form-control"
                name="instantRequiredTom"
                :class="{ valid: !$v.fieldTestEntity.instantRequiredTom.$invalid, invalid: $v.fieldTestEntity.instantRequiredTom.$invalid }"
                required
                :value="convertDateTimeFromServer($v.fieldTestEntity.instantRequiredTom.$model)"
                @change="updateInstantField('instantRequiredTom', $event)"
              />
            </div>
            <div v-if="$v.fieldTestEntity.instantRequiredTom.$anyDirty && $v.fieldTestEntity.instantRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.instantRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.instantRequiredTom.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.zonedDateTimeTom')"
              for="field-test-entity-zonedDateTimeTom"
              >Zoned Date Time Tom</label
            >
            <div class="d-flex">
              <input
                id="field-test-entity-zonedDateTimeTom"
                data-cy="zonedDateTimeTom"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeTom"
                :class="{ valid: !$v.fieldTestEntity.zonedDateTimeTom.$invalid, invalid: $v.fieldTestEntity.zonedDateTimeTom.$invalid }"
                :value="convertDateTimeFromServer($v.fieldTestEntity.zonedDateTimeTom.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeTom', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.zonedDateTimeRequiredTom')"
              for="field-test-entity-zonedDateTimeRequiredTom"
              >Zoned Date Time Required Tom</label
            >
            <div class="d-flex">
              <input
                id="field-test-entity-zonedDateTimeRequiredTom"
                data-cy="zonedDateTimeRequiredTom"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredTom"
                :class="{
                  valid: !$v.fieldTestEntity.zonedDateTimeRequiredTom.$invalid,
                  invalid: $v.fieldTestEntity.zonedDateTimeRequiredTom.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestEntity.zonedDateTimeRequiredTom.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredTom', $event)"
              />
            </div>
            <div v-if="$v.fieldTestEntity.zonedDateTimeRequiredTom.$anyDirty && $v.fieldTestEntity.zonedDateTimeRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.zonedDateTimeRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.zonedDateTimeRequiredTom.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.durationTom')" for="field-test-entity-durationTom"
              >Duration Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="durationTom"
              id="field-test-entity-durationTom"
              data-cy="durationTom"
              :class="{ valid: !$v.fieldTestEntity.durationTom.$invalid, invalid: $v.fieldTestEntity.durationTom.$invalid }"
              v-model="$v.fieldTestEntity.durationTom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.durationRequiredTom')"
              for="field-test-entity-durationRequiredTom"
              >Duration Required Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredTom"
              id="field-test-entity-durationRequiredTom"
              data-cy="durationRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.durationRequiredTom.$invalid, invalid: $v.fieldTestEntity.durationRequiredTom.$invalid }"
              v-model="$v.fieldTestEntity.durationRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.durationRequiredTom.$anyDirty && $v.fieldTestEntity.durationRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.durationRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.durationRequiredTom.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.booleanTom')" for="field-test-entity-booleanTom"
              >Boolean Tom</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanTom"
              id="field-test-entity-booleanTom"
              data-cy="booleanTom"
              :class="{ valid: !$v.fieldTestEntity.booleanTom.$invalid, invalid: $v.fieldTestEntity.booleanTom.$invalid }"
              v-model="$v.fieldTestEntity.booleanTom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.booleanRequiredTom')"
              for="field-test-entity-booleanRequiredTom"
              >Boolean Required Tom</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredTom"
              id="field-test-entity-booleanRequiredTom"
              data-cy="booleanRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.booleanRequiredTom.$invalid, invalid: $v.fieldTestEntity.booleanRequiredTom.$invalid }"
              v-model="$v.fieldTestEntity.booleanRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.booleanRequiredTom.$anyDirty && $v.fieldTestEntity.booleanRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.booleanRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.enumTom')" for="field-test-entity-enumTom"
              >Enum Tom</label
            >
            <select
              class="form-control"
              name="enumTom"
              :class="{ valid: !$v.fieldTestEntity.enumTom.$invalid, invalid: $v.fieldTestEntity.enumTom.$invalid }"
              v-model="$v.fieldTestEntity.enumTom.$model"
              id="field-test-entity-enumTom"
              data-cy="enumTom"
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
              v-text="$t('jhipsterApp.fieldTestEntity.enumRequiredTom')"
              for="field-test-entity-enumRequiredTom"
              >Enum Required Tom</label
            >
            <select
              class="form-control"
              name="enumRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.enumRequiredTom.$invalid, invalid: $v.fieldTestEntity.enumRequiredTom.$invalid }"
              v-model="$v.fieldTestEntity.enumRequiredTom.$model"
              id="field-test-entity-enumRequiredTom"
              data-cy="enumRequiredTom"
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
            <div v-if="$v.fieldTestEntity.enumRequiredTom.$anyDirty && $v.fieldTestEntity.enumRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.enumRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.uuidTom')" for="field-test-entity-uuidTom"
              >Uuid Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidTom"
              id="field-test-entity-uuidTom"
              data-cy="uuidTom"
              :class="{ valid: !$v.fieldTestEntity.uuidTom.$invalid, invalid: $v.fieldTestEntity.uuidTom.$invalid }"
              v-model="$v.fieldTestEntity.uuidTom.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.uuidRequiredTom')"
              for="field-test-entity-uuidRequiredTom"
              >Uuid Required Tom</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidRequiredTom"
              id="field-test-entity-uuidRequiredTom"
              data-cy="uuidRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.uuidRequiredTom.$invalid, invalid: $v.fieldTestEntity.uuidRequiredTom.$invalid }"
              v-model="$v.fieldTestEntity.uuidRequiredTom.$model"
              required
            />
            <div v-if="$v.fieldTestEntity.uuidRequiredTom.$anyDirty && $v.fieldTestEntity.uuidRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.uuidRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.byteImageTom')" for="field-test-entity-byteImageTom"
              >Byte Image Tom</label
            >
            <div>
              <img
                v-bind:src="'data:' + fieldTestEntity.byteImageTomContentType + ';base64,' + fieldTestEntity.byteImageTom"
                style="max-height: 100px"
                v-if="fieldTestEntity.byteImageTom"
                alt="fieldTestEntity image"
              />
              <div v-if="fieldTestEntity.byteImageTom" class="form-text text-danger clearfix">
                <span class="pull-left">{{ fieldTestEntity.byteImageTomContentType }}, {{ byteSize(fieldTestEntity.byteImageTom) }}</span>
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageTom', 'byteImageTomContentType', 'file_byteImageTom')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageTom"
                id="file_byteImageTom"
                data-cy="byteImageTom"
                v-on:change="setFileData($event, fieldTestEntity, 'byteImageTom', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageTom"
              id="field-test-entity-byteImageTom"
              data-cy="byteImageTom"
              :class="{ valid: !$v.fieldTestEntity.byteImageTom.$invalid, invalid: $v.fieldTestEntity.byteImageTom.$invalid }"
              v-model="$v.fieldTestEntity.byteImageTom.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageTomContentType"
              id="field-test-entity-byteImageTomContentType"
              v-model="fieldTestEntity.byteImageTomContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.byteImageRequiredTom')"
              for="field-test-entity-byteImageRequiredTom"
              >Byte Image Required Tom</label
            >
            <div>
              <img
                v-bind:src="'data:' + fieldTestEntity.byteImageRequiredTomContentType + ';base64,' + fieldTestEntity.byteImageRequiredTom"
                style="max-height: 100px"
                v-if="fieldTestEntity.byteImageRequiredTom"
                alt="fieldTestEntity image"
              />
              <div v-if="fieldTestEntity.byteImageRequiredTom" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestEntity.byteImageRequiredTomContentType }}, {{ byteSize(fieldTestEntity.byteImageRequiredTom) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageRequiredTom', 'byteImageRequiredTomContentType', 'file_byteImageRequiredTom')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageRequiredTom"
                id="file_byteImageRequiredTom"
                data-cy="byteImageRequiredTom"
                v-on:change="setFileData($event, fieldTestEntity, 'byteImageRequiredTom', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredTom"
              id="field-test-entity-byteImageRequiredTom"
              data-cy="byteImageRequiredTom"
              :class="{
                valid: !$v.fieldTestEntity.byteImageRequiredTom.$invalid,
                invalid: $v.fieldTestEntity.byteImageRequiredTom.$invalid,
              }"
              v-model="$v.fieldTestEntity.byteImageRequiredTom.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredTomContentType"
              id="field-test-entity-byteImageRequiredTomContentType"
              v-model="fieldTestEntity.byteImageRequiredTomContentType"
            />
            <div v-if="$v.fieldTestEntity.byteImageRequiredTom.$anyDirty && $v.fieldTestEntity.byteImageRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.byteImageRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.byteImageMinbytesTom')"
              for="field-test-entity-byteImageMinbytesTom"
              >Byte Image Minbytes Tom</label
            >
            <div>
              <img
                v-bind:src="'data:' + fieldTestEntity.byteImageMinbytesTomContentType + ';base64,' + fieldTestEntity.byteImageMinbytesTom"
                style="max-height: 100px"
                v-if="fieldTestEntity.byteImageMinbytesTom"
                alt="fieldTestEntity image"
              />
              <div v-if="fieldTestEntity.byteImageMinbytesTom" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestEntity.byteImageMinbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteImageMinbytesTom) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMinbytesTom', 'byteImageMinbytesTomContentType', 'file_byteImageMinbytesTom')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMinbytesTom"
                id="file_byteImageMinbytesTom"
                data-cy="byteImageMinbytesTom"
                v-on:change="setFileData($event, fieldTestEntity, 'byteImageMinbytesTom', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesTom"
              id="field-test-entity-byteImageMinbytesTom"
              data-cy="byteImageMinbytesTom"
              :class="{
                valid: !$v.fieldTestEntity.byteImageMinbytesTom.$invalid,
                invalid: $v.fieldTestEntity.byteImageMinbytesTom.$invalid,
              }"
              v-model="$v.fieldTestEntity.byteImageMinbytesTom.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesTomContentType"
              id="field-test-entity-byteImageMinbytesTomContentType"
              v-model="fieldTestEntity.byteImageMinbytesTomContentType"
            />
            <div v-if="$v.fieldTestEntity.byteImageMinbytesTom.$anyDirty && $v.fieldTestEntity.byteImageMinbytesTom.$invalid"></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.byteImageMaxbytesTom')"
              for="field-test-entity-byteImageMaxbytesTom"
              >Byte Image Maxbytes Tom</label
            >
            <div>
              <img
                v-bind:src="'data:' + fieldTestEntity.byteImageMaxbytesTomContentType + ';base64,' + fieldTestEntity.byteImageMaxbytesTom"
                style="max-height: 100px"
                v-if="fieldTestEntity.byteImageMaxbytesTom"
                alt="fieldTestEntity image"
              />
              <div v-if="fieldTestEntity.byteImageMaxbytesTom" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestEntity.byteImageMaxbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteImageMaxbytesTom) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMaxbytesTom', 'byteImageMaxbytesTomContentType', 'file_byteImageMaxbytesTom')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMaxbytesTom"
                id="file_byteImageMaxbytesTom"
                data-cy="byteImageMaxbytesTom"
                v-on:change="setFileData($event, fieldTestEntity, 'byteImageMaxbytesTom', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesTom"
              id="field-test-entity-byteImageMaxbytesTom"
              data-cy="byteImageMaxbytesTom"
              :class="{
                valid: !$v.fieldTestEntity.byteImageMaxbytesTom.$invalid,
                invalid: $v.fieldTestEntity.byteImageMaxbytesTom.$invalid,
              }"
              v-model="$v.fieldTestEntity.byteImageMaxbytesTom.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesTomContentType"
              id="field-test-entity-byteImageMaxbytesTomContentType"
              v-model="fieldTestEntity.byteImageMaxbytesTomContentType"
            />
            <div v-if="$v.fieldTestEntity.byteImageMaxbytesTom.$anyDirty && $v.fieldTestEntity.byteImageMaxbytesTom.$invalid"></div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.byteAnyTom')" for="field-test-entity-byteAnyTom"
              >Byte Any Tom</label
            >
            <div>
              <div v-if="fieldTestEntity.byteAnyTom" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="openFile(fieldTestEntity.byteAnyTomContentType, fieldTestEntity.byteAnyTom)"
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left">{{ fieldTestEntity.byteAnyTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyTom) }}</span>
                <button
                  type="button"
                  v-on:click="
                    fieldTestEntity.byteAnyTom = null;
                    fieldTestEntity.byteAnyTomContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyTom"
                id="file_byteAnyTom"
                data-cy="byteAnyTom"
                v-on:change="setFileData($event, fieldTestEntity, 'byteAnyTom', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyTom"
              id="field-test-entity-byteAnyTom"
              data-cy="byteAnyTom"
              :class="{ valid: !$v.fieldTestEntity.byteAnyTom.$invalid, invalid: $v.fieldTestEntity.byteAnyTom.$invalid }"
              v-model="$v.fieldTestEntity.byteAnyTom.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyTomContentType"
              id="field-test-entity-byteAnyTomContentType"
              v-model="fieldTestEntity.byteAnyTomContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.byteAnyRequiredTom')"
              for="field-test-entity-byteAnyRequiredTom"
              >Byte Any Required Tom</label
            >
            <div>
              <div v-if="fieldTestEntity.byteAnyRequiredTom" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="openFile(fieldTestEntity.byteAnyRequiredTomContentType, fieldTestEntity.byteAnyRequiredTom)"
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestEntity.byteAnyRequiredTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyRequiredTom) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestEntity.byteAnyRequiredTom = null;
                    fieldTestEntity.byteAnyRequiredTomContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyRequiredTom"
                id="file_byteAnyRequiredTom"
                data-cy="byteAnyRequiredTom"
                v-on:change="setFileData($event, fieldTestEntity, 'byteAnyRequiredTom', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredTom"
              id="field-test-entity-byteAnyRequiredTom"
              data-cy="byteAnyRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.byteAnyRequiredTom.$invalid, invalid: $v.fieldTestEntity.byteAnyRequiredTom.$invalid }"
              v-model="$v.fieldTestEntity.byteAnyRequiredTom.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredTomContentType"
              id="field-test-entity-byteAnyRequiredTomContentType"
              v-model="fieldTestEntity.byteAnyRequiredTomContentType"
            />
            <div v-if="$v.fieldTestEntity.byteAnyRequiredTom.$anyDirty && $v.fieldTestEntity.byteAnyRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.byteAnyRequiredTom.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.byteAnyMinbytesTom')"
              for="field-test-entity-byteAnyMinbytesTom"
              >Byte Any Minbytes Tom</label
            >
            <div>
              <div v-if="fieldTestEntity.byteAnyMinbytesTom" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="openFile(fieldTestEntity.byteAnyMinbytesTomContentType, fieldTestEntity.byteAnyMinbytesTom)"
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestEntity.byteAnyMinbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyMinbytesTom) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestEntity.byteAnyMinbytesTom = null;
                    fieldTestEntity.byteAnyMinbytesTomContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMinbytesTom"
                id="file_byteAnyMinbytesTom"
                data-cy="byteAnyMinbytesTom"
                v-on:change="setFileData($event, fieldTestEntity, 'byteAnyMinbytesTom', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesTom"
              id="field-test-entity-byteAnyMinbytesTom"
              data-cy="byteAnyMinbytesTom"
              :class="{ valid: !$v.fieldTestEntity.byteAnyMinbytesTom.$invalid, invalid: $v.fieldTestEntity.byteAnyMinbytesTom.$invalid }"
              v-model="$v.fieldTestEntity.byteAnyMinbytesTom.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesTomContentType"
              id="field-test-entity-byteAnyMinbytesTomContentType"
              v-model="fieldTestEntity.byteAnyMinbytesTomContentType"
            />
            <div v-if="$v.fieldTestEntity.byteAnyMinbytesTom.$anyDirty && $v.fieldTestEntity.byteAnyMinbytesTom.$invalid"></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.byteAnyMaxbytesTom')"
              for="field-test-entity-byteAnyMaxbytesTom"
              >Byte Any Maxbytes Tom</label
            >
            <div>
              <div v-if="fieldTestEntity.byteAnyMaxbytesTom" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="openFile(fieldTestEntity.byteAnyMaxbytesTomContentType, fieldTestEntity.byteAnyMaxbytesTom)"
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestEntity.byteAnyMaxbytesTomContentType }}, {{ byteSize(fieldTestEntity.byteAnyMaxbytesTom) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestEntity.byteAnyMaxbytesTom = null;
                    fieldTestEntity.byteAnyMaxbytesTomContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMaxbytesTom"
                id="file_byteAnyMaxbytesTom"
                data-cy="byteAnyMaxbytesTom"
                v-on:change="setFileData($event, fieldTestEntity, 'byteAnyMaxbytesTom', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesTom"
              id="field-test-entity-byteAnyMaxbytesTom"
              data-cy="byteAnyMaxbytesTom"
              :class="{ valid: !$v.fieldTestEntity.byteAnyMaxbytesTom.$invalid, invalid: $v.fieldTestEntity.byteAnyMaxbytesTom.$invalid }"
              v-model="$v.fieldTestEntity.byteAnyMaxbytesTom.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesTomContentType"
              id="field-test-entity-byteAnyMaxbytesTomContentType"
              v-model="fieldTestEntity.byteAnyMaxbytesTomContentType"
            />
            <div v-if="$v.fieldTestEntity.byteAnyMaxbytesTom.$anyDirty && $v.fieldTestEntity.byteAnyMaxbytesTom.$invalid"></div>
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('jhipsterApp.fieldTestEntity.byteTextTom')" for="field-test-entity-byteTextTom"
              >Byte Text Tom</label
            >
            <textarea
              class="form-control"
              name="byteTextTom"
              id="field-test-entity-byteTextTom"
              data-cy="byteTextTom"
              :class="{ valid: !$v.fieldTestEntity.byteTextTom.$invalid, invalid: $v.fieldTestEntity.byteTextTom.$invalid }"
              v-model="$v.fieldTestEntity.byteTextTom.$model"
            ></textarea>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestEntity.byteTextRequiredTom')"
              for="field-test-entity-byteTextRequiredTom"
              >Byte Text Required Tom</label
            >
            <textarea
              class="form-control"
              name="byteTextRequiredTom"
              id="field-test-entity-byteTextRequiredTom"
              data-cy="byteTextRequiredTom"
              :class="{ valid: !$v.fieldTestEntity.byteTextRequiredTom.$invalid, invalid: $v.fieldTestEntity.byteTextRequiredTom.$invalid }"
              v-model="$v.fieldTestEntity.byteTextRequiredTom.$model"
              required
            ></textarea>
            <div v-if="$v.fieldTestEntity.byteTextRequiredTom.$anyDirty && $v.fieldTestEntity.byteTextRequiredTom.$invalid">
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestEntity.byteTextRequiredTom.required"
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
            :disabled="$v.fieldTestEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./field-test-entity-update.component.ts"></script>
