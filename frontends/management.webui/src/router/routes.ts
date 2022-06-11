import {RouteRecordRaw} from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'route.home',
    meta: {icon: 'home'},
    redirect: '/workbench',
    component: () => import('layouts/main/MainLayout.vue'),
    children: [
      {path: '/workbench', name: 'route.workbench', meta: {icon: 'home'}, component: () => import('pages/IndexPage.vue')},
      {
        path: '/orders',
        name: 'route.order-management',
        meta: {icon: 'list_alt'},
        redirect: '/pending-orders',
        component: () => import('layouts/blank/BlankLayout.vue'),
        children: [
          {path: '/pending-orders', name: 'route.pending-orders', component: () => import('pages/IndexPage.vue')}
        ]
      },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
