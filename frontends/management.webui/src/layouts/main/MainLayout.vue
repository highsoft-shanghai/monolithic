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

const linksList = [
  {
    title: 'Docs',
    caption: 'quasar.dev',
    icon: 'school',
    link: 'https://quasar.dev'
  },
  {
    title: 'Github',
    caption: 'github.com/quasarframework',
    icon: 'code',
    link: 'https://github.com/quasarframework'
  },
  {
    title: 'Discord Chat Channel',
    caption: 'chat.quasar.dev',
    icon: 'chat',
    link: 'https://chat.quasar.dev'
  },
  {
    title: 'Forum',
    caption: 'forum.quasar.dev',
    icon: 'record_voice_over',
    link: 'https://forum.quasar.dev'
  },
  {
    title: 'Twitter',
    caption: '@quasarframework',
    icon: 'rss_feed',
    link: 'https://twitter.quasar.dev'
  },
  {
    title: 'Facebook',
    caption: '@QuasarFramework',
    icon: 'public',
    link: 'https://facebook.quasar.dev'
  },
  {
    title: 'Quasar Awesome',
    caption: 'Community Quasar projects',
    icon: 'favorite',
    link: 'https://awesome.quasar.dev'
  }
];

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
