<template>
  <q-drawer :model-value="model.menuVisible" side="left" show-if-above class="shadow-1" :mini="model.menuMinimized" :mini-width="48" @hide="model.hide()">
    <q-list padding class="non-selectable">
      <main-menu-item v-for="(item, index) in model.menuItems" :key="item.path + '|' + index" :model="item" :mini="model.menuMinimized"/>
    </q-list>
    <q-btn
      v-if="$q.screen.gt.sm"
      round outline size="6px" color="secondary" :icon="model.menuMinimized ? 'chevron_right' : 'chevron_left'" @click="model.toggleMenuMini()"
      class="mini-toggle-button"
    />
  </q-drawer>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {MainLayoutModel} from 'layouts/main/MainLayoutModel';
import MainMenuItem from 'layouts/main/MainMenuItem.vue';

export default defineComponent({
  name: 'MainMenu',
  components: {MainMenuItem},
  props: {
    model: {type: MainLayoutModel, required: true}
  },
});
</script>

<style lang="scss" scoped>
.mini-toggle-button {
  position: absolute;
  bottom: 15px;
  right: 15px;
}
</style>
