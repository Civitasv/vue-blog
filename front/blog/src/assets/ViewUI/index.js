import { Divider, Icon, Page, BackTop, Timeline, TimelineItem, Sider, Menu, MenuItem, Submenu, Layout, Header, Content, Card, Button, Form, FormItem, Input } from 'view-design';

const ViewUI = {
    install: function (Vue) {
        Vue.component('Icon', Icon);
        Vue.component('Divider', Divider);
        Vue.component('Page', Page);
        Vue.component('BackTop', BackTop);
        Vue.component('Timeline', Timeline);
        Vue.component('TimelineItem', TimelineItem);
        Vue.component('Sider', Sider);
        Vue.component('Menu', Menu);
        Vue.component('Layout', Layout);
        Vue.component('MenuItem', MenuItem);
        Vue.component('Submenu', Submenu);
        Vue.component('Header', Header);
        Vue.component('Content', Content);
        Vue.component('Card', Card);
        Vue.component('Button', Button);
        Vue.component('Form', Form);
        Vue.component('FormItem', FormItem);
        Vue.component('Input', Input);
    }
}

export default ViewUI
