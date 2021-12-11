/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import * as config from '@/shared/config/config';
import FieldTestMapstructAndServiceClassEntityUpdateComponent from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity-update.vue';
import FieldTestMapstructAndServiceClassEntityClass from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity-update.component';
import FieldTestMapstructAndServiceClassEntityService from '@/entities/field-test-mapstruct-and-service-class-entity/field-test-mapstruct-and-service-class-entity.service';

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
  describe('FieldTestMapstructAndServiceClassEntity Management Update Component', () => {
    let wrapper: Wrapper<FieldTestMapstructAndServiceClassEntityClass>;
    let comp: FieldTestMapstructAndServiceClassEntityClass;
    let fieldTestMapstructAndServiceClassEntityServiceStub: SinonStubbedInstance<FieldTestMapstructAndServiceClassEntityService>;

    beforeEach(() => {
      fieldTestMapstructAndServiceClassEntityServiceStub = sinon.createStubInstance<FieldTestMapstructAndServiceClassEntityService>(
        FieldTestMapstructAndServiceClassEntityService
      );

      wrapper = shallowMount<FieldTestMapstructAndServiceClassEntityClass>(FieldTestMapstructAndServiceClassEntityUpdateComponent, {
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
        comp.fieldTestMapstructAndServiceClassEntity = entity;
        fieldTestMapstructAndServiceClassEntityServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(fieldTestMapstructAndServiceClassEntityServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.fieldTestMapstructAndServiceClassEntity = entity;
        fieldTestMapstructAndServiceClassEntityServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(fieldTestMapstructAndServiceClassEntityServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestMapstructAndServiceClassEntity = { id: 123 };
        fieldTestMapstructAndServiceClassEntityServiceStub.find.resolves(foundFieldTestMapstructAndServiceClassEntity);
        fieldTestMapstructAndServiceClassEntityServiceStub.retrieve.resolves([foundFieldTestMapstructAndServiceClassEntity]);

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
