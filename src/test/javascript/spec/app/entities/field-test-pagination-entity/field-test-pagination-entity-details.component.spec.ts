/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import FieldTestPaginationEntityDetailComponent from '@/entities/field-test-pagination-entity/field-test-pagination-entity-details.vue';
import FieldTestPaginationEntityClass from '@/entities/field-test-pagination-entity/field-test-pagination-entity-details.component';
import FieldTestPaginationEntityService from '@/entities/field-test-pagination-entity/field-test-pagination-entity.service';
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
  describe('FieldTestPaginationEntity Management Detail Component', () => {
    let wrapper: Wrapper<FieldTestPaginationEntityClass>;
    let comp: FieldTestPaginationEntityClass;
    let fieldTestPaginationEntityServiceStub: SinonStubbedInstance<FieldTestPaginationEntityService>;

    beforeEach(() => {
      fieldTestPaginationEntityServiceStub = sinon.createStubInstance<FieldTestPaginationEntityService>(FieldTestPaginationEntityService);

      wrapper = shallowMount<FieldTestPaginationEntityClass>(FieldTestPaginationEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { fieldTestPaginationEntityService: () => fieldTestPaginationEntityServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundFieldTestPaginationEntity = { id: 123 };
        fieldTestPaginationEntityServiceStub.find.resolves(foundFieldTestPaginationEntity);

        // WHEN
        comp.retrieveFieldTestPaginationEntity(123);
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestPaginationEntity).toBe(foundFieldTestPaginationEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestPaginationEntity = { id: 123 };
        fieldTestPaginationEntityServiceStub.find.resolves(foundFieldTestPaginationEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { fieldTestPaginationEntityId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestPaginationEntity).toBe(foundFieldTestPaginationEntity);
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
