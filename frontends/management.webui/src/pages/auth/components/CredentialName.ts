import {TextInputModel} from 'pages/auth/components/TextInputModel';
import {i18n} from 'boot/i18n'

export class CredentialName implements TextInputModel {
  private _value = '';

  public changeValue(value: string): void {
    this._value = value;
  }

  public get value(): string {
    return this._value;
  }

  public get maxLength(): number {
    return 100;
  }

  public get rules(): ((value: string) => true | string)[] {
    return [val => !!val || i18n.translate('error.login-name-required')];
  }
}
