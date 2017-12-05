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
      v-if="emp">
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
      emp: true,
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
      employeeRows: [
        {
          id: 1,
          empId: 29,
          empName: '루피',
          empStartDate: '2017-09-20',
          empEndDate: '2017-12-05',
          role: {
            roleName: 'PM',
          },
        },
        {
          id: 2,
          empId: 30,
          empName: '조로',
          empStartDate: '2017-09-20',
          empEndDate: '2017-12-05',
          role: {
            roleName: 'PL',
          },
        },
        {
          id: 3,
          empId: 33,
          empName: '상디',
          empStartDate: '2017-10-12',
          empEndDate: '2017-12-05',
          role: {
            roleName: '설계자',
          },
        },
      ],
    };
  },

  methods: {
    toggle(row, index) {
      console.log('toggle');
      console.log(index);
      this.emp = !this.emp;
      // this.getEmployee(index); // 서버가 아직 구현 안됨.
    },

    // 실제로 프로젝트에 투입된 employee 정보를 받는 곳.
    getEmployee(index) {
      const prjNum = this.projectRows[index].prjId;
      console.log(prjNum);
      this.axios.get(`http://localhost:8080/app/input/${prjNum}`)
      .then((res) => {
        console.log(res);
      });
    },

    // 상세한 표를 보여줌.
    grade(row, index) {
      console.log('grade');
      console.log(this.employeeRows[index].empName);
      const empNum = this.employeeRows[index].empId;
      this.$router.push({ name: 'Grade', params: { id: empNum } });
    },
  },

  mounted() {
    this.axios.get('http://localhost:8000/app/project')
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