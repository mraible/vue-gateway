/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import FieldTestServiceImplEntityDetailComponent from '@/entities/field-test-service-impl-entity/field-test-service-impl-entity-details.vue';
import FieldTestServiceImplEntityClass from '@/entities/field-test-service-impl-entity/field-test-service-impl-entity-details.component';
import FieldTestServiceImplEntityService from '@/entities/field-test-service-impl-entity/field-test-service-impl-entity.service';
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
  describe('FieldTestServiceImplEntity Management Detail Component', () => {
    let wrapper: Wrapper<FieldTestServiceImplEntityClass>;
    let comp: FieldTestServiceImplEntityClass;
    let fieldTestServiceImplEntityServiceStub: SinonStubbedInstance<FieldTestServiceImplEntityService>;

    beforeEach(() => {
      fieldTestServiceImplEntityServiceStub =
        sinon.createStubInstance<FieldTestServiceImplEntityService>(FieldTestServiceImplEntityService);

      wrapper = shallowMount<FieldTestServiceImplEntityClass>(FieldTestServiceImplEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { fieldTestServiceImplEntityService: () => fieldTestServiceImplEntityServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundFieldTestServiceImplEntity = { id: 123 };
        fieldTestServiceImplEntityServiceStub.find.resolves(foundFieldTestServiceImplEntity);

        // WHEN
        comp.retrieveFieldTestServiceImplEntity(123);
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestServiceImplEntity).toBe(foundFieldTestServiceImplEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestServiceImplEntity = { id: 123 };
        fieldTestServiceImplEntityServiceStub.find.resolves(foundFieldTestServiceImplEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { fieldTestServiceImplEntityId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestServiceImplEntity).toBe(foundFieldTestServiceImplEntity);
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
