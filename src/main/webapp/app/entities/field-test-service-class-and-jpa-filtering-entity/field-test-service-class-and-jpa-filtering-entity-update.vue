<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.home.createOrEditLabel"
          data-cy="FieldTestServiceClassAndJpaFilteringEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.home.createOrEditLabel')"
        >
          Create or edit a FieldTestServiceClassAndJpaFilteringEntity
        </h2>
        <div>
          <div class="form-group" v-if="fieldTestServiceClassAndJpaFilteringEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="fieldTestServiceClassAndJpaFilteringEntity.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringBob')"
              for="field-test-service-class-and-jpa-filtering-entity-stringBob"
              >String Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="stringBob"
              id="field-test-service-class-and-jpa-filtering-entity-stringBob"
              data-cy="stringBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.stringBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.stringBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.stringBob.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-stringRequiredBob"
              >String Required Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-stringRequiredBob"
              data-cy="stringRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.stringRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob')"
              for="field-test-service-class-and-jpa-filtering-entity-stringMinlengthBob"
              >String Minlength Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthBob"
              id="field-test-service-class-and-jpa-filtering-entity-stringMinlengthBob"
              data-cy="stringMinlengthBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.stringMinlengthBob.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob')"
              for="field-test-service-class-and-jpa-filtering-entity-stringMaxlengthBob"
              >String Maxlength Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthBob"
              id="field-test-service-class-and-jpa-filtering-entity-stringMaxlengthBob"
              data-cy="stringMaxlengthBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.stringMaxlengthBob.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob')"
              for="field-test-service-class-and-jpa-filtering-entity-stringPatternBob"
              >String Pattern Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternBob"
              id="field-test-service-class-and-jpa-filtering-entity-stringPatternBob"
              data-cy="stringPatternBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.stringPatternBob.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Bob' })"
              >
                This field should follow pattern for "String Pattern Bob".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerBob')"
              for="field-test-service-class-and-jpa-filtering-entity-integerBob"
              >Integer Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="integerBob"
              id="field-test-service-class-and-jpa-filtering-entity-integerBob"
              data-cy="integerBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.integerBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.integerBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.integerBob.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-integerRequiredBob"
              >Integer Required Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-integerRequiredBob"
              data-cy="integerRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.integerRequiredBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob')"
              for="field-test-service-class-and-jpa-filtering-entity-integerMinBob"
              >Integer Min Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinBob"
              id="field-test-service-class-and-jpa-filtering-entity-integerMinBob"
              data-cy="integerMinBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.integerMinBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob')"
              for="field-test-service-class-and-jpa-filtering-entity-integerMaxBob"
              >Integer Max Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxBob"
              id="field-test-service-class-and-jpa-filtering-entity-integerMaxBob"
              data-cy="integerMaxBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.integerMaxBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longBob')"
              for="field-test-service-class-and-jpa-filtering-entity-longBob"
              >Long Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="longBob"
              id="field-test-service-class-and-jpa-filtering-entity-longBob"
              data-cy="longBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.longBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.longBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.longBob.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-longRequiredBob"
              >Long Required Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-longRequiredBob"
              data-cy="longRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.longRequiredBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longMinBob')"
              for="field-test-service-class-and-jpa-filtering-entity-longMinBob"
              >Long Min Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinBob"
              id="field-test-service-class-and-jpa-filtering-entity-longMinBob"
              data-cy="longMinBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.longMinBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.longMinBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.longMinBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.longMinBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.longMinBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.longMinBob.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.longMinBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob')"
              for="field-test-service-class-and-jpa-filtering-entity-longMaxBob"
              >Long Max Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxBob"
              id="field-test-service-class-and-jpa-filtering-entity-longMaxBob"
              data-cy="longMaxBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.longMaxBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatBob')"
              for="field-test-service-class-and-jpa-filtering-entity-floatBob"
              >Float Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="floatBob"
              id="field-test-service-class-and-jpa-filtering-entity-floatBob"
              data-cy="floatBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.floatBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.floatBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.floatBob.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-floatRequiredBob"
              >Float Required Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-floatRequiredBob"
              data-cy="floatRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.floatRequiredBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob')"
              for="field-test-service-class-and-jpa-filtering-entity-floatMinBob"
              >Float Min Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinBob"
              id="field-test-service-class-and-jpa-filtering-entity-floatMinBob"
              data-cy="floatMinBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.floatMinBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob')"
              for="field-test-service-class-and-jpa-filtering-entity-floatMaxBob"
              >Float Max Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxBob"
              id="field-test-service-class-and-jpa-filtering-entity-floatMaxBob"
              data-cy="floatMaxBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.floatMaxBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-doubleRequiredBob"
              >Double Required Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-doubleRequiredBob"
              data-cy="doubleRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.doubleRequiredBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob')"
              for="field-test-service-class-and-jpa-filtering-entity-doubleMinBob"
              >Double Min Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinBob"
              id="field-test-service-class-and-jpa-filtering-entity-doubleMinBob"
              data-cy="doubleMinBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.doubleMinBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob')"
              for="field-test-service-class-and-jpa-filtering-entity-doubleMaxBob"
              >Double Max Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxBob"
              id="field-test-service-class-and-jpa-filtering-entity-doubleMaxBob"
              data-cy="doubleMaxBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.doubleMaxBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-bigDecimalRequiredBob"
              >Big Decimal Required Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-bigDecimalRequiredBob"
              data-cy="bigDecimalRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalRequiredBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob')"
              for="field-test-service-class-and-jpa-filtering-entity-bigDecimalMinBob"
              >Big Decimal Min Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinBob"
              id="field-test-service-class-and-jpa-filtering-entity-bigDecimalMinBob"
              data-cy="bigDecimalMinBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMinBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob')"
              for="field-test-service-class-and-jpa-filtering-entity-bigDecimalMaxBob"
              >Big Decimal Max Bob</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxBob"
              id="field-test-service-class-and-jpa-filtering-entity-bigDecimalMaxBob"
              data-cy="bigDecimalMaxBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob.$invalid,
              }"
              v-model.number="$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob.$model"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.bigDecimalMaxBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.localDateBob')"
              for="field-test-service-class-and-jpa-filtering-entity-localDateBob"
              >Local Date Bob</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-service-class-and-jpa-filtering-entity-localDateBob"
                  v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.localDateBob.$model"
                  name="localDateBob"
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
                id="field-test-service-class-and-jpa-filtering-entity-localDateBob"
                data-cy="localDateBob"
                type="text"
                class="form-control"
                name="localDateBob"
                :class="{
                  valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.localDateBob.$invalid,
                  invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.localDateBob.$invalid,
                }"
                v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.localDateBob.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-localDateRequiredBob"
              >Local Date Required Bob</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-service-class-and-jpa-filtering-entity-localDateRequiredBob"
                  v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob.$model"
                  name="localDateRequiredBob"
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
                id="field-test-service-class-and-jpa-filtering-entity-localDateRequiredBob"
                data-cy="localDateRequiredBob"
                type="text"
                class="form-control"
                name="localDateRequiredBob"
                :class="{
                  valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob.$invalid,
                  invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob.$invalid,
                }"
                v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob.$model"
                required
              />
            </b-input-group>
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.localDateRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.instantBob')"
              for="field-test-service-class-and-jpa-filtering-entity-instantBob"
              >Instant Bob</label
            >
            <div class="d-flex">
              <input
                id="field-test-service-class-and-jpa-filtering-entity-instantBob"
                data-cy="instantBob"
                type="datetime-local"
                class="form-control"
                name="instantBob"
                :class="{
                  valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.instantBob.$invalid,
                  invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.instantBob.$invalid,
                }"
                :value="convertDateTimeFromServer($v.fieldTestServiceClassAndJpaFilteringEntity.instantBob.$model)"
                @change="updateInstantField('instantBob', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-instanteRequiredBob"
              >Instante Required Bob</label
            >
            <div class="d-flex">
              <input
                id="field-test-service-class-and-jpa-filtering-entity-instanteRequiredBob"
                data-cy="instanteRequiredBob"
                type="datetime-local"
                class="form-control"
                name="instanteRequiredBob"
                :class="{
                  valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob.$invalid,
                  invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob.$model)"
                @change="updateInstantField('instanteRequiredBob', $event)"
              />
            </div>
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.instanteRequiredBob.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob')"
              for="field-test-service-class-and-jpa-filtering-entity-zonedDateTimeBob"
              >Zoned Date Time Bob</label
            >
            <div class="d-flex">
              <input
                id="field-test-service-class-and-jpa-filtering-entity-zonedDateTimeBob"
                data-cy="zonedDateTimeBob"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeBob"
                :class="{
                  valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob.$invalid,
                  invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob.$invalid,
                }"
                :value="convertDateTimeFromServer($v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeBob.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeBob', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-zonedDateTimeRequiredBob"
              >Zoned Date Time Required Bob</label
            >
            <div class="d-flex">
              <input
                id="field-test-service-class-and-jpa-filtering-entity-zonedDateTimeRequiredBob"
                data-cy="zonedDateTimeRequiredBob"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredBob"
                :class="{
                  valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob.$invalid,
                  invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredBob', $event)"
              />
            </div>
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.zonedDateTimeRequiredBob.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.durationBob')"
              for="field-test-service-class-and-jpa-filtering-entity-durationBob"
              >Duration Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="durationBob"
              id="field-test-service-class-and-jpa-filtering-entity-durationBob"
              data-cy="durationBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.durationBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.durationBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.durationBob.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-durationRequiredBob"
              >Duration Required Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-durationRequiredBob"
              data-cy="durationRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.durationRequiredBob.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.booleanBob')"
              for="field-test-service-class-and-jpa-filtering-entity-booleanBob"
              >Boolean Bob</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanBob"
              id="field-test-service-class-and-jpa-filtering-entity-booleanBob"
              data-cy="booleanBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.booleanBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.booleanBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.booleanBob.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-booleanRequiredBob"
              >Boolean Required Bob</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-booleanRequiredBob"
              data-cy="booleanRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.booleanRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.enumBob')"
              for="field-test-service-class-and-jpa-filtering-entity-enumBob"
              >Enum Bob</label
            >
            <select
              class="form-control"
              name="enumBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.enumBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.enumBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.enumBob.$model"
              id="field-test-service-class-and-jpa-filtering-entity-enumBob"
              data-cy="enumBob"
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
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-enumRequiredBob"
              >Enum Required Bob</label
            >
            <select
              class="form-control"
              name="enumRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob.$model"
              id="field-test-service-class-and-jpa-filtering-entity-enumRequiredBob"
              data-cy="enumRequiredBob"
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
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.enumRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.uuidBob')"
              for="field-test-service-class-and-jpa-filtering-entity-uuidBob"
              >Uuid Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidBob"
              id="field-test-service-class-and-jpa-filtering-entity-uuidBob"
              data-cy="uuidBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.uuidBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.uuidBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.uuidBob.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-uuidRequiredBob"
              >Uuid Required Bob</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-uuidRequiredBob"
              data-cy="uuidRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.uuidRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteImageBob"
              >Byte Image Bob</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestServiceClassAndJpaFilteringEntity.byteImageBobContentType +
                  ';base64,' +
                  fieldTestServiceClassAndJpaFilteringEntity.byteImageBob
                "
                style="max-height: 100px"
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageBob"
                alt="fieldTestServiceClassAndJpaFilteringEntity image"
              />
              <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageBob" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestServiceClassAndJpaFilteringEntity.byteImageBobContentType }},
                  {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageBob) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageBob', 'byteImageBobContentType', 'file_byteImageBob')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageBob"
                id="file_byteImageBob"
                data-cy="byteImageBob"
                v-on:change="setFileData($event, fieldTestServiceClassAndJpaFilteringEntity, 'byteImageBob', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteImageBob"
              data-cy="byteImageBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageBob.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageBobContentType"
              id="field-test-service-class-and-jpa-filtering-entity-byteImageBobContentType"
              v-model="fieldTestServiceClassAndJpaFilteringEntity.byteImageBobContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteImageRequiredBob"
              >Byte Image Required Bob</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBobContentType +
                  ';base64,' +
                  fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob
                "
                style="max-height: 100px"
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob"
                alt="fieldTestServiceClassAndJpaFilteringEntity image"
              />
              <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBobContentType }},
                  {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageRequiredBob', 'byteImageRequiredBobContentType', 'file_byteImageRequiredBob')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageRequiredBob"
                id="file_byteImageRequiredBob"
                data-cy="byteImageRequiredBob"
                v-on:change="setFileData($event, fieldTestServiceClassAndJpaFilteringEntity, 'byteImageRequiredBob', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteImageRequiredBob"
              data-cy="byteImageRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredBobContentType"
              id="field-test-service-class-and-jpa-filtering-entity-byteImageRequiredBobContentType"
              v-model="fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBobContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteImageMinbytesBob"
              >Byte Image Minbytes Bob</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBobContentType +
                  ';base64,' +
                  fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob
                "
                style="max-height: 100px"
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob"
                alt="fieldTestServiceClassAndJpaFilteringEntity image"
              />
              <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBobContentType }},
                  {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMinbytesBob', 'byteImageMinbytesBobContentType', 'file_byteImageMinbytesBob')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMinbytesBob"
                id="file_byteImageMinbytesBob"
                data-cy="byteImageMinbytesBob"
                v-on:change="setFileData($event, fieldTestServiceClassAndJpaFilteringEntity, 'byteImageMinbytesBob', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteImageMinbytesBob"
              data-cy="byteImageMinbytesBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesBobContentType"
              id="field-test-service-class-and-jpa-filtering-entity-byteImageMinbytesBobContentType"
              v-model="fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBobContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMinbytesBob.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteImageMaxbytesBob"
              >Byte Image Maxbytes Bob</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBobContentType +
                  ';base64,' +
                  fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob
                "
                style="max-height: 100px"
                v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob"
                alt="fieldTestServiceClassAndJpaFilteringEntity image"
              />
              <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBobContentType }},
                  {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMaxbytesBob', 'byteImageMaxbytesBobContentType', 'file_byteImageMaxbytesBob')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMaxbytesBob"
                id="file_byteImageMaxbytesBob"
                data-cy="byteImageMaxbytesBob"
                v-on:change="setFileData($event, fieldTestServiceClassAndJpaFilteringEntity, 'byteImageMaxbytesBob', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteImageMaxbytesBob"
              data-cy="byteImageMaxbytesBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesBobContentType"
              id="field-test-service-class-and-jpa-filtering-entity-byteImageMaxbytesBobContentType"
              v-model="fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBobContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteImageMaxbytesBob.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteAnyBob"
              >Byte Any Bob</label
            >
            <div>
              <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(
                      fieldTestServiceClassAndJpaFilteringEntity.byteAnyBobContentType,
                      fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob
                    )
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyBobContentType }},
                  {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob = null;
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyBobContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyBob"
                id="file_byteAnyBob"
                data-cy="byteAnyBob"
                v-on:change="setFileData($event, fieldTestServiceClassAndJpaFilteringEntity, 'byteAnyBob', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteAnyBob"
              data-cy="byteAnyBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyBob.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyBobContentType"
              id="field-test-service-class-and-jpa-filtering-entity-byteAnyBobContentType"
              v-model="fieldTestServiceClassAndJpaFilteringEntity.byteAnyBobContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteAnyRequiredBob"
              >Byte Any Required Bob</label
            >
            <div>
              <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(
                      fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBobContentType,
                      fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob
                    )
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBobContentType }},
                  {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob = null;
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBobContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyRequiredBob"
                id="file_byteAnyRequiredBob"
                data-cy="byteAnyRequiredBob"
                v-on:change="setFileData($event, fieldTestServiceClassAndJpaFilteringEntity, 'byteAnyRequiredBob', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteAnyRequiredBob"
              data-cy="byteAnyRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredBobContentType"
              id="field-test-service-class-and-jpa-filtering-entity-byteAnyRequiredBobContentType"
              v-model="fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBobContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyRequiredBob.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteAnyMinbytesBob"
              >Byte Any Minbytes Bob</label
            >
            <div>
              <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(
                      fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBobContentType,
                      fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob
                    )
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBobContentType }},
                  {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob = null;
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBobContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMinbytesBob"
                id="file_byteAnyMinbytesBob"
                data-cy="byteAnyMinbytesBob"
                v-on:change="setFileData($event, fieldTestServiceClassAndJpaFilteringEntity, 'byteAnyMinbytesBob', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteAnyMinbytesBob"
              data-cy="byteAnyMinbytesBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesBobContentType"
              id="field-test-service-class-and-jpa-filtering-entity-byteAnyMinbytesBobContentType"
              v-model="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBobContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMinbytesBob.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteAnyMaxbytesBob"
              >Byte Any Maxbytes Bob</label
            >
            <div>
              <div v-if="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(
                      fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBobContentType,
                      fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob
                    )
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBobContentType }},
                  {{ byteSize(fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob = null;
                    fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBobContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMaxbytesBob"
                id="file_byteAnyMaxbytesBob"
                data-cy="byteAnyMaxbytesBob"
                v-on:change="setFileData($event, fieldTestServiceClassAndJpaFilteringEntity, 'byteAnyMaxbytesBob', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteAnyMaxbytesBob"
              data-cy="byteAnyMaxbytesBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesBobContentType"
              id="field-test-service-class-and-jpa-filtering-entity-byteAnyMaxbytesBobContentType"
              v-model="fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBobContentType"
            />
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteAnyMaxbytesBob.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteTextBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteTextBob"
              >Byte Text Bob</label
            >
            <textarea
              class="form-control"
              name="byteTextBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteTextBob"
              data-cy="byteTextBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteTextBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteTextBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteTextBob.$model"
            ></textarea>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob')"
              for="field-test-service-class-and-jpa-filtering-entity-byteTextRequiredBob"
              >Byte Text Required Bob</label
            >
            <textarea
              class="form-control"
              name="byteTextRequiredBob"
              id="field-test-service-class-and-jpa-filtering-entity-byteTextRequiredBob"
              data-cy="byteTextRequiredBob"
              :class="{
                valid: !$v.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob.$invalid,
                invalid: $v.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob.$invalid,
              }"
              v-model="$v.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob.$model"
              required
            ></textarea>
            <div
              v-if="
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob.$anyDirty &&
                $v.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestServiceClassAndJpaFilteringEntity.byteTextRequiredBob.required"
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
            :disabled="$v.fieldTestServiceClassAndJpaFilteringEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./field-test-service-class-and-jpa-filtering-entity-update.component.ts"></script>
