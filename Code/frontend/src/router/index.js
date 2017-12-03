import Vue from 'vue';
import Router from 'vue-router';

// components
const Login = () => import('../components/Login');
const Main = () => import('../components/Main');

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
];

const router = new Router({
  routes,
  mode: 'history',
});

export default router;
