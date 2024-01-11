import { createRouter, createWebHistory } from 'vue-router'
import ProductsView from '../views/ProductsView.vue'
import CreateProductView from '../views/CreateProductView.vue'

const routes = [
  {
    path: '/',
    name: 'products',
    component: ProductsView
  },
  {
    path: '/createProdutos',
    name: 'create',
    component: CreateProductView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
