/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import EntityWithServiceImplAndPaginationDetailComponent from '@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination-details.vue';
import EntityWithServiceImplAndPaginationClass from '@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination-details.component';
import EntityWithServiceImplAndPaginationService from '@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination.service';
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
  describe('EntityWithServiceImplAndPagination Management Detail Component', () => {
    let wrapper: Wrapper<EntityWithServiceImplAndPaginationClass>;
    let comp: EntityWithServiceImplAndPaginationClass;
    let entityWithServiceImplAndPaginationServiceStub: SinonStubbedInstance<EntityWithServiceImplAndPaginationService>;

    beforeEach(() => {
      entityWithServiceImplAndPaginationServiceStub = sinon.createStubInstance<EntityWithServiceImplAndPaginationService>(
        EntityWithServiceImplAndPaginationService
      );

      wrapper = shallowMount<EntityWithServiceImplAndPaginationClass>(EntityWithServiceImplAndPaginationDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          entityWithServiceImplAndPaginationService: () => entityWithServiceImplAndPaginationServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundEntityWithServiceImplAndPagination = { id: 123 };
        entityWithServiceImplAndPaginationServiceStub.find.resolves(foundEntityWithServiceImplAndPagination);

        // WHEN
        comp.retrieveEntityWithServiceImplAndPagination(123);
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithServiceImplAndPagination).toBe(foundEntityWithServiceImplAndPagination);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithServiceImplAndPagination = { id: 123 };
        entityWithServiceImplAndPaginationServiceStub.find.resolves(foundEntityWithServiceImplAndPagination);

        // WHEN
        comp.beforeRouteEnter({ params: { entityWithServiceImplAndPaginationId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithServiceImplAndPagination).toBe(foundEntityWithServiceImplAndPagination);
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
