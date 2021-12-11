/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import { ToastPlugin } from 'bootstrap-vue';

import * as config from '@/shared/config/config';
import MapsIdUserProfileWithDTOComponent from '@/entities/maps-id-user-profile-with-dto/maps-id-user-profile-with-dto.vue';
import MapsIdUserProfileWithDTOClass from '@/entities/maps-id-user-profile-with-dto/maps-id-user-profile-with-dto.component';
import MapsIdUserProfileWithDTOService from '@/entities/maps-id-user-profile-with-dto/maps-id-user-profile-with-dto.service';
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
  describe('MapsIdUserProfileWithDTO Management Component', () => {
    let wrapper: Wrapper<MapsIdUserProfileWithDTOClass>;
    let comp: MapsIdUserProfileWithDTOClass;
    let mapsIdUserProfileWithDTOServiceStub: SinonStubbedInstance<MapsIdUserProfileWithDTOService>;

    beforeEach(() => {
      mapsIdUserProfileWithDTOServiceStub = sinon.createStubInstance<MapsIdUserProfileWithDTOService>(MapsIdUserProfileWithDTOService);
      mapsIdUserProfileWithDTOServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<MapsIdUserProfileWithDTOClass>(MapsIdUserProfileWithDTOComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          mapsIdUserProfileWithDTOService: () => mapsIdUserProfileWithDTOServiceStub,
          alertService: () => new AlertService(),
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      mapsIdUserProfileWithDTOServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllMapsIdUserProfileWithDTOs();
      await comp.$nextTick();

      // THEN
      expect(mapsIdUserProfileWithDTOServiceStub.retrieve.called).toBeTruthy();
      expect(comp.mapsIdUserProfileWithDTOS[0]).toEqual(expect.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      mapsIdUserProfileWithDTOServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      expect(mapsIdUserProfileWithDTOServiceStub.retrieve.callCount).toEqual(1);

      comp.removeMapsIdUserProfileWithDTO();
      await comp.$nextTick();

      // THEN
      expect(mapsIdUserProfileWithDTOServiceStub.delete.called).toBeTruthy();
      expect(mapsIdUserProfileWithDTOServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
