<template>
    <div id="product-table">
        <div>
            <div id="product-table-heading">
                <div>Nome:</div>
                <div>Tipo:</div>
                <div>Preço:</div>
                <div>Quantidade:</div>
            </div>    
        </div>
        <form @submit="create">
        <div id=" product-table-rows">
            <div class="product-table-row" :key="id">
                <div><input type="text" v-model="name" required></div>
                <div>
                    <select v-model="selectOption" required>
                        <option disabled selected>Selecione</option>
                        <option v-for="tipo in tipos" :key="tipo.id" :value="tipo.id +',' +tipo.tipo">
                            {{tipo.tipo}}
                        </option>
                    </select>
                </div>
                <div><input type="text" v-model="price" required placeholder="0,00"></div>
                <div><input type="text" v-model="quantity" required></div>
                <input type="submit" class="save-btn" value="Save">
                <button class="limpar-btn" @click="limpar()" >Limpar</button>
            </div>
        </div>
        </form>
    </div>
</template>

<script>
import route from '../router'

    export default {
        name: 'CreateProduct',
        components: {
            route
        },
        data(){
            return{
                tipos: null,
                selectOption: "Selecione",
            }
        },
        methods: {
            async getTipos(){
                const req = await fetch("http://localhost:3003/tipos/getTipos");
                const data = await req.json();

                this.tipos = data;
            }
        },
        mounted(){
            this.getTipos();
        }
           
    }
    
</script>

<style scoped>
    #product-table{
        max-width: 1200px;
        margin: 0 auto;
    }

    #product-table-heading,
    #product-table-rows,
    .product-table-row{
        display: flex;
        flex-wrap: wrap;
    }

    #product-table-heading{
        font-weight: bold;
        padding: 12px;
        border-bottom: 3px solid #333;
        margin-top: 15px;
    }

    #product-table-heading div{
        width: 16%;
    }

    .product-table-row div{
        width: 16%;
    }
    
    .product-table-row{
        width: 100%;
        padding: 10px;
        border-bottom: 1px solid #CCC;
    }

    .save-btn{
        background-color: #26232e7c;
        color: white;
        font-weight: bold;
        border: 2px solid white;
        padding: 10px;
        font-size: 14px;
        margin: 0 auto;
        cursor: pointer;
        transition: .5s;
        width: 70px;
        border-radius: 30px;
    }

    .save-btn:hover {
        background-color: white;
        color: #26232e7c;
        border: 2px solid #26232e7c;
    }

    .limpar-btn{
        background-color: #100235dc;
        color: white;
        font-weight: bold;
        border: 2px solid white;
        padding: 10px;
        font-size: 14px;
        margin: 0 auto;
        cursor: pointer;
        transition: .5s;
        width: 70px;
        border-radius: 30px;
    }

    .limpar-btn:hover {
        background-color: white;
        color: #100235dc;
        border: 2px solid #100235dc;
    }

    input{
        padding: 5px 10px;
    }
    
    select{
        padding: 5px 10px;
        width: 170px;
        height: 30px;
    }
</style>