/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import EntityWithDTOComponent from '@/entities/entity-with-dto/entity-with-dto.vue';
import EntityWithDTOClass from '@/entities/entity-with-dto/entity-with-dto.component';
import EntityWithDTOService from '@/entities/entity-with-dto/entity-with-dto.service';
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
  describe('EntityWithDTO Management Component', () => {
    let wrapper: Wrapper<EntityWithDTOClass>;
    let comp: EntityWithDTOClass;
    let entityWithDTOServiceStub: SinonStubbedInstance<EntityWithDTOService>;

    beforeEach(() => {
      entityWithDTOServiceStub = sinon.createStubInstance<EntityWithDTOService>(EntityWithDTOService);
      entityWithDTOServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<EntityWithDTOClass>(EntityWithDTOComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          entityWithDTOService: () => entityWithDTOServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      entityWithDTOServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllEntityWithDTOs();
      await comp.$nextTick();

      // THEN
      expect(entityWithDTOServiceStub.retrieve.called).toBeTruthy();
      expect(comp.entityWithDTOS[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      entityWithDTOServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(entityWithDTOServiceStub.retrieve.callCount).toEqual(1);

      comp.removeEntityWithDTO();
      await comp.$nextTick();

      // THEN
      expect(entityWithDTOServiceStub.delete.called).toBeTruthy();
      expect(entityWithDTOServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
