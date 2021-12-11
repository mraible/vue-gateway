/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import EntityWithPaginationAndDTODetailComponent from '@/entities/entity-with-pagination-and-dto/entity-with-pagination-and-dto-details.vue';
import EntityWithPaginationAndDTOClass from '@/entities/entity-with-pagination-and-dto/entity-with-pagination-and-dto-details.component';
import EntityWithPaginationAndDTOService from '@/entities/entity-with-pagination-and-dto/entity-with-pagination-and-dto.service';
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
  describe('EntityWithPaginationAndDTO Management Detail Component', () => {
    let wrapper: Wrapper<EntityWithPaginationAndDTOClass>;
    let comp: EntityWithPaginationAndDTOClass;
    let entityWithPaginationAndDTOServiceStub: SinonStubbedInstance<EntityWithPaginationAndDTOService>;

    beforeEach(() => {
      entityWithPaginationAndDTOServiceStub =
        sinon.createStubInstance<EntityWithPaginationAndDTOService>(EntityWithPaginationAndDTOService);

      wrapper = shallowMount<EntityWithPaginationAndDTOClass>(EntityWithPaginationAndDTODetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { entityWithPaginationAndDTOService: () => entityWithPaginationAndDTOServiceStub, alertService: () => new AlertService() },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundEntityWithPaginationAndDTO = { id: 123 };
        entityWithPaginationAndDTOServiceStub.find.resolves(foundEntityWithPaginationAndDTO);

        // WHEN
        comp.retrieveEntityWithPaginationAndDTO(123);
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithPaginationAndDTO).toBe(foundEntityWithPaginationAndDTO);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEntityWithPaginationAndDTO = { id: 123 };
        entityWithPaginationAndDTOServiceStub.find.resolves(foundEntityWithPaginationAndDTO);

        // WHEN
        comp.beforeRouteEnter({ params: { entityWithPaginationAndDTOId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.entityWithPaginationAndDTO).toBe(foundEntityWithPaginationAndDTO);
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
