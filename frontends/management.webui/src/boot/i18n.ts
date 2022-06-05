import {boot} from 'quasar/wrappers';
import {createI18n} from 'vue-i18n';

import messages from 'src/i18n';

export default boot(({app}) => {
  app.use(createI18n({
    legacy: false,
    globalInjection: true,
    locale: 'en-US',
    messages,
  }));
});
