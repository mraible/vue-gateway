/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import FieldTestEnumWithValueDetailComponent from '@/entities/field-test-enum-with-value/field-test-enum-with-value-details.vue';
import FieldTestEnumWithValueClass from '@/entities/field-test-enum-with-value/field-test-enum-with-value-details.component';
import FieldTestEnumWithValueService from '@/entities/field-test-enum-with-value/field-test-enum-with-value.service';
import router from '@/router';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('FieldTestEnumWithValue Management Detail Component', () => {
    let wrapper: Wrapper<FieldTestEnumWithValueClass>;
    let comp: FieldTestEnumWithValueClass;
    let fieldTestEnumWithValueServiceStub: SinonStubbedInstance<FieldTestEnumWithValueService>;

    beforeEach(() => {
      fieldTestEnumWithValueServiceStub = sinon.createStubInstance<FieldTestEnumWithValueService>(FieldTestEnumWithValueService);

      wrapper = shallowMount<FieldTestEnumWithValueClass>(FieldTestEnumWithValueDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { fieldTestEnumWithValueService: () => fieldTestEnumWithValueServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundFieldTestEnumWithValue = { id: 123 };
        fieldTestEnumWithValueServiceStub.find.resolves(foundFieldTestEnumWithValue);

        // WHEN
        comp.retrieveFieldTestEnumWithValue(123);
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestEnumWithValue).toBe(foundFieldTestEnumWithValue);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestEnumWithValue = { id: 123 };
        fieldTestEnumWithValueServiceStub.find.resolves(foundFieldTestEnumWithValue);

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
