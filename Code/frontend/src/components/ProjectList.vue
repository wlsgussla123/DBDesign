<template>
  <section>
    <my-header></my-header>
    <main>
        <div>
            <vue-good-table
            title="Project List Table"
            :columns="columns"
            :rows="rows"
            :paginate="true"
            :lineNumbers="true"/>
        </div>

    </main>
    <footer></footer>
  </section>
</template>

<script>
import Header from './Header';

export default {
  name: 'ProjectList',
  components: {
    myHeader: Header,
  },

  methods: {
    getProjectList() {
      console.log('함수호출');
      this.axios.get('http://localhost:8080/app/project/', {})
      .then((res) => {
        if (res.data) {
          console.log(res);
          res.data.forEach((data) => {
            console.log(data);
            this.rows.push(data);
          });
          console.log('확인');
        } else {
          console.log('null');
          this.alert = true;
        }
      });
    },
  },

  created() {
    console.log('바로생성');
    this.getProjectList();
  },

  data() {
    return {
      columns: [
        {
          label: 'Project Name',
          field: 'prjName',
          filterable: true,
        },
        {
          label: '시작기간',
          field: 'prjStartDate',
          type: 'date',
          html: false,
          filterable: true,
          inputFormat: 'YYYY-MM-DD',
          outputFormat: 'YYYY-MM-DD',
        },
        {
          label: '종료기간',
          field: 'prjEndDate',
          type: 'date',
          html: false,
          filterable: true,
          inputFormat: 'YYYY-MM-DD',
          outputFormat: 'YYYY-MM-DD',
        },
        {
          label: '발주처',
          field: 'cusotmer.cusName',
          filterable: true,
        },
      ],
      rows: [],
    };
  },
};
</script>

<style lang="scss" module>
</style>