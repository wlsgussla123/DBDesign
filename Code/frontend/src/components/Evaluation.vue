<template>
  <section>
    <my-header></my-header>
    <vue-good-table
      title="프로젝트를 선택해주세요."
      :onClick="toggle"
      :columns="projectColumns"
      :rows="projectRows"
      :paginate="true"
      :lineNumbers="true"
      v-if="!emp">
    </vue-good-table>    

    <vue-good-table
      title="직원을 선택하세요."
      :onClick="grade"
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
  name: 'Evaluation',
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
      console.log('toggle');
      console.log(index);
      this.emp = !this.emp;
      this.getEmployee(index); // 서버가 아직 구현 안됨.
    },

    // 실제로 프로젝트에 투입된 employee 정보를 받는 곳.
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
      });
    },

    // 상세한 표를 보여줌.
    grade(row, index) {
      console.log('grade');
      console.log(this.employeeRows[index].empName);
      const empNum = this.employeeRows[index].empId;
      // const empName = this.employeeRos[index].empName;

      this.$router.push({ name: 'Grade', params: { id: empNum } });
    },
  },

  mounted() {
    this.axios.get('http://localhost:8080/app/project/end')
    .then((res) => {
      if (res.data) {
        res.data.forEach((data) => {
          this.projectRows.push(data);
        });
      } else {
        console.log('data null');
      }
    })
    .catch((err) => {
      console.log(err);
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