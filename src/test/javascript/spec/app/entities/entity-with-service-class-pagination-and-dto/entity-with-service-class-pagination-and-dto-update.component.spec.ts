/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import EntityWithServiceClassPaginationAndDTOUpdateComponent from '@/entities/entity-with-service-class-pagination-and-dto/entity-with-service-class-pagination-and-dto-update.vue';
import EntityWithServiceClassPaginationAndDTOClass from '@/entities/entity-with-service-class-pagination-and-dto/entity-with-service-class-pagination-and-dto-update.component';
import EntityWithServiceClassPaginationAndDTOService from '@/entities/entity-with-service-class-pagination-and-dto/entity-with-service-class-pagination-and-dto.service';

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
  describe('EntityWithServiceClassPaginationAndDTO Management Update Component', () => {
    let wrapper: Wrapper<EntityWithServiceClassPaginationAndDTOClass>;
    let comp: EntityWithServiceClassPaginationAndDTOClass;
    let entityWithServiceClassPaginationAndDTOServiceStub: SinonStubbedInstance<EntityWithServiceClassPaginationAndDTOService>;

    beforeEach(() => {
      entityWithServiceClassPaginationAndDTOServiceStub = sinon.createStubInstance<EntityWithServiceClassPaginationAndDTOService>(
        EntityWithServiceClassPaginationAndDTOService
      );

      wrapper = shallowMount<EntityWithServiceClassPaginationAndDTOClass>(EntityWithServiceClassPaginationAndDTOUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          entityWithServiceClassPaginationAndDTOService: () => entityWithServiceClassPaginationAndDTOServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.entityWithServiceClassPaginationAndDTO = entity;
        entityWithServiceClassPaginationAndDTOServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceClassPaginationAndDTOServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.entityWithServiceClassPaginationAndDTO = entity;
        entityWithServiceClassPaginationAndDTOServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceClassPaginationAndDTOServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithServiceClassPaginationAndDTO = { id: 123 };
        entityWithServiceClassPaginationAndDTOServiceStub.find.resolves(foundEntityWithServiceClassPaginationAndDTO);
        entityWithServiceClassPaginationAndDTOServiceStub.retrieve.resolves([foundEntityWithServiceClassPaginationAndDTO]);

        // WHEN
        comp.beforeRouteEnter({ params: { entityWithServiceClassPaginationAndDTOId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithServiceClassPaginationAndDTO).toBe(foundEntityWithServiceClassPaginationAndDTO);
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
