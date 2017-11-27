<template>
  <div :class="$style.hello">
    <h1>{{ msg }}</h1>
    <span :id="$style.test">scss test</span>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: 'Welcome to Your Vue.js App',
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" module>
.hello {
  #test {
    color: blue;
  }
}
</style>
