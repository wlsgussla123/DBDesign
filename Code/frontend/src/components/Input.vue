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

    <vue-good-table
      title="투입 중 직원"
      :columns="employeeColumns"
      :rows="employeeRows"
      :paginate="true"
      :lineNumbers="true"
      v-else>
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
          field: 'employee.empName',
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
    toggle(row, index) {
      this.emp = !this.emp;
      this.getEmployee(index);
    },

    // 프로젝트 번호를 받고, 그 프로젝트에 투입된 직원 정보를 받는다.
    getEmployee(index) {
      const prjNum = this.projectRows[index].prjId;
      this.axios.get(`http://localhost:8080/app/input/${prjNum}`)
      .then((res) => {
        if (res.data) {
          res.data.forEach((data) => {
            this.employeeRows.push(data);
          });
        } else {
          console.log('input employee is null');
        }
      })
      .catch((err) => {
        console.log(err);
      });
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