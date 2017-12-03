import Vue from 'vue';
import Router from 'vue-router';
import VueGoodTable from 'vue-good-table';
// components
const Login = () => import('../components/Login');
const Main = () => import('../components/Main');
const ProjectList = () => import('../components/ProjectList');


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
    path: '/projectlist',
    name: 'ProjectList',
    component: ProjectList,
  },
];

const router = new Router({
  routes,
});

export default router;
