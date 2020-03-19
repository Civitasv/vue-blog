<style scoped>
.layout {
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: hidden;
}
.layout-header-bar {
  background: #fff;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
}
</style>
<template>
  <div class="layout">
    <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
      <Menu active-name="1-1" theme="dark" width="auto" :open-names="['1']">
        <MenuItem name="1-1">
          <Icon type="logo-markdown" />
          <router-link to="/write" tag="span">Markdown</router-link>
        </MenuItem>
        <Submenu name="2">
          <template slot="title">
            <Icon type="ios-keypad"></Icon>博客管理
          </template>
          <MenuItem name="2-1">文章管理</MenuItem>
          <MenuItem name="2-2">评论管理</MenuItem>
          <MenuItem name="2-3">标签管理</MenuItem>
        </Submenu>
      </Menu>
    </Sider>
    <Layout :style="{marginLeft: '200px'}">
      <Header :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}"></Header>
      <Content :style="{padding: '0 16px 16px'}">
        <Breadcrumb :style="{margin: '16px 0'}">
          <BreadcrumbItem>Home</BreadcrumbItem>
          <BreadcrumbItem>Components</BreadcrumbItem>
          <BreadcrumbItem>Layout</BreadcrumbItem>
        </Breadcrumb>
        <Card>
          <div style="height: 600px">Content</div>
        </Card>
      </Content>
    </Layout>
  </div>
</template>
<script>
export default {};
</script>
