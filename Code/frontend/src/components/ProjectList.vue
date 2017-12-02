<template>
  <section>
    <my-header></my-header>
    <main>
        프로젝트 리스트 보기

        <div id="demo">
            <demo-grid
                :data="gridData"
                :columns="gridColumns"
                :filter-key="searchQuery">
            </demo-grid>
        </div>




    </main>
    <footer></footer>
  </section>
</template>

<script>
import Header from './Header';

export default {
  name: 'ProjectList',
  components: {
    myHeader: Header,
  },
};
</script>

<style lang="scss" module>
</style>