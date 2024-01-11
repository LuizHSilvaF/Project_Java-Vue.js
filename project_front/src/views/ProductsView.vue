<template>
  <div class="main-container">
    <Navbar />
    <h1>Produtos</h1>
    <ProductsPage />
  </div>
</template>

<script>
import Navbar from '../components/Navbar.vue'
import ProductsPage from '../components/ProductsPage.vue'

export default {
  name: 'ProductsView',
  components: {
    Navbar,
    ProductsPage
  }
}
</script>

<style scoped>
  *{
      margin: 0;
        padding: 0;
  }

  h1{
    margin-top: -70px;
    margin-bottom: 60px;
  }
</style>
