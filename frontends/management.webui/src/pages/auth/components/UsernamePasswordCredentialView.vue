<template>
  <credential-name-input :model="model.name2" class="col-8"/>
  <q-input type="password" :model-value="model.secret" @update:model-value="model.changeSecret($event)" label="密码" class="col-8" :rules="[val => !!val || $t('error.password-required')]">
    <template #prepend>
      <q-icon name="s_lock_outline"/>
    </template>
  </q-input>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import {LoginModel} from 'pages/auth/LoginModel';
import CredentialNameInput from 'pages/auth/components/CredentialNameInput.vue';

export default defineComponent({
  name: 'UsernamePasswordCredentialView',
  components: {CredentialNameInput},
  props: {
    model: {
      type: LoginModel,
      required: true
    }
  }
});
</script>
`
