import { createRouter, createWebHistory } from "vue-router";
import HelloWorld from "../components/Home/HelloWorld.vue";
import VignettesList from "../components/Vignettes/VignettesList.vue";
import VignetteAdd from "../components/Vignettes/VignetteAdd.vue";
import ValidityCheck from "../components/Validity/ValidityCheck.vue";
import LoginView from "../views/LoginView.vue";
import SignUpView from "../views/SignUpView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HelloWorld,
    props: { msg: "Welcome to Goran's Vue.js App" },
  },
  {
    path: "/vignettes",
    name: "vignettes",
    component: VignettesList,
  },
  {
    path: "/add-vignette",
    name: "add-vignette",
    component: VignetteAdd,
  },
  {
    path: "/validate",
    name: "validate",
    component: ValidityCheck,
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
  },
  {
    path: "/signup",
    name: "signup",
    component: SignUpView,
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
