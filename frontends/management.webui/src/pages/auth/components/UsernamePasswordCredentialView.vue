<template>
  <credential-name-input :model="model.name" class="col-8"/>
  <secret-input :model="model.secret" class="col-8"/>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {LoginModel} from 'pages/auth/LoginModel';
import CredentialNameInput from 'pages/auth/components/credential-name-input/CredentialNameInput.vue';
import SecretInput from 'pages/auth/components/secret-input/SecretInput.vue';

export default defineComponent({
  name: 'UsernamePasswordCredentialView',
  components: {SecretInput, CredentialNameInput},
  props: {
    model: {
      type: LoginModel,
      required: true
    }
  }
});
</script>
