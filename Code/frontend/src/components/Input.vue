<template>
  <section id="$style.inputContainer">
    <my-header></my-header>

    <vue-good-table
      title="투입된 직원을 볼 프로젝트를 선택해주세요."
      :onClick="toggle"
      :columns="projectColumns"
      :rows="projectRows"
      :paginate="true"
      :lineNumbers="true"
      v-if="!emp">
    </vue-good-table>
  </section>
</template>

<script>
const Header = () => import('../components/Header');

export default {
  name: 'Input',
  components: {
    myHeader: Header,
  },

  data() {
    return {
      emp: false,
      projectList: [],
      projectColumns: [
        {
          label: '프로젝트 이름',
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
          field: 'customer.cusName',
          filterable: true,
        },
      ],
      employeeColumns: [
        {
          label: '직원 이름',
          field: 'empName',
          filterable: true,
        },
        {
          label: '투입 시작',
          field: 'empStartDate',
          type: 'date',
          html: false,
          filterable: true,
          inputFormat: 'YYYY-MM-DD',
          outputFormat: 'YYYY-MM-DD',
        },
        {
          label: '투입 종료',
          field: 'empEndDate',
          type: 'date',
          html: false,
          filterable: true,
          inputFormat: 'YYYY-MM-DD',
          outputFormat: 'YYYY-MM-DD',
        },
        {
          label: '직책',
          field: 'role.roleName',
          filterable: true,
        },
      ],
      projectRows: [],
      employeeRows: [],
    };
  },

  methods: {
    toggle() {
      this.emp = !this.emp;
    },
  },

  mounted() {
    this.axios.get('http://localhost:8080/app/project')
    .then((res) => {
      res.data.forEach((data) => {
        this.projectRows.push(data);
      });
    });
  },
};

</script>

<style lang="scss" module>
</style>