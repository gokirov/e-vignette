import { createApp } from "vue";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "./App.vue";
import router from "./router";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faPhone, faUser, faFlag } from "@fortawesome/free-solid-svg-icons";
import { fab } from "@fortawesome/free-brands-svg-icons";
import { far } from "@fortawesome/free-regular-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(faPhone, faUser, faFlag, fab, far);
createApp(App)
  .use(router)
  .use("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");
