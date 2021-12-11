/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import EntityWithServiceClassAndPaginationUpdateComponent from '@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination-update.vue';
import EntityWithServiceClassAndPaginationClass from '@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination-update.component';
import EntityWithServiceClassAndPaginationService from '@/entities/entity-with-service-class-and-pagination/entity-with-service-class-and-pagination.service';

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
  describe('EntityWithServiceClassAndPagination Management Update Component', () => {
    let wrapper: Wrapper<EntityWithServiceClassAndPaginationClass>;
    let comp: EntityWithServiceClassAndPaginationClass;
    let entityWithServiceClassAndPaginationServiceStub: SinonStubbedInstance<EntityWithServiceClassAndPaginationService>;

    beforeEach(() => {
      entityWithServiceClassAndPaginationServiceStub = sinon.createStubInstance<EntityWithServiceClassAndPaginationService>(
        EntityWithServiceClassAndPaginationService
      );

      wrapper = shallowMount<EntityWithServiceClassAndPaginationClass>(EntityWithServiceClassAndPaginationUpdateComponent, {
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

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.entityWithServiceClassAndPagination = entity;
        entityWithServiceClassAndPaginationServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceClassAndPaginationServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.entityWithServiceClassAndPagination = entity;
        entityWithServiceClassAndPaginationServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceClassAndPaginationServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithServiceClassAndPagination = { id: 123 };
        entityWithServiceClassAndPaginationServiceStub.find.resolves(foundEntityWithServiceClassAndPagination);
        entityWithServiceClassAndPaginationServiceStub.retrieve.resolves([foundEntityWithServiceClassAndPagination]);

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
