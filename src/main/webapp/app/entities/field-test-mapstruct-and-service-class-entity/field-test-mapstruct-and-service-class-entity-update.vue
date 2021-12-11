<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="jhipsterApp.fieldTestMapstructAndServiceClassEntity.home.createOrEditLabel"
          data-cy="FieldTestMapstructAndServiceClassEntityCreateUpdateHeading"
          v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.home.createOrEditLabel')"
        >
          Create or edit a FieldTestMapstructAndServiceClassEntity
        </h2>
        <div>
          <div class="form-group" v-if="fieldTestMapstructAndServiceClassEntity.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="fieldTestMapstructAndServiceClassEntity.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringEva')"
              for="field-test-mapstruct-and-service-class-entity-stringEva"
              >String Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="stringEva"
              id="field-test-mapstruct-and-service-class-entity-stringEva"
              data-cy="stringEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.stringEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.stringEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.stringEva.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-stringRequiredEva"
              >String Required Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="stringRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-stringRequiredEva"
              data-cy="stringRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.stringRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.stringRequiredEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.stringRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.stringRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.stringRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.stringRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva')"
              for="field-test-mapstruct-and-service-class-entity-stringMinlengthEva"
              >String Minlength Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMinlengthEva"
              id="field-test-mapstruct-and-service-class-entity-stringMinlengthEva"
              data-cy="stringMinlengthEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.stringMinlengthEva.minLength"
                v-text="$t('entity.validation.minlength', { min: 0 })"
              >
                This field is required to be at least 0 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva')"
              for="field-test-mapstruct-and-service-class-entity-stringMaxlengthEva"
              >String Maxlength Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="stringMaxlengthEva"
              id="field-test-mapstruct-and-service-class-entity-stringMaxlengthEva"
              data-cy="stringMaxlengthEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.stringMaxlengthEva.maxLength"
                v-text="$t('entity.validation.maxlength', { max: 20 })"
              >
                This field cannot be longer than 20 characters.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.stringPatternEva')"
              for="field-test-mapstruct-and-service-class-entity-stringPatternEva"
              >String Pattern Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="stringPatternEva"
              id="field-test-mapstruct-and-service-class-entity-stringPatternEva"
              data-cy="stringPatternEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.stringPatternEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.stringPatternEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.stringPatternEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.stringPatternEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.stringPatternEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.stringPatternEva.pattern"
                v-text="$t('entity.validation.pattern', { pattern: 'String Pattern Eva' })"
              >
                This field should follow pattern for "String Pattern Eva".
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerEva')"
              for="field-test-mapstruct-and-service-class-entity-integerEva"
              >Integer Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="integerEva"
              id="field-test-mapstruct-and-service-class-entity-integerEva"
              data-cy="integerEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.integerEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.integerEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.integerEva.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-integerRequiredEva"
              >Integer Required Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="integerRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-integerRequiredEva"
              data-cy="integerRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.integerRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.integerRequiredEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.integerRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.integerRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.integerRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.integerRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.integerRequiredEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerMinEva')"
              for="field-test-mapstruct-and-service-class-entity-integerMinEva"
              >Integer Min Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMinEva"
              id="field-test-mapstruct-and-service-class-entity-integerMinEva"
              data-cy="integerMinEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.integerMinEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.integerMinEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.integerMinEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.integerMinEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.integerMinEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.integerMinEva.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.integerMinEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.integerMaxEva')"
              for="field-test-mapstruct-and-service-class-entity-integerMaxEva"
              >Integer Max Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="integerMaxEva"
              id="field-test-mapstruct-and-service-class-entity-integerMaxEva"
              data-cy="integerMaxEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.integerMaxEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.integerMaxEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.integerMaxEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.integerMaxEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.integerMaxEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.integerMaxEva.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.integerMaxEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longEva')"
              for="field-test-mapstruct-and-service-class-entity-longEva"
              >Long Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="longEva"
              id="field-test-mapstruct-and-service-class-entity-longEva"
              data-cy="longEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.longEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.longEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.longEva.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-longRequiredEva"
              >Long Required Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="longRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-longRequiredEva"
              data-cy="longRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.longRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.longRequiredEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.longRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.longRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.longRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.longRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.longRequiredEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longMinEva')"
              for="field-test-mapstruct-and-service-class-entity-longMinEva"
              >Long Min Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="longMinEva"
              id="field-test-mapstruct-and-service-class-entity-longMinEva"
              data-cy="longMinEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.longMinEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.longMinEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.longMinEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.longMinEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.longMinEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.longMinEva.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.longMinEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.longMaxEva')"
              for="field-test-mapstruct-and-service-class-entity-longMaxEva"
              >Long Max Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="longMaxEva"
              id="field-test-mapstruct-and-service-class-entity-longMaxEva"
              data-cy="longMaxEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.longMaxEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.longMaxEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.longMaxEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.longMaxEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.longMaxEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.longMaxEva.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.longMaxEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatEva')"
              for="field-test-mapstruct-and-service-class-entity-floatEva"
              >Float Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="floatEva"
              id="field-test-mapstruct-and-service-class-entity-floatEva"
              data-cy="floatEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.floatEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.floatEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.floatEva.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-floatRequiredEva"
              >Float Required Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="floatRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-floatRequiredEva"
              data-cy="floatRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.floatRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.floatRequiredEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.floatRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.floatRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.floatRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.floatRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.floatRequiredEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatMinEva')"
              for="field-test-mapstruct-and-service-class-entity-floatMinEva"
              >Float Min Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMinEva"
              id="field-test-mapstruct-and-service-class-entity-floatMinEva"
              data-cy="floatMinEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.floatMinEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.floatMinEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.floatMinEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.floatMinEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.floatMinEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.floatMinEva.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.floatMinEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.floatMaxEva')"
              for="field-test-mapstruct-and-service-class-entity-floatMaxEva"
              >Float Max Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="floatMaxEva"
              id="field-test-mapstruct-and-service-class-entity-floatMaxEva"
              data-cy="floatMaxEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.floatMaxEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.floatMaxEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.floatMaxEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.floatMaxEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.floatMaxEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.floatMaxEva.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.floatMaxEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-doubleRequiredEva"
              >Double Required Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-doubleRequiredEva"
              data-cy="doubleRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.doubleRequiredEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleMinEva')"
              for="field-test-mapstruct-and-service-class-entity-doubleMinEva"
              >Double Min Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMinEva"
              id="field-test-mapstruct-and-service-class-entity-doubleMinEva"
              data-cy="doubleMinEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.doubleMinEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.doubleMinEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.doubleMinEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.doubleMinEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.doubleMinEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.doubleMinEva.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.doubleMinEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.doubleMaxEva')"
              for="field-test-mapstruct-and-service-class-entity-doubleMaxEva"
              >Double Max Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="doubleMaxEva"
              id="field-test-mapstruct-and-service-class-entity-doubleMaxEva"
              data-cy="doubleMaxEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.doubleMaxEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.doubleMaxEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.doubleMaxEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.doubleMaxEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.doubleMaxEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.doubleMaxEva.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.doubleMaxEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-bigDecimalRequiredEva"
              >Big Decimal Required Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-bigDecimalRequiredEva"
              data-cy="bigDecimalRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.bigDecimalRequiredEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva')"
              for="field-test-mapstruct-and-service-class-entity-bigDecimalMinEva"
              >Big Decimal Min Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMinEva"
              id="field-test-mapstruct-and-service-class-entity-bigDecimalMinEva"
              data-cy="bigDecimalMinEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva.min"
                v-text="$t('entity.validation.min', { min: 0 })"
              >
                This field should be at least 0.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.bigDecimalMinEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva')"
              for="field-test-mapstruct-and-service-class-entity-bigDecimalMaxEva"
              >Big Decimal Max Eva</label
            >
            <input
              type="number"
              class="form-control"
              name="bigDecimalMaxEva"
              id="field-test-mapstruct-and-service-class-entity-bigDecimalMaxEva"
              data-cy="bigDecimalMaxEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva.$invalid,
              }"
              v-model.number="$v.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva.$model"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva.max"
                v-text="$t('entity.validation.max', { max: 100 })"
              >
                This field cannot be longer than 100 characters.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.bigDecimalMaxEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.localDateEva')"
              for="field-test-mapstruct-and-service-class-entity-localDateEva"
              >Local Date Eva</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-mapstruct-and-service-class-entity-localDateEva"
                  v-model="$v.fieldTestMapstructAndServiceClassEntity.localDateEva.$model"
                  name="localDateEva"
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
                id="field-test-mapstruct-and-service-class-entity-localDateEva"
                data-cy="localDateEva"
                type="text"
                class="form-control"
                name="localDateEva"
                :class="{
                  valid: !$v.fieldTestMapstructAndServiceClassEntity.localDateEva.$invalid,
                  invalid: $v.fieldTestMapstructAndServiceClassEntity.localDateEva.$invalid,
                }"
                v-model="$v.fieldTestMapstructAndServiceClassEntity.localDateEva.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-localDateRequiredEva"
              >Local Date Required Eva</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="field-test-mapstruct-and-service-class-entity-localDateRequiredEva"
                  v-model="$v.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva.$model"
                  name="localDateRequiredEva"
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
                id="field-test-mapstruct-and-service-class-entity-localDateRequiredEva"
                data-cy="localDateRequiredEva"
                type="text"
                class="form-control"
                name="localDateRequiredEva"
                :class="{
                  valid: !$v.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva.$invalid,
                  invalid: $v.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva.$invalid,
                }"
                v-model="$v.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva.$model"
                required
              />
            </b-input-group>
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.localDateRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.instantEva')"
              for="field-test-mapstruct-and-service-class-entity-instantEva"
              >Instant Eva</label
            >
            <div class="d-flex">
              <input
                id="field-test-mapstruct-and-service-class-entity-instantEva"
                data-cy="instantEva"
                type="datetime-local"
                class="form-control"
                name="instantEva"
                :class="{
                  valid: !$v.fieldTestMapstructAndServiceClassEntity.instantEva.$invalid,
                  invalid: $v.fieldTestMapstructAndServiceClassEntity.instantEva.$invalid,
                }"
                :value="convertDateTimeFromServer($v.fieldTestMapstructAndServiceClassEntity.instantEva.$model)"
                @change="updateInstantField('instantEva', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-instanteRequiredEva"
              >Instante Required Eva</label
            >
            <div class="d-flex">
              <input
                id="field-test-mapstruct-and-service-class-entity-instanteRequiredEva"
                data-cy="instanteRequiredEva"
                type="datetime-local"
                class="form-control"
                name="instanteRequiredEva"
                :class="{
                  valid: !$v.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva.$invalid,
                  invalid: $v.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva.$model)"
                @change="updateInstantField('instanteRequiredEva', $event)"
              />
            </div>
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.instanteRequiredEva.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva')"
              for="field-test-mapstruct-and-service-class-entity-zonedDateTimeEva"
              >Zoned Date Time Eva</label
            >
            <div class="d-flex">
              <input
                id="field-test-mapstruct-and-service-class-entity-zonedDateTimeEva"
                data-cy="zonedDateTimeEva"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeEva"
                :class="{
                  valid: !$v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva.$invalid,
                  invalid: $v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva.$invalid,
                }"
                :value="convertDateTimeFromServer($v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeEva.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeEva', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-zonedDateTimeRequiredEva"
              >Zoned Date Time Required Eva</label
            >
            <div class="d-flex">
              <input
                id="field-test-mapstruct-and-service-class-entity-zonedDateTimeRequiredEva"
                data-cy="zonedDateTimeRequiredEva"
                type="datetime-local"
                class="form-control"
                name="zonedDateTimeRequiredEva"
                :class="{
                  valid: !$v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva.$invalid,
                  invalid: $v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva.$invalid,
                }"
                required
                :value="convertDateTimeFromServer($v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva.$model)"
                @change="updateZonedDateTimeField('zonedDateTimeRequiredEva', $event)"
              />
            </div>
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.zonedDateTimeRequiredEva.ZonedDateTimelocal"
                v-text="$t('entity.validation.ZonedDateTimelocal')"
              >
                This field should be a date and time.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.durationEva')"
              for="field-test-mapstruct-and-service-class-entity-durationEva"
              >Duration Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="durationEva"
              id="field-test-mapstruct-and-service-class-entity-durationEva"
              data-cy="durationEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.durationEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.durationEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.durationEva.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.durationRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-durationRequiredEva"
              >Duration Required Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="durationRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-durationRequiredEva"
              data-cy="durationRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.durationRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.durationRequiredEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.durationRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.durationRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.durationRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.durationRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.durationRequiredEva.numeric"
                v-text="$t('entity.validation.number')"
              >
                This field should be a number.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.booleanEva')"
              for="field-test-mapstruct-and-service-class-entity-booleanEva"
              >Boolean Eva</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanEva"
              id="field-test-mapstruct-and-service-class-entity-booleanEva"
              data-cy="booleanEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.booleanEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.booleanEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.booleanEva.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-booleanRequiredEva"
              >Boolean Required Eva</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="booleanRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-booleanRequiredEva"
              data-cy="booleanRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.booleanRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.enumEva')"
              for="field-test-mapstruct-and-service-class-entity-enumEva"
              >Enum Eva</label
            >
            <select
              class="form-control"
              name="enumEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.enumEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.enumEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.enumEva.$model"
              id="field-test-mapstruct-and-service-class-entity-enumEva"
              data-cy="enumEva"
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
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.enumRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-enumRequiredEva"
              >Enum Required Eva</label
            >
            <select
              class="form-control"
              name="enumRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.enumRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.enumRequiredEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.enumRequiredEva.$model"
              id="field-test-mapstruct-and-service-class-entity-enumRequiredEva"
              data-cy="enumRequiredEva"
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
                $v.fieldTestMapstructAndServiceClassEntity.enumRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.enumRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.enumRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.uuidEva')"
              for="field-test-mapstruct-and-service-class-entity-uuidEva"
              >Uuid Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidEva"
              id="field-test-mapstruct-and-service-class-entity-uuidEva"
              data-cy="uuidEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.uuidEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.uuidEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.uuidEva.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-uuidRequiredEva"
              >Uuid Required Eva</label
            >
            <input
              type="text"
              class="form-control"
              name="uuidRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-uuidRequiredEva"
              data-cy="uuidRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva.$model"
              required
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.uuidRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageEva')"
              for="field-test-mapstruct-and-service-class-entity-byteImageEva"
              >Byte Image Eva</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestMapstructAndServiceClassEntity.byteImageEvaContentType +
                  ';base64,' +
                  fieldTestMapstructAndServiceClassEntity.byteImageEva
                "
                style="max-height: 100px"
                v-if="fieldTestMapstructAndServiceClassEntity.byteImageEva"
                alt="fieldTestMapstructAndServiceClassEntity image"
              />
              <div v-if="fieldTestMapstructAndServiceClassEntity.byteImageEva" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestMapstructAndServiceClassEntity.byteImageEvaContentType }},
                  {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageEva) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageEva', 'byteImageEvaContentType', 'file_byteImageEva')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageEva"
                id="file_byteImageEva"
                data-cy="byteImageEva"
                v-on:change="setFileData($event, fieldTestMapstructAndServiceClassEntity, 'byteImageEva', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageEva"
              id="field-test-mapstruct-and-service-class-entity-byteImageEva"
              data-cy="byteImageEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteImageEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteImageEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteImageEva.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageEvaContentType"
              id="field-test-mapstruct-and-service-class-entity-byteImageEvaContentType"
              v-model="fieldTestMapstructAndServiceClassEntity.byteImageEvaContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-byteImageRequiredEva"
              >Byte Image Required Eva</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestMapstructAndServiceClassEntity.byteImageRequiredEvaContentType +
                  ';base64,' +
                  fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva
                "
                style="max-height: 100px"
                v-if="fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva"
                alt="fieldTestMapstructAndServiceClassEntity image"
              />
              <div v-if="fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestMapstructAndServiceClassEntity.byteImageRequiredEvaContentType }},
                  {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageRequiredEva', 'byteImageRequiredEvaContentType', 'file_byteImageRequiredEva')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageRequiredEva"
                id="file_byteImageRequiredEva"
                data-cy="byteImageRequiredEva"
                v-on:change="setFileData($event, fieldTestMapstructAndServiceClassEntity, 'byteImageRequiredEva', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-byteImageRequiredEva"
              data-cy="byteImageRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageRequiredEvaContentType"
              id="field-test-mapstruct-and-service-class-entity-byteImageRequiredEvaContentType"
              v-model="fieldTestMapstructAndServiceClassEntity.byteImageRequiredEvaContentType"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.byteImageRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva')"
              for="field-test-mapstruct-and-service-class-entity-byteImageMinbytesEva"
              >Byte Image Minbytes Eva</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEvaContentType +
                  ';base64,' +
                  fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva
                "
                style="max-height: 100px"
                v-if="fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva"
                alt="fieldTestMapstructAndServiceClassEntity image"
              />
              <div v-if="fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEvaContentType }},
                  {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMinbytesEva', 'byteImageMinbytesEvaContentType', 'file_byteImageMinbytesEva')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMinbytesEva"
                id="file_byteImageMinbytesEva"
                data-cy="byteImageMinbytesEva"
                v-on:change="setFileData($event, fieldTestMapstructAndServiceClassEntity, 'byteImageMinbytesEva', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesEva"
              id="field-test-mapstruct-and-service-class-entity-byteImageMinbytesEva"
              data-cy="byteImageMinbytesEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMinbytesEvaContentType"
              id="field-test-mapstruct-and-service-class-entity-byteImageMinbytesEvaContentType"
              v-model="fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEvaContentType"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.byteImageMinbytesEva.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva')"
              for="field-test-mapstruct-and-service-class-entity-byteImageMaxbytesEva"
              >Byte Image Maxbytes Eva</label
            >
            <div>
              <img
                v-bind:src="
                  'data:' +
                  fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEvaContentType +
                  ';base64,' +
                  fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva
                "
                style="max-height: 100px"
                v-if="fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva"
                alt="fieldTestMapstructAndServiceClassEntity image"
              />
              <div v-if="fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva" class="form-text text-danger clearfix">
                <span class="pull-left"
                  >{{ fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEvaContentType }},
                  {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva) }}</span
                >
                <button
                  type="button"
                  v-on:click="clearInputImage('byteImageMaxbytesEva', 'byteImageMaxbytesEvaContentType', 'file_byteImageMaxbytesEva')"
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteImageMaxbytesEva"
                id="file_byteImageMaxbytesEva"
                data-cy="byteImageMaxbytesEva"
                v-on:change="setFileData($event, fieldTestMapstructAndServiceClassEntity, 'byteImageMaxbytesEva', true)"
                accept="image/*"
                v-text="$t('entity.action.addimage')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesEva"
              id="field-test-mapstruct-and-service-class-entity-byteImageMaxbytesEva"
              data-cy="byteImageMaxbytesEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteImageMaxbytesEvaContentType"
              id="field-test-mapstruct-and-service-class-entity-byteImageMaxbytesEvaContentType"
              v-model="fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEvaContentType"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.byteImageMaxbytesEva.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyEva')"
              for="field-test-mapstruct-and-service-class-entity-byteAnyEva"
              >Byte Any Eva</label
            >
            <div>
              <div v-if="fieldTestMapstructAndServiceClassEntity.byteAnyEva" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(
                      fieldTestMapstructAndServiceClassEntity.byteAnyEvaContentType,
                      fieldTestMapstructAndServiceClassEntity.byteAnyEva
                    )
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestMapstructAndServiceClassEntity.byteAnyEvaContentType }},
                  {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyEva) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestMapstructAndServiceClassEntity.byteAnyEva = null;
                    fieldTestMapstructAndServiceClassEntity.byteAnyEvaContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyEva"
                id="file_byteAnyEva"
                data-cy="byteAnyEva"
                v-on:change="setFileData($event, fieldTestMapstructAndServiceClassEntity, 'byteAnyEva', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyEva"
              id="field-test-mapstruct-and-service-class-entity-byteAnyEva"
              data-cy="byteAnyEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteAnyEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteAnyEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteAnyEva.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyEvaContentType"
              id="field-test-mapstruct-and-service-class-entity-byteAnyEvaContentType"
              v-model="fieldTestMapstructAndServiceClassEntity.byteAnyEvaContentType"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-byteAnyRequiredEva"
              >Byte Any Required Eva</label
            >
            <div>
              <div v-if="fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(
                      fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEvaContentType,
                      fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva
                    )
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEvaContentType }},
                  {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva = null;
                    fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEvaContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyRequiredEva"
                id="file_byteAnyRequiredEva"
                data-cy="byteAnyRequiredEva"
                v-on:change="setFileData($event, fieldTestMapstructAndServiceClassEntity, 'byteAnyRequiredEva', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-byteAnyRequiredEva"
              data-cy="byteAnyRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva.$model"
              required
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyRequiredEvaContentType"
              id="field-test-mapstruct-and-service-class-entity-byteAnyRequiredEvaContentType"
              v-model="fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEvaContentType"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.byteAnyRequiredEva.required"
                v-text="$t('entity.validation.required')"
              >
                This field is required.
              </small>
            </div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva')"
              for="field-test-mapstruct-and-service-class-entity-byteAnyMinbytesEva"
              >Byte Any Minbytes Eva</label
            >
            <div>
              <div v-if="fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(
                      fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEvaContentType,
                      fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva
                    )
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEvaContentType }},
                  {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva = null;
                    fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEvaContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMinbytesEva"
                id="file_byteAnyMinbytesEva"
                data-cy="byteAnyMinbytesEva"
                v-on:change="setFileData($event, fieldTestMapstructAndServiceClassEntity, 'byteAnyMinbytesEva', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesEva"
              id="field-test-mapstruct-and-service-class-entity-byteAnyMinbytesEva"
              data-cy="byteAnyMinbytesEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMinbytesEvaContentType"
              id="field-test-mapstruct-and-service-class-entity-byteAnyMinbytesEvaContentType"
              v-model="fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEvaContentType"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.byteAnyMinbytesEva.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva')"
              for="field-test-mapstruct-and-service-class-entity-byteAnyMaxbytesEva"
              >Byte Any Maxbytes Eva</label
            >
            <div>
              <div v-if="fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva" class="form-text text-danger clearfix">
                <a
                  class="pull-left"
                  v-on:click="
                    openFile(
                      fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEvaContentType,
                      fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva
                    )
                  "
                  v-text="$t('entity.action.open')"
                  >open</a
                ><br />
                <span class="pull-left"
                  >{{ fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEvaContentType }},
                  {{ byteSize(fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva) }}</span
                >
                <button
                  type="button"
                  v-on:click="
                    fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva = null;
                    fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEvaContentType = null;
                  "
                  class="btn btn-secondary btn-xs pull-right"
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                </button>
              </div>
              <input
                type="file"
                ref="file_byteAnyMaxbytesEva"
                id="file_byteAnyMaxbytesEva"
                data-cy="byteAnyMaxbytesEva"
                v-on:change="setFileData($event, fieldTestMapstructAndServiceClassEntity, 'byteAnyMaxbytesEva', false)"
                v-text="$t('entity.action.addblob')"
              />
            </div>
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesEva"
              id="field-test-mapstruct-and-service-class-entity-byteAnyMaxbytesEva"
              data-cy="byteAnyMaxbytesEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva.$model"
            />
            <input
              type="hidden"
              class="form-control"
              name="byteAnyMaxbytesEvaContentType"
              id="field-test-mapstruct-and-service-class-entity-byteAnyMaxbytesEvaContentType"
              v-model="fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEvaContentType"
            />
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.byteAnyMaxbytesEva.$invalid
              "
            ></div>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteTextEva')"
              for="field-test-mapstruct-and-service-class-entity-byteTextEva"
              >Byte Text Eva</label
            >
            <textarea
              class="form-control"
              name="byteTextEva"
              id="field-test-mapstruct-and-service-class-entity-byteTextEva"
              data-cy="byteTextEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteTextEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteTextEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteTextEva.$model"
            ></textarea>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('jhipsterApp.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva')"
              for="field-test-mapstruct-and-service-class-entity-byteTextRequiredEva"
              >Byte Text Required Eva</label
            >
            <textarea
              class="form-control"
              name="byteTextRequiredEva"
              id="field-test-mapstruct-and-service-class-entity-byteTextRequiredEva"
              data-cy="byteTextRequiredEva"
              :class="{
                valid: !$v.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva.$invalid,
                invalid: $v.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva.$invalid,
              }"
              v-model="$v.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva.$model"
              required
            ></textarea>
            <div
              v-if="
                $v.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva.$anyDirty &&
                $v.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva.$invalid
              "
            >
              <small
                class="form-text text-danger"
                v-if="!$v.fieldTestMapstructAndServiceClassEntity.byteTextRequiredEva.required"
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
            :disabled="$v.fieldTestMapstructAndServiceClassEntity.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./field-test-mapstruct-and-service-class-entity-update.component.ts"></script>
