<template>
  <q-page class="relative-position q-pa-sm">
    <div class="page-title-bar non-selectable row">
      <q-input dense debounce="500" type="search" bg-color="white" model-value="text"
               class="search-input shadow-light-2 col-12 col-sm-5 col-md-4 col-lg-3 col-xl-2">
        <template #prepend>
          <q-btn flat stretch dense class="q-ma-none input-btn">
            <q-icon name="search" size="20px"/>
          </q-btn>
        </template>
        <template #append>
          <q-btn flat stretch dense class="q-ma-none input-btn">
            <q-icon name="o_filter_alt" size="20px"/>
          </q-btn>
        </template>
      </q-input>
      <q-space/>
      <q-btn dense stretch flat color="primary" label="添加" class="page-header-btn shadow-light-2 q-px-md text-no-wrap" :class="{'q-ml-sm': $q.screen.gt.xs, 'q-mt-sm': !$q.screen.gt.xs}"/>
      <q-btn dense stretch flat color="primary" label="编辑" class="page-header-btn shadow-light-2 q-px-md text-no-wrap" :class="{'q-ml-xs': true, 'q-mt-sm': !$q.screen.gt.xs}"/>
      <q-btn dense stretch flat color="red" label="删除" class="page-header-btn shadow-light-2 q-px-md text-no-wrap" :class="{'q-ml-xs': true, 'q-mt-sm': !$q.screen.gt.xs}"/>
    </div>
    <q-card class="shadow-light-2 q-pa-sm page-content" :class="{'double-page-content-top': !$q.screen.gt.xs}">
      <q-table dense virtual-scroll separator="horizontal" :virtual-scroll-sticky-size-start="48" :columns="columns" :rows="rows" row-key="id"
               class="fit data-table">
        <template v-slot:loading>
          <q-inner-loading showing color="primary"/>
        </template>
      </q-table>
    </q-card>
  </q-page>
</template>

<script lang="ts">
import {Meta} from 'components/models';
import {defineComponent, ref} from 'vue';
import {useRoute} from 'vue-router';

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
      {id: '11', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '12', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '13', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '14', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '15', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '16', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '17', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '18', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '19', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '20', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '21', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '22', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '23', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '24', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '25', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '26', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '27', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '28', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '29', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '30', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '31', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '32', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '33', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '34', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '35', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '36', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '37', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '38', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '39', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '40', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '51', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '52', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '53', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '54', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '55', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '56', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '57', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '58', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '59', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '60', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '61', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '62', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '63', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '64', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '65', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '66', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '67', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '68', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '69', name: '张三', class: '班级', score: '分数', remarks: ''},
      {id: '70', name: '张三', class: '班级', score: '分数', remarks: ''},
    ]);

    return {meta, text: ref(''), columns, rows, route: useRoute()};
  }
});
</script>
