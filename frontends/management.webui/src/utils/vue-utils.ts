import {reactive} from 'vue';

export function useModel<Model extends object>(model: Model): Model {
  return reactive(model) as Model;
}
