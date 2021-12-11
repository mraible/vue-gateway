/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import FieldTestEnumWithValueUpdateComponent from '@/entities/field-test-enum-with-value/field-test-enum-with-value-update.vue';
import FieldTestEnumWithValueClass from '@/entities/field-test-enum-with-value/field-test-enum-with-value-update.component';
import FieldTestEnumWithValueService from '@/entities/field-test-enum-with-value/field-test-enum-with-value.service';

import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.use(ToastPlugin);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('FieldTestEnumWithValue Management Update Component', () => {
    let wrapper: Wrapper<FieldTestEnumWithValueClass>;
    let comp: FieldTestEnumWithValueClass;
    let fieldTestEnumWithValueServiceStub: SinonStubbedInstance<FieldTestEnumWithValueService>;

    beforeEach(() => {
      fieldTestEnumWithValueServiceStub = sinon.createStubInstance<FieldTestEnumWithValueService>(FieldTestEnumWithValueService);

      wrapper = shallowMount<FieldTestEnumWithValueClass>(FieldTestEnumWithValueUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          fieldTestEnumWithValueService: () => fieldTestEnumWithValueServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.fieldTestEnumWithValue = entity;
        fieldTestEnumWithValueServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(fieldTestEnumWithValueServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.fieldTestEnumWithValue = entity;
        fieldTestEnumWithValueServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(fieldTestEnumWithValueServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestEnumWithValue = { id: 123 };
        fieldTestEnumWithValueServiceStub.find.resolves(foundFieldTestEnumWithValue);
        fieldTestEnumWithValueServiceStub.retrieve.resolves([foundFieldTestEnumWithValue]);

        // WHEN
        comp.beforeRouteEnter({ params: { fieldTestEnumWithValueId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestEnumWithValue).toBe(foundFieldTestEnumWithValue);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
