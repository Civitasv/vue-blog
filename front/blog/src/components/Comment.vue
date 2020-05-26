<template>
  <div id="disqus_thread"></div>
</template>

<style lang="">
</style>
<script>
import "disqusjs/dist/disqusjs.css";
import DisqusJS from "disqusjs";
/**
 *  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
 *  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables*/
/*
var disqus_config = function () {
this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
};
*/

export default {
  methods: {},
  mounted() {
    new DisqusJS({
      shortname: "starss-1",
      siteName: "starss",
      apikey:
        "LowlTuzNzQ1qjhln5Hi07hvkvDNadoUC2lR6RbhRZqfEsBb6dolcMDtkaIrXibWL",
      admin: "civitasv",
      adminLabel: "Mod"
    });
  }
};
</script>

<style>
#dsqjs *,
#dsqjs .dsqjs-no-comment,
#dsqjs .dsqjs-post-body {
  color: whitesmoke;
}
#dsqjs a {
  color: #00d3dd;
}
#dsqjs .dsqjs-disqus-logo {
  color: whitesmoke;
}
#dsqjs .dsqjs-order-radio:checked + .dsqjs-order-label {
  background-color: #202020;
}
#dsqjs .dsqjs-order-label {
  background-color: #396882;
}
</style>