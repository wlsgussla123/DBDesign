<template>
  <section :id="$style.homeContainer">
    <header>
      <span :id="$style.title">{{title}}</span>
    </header>
    <main>
      <md-field>
        <label>아이디</label>
        <md-input v-model="id"></md-input>
      </md-field>

      <md-field :md-toggle-password="false">
        <label>비밀번호</label>
        <md-input v-model="password" type="password"></md-input>
      </md-field>

      <md-dialog-alert
        :md-active.sync="alert"
        md-content="아이디 혹은 비밀번호를 올바르게 입력하세요."
        md-confirm-text="확인" />            
    </main>
    <footer>
      <md-button :id="$style.loginBtn" class="md-raised md-primary" @click="login()">로그인</md-button>
    </footer>
  </section>
</template>

<script>
export default {
  name: 'login',
  data() {
    return {
      title: 'Database Design Project',
      id: 'model9960@naver.com',
      password: '9960',
      alert: false, // 로그인 실패 시
    };
  },

  methods: {
    login() {
      this.axios.post('http://localhost:8000/app/login/', {
        empEmail: this.id,
        pass: this.password,
      })
      .then((res) => {
        if (res.data) {
          console.log(res);
          this.$router.push({ path: 'Main' });
        } else {
          console.log('null');
          this.alert = true;
        }
      });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" module>
#homeContainer {
  max-width: 560px; // 가운데 정렬을 위하여

  margin-top: 60px;
  margin-right: auto;
  margin-bottom: 60px;
  margin-left: auto;
}

header {
  margin-top: 30px;
  margin-bottom: 30px;

  #title {
    font-size: 24px;
    font-weight: bold;
  }
}

main {
  margin-bottom: 60px;
}

footer {
  display: flex;
  justify-content: center;
  
  #loginBtn {
    width: 100%;
  }
}
</style>
