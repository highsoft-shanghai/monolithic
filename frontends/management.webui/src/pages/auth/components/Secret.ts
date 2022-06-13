import {TextInputModel} from 'components/input/text/TextInputModel';
import {i18n} from 'boot/i18n'

export class Secret implements TextInputModel {
  private _value = '';

  public changeValue(value: string): void {
    this._value = value;
  }

  public get value(): string {
    return this._value;
  }

  public get maxLength(): number {
    return 50;
  }

  public get rules(): ((value: string) => true | string)[] {
    return [val => !!val || i18n.translate('error.password-required')];
  }
}
