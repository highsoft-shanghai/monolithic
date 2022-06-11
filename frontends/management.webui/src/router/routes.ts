import {RouteRecordRaw} from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'route.home',
    meta: {icon: 'home'},
    redirect: '/workbench',
    component: () => import('layouts/main/MainLayout.vue'),
    children: [
      {
        path: '/workbench',
        name: 'route.workbench',
        meta: {icon: 'home'},
        redirect: '/workbench/home',
        component: () => import('layouts/blank/BlankLayout.vue'),
        children: [
          {path: '/workbench/home', name: 'route.workbench.home', component: () => import('pages/IndexPage.vue')},
          {path: '/workbench/others', name: 'route.workbench.others', component: () => import('pages/IndexPage.vue')},
        ]
      },
      {
        path: '/orders',
        name: 'route.orders',
        meta: {icon: 'list_alt'},
        redirect: '/orders/pending-orders',
        component: () => import('layouts/blank/BlankLayout.vue'),
        children: [
          {path: '/orders/pending-orders', name: 'route.orders.pending-orders', component: () => import('pages/IndexPage.vue')},
          {path: '/orders/orders', name: 'route.orders.orders', component: () => import('pages/IndexPage.vue')},
        ]
      },
      {
        path: '/persons',
        name: 'route.persons',
        meta: {icon: 'people'},
        redirect: '/persons/persons',
        component: () => import('layouts/blank/BlankLayout.vue'),
        children: [
          {path: '/persons/persons', name: 'route.persons.persons', component: () => import('pages/IndexPage.vue')},
          {path: '/persons/historic-persons', name: 'route.persons.historic-persons', component: () => import('pages/IndexPage.vue')},
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
