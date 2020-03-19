<template>
  <header>
    <div class="head">
      <div class="title">
        <router-link to="/home" tag="span">甜木木夕</router-link>
      </div>
      <div class="subtitle">Be Someone</div>
    </div>
    <div class="nav">
      <router-link to="/home" tag="span">
        <Icon type="ios-home" />&nbsp;&nbsp;Home
      </router-link>
      <router-link to="/archives" tag="span">
        <Icon type="ios-archive" />&nbsp;&nbsp;Archives
      </router-link>
      <router-link to="/tags" tag="span">
        <Icon type="ios-pricetags" />&nbsp;&nbsp;Tags
      </router-link>
      <router-link to="/search" tag="span">
        <Icon type="md-search" />&nbsp;&nbsp;Search
      </router-link>
      <router-link to="/about" tag="span">
        <Icon type="ios-at" />&nbsp;&nbsp;About
      </router-link>
      <router-link to="/link" tag="span">
        <Icon type="ios-link" />&nbsp;&nbsp;Link
      </router-link>
    </div>
  </header>
</template>

<style scoped>
.title {
  background: #493374;
  color: white;
  font-size: 18px;
  font-weight: bold;
  line-height: 2em;
  cursor: pointer;
  margin-bottom: 0.5em;
}
.head {
  width: 16%;
  text-align: center;
  margin: 0 auto;
  padding-top: 10vh;
}
.subtitle {
  color: whitesmoke;
  font-size: 12px;
}
.nav {
  text-align: center;
  margin-top: 4vh;
  color: whitesmoke;
}
.nav span {
  margin: 10px;
  cursor: pointer;
}
</style>