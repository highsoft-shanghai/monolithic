import {boot} from 'quasar/wrappers';
import {createI18n, I18n} from 'vue-i18n';

import messages from 'src/i18n';

export class i18n {
  private static _instance: I18n<unknown, unknown, unknown, false>;

  public static initialize(): void {
    i18n._instance = createI18n({
      legacy: false,
      globalInjection: true,
      locale: 'zh-CN',
      messages,
    });
  }

  public static translate(code: string): string {
    return i18n.instance.global.t(code);
  }

  public static get instance(): I18n<unknown, unknown, unknown, false> {
    return this._instance;
  }
}

export default boot(({app}) => {
  i18n.initialize();
  app.use(i18n.instance);
});
