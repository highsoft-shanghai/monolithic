import {TextModel} from 'components/input/text/TextModel';

export class Text implements TextModel {
  private _value = '';

  public changeValue(value: string): void {
    this._value = value;
  }

  public get value(): string {
    return this._value;
  }

  public get maxLength(): number | undefined {
    return undefined;
  }

  public get rules(): ((value: string) => true | string)[] {
    return [];
  }
}
