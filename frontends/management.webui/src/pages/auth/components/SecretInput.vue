<template>
  <q-input :model-value="model.value" @update:model-value="model.changeValue($event)" type="password" :maxlength="model.maxLength" label="密码" :rules="model.rules">
    <template #prepend>
      <q-icon name="s_lock_outline"/>
    </template>
  </q-input>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {Secret} from 'pages/auth/components/Secret';

export default defineComponent({
  name: 'SecretInput',
  components: {},
  props: {
    model: {
      type: Secret,
      required: true
    }
  }
});
</script>
`
