/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';
import { ToastPlugin } from 'bootstrap-vue';

import dayjs from 'dayjs';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import * as config from '@/shared/config/config';
import FieldTestPaginationEntityUpdateComponent from '@/entities/field-test-pagination-entity/field-test-pagination-entity-update.vue';
import FieldTestPaginationEntityClass from '@/entities/field-test-pagination-entity/field-test-pagination-entity-update.component';
import FieldTestPaginationEntityService from '@/entities/field-test-pagination-entity/field-test-pagination-entity.service';

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
  describe('FieldTestPaginationEntity Management Update Component', () => {
    let wrapper: Wrapper<FieldTestPaginationEntityClass>;
    let comp: FieldTestPaginationEntityClass;
    let fieldTestPaginationEntityServiceStub: SinonStubbedInstance<FieldTestPaginationEntityService>;

    beforeEach(() => {
      fieldTestPaginationEntityServiceStub = sinon.createStubInstance<FieldTestPaginationEntityService>(FieldTestPaginationEntityService);

      wrapper = shallowMount<FieldTestPaginationEntityClass>(FieldTestPaginationEntityUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          fieldTestPaginationEntityService: () => fieldTestPaginationEntityServiceStub,
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
        comp.fieldTestPaginationEntity = entity;
        fieldTestPaginationEntityServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(fieldTestPaginationEntityServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.fieldTestPaginationEntity = entity;
        fieldTestPaginationEntityServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(fieldTestPaginationEntityServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFieldTestPaginationEntity = { id: 123 };
        fieldTestPaginationEntityServiceStub.find.resolves(foundFieldTestPaginationEntity);
        fieldTestPaginationEntityServiceStub.retrieve.resolves([foundFieldTestPaginationEntity]);

        // WHEN
        comp.beforeRouteEnter({ params: { fieldTestPaginationEntityId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.fieldTestPaginationEntity).toBe(foundFieldTestPaginationEntity);
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
