import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ILabel } from '@/shared/model/test-root/label.model';

import LabelService from './label.service';
import AlertService from '@/shared/alert/alert.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Label extends Vue {
  @Inject('labelService') private labelService: () => LabelService;
  @Inject('alertService') private alertService: () => AlertService;

  private removeId: number = null;
  public itemsPerPage = 20;
  public queryCount: number = null;
  public page = 1;
  public previousPage = 1;
  public propOrder = 'id';
  public reverse = false;
  public totalItems = 0;

  public labels: ILabel[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllLabels();
  }

  public clear(): void {
    this.page = 1;
    this.retrieveAllLabels();
  }

  public retrieveAllLabels(): void {
    this.isFetching = true;
    const paginationQuery = {
      page: this.page - 1,
      size: this.itemsPerPage,
      sort: this.sort(),
    };
    this.labelService()
      .retrieve(paginationQuery)
      .then(
        res => {
          this.labels = res.data;
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
    this.retrieveAllLabels();
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
