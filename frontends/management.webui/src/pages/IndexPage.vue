<template>
  <q-page class="row items-center justify-evenly">
    <example-component title="Example component" active :todos="todos" :meta="meta"/>
  </q-page>
</template>

<script lang="ts">
import {Meta, Todo} from 'components/models';
import ExampleComponent from 'components/ExampleComponent.vue';
import {defineComponent, ref} from 'vue';

export default defineComponent({
  name: 'IndexPage',
  components: {ExampleComponent},
  setup() {
    const todos = ref<Todo[]>([
      {
        id: 1,
        content: 'ct1'
      },
      {
        id: 2,
        content: 'ct2'
      },
      {
        id: 3,
        content: 'ct3'
      },
      {
        id: 4,
        content: 'ct4'
      },
      {
        id: 5,
        content: 'ct5'
      },
      {
        id: 6,
        content: 'ct6'
      },
      {
        id: 7,
        content: 'ct7'
      },
      {
        id: 8,
        content: 'ct8'
      },
      {
        id: 9,
        content: 'ct9'
      },
      {
        id: 10,
        content: 'ct10'
      },
      {
        id: 11,
        content: 'ct1'
      },
      {
        id: 12,
        content: 'ct2'
      },
      {
        id: 13,
        content: 'ct3'
      },
      {
        id: 14,
        content: 'ct4'
      },
      {
        id: 15,
        content: 'ct5'
      },
      {
        id: 16,
        content: 'ct6'
      },
      {
        id: 17,
        content: 'ct7'
      },
      {
        id: 18,
        content: 'ct8'
      },
      {
        id: 19,
        content: 'ct9'
      },
      {
        id: 20,
        content: 'ct10'
      },
      {
        id: 21,
        content: 'ct1'
      },
      {
        id: 22,
        content: 'ct2'
      },
      {
        id: 23,
        content: 'ct3'
      },
      {
        id: 24,
        content: 'ct4'
      },
      {
        id: 25,
        content: 'ct5'
      },
      {
        id: 26,
        content: 'ct6'
      },
      {
        id: 27,
        content: 'ct7'
      },
      {
        id: 28,
        content: 'ct8'
      },
      {
        id: 29,
        content: 'ct9'
      },
      {
        id: 30,
        content: 'ct10'
      },
      {
        id: 31,
        content: 'ct1'
      },
      {
        id: 32,
        content: 'ct2'
      },
      {
        id: 33,
        content: 'ct3'
      },
      {
        id: 34,
        content: 'ct4'
      },
      {
        id: 35,
        content: 'ct5'
      },
      {
        id: 36,
        content: 'ct6'
      },
      {
        id: 37,
        content: 'ct7'
      },
      {
        id: 38,
        content: 'ct8'
      },
      {
        id: 39,
        content: 'ct9'
      },
      {
        id: 40,
        content: 'ct10'
      },
      {
        id: 41,
        content: 'ct1'
      },
      {
        id: 42,
        content: 'ct2'
      },
      {
        id: 43,
        content: 'ct3'
      },
      {
        id: 44,
        content: 'ct4'
      },
      {
        id: 45,
        content: 'ct5'
      },
      {
        id: 46,
        content: 'ct6'
      },
      {
        id: 47,
        content: 'ct7'
      },
      {
        id: 48,
        content: 'ct8'
      },
      {
        id: 49,
        content: 'ct9'
      },
    ]);
    const meta = ref<Meta>({
      totalCount: 1200
    });
    return {todos, meta};
  }
});
</script>
