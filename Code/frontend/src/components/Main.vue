<template>
  <section>
    <my-header></my-header>
    <main>
      Main에는 무엇을 채울까요 ?
    </main>
    <footer></footer>
  </section>
</template>

<script>
import Header from './Header';

export default {
  name: 'Main',
  components: {
    myHeader: Header,
  },
};
</script>

<style lang="scss" module>
</style>