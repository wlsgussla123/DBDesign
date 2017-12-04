import Vue from 'vue';
import Router from 'vue-router';

// components
const Login = () => import('../components/Login');
const Main = () => import('../components/Main');
const Evaluation = () => import('../components/Evaluation');
const Employee = () => import('../components/EmployeeList');

Vue.use(Router);

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
    path: '/evaluation',
    name: 'Evaluation',
    component: Evaluation,
  },
  {
    path: '/employee',
    name: 'Employee',
    component: Employee,
  },
];

const router = new Router({
  routes,
  mode: 'history',
});

export default router;
