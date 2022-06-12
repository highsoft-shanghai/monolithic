<template>
  <div class="fullscreen row non-selectable">
    <div class="col gt-sm bg-blue-8">
      <q-img src=""/>
    </div>
    <div class="col row items-center flex-center">
      <div class="row items-center">
        <app-logo size="40px"/>
        <h4 class="q-pl-sm">{{ $t('app.title') }}</h4>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import AppLogo from 'components/AppLogo.vue';

export default defineComponent({
  name: 'LoginPage',
  components: {AppLogo}
});
</script>
