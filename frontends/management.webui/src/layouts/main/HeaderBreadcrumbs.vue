<template>
  <q-toolbar-title class="text-body2">
    <q-breadcrumbs gutter="xs">
      <q-breadcrumbs-el icon="home" to="/"/>
      <q-breadcrumbs-el v-for="item in route.matched.slice(1, route.matched.length - 1)" :label="$t(item.name || '')" :to="item.path" :key="item.path"/>
      <q-breadcrumbs-el :label="$t(route.name || '')" class="text-weight-bold"/>
    </q-breadcrumbs>
  </q-toolbar-title>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {useRoute} from 'vue-router';

export default defineComponent({
  name: 'HeaderBreadcrumbs',

  setup() {
    return {route: useRoute()}
  }
});
</script>
