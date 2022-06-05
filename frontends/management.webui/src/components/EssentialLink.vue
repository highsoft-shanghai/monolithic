<template>
  <q-expansion-item :icon="icon" :label="title" group="level-1">
    <div>test</div>
  </q-expansion-item>
</template>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: 'EssentialLink',
  props: {
    title: {
      type: String,
      required: true
    },

    caption: {
      type: String,
      default: ''
    },

    link: {
      type: String,
      default: '#'
    },

    icon: {
      type: String,
      default: ''
    }
  }
});
</script>
