<template>
    <div class="main-container">
        <button class="sair-btn" @click="voltar()">Voltar</button>
        <h1>Criar Produto</h1>
        <CreateProduct />
    </div>
</template>

<script>
import route from '../router'
import CreateProduct from '../components/CreateProduct.vue'

    export default {
        name: 'CreateProductView',
        components: {
            CreateProduct,
            route
        },
        methods: {
            voltar(){
                route.push({name: 'products'})
            }
        }
    }
</script>

<style scoped>
    .sair-btn{
        background-color: #9e0606ad;
        color: white;
        font-weight: bold;
        border: 2px solid white;
        padding: 10px;
        font-size: 20px;
        margin: 0 auto;
        cursor: pointer;
        transition: .5s;
        width: 100px;
        border-radius: 30px;
        margin-left: 50px;
        margin-bottom: 30px;
    }

    .sair-btn:hover{
        background-color: white;
        color: #9e0606ad;
        border: 2px solid #9e0606ad;
    }

    *{
        margin: 0;
        padding: 0;
    }

    h1{
        margin-top: -70px;
        margin-bottom: 60px;
    }
</style>
