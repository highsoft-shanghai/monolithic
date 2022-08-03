<template>
  <q-item v-if="model.isLeaf" clickable :to="model.path" :inset-level="model.insetLevel(mini)">
    <q-item-section avatar>
      <q-icon :name="model.icon"/>
    </q-item-section>
    <q-item-section>{{ $t(model.name) }}</q-item-section>
  </q-item>
  <q-expansion-item
    v-else :icon="model.icon" :label="$t(model.name)" :group="model.group" :to="model.path" :duration="100"
    :content-inset-level="model.insetLevel(mini)" :header-inset-level="model.insetLevel(mini)"
    active-class="q-router-link--active text-weight-bold" @click="model.expand()" :model-value="model.expanded" @show="model.expand()" @hide="model.collapse()"
  >
    <main-menu-item v-for="(child, index) in model.children" :model="child" :mini="mini" :key="child.path + '|' + index"/>
  </q-expansion-item>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {MainMenuItemModel} from 'layouts/main/MainMenuItemModel';

export default defineComponent({
  name: 'MainMenuItem',
  props: {
    model: {
      type: MainMenuItemModel,
      required: true
    },
    mini: {
      type: Boolean,
      required: true
    }
  }
});
</script>
