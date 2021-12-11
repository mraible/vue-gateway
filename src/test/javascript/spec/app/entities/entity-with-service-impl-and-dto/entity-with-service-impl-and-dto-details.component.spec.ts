/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import EntityWithServiceImplAndDTODetailComponent from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto-details.vue';
import EntityWithServiceImplAndDTOClass from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto-details.component';
import EntityWithServiceImplAndDTOService from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto.service';
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
  describe('EntityWithServiceImplAndDTO Management Detail Component', () => {
    let wrapper: Wrapper<EntityWithServiceImplAndDTOClass>;
    let comp: EntityWithServiceImplAndDTOClass;
    let entityWithServiceImplAndDTOServiceStub: SinonStubbedInstance<EntityWithServiceImplAndDTOService>;

    beforeEach(() => {
      entityWithServiceImplAndDTOServiceStub =
        sinon.createStubInstance<EntityWithServiceImplAndDTOService>(EntityWithServiceImplAndDTOService);

      wrapper = shallowMount<EntityWithServiceImplAndDTOClass>(EntityWithServiceImplAndDTODetailComponent, {
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

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundEntityWithServiceImplAndDTO = { id: 123 };
        entityWithServiceImplAndDTOServiceStub.find.resolves(foundEntityWithServiceImplAndDTO);

        // WHEN
        comp.retrieveEntityWithServiceImplAndDTO(123);
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithServiceImplAndDTO).toBe(foundEntityWithServiceImplAndDTO);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithServiceImplAndDTO = { id: 123 };
        entityWithServiceImplAndDTOServiceStub.find.resolves(foundEntityWithServiceImplAndDTO);

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
