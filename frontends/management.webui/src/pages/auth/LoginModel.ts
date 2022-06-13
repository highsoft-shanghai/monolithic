import {CredentialName} from 'pages/auth/components/CredentialName';
import {Secret} from 'pages/auth/components/Secret';

export class LoginModel {
  private _name = new CredentialName();
  private _secret = new Secret();

  public get name(): CredentialName {
    return this._name;
  }

  public get secret(): Secret {
    return this._secret;
  }
}
