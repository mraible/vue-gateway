/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import FieldTestInfiniteScrollEntityDetailComponent from '@/entities/field-test-infinite-scroll-entity/field-test-infinite-scroll-entity-details.vue';
import FieldTestInfiniteScrollEntityClass from '@/entities/field-test-infinite-scroll-entity/field-test-infinite-scroll-entity-details.component';
import FieldTestInfiniteScrollEntityService from '@/entities/field-test-infinite-scroll-entity/field-test-infinite-scroll-entity.service';
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
  describe('FieldTestInfiniteScrollEntity Management Detail Component', () => {
    let wrapper: Wrapper<FieldTestInfiniteScrollEntityClass>;
    let comp: FieldTestInfiniteScrollEntityClass;
    let fieldTestInfiniteScrollEntityServiceStub: SinonStubbedInstance<FieldTestInfiniteScrollEntityService>;

    beforeEach(() => {
      fieldTestInfiniteScrollEntityServiceStub = sinon.createStubInstance<FieldTestInfiniteScrollEntityService>(
        FieldTestInfiniteScrollEntityService
      );

      wrapper = shallowMount<FieldTestInfiniteScrollEntityClass>(FieldTestInfiniteScrollEntityDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          fieldTestInfiniteScrollEntityService: () => fieldTestInfiniteScrollEntityServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundFieldTestInfiniteScrollEntity = { id: 123 };
        fieldTestInfiniteScrollEntityServiceStub.find.resolves(foundFieldTestInfiniteScrollEntity);

        // WHEN
        comp.retrieveFieldTestInfiniteScrollEntity(123);
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestInfiniteScrollEntity).toBe(foundFieldTestInfiniteScrollEntity);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestInfiniteScrollEntity = { id: 123 };
        fieldTestInfiniteScrollEntityServiceStub.find.resolves(foundFieldTestInfiniteScrollEntity);

        // WHEN
        comp.beforeRouteEnter({ params: { fieldTestInfiniteScrollEntityId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestInfiniteScrollEntity).toBe(foundFieldTestInfiniteScrollEntity);
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
