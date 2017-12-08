<template>
    <section>
        <myHeader>
        </myHeader>
        <div>
            <vue-good-table
            title = "Employee Table"
            :columns = "columns"
            :rows = "rows"
            :paginate = "true"
            :lineNumbers = "true"/>
        </div>
    </section>    
</template>

<script>
const Header = () => import('../components/Header');

export default {
  name: 'EmployeeList',
  components: {
    myHeader: Header,
  },
  data() {
    return {
      columns: [
        {
          label: 'Employee ID',
          field: 'empId',
          filterable: true,
        },
        {
          label: 'Department',
          field: 'deptId',
          type: 'number',
          filterable: true,
        },
        {
          label: 'Name',
          field: 'empName',
          type: 'text',
          filterable: true,
        },
        {
          label: 'Education',
          field: 'empEdu',
          type: 'text',
          filterable: true,
        },
        {
          label: 'Email',
          field: 'empEmail',
          type: 'text',
          filterable: true,
        },
      ],
      rows: [
      ],
    };
  },
  mounted() {
    this.axios.get('http://localhost:8080/app/employee')
    .then((res) => {
      console.log(res);
      this.rows = res.data;
      this.deptIdCondition();
    });
  },
  // 부서이름을 한글로
  methods: {
    deptIdCondition() {
      Object.keys(this.rows).forEach((key) => {
        if (this.rows[key].deptId === 4) this.rows[key].deptId = '개발 부서';
        else if (this.rows[key].deptId === 3) this.rows[key].deptId = '연구개발 부서';
        else if (this.rows[key].deptId === 2) this.rows[key].deptId = '경영관리 부서';
        else if (this.rows[key].deptId === 1) this.rows[key].deptId = '마케팅 부서';
      });
    },
  },
};
</script>