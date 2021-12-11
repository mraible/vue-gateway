/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import EntityWithServiceImplAndDTOComponent from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto.vue';
import EntityWithServiceImplAndDTOClass from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto.component';
import EntityWithServiceImplAndDTOService from '@/entities/entity-with-service-impl-and-dto/entity-with-service-impl-and-dto.service';
import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();
localVue.use(ToastPlugin);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('EntityWithServiceImplAndDTO Management Component', () => {
    let wrapper: Wrapper<EntityWithServiceImplAndDTOClass>;
    let comp: EntityWithServiceImplAndDTOClass;
    let entityWithServiceImplAndDTOServiceStub: SinonStubbedInstance<EntityWithServiceImplAndDTOService>;

    beforeEach(() => {
      entityWithServiceImplAndDTOServiceStub =
        sinon.createStubInstance<EntityWithServiceImplAndDTOService>(EntityWithServiceImplAndDTOService);
      entityWithServiceImplAndDTOServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<EntityWithServiceImplAndDTOClass>(EntityWithServiceImplAndDTOComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          entityWithServiceImplAndDTOService: () => entityWithServiceImplAndDTOServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      entityWithServiceImplAndDTOServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllEntityWithServiceImplAndDTOs();
      await comp.$nextTick();

      // THEN
      expect(entityWithServiceImplAndDTOServiceStub.retrieve.called).toBeTruthy();
      expect(comp.entityWithServiceImplAndDTOS[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      entityWithServiceImplAndDTOServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(entityWithServiceImplAndDTOServiceStub.retrieve.callCount).toEqual(1);

      comp.removeEntityWithServiceImplAndDTO();
      await comp.$nextTick();

      // THEN
      expect(entityWithServiceImplAndDTOServiceStub.delete.called).toBeTruthy();
      expect(entityWithServiceImplAndDTOServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
