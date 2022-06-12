<template>
  <q-header class="non-selectable shadow-center-2">
    <q-toolbar class="q-pa-none q-pr-sm">
      <q-btn stretch flat class="q-px-none" @click="model.toggleMenu()">
        <q-icon name="menu" size="16px" class="q-px-md"/>
      </q-btn>
      <q-separator dark vertical inset/>
      <app-logo class="q-ml-md"/>
      <q-toolbar-title shrink v-if="$q.screen.gt.sm">{{ $t('app.title') }}</q-toolbar-title>
      <header-breadcrumbs/>
      <div>Quasar v{{ $q.version }}</div>
    </q-toolbar>
  </q-header>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import HeaderBreadcrumbs from 'layouts/main/HeaderBreadcrumbs.vue';
import {MainLayoutModel} from 'layouts/main/MainLayoutModel';
import AppLogo from 'components/AppLogo.vue';

export default defineComponent({
  name: 'LayoutHeader',
  components: {AppLogo, HeaderBreadcrumbs},
  props: {
    model: {type: MainLayoutModel, required: true}
  },
});
</script>
