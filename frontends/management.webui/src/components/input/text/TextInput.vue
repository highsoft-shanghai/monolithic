<template>
  <q-input :model-value="model.value" @update:model-value="model.changeValue($event)" :type="type" :maxlength="model.maxLength" :label="label" :rules="model.rules">
    <template v-if="!!icon" #prepend>
      <q-icon :name="icon"/>
    </template>
  </q-input>
</template>

<script lang="ts">
import {defineComponent, PropType} from 'vue';
import {TextModel} from 'components/input/text/TextInputModel';

export default defineComponent({
  name: 'TextInput',
  components: {},
  props: {
    model: {
      type: Object as PropType<TextModel>,
      required: true
    },
    label: {
      type: String,
      required: false
    },
    type: {
      type: String,
      default: 'text'
    },
    icon: {
      type: String,
      required: false
    }
  }
});
</script>
