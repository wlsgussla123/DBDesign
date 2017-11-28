// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import axios from 'axios';
import Vue from 'vue';
import VueAxios from 'vue-axios';
import VueMaterial from 'vue-material';
import 'vue-material/dist/vue-material.min.css';

import App from './App'; // load App
import router from './router'; // about router
import './styles/common.scss'; // about style

Vue.config.productionTip = false;

Vue.use(VueAxios, axios);
Vue.use(VueMaterial);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App },
});
