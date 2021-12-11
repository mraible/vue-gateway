import { Authority } from '@/shared/security/authority';

const UserManagementComponent = () => import('@/admin/user-management/user-management.vue');
const UserManagementViewComponent = () => import('@/admin/user-management/user-management-view.vue');
const UserManagementEditComponent = () => import('@/admin/user-management/user-management-edit.vue');
const DocsComponent = () => import('@/admin/docs/docs.vue');
const ConfigurationComponent = () => import('@/admin/configuration/configuration.vue');
const HealthComponent = () => import('@/admin/health/health.vue');
const LogsComponent = () => import('@/admin/logs/logs.vue');
const MetricsComponent = () => import('@/admin/metrics/metrics.vue');

export default [
  {
    path: '/admin/user-management',
    name: 'User',
    component: UserManagementComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
  {
    path: '/admin/user-management/new',
    name: 'UserCreate',
    component: UserManagementEditComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
  {
    path: '/admin/user-management/:userId/edit',
    name: 'UserEdit',
    component: UserManagementEditComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
  {
    path: '/admin/user-management/:userId/view',
    name: 'UserView',
    component: UserManagementViewComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
  {
    path: '/admin/docs',
    name: 'DocsComponent',
    component: DocsComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
  {
    path: '/admin/health',
    name: 'HealthComponent',
    component: HealthComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
  {
    path: '/admin/logs',
    name: 'LogsComponent',
    component: LogsComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
  {
    path: '/admin/metrics',
    name: 'MetricsComponent',
    component: MetricsComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
  {
    path: '/admin/configuration',
    name: 'ConfigurationComponent',
    component: ConfigurationComponent,
    meta: { authorities: [Authority.ADMIN] },
  },
];
