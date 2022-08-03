<template>
  <div class="fullscreen row non-selectable">
    <div class="col gt-sm bg-blue-8">
      <q-img src=""/>
    </div>
    <div class="col column items-stretch">
      <div class="col-2"/>
      <div class="row items-center justify-center">
        <app-logo size="40px"/>
        <h4 class="q-pl-sm">{{ $t('app.title') }}</h4>
      </div>
      <div class="col row content-start justify-center q-gutter-sm">
        <username-password-credential-view :model="model"/>
        <q-checkbox size="xs" :model-value="false" :label="tc" class="col-8 q-pa-none text-primary"/>
        <q-btn color="primary" label="登录" class="col-8"/>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue';
import AppLogo from 'components/AppLogo.vue';
import UsernamePasswordCredentialView from 'pages/auth/components/UsernamePasswordCredentialView.vue';
import {useModel} from 'src/utils/vue-utils';
import {LoginModel} from 'pages/auth/LoginModel';
import {useI18n} from 'vue-i18n';

export default defineComponent({
  name: 'LoginPage',
  components: {UsernamePasswordCredentialView, AppLogo},
  setup() {
    const i18n = useI18n();
    return {model: useModel(new LoginModel()), tc: i18n.t('label.login.tc', [i18n.t('app.title')])};
  }
});
</script>
