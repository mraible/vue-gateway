/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import EntityWithServiceImplAndPaginationUpdateComponent from '@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination-update.vue';
import EntityWithServiceImplAndPaginationClass from '@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination-update.component';
import EntityWithServiceImplAndPaginationService from '@/entities/entity-with-service-impl-and-pagination/entity-with-service-impl-and-pagination.service';

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
  describe('EntityWithServiceImplAndPagination Management Update Component', () => {
    let wrapper: Wrapper<EntityWithServiceImplAndPaginationClass>;
    let comp: EntityWithServiceImplAndPaginationClass;
    let entityWithServiceImplAndPaginationServiceStub: SinonStubbedInstance<EntityWithServiceImplAndPaginationService>;

    beforeEach(() => {
      entityWithServiceImplAndPaginationServiceStub = sinon.createStubInstance<EntityWithServiceImplAndPaginationService>(
        EntityWithServiceImplAndPaginationService
      );

      wrapper = shallowMount<EntityWithServiceImplAndPaginationClass>(EntityWithServiceImplAndPaginationUpdateComponent, {
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

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.entityWithServiceImplAndPagination = entity;
        entityWithServiceImplAndPaginationServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceImplAndPaginationServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.entityWithServiceImplAndPagination = entity;
        entityWithServiceImplAndPaginationServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceImplAndPaginationServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithServiceImplAndPagination = { id: 123 };
        entityWithServiceImplAndPaginationServiceStub.find.resolves(foundEntityWithServiceImplAndPagination);
        entityWithServiceImplAndPaginationServiceStub.retrieve.resolves([foundEntityWithServiceImplAndPagination]);

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
