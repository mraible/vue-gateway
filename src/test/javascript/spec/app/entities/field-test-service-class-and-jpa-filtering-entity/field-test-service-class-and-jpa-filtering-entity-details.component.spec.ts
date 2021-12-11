/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import FieldTestServiceClassAndJpaFilteringEntityDetailComponent from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity-details.vue';
import FieldTestServiceClassAndJpaFilteringEntityClass from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity-details.component';
import FieldTestServiceClassAndJpaFilteringEntityService from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity.service';
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
  describe('FieldTestServiceClassAndJpaFilteringEntity Management Detail Component', () => {
    let wrapper: Wrapper<FieldTestServiceClassAndJpaFilteringEntityClass>;
    let comp: FieldTestServiceClassAndJpaFilteringEntityClass;
    let fieldTestServiceClassAndJpaFilteringEntityServiceStub: SinonStubbedInstance<FieldTestServiceClassAndJpaFilteringEntityService>;

    beforeEach(() => {
      fieldTestServiceClassAndJpaFilteringEntityServiceStub = sinon.createStubInstance<FieldTestServiceClassAndJpaFilteringEntityService>(
        FieldTestServiceClassAndJpaFilteringEntityService
      );

      wrapper = shallowMount<FieldTestServiceClassAndJpaFilteringEntityClass>(FieldTestServiceClassAndJpaFilteringEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          fieldTestServiceClassAndJpaFilteringEntityService: () => fieldTestServiceClassAndJpaFilteringEntityServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundFieldTestServiceClassAndJpaFilteringEntity = { id: 123 };
        fieldTestServiceClassAndJpaFilteringEntityServiceStub.find.resolves(foundFieldTestServiceClassAndJpaFilteringEntity);

        // WHEN
        comp.retrieveFieldTestServiceClassAndJpaFilteringEntity(123);
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestServiceClassAndJpaFilteringEntity).toBe(foundFieldTestServiceClassAndJpaFilteringEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestServiceClassAndJpaFilteringEntity = { id: 123 };
        fieldTestServiceClassAndJpaFilteringEntityServiceStub.find.resolves(foundFieldTestServiceClassAndJpaFilteringEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { fieldTestServiceClassAndJpaFilteringEntityId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestServiceClassAndJpaFilteringEntity).toBe(foundFieldTestServiceClassAndJpaFilteringEntity);
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
