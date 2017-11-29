<template>
  <div class="page-container md-layout-column">
    <md-toolbar class="md-primary">
      <md-button class="md-icon-button" @click="showNavigation = true">
        <md-icon>menu</md-icon>
      </md-button>
      <span class="md-title">MJU System </span>
    </md-toolbar>

    <md-drawer :md-active.sync="showNavigation">
      <md-toolbar class="md-transparent" md-elevation="0" :id="$style.navHeader">
        <span class="md-title">Navigation</span>
      </md-toolbar>

      <md-list>
        <md-list-item>
          <md-icon>account_box</md-icon>
          <span class="md-list-item-text">내 정보</span>
        </md-list-item>

        <md-list-item>
          <md-icon>description</md-icon>
          <span class="md-list-item-text">내 프로젝트 관리</span>
        </md-list-item>

        <md-list-item>
          <md-icon>assessment</md-icon>
          <span class="md-list-item-text">내 평점 보기</span>
        </md-list-item>

        <md-list-item>
          <md-icon>error</md-icon>
          <span class="md-list-item-text">또 뭐가 있지</span>
        </md-list-item>
      </md-list>
    </md-drawer>
  </div>
</template>

<script>
const Component = {
  name: 'Sidenav',
  data() {
    return {
      showNavigation: false,
    };
  },
};

export default Component;
</script>

<style lang="scss" module>
#navHeader {
  border-bottom: 1px solid #d2d2d2;
}

</style>