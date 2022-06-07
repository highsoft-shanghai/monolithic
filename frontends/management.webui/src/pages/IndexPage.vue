<template>
  <q-page class="column q-pa-sm">
    <q-toolbar class="bg-white page-title-bar q-pa-none shadow-light-2 non-selectable">
      <q-btn flat stretch padding="0">
        <q-icon name="arrow_back" size="16px" class="q-ma-sm q-pa-xs text-grey-8"/>
      </q-btn>
      <q-separator vertical inset/>
      <q-toolbar-title class="text-body1 text-weight-bold">待处理订单</q-toolbar-title>
      <q-input dense v-model="text" placeholder="搜索" class="text-body2 search-input q-mr-sm" input-class="q-pa-none">
        <template #prepend>
          <q-btn flat dense class="q-ma-none">
            <q-icon name="search" size="20px"/>
          </q-btn>
        </template>
        <template #append>
          <q-btn flat dense class="q-ma-none">
            <q-icon name="o_filter_alt" size="20px"/>
          </q-btn>
        </template>
      </q-input>
    </q-toolbar>
    <q-card class="shadow-light-2 q-pa-md q-mt-sm page-content">
      <q-table dense separator="horizontal" :columns="columns" :rows="rows" row-key="id" class="fit"/>
    </q-card>
  </q-page>
</template>

<script lang="ts">
import {Meta} from 'components/models';
import {defineComponent, ref} from 'vue';

export default defineComponent({
  name: 'IndexPage',
  components: {},
  setup() {
    const meta = ref<Meta>({totalCount: 1200});
    const columns = ref([
      {name: 'id', label: '标识', field: 'id', align: 'left'},
      {name: 'name', label: '姓名', field: 'name', align: 'left'},
      {name: 'class', label: '班级', field: 'class', align: 'left'},
      {name: 'score', label: '分数', field: 'score', align: 'left'},
      {name: 'remarks', label: '备注', field: 'remarks', align: 'left'},
    ]);
    const rows = ref([
      {id: '1', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '2', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '3', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '4', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '5', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '6', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '7', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '8', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '9', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '10', name: '张三', class: '班级', score: '分数', remarks: ''},
    ]);

    return {meta, text: ref(''), columns, rows};
  }
});
</script>
