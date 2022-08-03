<template>
  <text-input :label="$t('label.credential.username-and-password')" icon="s_perm_identity" :model="model"/>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {CredentialName} from 'pages/auth/components/credential-name-input/CredentialName';
import TextInput from 'components/input/text/TextInput.vue';

export default defineComponent({
  name: 'CredentialNameInput',
  components: {TextInput},
  props: {
    model: {
      type: CredentialName,
      required: true
    }
  }
});
</script>
