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
          {path: '/workbench/home', meta: {icon: 's_insert_chart_outlined'}, name: 'route.workbench.home', component: () => import('pages/IndexPage.vue')},
          {path: '/workbench/others', meta: {icon: 's_list_alt'}, name: 'route.workbench.others', component: () => import('pages/IndexPage.vue')},
        ]
      },
      {
        path: '/orders',
        name: 'route.orders',
        meta: {icon: 's_list_alt'},
        redirect: '/orders/pending-orders',
        component: () => import('layouts/blank/BlankLayout.vue'),
        children: [
          {path: '/orders/pending-orders', meta: {icon: 's_list_alt'}, name: 'route.orders.pending-orders', component: () => import('pages/IndexPage.vue')},
          {path: '/orders/orders', meta: {icon: 's_list_alt'}, name: 'route.orders.orders', component: () => import('pages/IndexPage.vue')},
        ]
      },
      {
        path: '/persons',
        name: 'route.persons',
        meta: {icon: 's_people_outline'},
        redirect: '/persons/persons',
        component: () => import('layouts/blank/BlankLayout.vue'),
        children: [
          {path: '/persons/persons', meta: {icon: 's_list_alt'}, name: 'route.persons.persons', component: () => import('pages/IndexPage.vue')},
          {path: '/persons/historic-persons', meta: {icon: 's_history'}, name: 'route.persons.historic-persons', component: () => import('pages/IndexPage.vue')},
        ]
      },
    ],
  },

  {
    path: '/auth',
    name: 'route.auth',
    redirect: '/auth/login',
    component: () => import('layouts/blank/BlankLayout.vue'),
    children: [
      {path: '/auth/login', name: 'route.auth.login', component: () => import('pages/auth/LoginPage.vue')},
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
