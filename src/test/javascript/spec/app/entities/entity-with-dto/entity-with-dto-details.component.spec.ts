/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import EntityWithDTODetailComponent from '@/entities/entity-with-dto/entity-with-dto-details.vue';
import EntityWithDTOClass from '@/entities/entity-with-dto/entity-with-dto-details.component';
import EntityWithDTOService from '@/entities/entity-with-dto/entity-with-dto.service';
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
  describe('EntityWithDTO Management Detail Component', () => {
    let wrapper: Wrapper<EntityWithDTOClass>;
    let comp: EntityWithDTOClass;
    let entityWithDTOServiceStub: SinonStubbedInstance<EntityWithDTOService>;

    beforeEach(() => {
      entityWithDTOServiceStub = sinon.createStubInstance<EntityWithDTOService>(EntityWithDTOService);

      wrapper = shallowMount<EntityWithDTOClass>(EntityWithDTODetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { entityWithDTOService: () => entityWithDTOServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundEntityWithDTO = { id: 123 };
        entityWithDTOServiceStub.find.resolves(foundEntityWithDTO);

        // WHEN
        comp.retrieveEntityWithDTO(123);
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithDTO).toBe(foundEntityWithDTO);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithDTO = { id: 123 };
        entityWithDTOServiceStub.find.resolves(foundEntityWithDTO);

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
