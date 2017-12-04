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
  name: 'Employee',
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
      rows: [],
    };
  },
  method: {
    deptIdCondition() {
      console.log(this.rows.deptId);
    },
  },
  mounted() {
    this.axios.get('http://localhost:8000/app/employee')
    .then((res) => {
      console.log(res);
      this.rows = res.data;
    });
  },
};
</script>