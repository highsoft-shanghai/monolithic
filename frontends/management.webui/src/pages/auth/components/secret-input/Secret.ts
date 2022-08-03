import {i18n} from 'boot/i18n'
import {Text} from 'components/input/text/Text';

export class Secret extends Text {
  public get maxLength(): number {
    return 50;
  }

  public get rules(): ((value: string) => true | string)[] {
    return [val => !!val || i18n.translate('error.password-required')];
  }
}
