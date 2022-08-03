import {CredentialName} from 'pages/auth/components/credential-name-input/CredentialName';
import {Secret} from 'pages/auth/components/secret-input/Secret';

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
