/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import FieldTestEntityComponent from '@/entities/field-test-entity/field-test-entity.vue';
import FieldTestEntityClass from '@/entities/field-test-entity/field-test-entity.component';
import FieldTestEntityService from '@/entities/field-test-entity/field-test-entity.service';
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
  describe('FieldTestEntity Management Component', () => {
    let wrapper: Wrapper<FieldTestEntityClass>;
    let comp: FieldTestEntityClass;
    let fieldTestEntityServiceStub: SinonStubbedInstance<FieldTestEntityService>;

    beforeEach(() => {
      fieldTestEntityServiceStub = sinon.createStubInstance<FieldTestEntityService>(FieldTestEntityService);
      fieldTestEntityServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<FieldTestEntityClass>(FieldTestEntityComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          fieldTestEntityService: () => fieldTestEntityServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      fieldTestEntityServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllFieldTestEntitys();
      await comp.$nextTick();

      // THEN
      expect(fieldTestEntityServiceStub.retrieve.called).toBeTruthy();
      expect(comp.fieldTestEntities[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      fieldTestEntityServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(fieldTestEntityServiceStub.retrieve.callCount).toEqual(1);

      comp.removeFieldTestEntity();
      await comp.$nextTick();

      // THEN
      expect(fieldTestEntityServiceStub.delete.called).toBeTruthy();
      expect(fieldTestEntityServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
