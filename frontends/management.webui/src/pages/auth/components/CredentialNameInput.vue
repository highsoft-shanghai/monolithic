<template>
  <q-input :model-value="model.value" @update:model-value="model.changeValue($event)" maxlength="100" label="手机号/邮箱/用户名" :rules="model.rules">
    <template #prepend>
      <q-icon name="s_perm_identity"/>
    </template>
  </q-input>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {CredentialName} from 'pages/auth/components/CredentialName';

export default defineComponent({
  name: 'CredentialNameInput',
  components: {},
  props: {
    model: {
      type: CredentialName,
      required: true
    }
  }
});
</script>
`
