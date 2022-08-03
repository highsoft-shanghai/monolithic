<template>
  <q-icon name="troubleshoot" :size="size"/>
</template>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: 'AppLogo',
  props: {
    size: {
      type: [String, Number],
      default: '24px'
    }
  }
});
</script>
