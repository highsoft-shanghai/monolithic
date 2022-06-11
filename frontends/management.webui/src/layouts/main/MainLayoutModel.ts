import {MainMenuItemModel} from 'layouts/main/MainMenuItemModel';
import routes from 'src/router/routes';

export class MainLayoutModel {
  private _menuVisible = true;
  private _menuMinimized = false;
  private _menuItems: MainMenuItemModel[] = routes[0].children?.map(x => new MainMenuItemModel(x, 0)) || [];

  public toggleMenu(): void {
    this._menuVisible = !this._menuVisible;
  }

  public toggleMenuMini(): void {
    this._menuMinimized = !this._menuMinimized;
  }

  public get menuVisible(): boolean {
    return this._menuVisible;
  }

  public get menuMinimized(): boolean {
    return this._menuMinimized;
  }

  public get menuItems(): MainMenuItemModel[] {
    return this._menuItems;
  }
}
