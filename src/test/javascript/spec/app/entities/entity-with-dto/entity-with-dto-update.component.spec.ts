/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import EntityWithDTOUpdateComponent from '@/entities/entity-with-dto/entity-with-dto-update.vue';
import EntityWithDTOClass from '@/entities/entity-with-dto/entity-with-dto-update.component';
import EntityWithDTOService from '@/entities/entity-with-dto/entity-with-dto.service';

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
  describe('EntityWithDTO Management Update Component', () => {
    let wrapper: Wrapper<EntityWithDTOClass>;
    let comp: EntityWithDTOClass;
    let entityWithDTOServiceStub: SinonStubbedInstance<EntityWithDTOService>;

    beforeEach(() => {
      entityWithDTOServiceStub = sinon.createStubInstance<EntityWithDTOService>(EntityWithDTOService);

      wrapper = shallowMount<EntityWithDTOClass>(EntityWithDTOUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          entityWithDTOService: () => entityWithDTOServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.entityWithDTO = entity;
        entityWithDTOServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithDTOServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.entityWithDTO = entity;
        entityWithDTOServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(entityWithDTOServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithDTO = { id: 123 };
        entityWithDTOServiceStub.find.resolves(foundEntityWithDTO);
        entityWithDTOServiceStub.retrieve.resolves([foundEntityWithDTO]);

        // WHEN
        comp.beforeRouteEnter({ params: { entityWithDTOId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithDTO).toBe(foundEntityWithDTO);
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
