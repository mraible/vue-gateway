import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IEntityWithServiceImplAndPagination } from '@/shared/model/entity-with-service-impl-and-pagination.model';

import EntityWithServiceImplAndPaginationService from './entity-with-service-impl-and-pagination.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class EntityWithServiceImplAndPagination extends Vue {
  @Inject('entityWithServiceImplAndPaginationService')
  private entityWithServiceImplAndPaginationService: () => EntityWithServiceImplAndPaginationService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public entityWithServiceImplAndPaginations: IEntityWithServiceImplAndPagination[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllEntityWithServiceImplAndPaginations();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllEntityWithServiceImplAndPaginations();
  }

  public retrieveAllEntityWithServiceImplAndPaginations(): void {
    this.isFetching = true;
    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    this.entityWithServiceImplAndPaginationService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.entityWithServiceImplAndPaginations = res.data;
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

  public prepareRemove(instance: IEntityWithServiceImplAndPagination): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeEntityWithServiceImplAndPagination(): void {
    this.entityWithServiceImplAndPaginationService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterApp.entityWithServiceImplAndPagination.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllEntityWithServiceImplAndPaginations();
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
    this.retrieveAllEntityWithServiceImplAndPaginations();
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
