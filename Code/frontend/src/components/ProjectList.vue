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

    data(){ 
        return {
            columns: [
                {
                    label: 'Project Name',
                    field: 'projectName',
                    filterable: true,
                },
                {
                    label: '시작기간',
                    field: 'startDay',
                    type: 'date',
                    html: false,
                    filterable: true,
                    inputFormat: 'YYYY-MM-DD',
                    outputFormat: 'YYYY-MM-DD',
                },
                {
                    label: '종료기간',
                    field: 'endDay',
                    type: 'date',
                    html: false,
                    filterable: true,
                    inputFormat: 'YYYY-MM-DD',
                    outputFormat: 'YYYY-MM-DD',
                },
                {
                    label: '발주처',
                    field: 'customer',
                    filterable: true,
                },
            ],

            //mockup data
            rows: [
                {id:1, projectName:"DBdeign",startDay: '2017-10-31',endDay: '2017-10-31',customer: '주식회사'},
                {id:2, projectName:"Jane",startDay: '2017-10-31',endDay: '2011-10-31',customer: '주식회사'},
                {id:3, projectName:"Susan",startDay: '2017-10-31',endDay: '2011-10-30',customer: '주식회사'},
                {id:4, projectName:"Chris",startDay: '2017-10-31',endDay: '2011-10-11',customer: '주식회사'},
                {id:5, projectName:"Dan",startDay: '2017-10-31',endDay: '2011-10-21',customer: '주식회사'},
                {id:6, projectName:"John",startDay: '2017-10-31',endDay: '2011-10-31',customer: '주식회사'},
                {id:7, projectName:"Jane",startDay: '2017-10-31',endDay: '2011-10-31',customer: '주식회사'},
                {id:8, projectName:"Susan",startDay: '2017-10-31',endDay: '2013-10-31',customer: '주식회사'},
                {id:9, projectName:"Chris",startDay: '2017-10-31',endDay: '2012-10-31',customer: '주식회사'},
                {id:10, projectName:"Dan",startDay: '2017-10-31',endDay: '2011-10-31',customer: '주식회사'},
                {id:11, projectName:"John",startDay: '2017-10-31',endDay: '2011-10-31',customer: '주식회사'},
                {id:12, projectName:"Jane",startDay: '2017-10-31',endDay: '2011-07-31',customer: '주식회사'},
                {id:13, projectName:"Susan",startDay: '2017-10-31',endDay: '2017-02-28',customer: '주식회사'},
                {id:14, projectName:"Chris",startDay: '2017-10-31',endDay: '2017-02-28',customer: '주식회사'},
                {id:15, projectName:"Dan",startDay: '2017-10-31',endDay: '2011-10-31',customer: '주식회사'},
                {id:19, projectName:"Chris",startDay: '2017-10-31',endDay: '2011-10-31',customer: '주식회사'},
                {id:20, projectName:"Dan",startDay: '2017-10-31',endDay: '2011-10-31',customer: '주식회사'},
            ],
        };
    },

};
</script>

<style lang="scss" module>
</style>