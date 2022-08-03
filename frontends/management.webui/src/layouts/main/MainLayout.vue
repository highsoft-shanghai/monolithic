<template>
  <q-layout view="hHh LpR fFf">
    <main-header :model="model"/>
    <main-menu :model="model"/>
    <q-page-container class="bg-grey-2 fit">
      <router-view/>
    </q-page-container>
  </q-layout>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import MainHeader from 'layouts/main/MainHeader.vue';
import {MainLayoutModel} from 'layouts/main/MainLayoutModel';
import {useModel} from 'src/utils/vue-utils';
import MainMenu from 'layouts/main/MainMenu.vue';

export default defineComponent({
  name: 'MainLayout',

  components: {
    MainMenu,
    MainHeader,
  },

  setup() {
    return {
      model: useModel(new MainLayoutModel()),
    }
  }
});
</script>
