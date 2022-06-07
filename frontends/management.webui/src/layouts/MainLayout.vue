<template>
  <q-layout view="hHh LpR fFf">
    <q-header class="non-selectable shadow-center-2">
      <q-toolbar class="q-pa-none q-pr-sm">
        <q-btn stretch flat class="q-px-none" @click="toggleLeftDrawer">
          <q-icon name="menu" size="16px" class="q-px-md q-mx-xs"/>
        </q-btn>
        <q-separator dark vertical inset/>
        <q-icon name="troubleshoot" size="24px" class="q-ml-md"/>
        <q-toolbar-title>{{ $t('app.title') }}</q-toolbar-title>
        <div>Quasar v{{ $q.version }}</div>
      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" side="left" show-if-above class="shadow-1" :mini="miniMode" :mini-width="56">
      <q-list padding class="non-selectable">
        <EssentialLink v-for="link in essentialLinks" :key="link.title" v-bind="link"/>
      </q-list>
      <q-btn round outline color="secondary" size="xs" :icon="miniMode ? 'chevron_right' : 'chevron_left'" @click="toggleMiniMode" class="mini-toggle-button"/>
    </q-drawer>

    <q-page-container class="bg-grey-2 fit">
      <router-view/>
    </q-page-container>
  </q-layout>
</template>

<script lang="ts">
import {defineComponent, ref} from 'vue';
import EssentialLink from 'components/EssentialLink.vue';

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
    EssentialLink
  },

  setup() {
    const leftDrawerOpen = ref(false);
    const miniMode = ref(false);

    return {
      essentialLinks: linksList,
      leftDrawerOpen,
      miniMode,
      toggleLeftDrawer: () => {
        leftDrawerOpen.value = !leftDrawerOpen.value;
      },
      toggleMiniMode: () => {
        miniMode.value = !miniMode.value;
      },
      goHome: () => {
        console.log('go home');
      }
    }
  }
});
</script>

<style lang="scss" scoped>
.mini-toggle-button {
  position: absolute;
  bottom: map-get($space-md, 'y');
  right: map-get($space-md, 'x');
}
</style>
