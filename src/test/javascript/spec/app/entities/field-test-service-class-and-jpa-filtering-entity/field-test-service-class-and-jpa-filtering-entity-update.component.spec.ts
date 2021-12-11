/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import * as config from '@/shared/config/config';
import FieldTestServiceClassAndJpaFilteringEntityUpdateComponent from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity-update.vue';
import FieldTestServiceClassAndJpaFilteringEntityClass from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity-update.component';
import FieldTestServiceClassAndJpaFilteringEntityService from '@/entities/field-test-service-class-and-jpa-filtering-entity/field-test-service-class-and-jpa-filtering-entity.service';

import AlertService from '@/shared/alert/alert.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.use(ToastPlugin);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('FieldTestServiceClassAndJpaFilteringEntity Management Update Component', () => {
    let wrapper: Wrapper<FieldTestServiceClassAndJpaFilteringEntityClass>;
    let comp: FieldTestServiceClassAndJpaFilteringEntityClass;
    let fieldTestServiceClassAndJpaFilteringEntityServiceStub: SinonStubbedInstance<FieldTestServiceClassAndJpaFilteringEntityService>;

    beforeEach(() => {
      fieldTestServiceClassAndJpaFilteringEntityServiceStub = sinon.createStubInstance<FieldTestServiceClassAndJpaFilteringEntityService>(
        FieldTestServiceClassAndJpaFilteringEntityService
      );

      wrapper = shallowMount<FieldTestServiceClassAndJpaFilteringEntityClass>(FieldTestServiceClassAndJpaFilteringEntityUpdateComponent, {
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

    describe('load', () => {
      it('Should convert date from string', () => {
        // GIVEN
        const date = new Date('2019-10-15T11:42:02Z');

        // WHEN
        const convertedDate = comp.convertDateTimeFromServer(date);

        // THEN
        expect(convertedDate).toEqual(dayjs(date).format(DATE_TIME_LONG_FORMAT));
      });

      it('Should not convert date if date is not present', () => {
        expect(comp.convertDateTimeFromServer(null)).toBeNull();
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.fieldTestServiceClassAndJpaFilteringEntity = entity;
        fieldTestServiceClassAndJpaFilteringEntityServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(fieldTestServiceClassAndJpaFilteringEntityServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.fieldTestServiceClassAndJpaFilteringEntity = entity;
        fieldTestServiceClassAndJpaFilteringEntityServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(fieldTestServiceClassAndJpaFilteringEntityServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestServiceClassAndJpaFilteringEntity = { id: 123 };
        fieldTestServiceClassAndJpaFilteringEntityServiceStub.find.resolves(foundFieldTestServiceClassAndJpaFilteringEntity);
        fieldTestServiceClassAndJpaFilteringEntityServiceStub.retrieve.resolves([foundFieldTestServiceClassAndJpaFilteringEntity]);

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
