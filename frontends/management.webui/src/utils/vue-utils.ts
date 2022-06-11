import {ref, Ref} from 'vue';

export function useModel<Model extends object>(model: Model): Ref<Model> {
  return ref(model) as Ref<Model>;
}
