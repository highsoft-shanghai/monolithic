import {i18n} from 'boot/i18n'
import {Text} from 'components/input/text/Text';

export class CredentialName extends Text {
  public get maxLength(): number {
    return 100;
  }

  public get rules(): ((value: string) => true | string)[] {
    return [val => !!val || i18n.translate('error.login-name-required')];
  }
}
