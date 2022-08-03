<template>
  <text-input :label="$t('label.credential.secret')" icon="s_lock_outline" type="password" :model="model"/>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {Secret} from 'pages/auth/components/secret-input/Secret';
import TextInput from 'components/input/text/TextInput.vue';

export default defineComponent({
  name: 'SecretInput',
  components: {TextInput},
  props: {
    model: {
      type: Secret,
      required: true
    }
  }
});
</script>
