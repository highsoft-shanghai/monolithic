<template>
  <div class="fullscreen bg-blue text-white text-center q-pa-md flex flex-center non-selectable">
    <div>
      <div style="font-size: 30vh">404</div>
      <div class="text-h2" style="opacity:.4">您访问的页面不存在</div>
      <q-btn class="q-mt-xl" color="white" text-color="blue" unelevated to="/" :label="$t('message.back-home')" no-caps/>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';

export default defineComponent({
  name: 'ErrorNotFound'
});
</script>
