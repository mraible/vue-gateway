import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IEntityWithServiceImplPaginationAndDTO } from '@/shared/model/entity-with-service-impl-pagination-and-dto.model';

import EntityWithServiceImplPaginationAndDTOService from './entity-with-service-impl-pagination-and-dto.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class EntityWithServiceImplPaginationAndDTO extends Vue {
  @Inject('entityWithServiceImplPaginationAndDTOService')
  private entityWithServiceImplPaginationAndDTOService: () => EntityWithServiceImplPaginationAndDTOService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public entityWithServiceImplPaginationAndDTOS: IEntityWithServiceImplPaginationAndDTO[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllEntityWithServiceImplPaginationAndDTOs();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllEntityWithServiceImplPaginationAndDTOs();
  }

  public retrieveAllEntityWithServiceImplPaginationAndDTOs(): void {
    this.isFetching = true;
    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    this.entityWithServiceImplPaginationAndDTOService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.entityWithServiceImplPaginationAndDTOS = res.data;
          this.totalItems = Number(res.headers['x-total-count']);
          this.queryCount = this.totalItems;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
          this.alertService().showHttpError(this, err.response);
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IEntityWithServiceImplPaginationAndDTO): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeEntityWithServiceImplPaginationAndDTO(): void {
    this.entityWithServiceImplPaginationAndDTOService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.entityWithServiceImplPaginationAndDTO.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllEntityWithServiceImplPaginationAndDTOs();
        this.closeDialog();
      })
      .catch(error => {
        this.alertService().showHttpError(this, error.response);
      });
  }

  public sort(): Array<any> {
    const result = [this.propOrder + ',' + (this.reverse ? 'desc' : 'asc')];
    if (this.propOrder !== 'id') {
      result.push('id');
    }
    return result;
  }

  public loadPage(page: number): void {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
    }
  }

  public transition(): void {
    this.retrieveAllEntityWithServiceImplPaginationAndDTOs();
  }

  public changeOrder(propOrder): void {
    this.propOrder = propOrder;
    this.reverse = !this.reverse;
    this.transition();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
