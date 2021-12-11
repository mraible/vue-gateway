/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import FieldTestMapstructAndServiceClassEntityDetailComponent from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity-details.vue';
import FieldTestMapstructAndServiceClassEntityClass from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity-details.component';
import FieldTestMapstructAndServiceClassEntityService from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity.service';
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
  describe('FieldTestMapstructAndServiceClassEntity Management Detail Component', () => {
    let wrapper: Wrapper<FieldTestMapstructAndServiceClassEntityClass>;
    let comp: FieldTestMapstructAndServiceClassEntityClass;
    let fieldTestMapstructAndServiceClassEntityServiceStub: SinonStubbedInstance<FieldTestMapstructAndServiceClassEntityService>;

    beforeEach(() => {
      fieldTestMapstructAndServiceClassEntityServiceStub = sinon.createStubInstance<FieldTestMapstructAndServiceClassEntityService>(
        FieldTestMapstructAndServiceClassEntityService
      );

      wrapper = shallowMount<FieldTestMapstructAndServiceClassEntityClass>(FieldTestMapstructAndServiceClassEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          fieldTestMapstructAndServiceClassEntityService: () => fieldTestMapstructAndServiceClassEntityServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundFieldTestMapstructAndServiceClassEntity = { id: 123 };
        fieldTestMapstructAndServiceClassEntityServiceStub.find.resolves(foundFieldTestMapstructAndServiceClassEntity);

        // WHEN
        comp.retrieveFieldTestMapstructAndServiceClassEntity(123);
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestMapstructAndServiceClassEntity).toBe(foundFieldTestMapstructAndServiceClassEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestMapstructAndServiceClassEntity = { id: 123 };
        fieldTestMapstructAndServiceClassEntityServiceStub.find.resolves(foundFieldTestMapstructAndServiceClassEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { fieldTestMapstructAndServiceClassEntityId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestMapstructAndServiceClassEntity).toBe(foundFieldTestMapstructAndServiceClassEntity);
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
