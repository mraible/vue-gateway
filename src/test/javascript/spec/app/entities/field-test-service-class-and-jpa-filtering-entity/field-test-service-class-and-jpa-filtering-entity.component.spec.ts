/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import FieldTestServiceClassAndJpaFilteringEntityComponent from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity.vue';
import FieldTestServiceClassAndJpaFilteringEntityClass from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity.component';
import FieldTestServiceClassAndJpaFilteringEntityService from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity.service';
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
  describe('FieldTestServiceClassAndJpaFilteringEntity Management Component', () => {
    let wrapper: Wrapper<FieldTestServiceClassAndJpaFilteringEntityClass>;
    let comp: FieldTestServiceClassAndJpaFilteringEntityClass;
    let fieldTestServiceClassAndJpaFilteringEntityServiceStub: SinonStubbedInstance<FieldTestServiceClassAndJpaFilteringEntityService>;

    beforeEach(() => {
      fieldTestServiceClassAndJpaFilteringEntityServiceStub = sinon.createStubInstance<FieldTestServiceClassAndJpaFilteringEntityService>(
        FieldTestServiceClassAndJpaFilteringEntityService
      );
      fieldTestServiceClassAndJpaFilteringEntityServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<FieldTestServiceClassAndJpaFilteringEntityClass>(FieldTestServiceClassAndJpaFilteringEntityComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          fieldTestServiceClassAndJpaFilteringEntityService: () => fieldTestServiceClassAndJpaFilteringEntityServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      fieldTestServiceClassAndJpaFilteringEntityServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllFieldTestServiceClassAndJpaFilteringEntitys();
      await comp.$nextTick();

      // THEN
      expect(fieldTestServiceClassAndJpaFilteringEntityServiceStub.retrieve.called).toBeTruthy();
      expect(comp.fieldTestServiceClassAndJpaFilteringEntities[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      fieldTestServiceClassAndJpaFilteringEntityServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(fieldTestServiceClassAndJpaFilteringEntityServiceStub.retrieve.callCount).toEqual(1);

      comp.removeFieldTestServiceClassAndJpaFilteringEntity();
      await comp.$nextTick();

      // THEN
      expect(fieldTestServiceClassAndJpaFilteringEntityServiceStub.delete.called).toBeTruthy();
      expect(fieldTestServiceClassAndJpaFilteringEntityServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
