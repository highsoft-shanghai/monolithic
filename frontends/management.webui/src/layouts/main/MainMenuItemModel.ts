import {RouteRecordRaw} from 'vue-router';
import {asString} from 'src/utils/string';

export class MainMenuItemModel {
  public readonly path: string = '';
  public readonly name: string = '';
  public readonly children: MainMenuItemModel[] = [];
  public readonly icon: string = '';
  public readonly requiredAuthorities: string[] = [];
  public readonly level: number = 0;
  public readonly group: string = '';

  public constructor(route: RouteRecordRaw, level: number) {
    if (!route) return;
    this.path = route.path;
    this.name = asString(route.name);
    this.icon = asString(route.meta?.['icon']);
    this.requiredAuthorities = route.meta?.['requiredAuthorities'] as string[] || [];
    this.children = route.children?.map(x => new MainMenuItemModel(x, level + 1)) || [];
    this.level = level;
    this.group = level.toString();
  }

  public get isLeaf(): boolean {
    return !this.children.length;
  }
}
