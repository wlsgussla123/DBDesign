<template>
  <section>
    <my-header></my-header>

    <md-table v-model="projectList" md-card>
      <md-table-toolbar>
        <h1 :id="$style.title" class="md-title">프로젝트를 선택해주세요.</h1>
      </md-table-toolbar>

      <md-table-row :id="$style.tableRow" slot="md-table-row" slot-scope="{ item }" @click.native="toggle()">
          <md-table-cell md-label="번호" md-numeric>{{ item.prjId }}</md-table-cell>
          <md-table-cell md-label="이름">{{ item.prjName }}</md-table-cell>
          <md-table-cell md-label="시작일">{{ item.prjStartDate }}</md-table-cell>
          <md-table-cell md-label="종료일">{{ item.prjEndDate }}</md-table-cell>
          <md-table-cell md-label="고객사">{{ item.customer.cusName }}</md-table-cell>
          <md-table-cell md-label="고객사 이메일">{{ item.customer.cusEmail }}</md-table-cell>
      </md-table-row>
    </md-table>
  </section>
</template>

<script>
const Header = () => import('../components/Header');

export default {
  name: 'Evaluation',
  components: {
    myHeader: Header,
  },
  data() {
    return {
      projectList: [],
    };
  },

  methods: {
    toggle() {
      console.log('toggle');
    },
  },

  mounted() {
    this.axios.get('http://localhost:8000/app/project')
    .then((res) => {
      console.log(res);
      this.projectList = res.data;
    });
  },
};
</script>

<style lang="scss" module>
#title {
  font-weight: bold;
}

:global(.md-table-row) {
  cursor: pointer;
}

// th 정렬
:global(.md-table-head-container) {
  text-align: center;
}

// td 정렬
:global(.md-table-cell-container) {
  text-align: center;
}
</style>