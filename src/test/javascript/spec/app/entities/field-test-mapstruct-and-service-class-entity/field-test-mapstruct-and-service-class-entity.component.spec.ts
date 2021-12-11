/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import FieldTestMapstructAndServiceClassEntityComponent from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity.vue';
import FieldTestMapstructAndServiceClassEntityClass from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity.component';
import FieldTestMapstructAndServiceClassEntityService from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity.service';
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
  describe('FieldTestMapstructAndServiceClassEntity Management Component', () => {
    let wrapper: Wrapper<FieldTestMapstructAndServiceClassEntityClass>;
    let comp: FieldTestMapstructAndServiceClassEntityClass;
    let fieldTestMapstructAndServiceClassEntityServiceStub: SinonStubbedInstance<FieldTestMapstructAndServiceClassEntityService>;

    beforeEach(() => {
      fieldTestMapstructAndServiceClassEntityServiceStub = sinon.createStubInstance<FieldTestMapstructAndServiceClassEntityService>(
        FieldTestMapstructAndServiceClassEntityService
      );
      fieldTestMapstructAndServiceClassEntityServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<FieldTestMapstructAndServiceClassEntityClass>(FieldTestMapstructAndServiceClassEntityComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          fieldTestMapstructAndServiceClassEntityService: () => fieldTestMapstructAndServiceClassEntityServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      fieldTestMapstructAndServiceClassEntityServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllFieldTestMapstructAndServiceClassEntitys();
      await comp.$nextTick();

      // THEN
      expect(fieldTestMapstructAndServiceClassEntityServiceStub.retrieve.called).toBeTruthy();
      expect(comp.fieldTestMapstructAndServiceClassEntities[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      fieldTestMapstructAndServiceClassEntityServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(fieldTestMapstructAndServiceClassEntityServiceStub.retrieve.callCount).toEqual(1);

      comp.removeFieldTestMapstructAndServiceClassEntity();
      await comp.$nextTick();

      // THEN
      expect(fieldTestMapstructAndServiceClassEntityServiceStub.delete.called).toBeTruthy();
      expect(fieldTestMapstructAndServiceClassEntityServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
