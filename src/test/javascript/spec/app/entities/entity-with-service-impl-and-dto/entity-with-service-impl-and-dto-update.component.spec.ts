/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import EntityWithServiceImplAndDTOUpdateComponent from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto-update.vue';
import EntityWithServiceImplAndDTOClass from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto-update.component';
import EntityWithServiceImplAndDTOService from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto.service';

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
  describe('EntityWithServiceImplAndDTO Management Update Component', () => {
    let wrapper: Wrapper<EntityWithServiceImplAndDTOClass>;
    let comp: EntityWithServiceImplAndDTOClass;
    let entityWithServiceImplAndDTOServiceStub: SinonStubbedInstance<EntityWithServiceImplAndDTOService>;

    beforeEach(() => {
      entityWithServiceImplAndDTOServiceStub =
        sinon.createStubInstance<EntityWithServiceImplAndDTOService>(EntityWithServiceImplAndDTOService);

      wrapper = shallowMount<EntityWithServiceImplAndDTOClass>(EntityWithServiceImplAndDTOUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          entityWithServiceImplAndDTOService: () => entityWithServiceImplAndDTOServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.entityWithServiceImplAndDTO = entity;
        entityWithServiceImplAndDTOServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceImplAndDTOServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.entityWithServiceImplAndDTO = entity;
        entityWithServiceImplAndDTOServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithServiceImplAndDTOServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithServiceImplAndDTO = { id: 123 };
        entityWithServiceImplAndDTOServiceStub.find.resolves(foundEntityWithServiceImplAndDTO);
        entityWithServiceImplAndDTOServiceStub.retrieve.resolves([foundEntityWithServiceImplAndDTO]);

        // WHEN
        comp.beforeRouteEnter({ params: { entityWithServiceImplAndDTOId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithServiceImplAndDTO).toBe(foundEntityWithServiceImplAndDTO);
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
