/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import EntityWithServiceClassAndPaginationDetailComponent from '@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination-details.vue';
import EntityWithServiceClassAndPaginationClass from '@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination-details.component';
import EntityWithServiceClassAndPaginationService from '@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination.service';
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
  describe('EntityWithServiceClassAndPagination Management Detail Component', () => {
    let wrapper: Wrapper<EntityWithServiceClassAndPaginationClass>;
    let comp: EntityWithServiceClassAndPaginationClass;
    let entityWithServiceClassAndPaginationServiceStub: SinonStubbedInstance<EntityWithServiceClassAndPaginationService>;

    beforeEach(() => {
      entityWithServiceClassAndPaginationServiceStub = sinon.createStubInstance<EntityWithServiceClassAndPaginationService>(
        EntityWithServiceClassAndPaginationService
      );

      wrapper = shallowMount<EntityWithServiceClassAndPaginationClass>(EntityWithServiceClassAndPaginationDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          entityWithServiceClassAndPaginationService: () => entityWithServiceClassAndPaginationServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundEntityWithServiceClassAndPagination = { id: 123 };
        entityWithServiceClassAndPaginationServiceStub.find.resolves(foundEntityWithServiceClassAndPagination);

        // WHEN
        comp.retrieveEntityWithServiceClassAndPagination(123);
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithServiceClassAndPagination).toBe(foundEntityWithServiceClassAndPagination);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithServiceClassAndPagination = { id: 123 };
        entityWithServiceClassAndPaginationServiceStub.find.resolves(foundEntityWithServiceClassAndPagination);

        // WHEN
        comp.beforeRouteEnter({ params: { entityWithServiceClassAndPaginationId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithServiceClassAndPagination).toBe(foundEntityWithServiceClassAndPagination);
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
