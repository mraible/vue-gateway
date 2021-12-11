/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import FieldTestEnumWithValueComponent from '@/entities/field-test-enum-with-value/field-test-enum-with-value.vue';
import FieldTestEnumWithValueClass from '@/entities/field-test-enum-with-value/field-test-enum-with-value.component';
import FieldTestEnumWithValueService from '@/entities/field-test-enum-with-value/field-test-enum-with-value.service';
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
  describe('FieldTestEnumWithValue Management Component', () => {
    let wrapper: Wrapper<FieldTestEnumWithValueClass>;
    let comp: FieldTestEnumWithValueClass;
    let fieldTestEnumWithValueServiceStub: SinonStubbedInstance<FieldTestEnumWithValueService>;

    beforeEach(() => {
      fieldTestEnumWithValueServiceStub = sinon.createStubInstance<FieldTestEnumWithValueService>(FieldTestEnumWithValueService);
      fieldTestEnumWithValueServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<FieldTestEnumWithValueClass>(FieldTestEnumWithValueComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          fieldTestEnumWithValueService: () => fieldTestEnumWithValueServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      fieldTestEnumWithValueServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllFieldTestEnumWithValues();
      await comp.$nextTick();

      // THEN
      expect(fieldTestEnumWithValueServiceStub.retrieve.called).toBeTruthy();
      expect(comp.fieldTestEnumWithValues[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      fieldTestEnumWithValueServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(fieldTestEnumWithValueServiceStub.retrieve.callCount).toEqual(1);

      comp.removeFieldTestEnumWithValue();
      await comp.$nextTick();

      // THEN
      expect(fieldTestEnumWithValueServiceStub.delete.called).toBeTruthy();
      expect(fieldTestEnumWithValueServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
