import {CredentialName} from 'pages/auth/components/CredentialName';
import {Secret} from 'pages/auth/components/Secret';

export class LoginModel {
  private _name2 = new CredentialName();
  private _secret2 = new Secret();
  private _name = '';
  private _secret = '';

  public changeName(name: string): void {
    this._name = name;
  }

  public changeSecret(secret: string): void {
    this._secret = secret;
  }

  public get name(): string {
    return this._name;
  }

  public get secret(): string {
    return this._secret;
  }

  public get name2(): CredentialName {
    return this._name2;
  }

  public get secret2(): Secret {
    return this._secret2;
  }
}
