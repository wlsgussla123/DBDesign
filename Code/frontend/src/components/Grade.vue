<template>
  <section>
    <my-header></my-header>
    <div :id="$style.chartContainer">
      <div :id="$style.title">
        <span>평가 실적</span>
        <md-checkbox v-model="toggle" class="md-primary">커뮤니케이션</md-checkbox>
      </div>

      <canvas id="myChart" width="150" height="100"></canvas>
      <md-field v-if="toggle">
        <label>PM 커뮤니케이션 평가 내용</label>
        <md-textarea v-model="this.pmData.commContents" disabled></md-textarea>
      </md-field>

      <md-field v-if="toggle">
        <label>동료 커뮤니케이션 평가 내용</label>
        <md-textarea v-model="this.coworkData.commContents" disabled></md-textarea>
      </md-field>

      <md-field v-if="toggle">
        <label>고객 커뮤니케이션 평가 내용</label>
        <md-textarea v-model="this.customerData.commContents" disabled></md-textarea>
      </md-field>

      <md-field v-if="!toggle">
        <label>PM 업무 수행능력 평가 내용</label>
        <md-textarea v-model="this.pmData.perfContents" disabled></md-textarea>
      </md-field>
  
      <md-field v-if="!toggle">
        <label>동료 업무 수행능력 평가 내용</label>
        <md-textarea v-model="this.coworkData.perfContents" disabled></md-textarea>
      </md-field>

      <md-field v-if="!toggle">
        <label>고객 업무 수행능력 평가 내용</label>
        <md-textarea v-model="this.customerData.perfContents" disabled></md-textarea>
      </md-field>
    </div>
  </section>
 </template>

<script>
import axios from 'axios'; // eslint-disable-line
import Chart from 'chart.js';
import Header from './Header';

const Component = {
  name: 'Grade',
  props: ['id'],
  components: {
    myHeader: Header,
  },
  data() {
    return {
      data: [],
      pmData: [],
      coworkData: [],
      customerData: [],
      communication: '잘함',
      performance: '잘함',

      chart: 'communication',
      toggle: true, // false면 communication true면 performance
    };
  },
  watch: {
    toggle() {
      this.drawChart();
    },
  },

  methods: {
    drawChart() {
      const ctx = document.getElementById('myChart');
      if (this.toggle) {
        const communication = new Chart(ctx, { // eslint-disable-line
          type: 'bar',
          data: {
            labels: ['PM', '동료', '고객'],
            datasets: [{
              label: '커뮤니케이션 능력',
              data: [this.pmData.commGrade, this.coworkData.commGrade, this.customerData.commGrade],
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
              ],
              borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
              ],
              borderWidth: 1,
            }],
          },
          options: {
            scales: {
              yAxes: [{
                ticks: {
                  beginAtZero: true,
                },
              }],
            },
          },
        });
      } else {
        const performance = new Chart(ctx, { // eslint-disable-line
          type: 'bar',
          data: {
            labels: ['PM', '동료', '고객'],
            datasets: [{
              label: '업무수행 능력',
              data: [this.pmData.perfGrade, this.coworkData.perfGrade, this.customerData.perfGrade],
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
              ],
              borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
              ],
              borderWidth: 1,
            }],
          },
          options: {
            scales: {
              yAxes: [{
                ticks: {
                  beginAtZero: true,
                },
              }],
            },
          },
        });
      }
    },
  },

  mounted() {
    console.log('mounted');
    this.axios.get('http://localhost:8080/app/evaluation')
    .then((res) => {
      res.data.forEach((data) => {
        // props로 넘어온 empID와 같은 ID를 가진 피평가자만 추가하자.
        if (this.id === data.subject) {
          // PM : 1, coworker : 2, custoemr : 3
          if (data.evalCategory === 1) {
            console.log('pm');
            this.pmData = data;
          } else if (data.evalCategory === 2) {
            console.log('coworker');
            this.coworkData = data;
          } else {
            console.log('customer');
            this.customerData = data;
          }
        }
      });
      this.drawChart(); // data set을 하고나서 그리자.
    });
  },
};

export default Component;
</script>

<style lang="scss" module>
#chartContainer {
  max-width: 700px;
  padding-top: 30px;
  margin-left: auto;
  margin-right: auto;
  padding-bottom: 30px;

  #title {
    display: flex;
    justify-content: space-around;
    align-items: center;

    margin-bottom: 30px;
    span {
      font-size: 20px;
      font-weight: bold;
    }
  }
}
</style>