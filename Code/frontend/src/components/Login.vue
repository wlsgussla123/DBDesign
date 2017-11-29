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
    </main>
    <footer>
      <md-button :id="$style.loginBtn" class="md-raised md-primary">로그인</md-button>
    </footer>
  </section>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      title: 'Database Design Project',
      id: '',
      password: '',
    };
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
