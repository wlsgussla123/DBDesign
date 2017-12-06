import Vue from 'vue';
import Router from 'vue-router';
import VueGoodTable from 'vue-good-table';

// components
const Login = () => import('../components/Login');
const Main = () => import('../components/Main');
const Evaluation = () => import('../components/Evaluation');
const ProjectList = () => import('../components/ProjectList');
const EmployeeList = () => import('../components/EmployeeList');
const Grade = () => import('../components/Grade'); // 평가 페이지에서 쓰임.
const SignUp = () => import('../components/SignUp');

Vue.use(Router);
Vue.use(VueGoodTable);

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login,
  },

  {
    path: '/main',
    name: 'Main',
    component: Main,
  },
  {
    path: '/employeelist',
    name: 'EmployeeList',
    component: EmployeeList,
  },
  {
    path: '/projectlist',
    name: 'ProjectList',
    component: ProjectList,
  },

  {
    path: '/evaluation',
    name: 'Evaluation',
    component: Evaluation,
  },
  {
    path: '/grade/:id',
    name: 'Grade',
    component: Grade,
    props: true,
  },
  {
    path: '/SignUp',
    name: 'SignUp',
    component: SignUp,
  },
];

const router = new Router({
  routes,
});

export default router;
