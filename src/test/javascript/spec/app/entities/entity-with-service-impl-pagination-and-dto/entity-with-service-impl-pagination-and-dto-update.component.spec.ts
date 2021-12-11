/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import EntityWithServiceImplPaginationAndDTOUpdateComponent from '@/entities/entity-with-service-impl-pagination-and-dto/entity-with-service-impl-pagination-and-dto-update.vue';
import EntityWithServiceImplPaginationAndDTOClass from '@/entities/entity-with-service-impl-pagination-and-dto/entity-with-service-impl-pagination-and-dto-update.component';
import EntityWithServiceImplPaginationAndDTOService from '@/entities/entity-with-service-impl-pagination-and-dto/entity-with-service-impl-pagination-and-dto.service';

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
  describe('EntityWithServiceImplPaginationAndDTO Management Update Component', () => {
    let wrapper: Wrapper<EntityWithServiceImplPaginationAndDTOClass>;
    let comp: EntityWithServiceImplPaginationAndDTOClass;
    let entityWithServiceImplPaginationAndDTOServiceStub: SinonStubbedInstance<EntityWithServiceImplPaginationAndDTOService>;

    beforeEach(() => {
      entityWithServiceImplPaginationAndDTOServiceStub = sinon.createStubInstance<EntityWithServiceImplPaginationAndDTOService>(
        EntityWithServiceImplPaginationAndDTOService
      );

      wrapper = shallowMount<EntityWithServiceImplPaginationAndDTOClass>(EntityWithServiceImplPaginationAndDTOUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          entityWithServiceImplPaginationAndDTOService: () => entityWithServiceImplPaginationAndDTOServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.entityWithServiceImplPaginationAndDTO = entity;
        entityWithServiceImplPaginationAndDTOServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceImplPaginationAndDTOServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.entityWithServiceImplPaginationAndDTO = entity;
        entityWithServiceImplPaginationAndDTOServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceImplPaginationAndDTOServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithServiceImplPaginationAndDTO = { id: 123 };
        entityWithServiceImplPaginationAndDTOServiceStub.find.resolves(foundEntityWithServiceImplPaginationAndDTO);
        entityWithServiceImplPaginationAndDTOServiceStub.retrieve.resolves([foundEntityWithServiceImplPaginationAndDTO]);

        // WHEN
        comp.beforeRouteEnter({ params: { entityWithServiceImplPaginationAndDTOId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithServiceImplPaginationAndDTO).toBe(foundEntityWithServiceImplPaginationAndDTO);
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
