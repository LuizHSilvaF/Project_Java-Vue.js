<template>
    <div id="product-table">
        <div>
            <div id="product-search">
                <div><input type="search" id="pesquisa" name="pesquisa" v-model="name" placeholder="Pesquisa por nome">
                <button class="pesquisar-btn" @click="findByName(name)">Pesquisar</button>
                <select class="ordenacao" v-model="opcaoSelecionada" @change="pesquisaTipo(opcaoSelecionada)">
                    <option disabled selected>Selecione</option>
                    <option v-for="tipo in tipos" :key="tipo.id" :value="tipo.id">
                            {{tipo.tipo}}
                    </option>
                </select>
                <button class="criar-btn" @click="createProduto()">Criar</button>
                </div>
            </div>    
            <div id="product-table-heading">
                <div>Nome:</div>
                <div>Tipo:</div>
                <div>Preço:</div>
                <div>Quantidade:</div>
            </div>    
        </div>
        <div id=" product-table-rows">
            <div v-if="findProducts">
            <div class="product-table-row" v-for="findProduct in findProducts" :key="findProduct.id">
                <div><input type="text" :readonly="read" v-model="findProduct.name"></div>
               <div><input type="text" readonly :value="findProduct.tipo ? findProduct.tipo.tipo : ''"></div>
                <div><input type="text" :readonly="read" v-model="findProduct.price"></div>
                <div><input type="text" readonly v-model="findProduct.quantity"></div>
                <button class="save-btn" @click="updateUser(findProduct.id, findProduct.name, findProduct.price)" :hidden="hid">Save</button>
                <button class="editar-btn" @click="readData()">Editar</button>
                <button class="excluir-btn" @click="deleteProduto(findProduct.id, findProduct.name)">Excluir</button>
            </div>
            </div>
            <div v-else>
            <div class="product-table-row" v-for="product in products" :key="product.id">
                <div><input type="text" :readonly="read" v-model="product.name"></div>
                <div><input type="text" readonly :value="product.tipo ? product.tipo.tipo : ''"></div>
                <div><input type="text" :readonly="read" v-model="product.price"></div>
                <div><input type="text" readonly v-model="product.quantity"></div>
                <button class="save-btn" @click="updateUser(product.id, product.name, product.price)" :hidden="hid">Save</button>
                <button class="editar-btn" @click="readData()">Editar</button>
                <button class="excluir-btn" @click="deleteProduto(product.id, product.name)">Excluir</button>
            </div>
            </div>
        </div>
    </div>
</template>

<script>
import route from '../router'

    export default {
        name: 'ProductsPage',
        components: {
            route
        },
        data(){
            return{
                products: null,
                findProducts: null,
                read: true
            }
        },
        methods: {
            async findAll(){
                const req = await fetch("http://localhost:3003/products/findAll");
                const data = await req.json();

                this.products = data;
                this.findProducts = null;
            },
            async findByName(name){
                const req = await fetch(`http://localhost:3003/products/findByName?name=${name}`);
                const data = await req.json();

                this.findProducts = data;
            }
            ,
            readData(){
                this.read = !this.read;
                    if(this.read===false){
                       this.hid = !this.hid;
                    }
                    else{
                      this.hid = true;
                    }
                }
        },
        mounted() {
            this.findAll();
        }
    }
    
</script>

<style scoped>
    #product-search input{
       width: 30%;
    }

    #product-search button{
        margin-left: 3%;
    }

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

    #product-table-heading #pesquisa {
        margin-left: -90px;
        margin-top: -7px;
    }

    .pesquisar-btn{
        background-color: #e0dc0eb2;
        color: white;
        font-weight: bold;
        border: 2px solid white;
        padding: 10px;
        font-size: 16px;
        margin: 0 auto;
        cursor: pointer;
        transition: .5s;
        border-radius: 30px;
        margin-left: 1%;
        width: 15%;
    }

    .pesquisar-btn:hover{
        background-color: white;
        color: #e0dc0eb2;
        border: 2px solid #e0dc0eb2;
    }

    .criar-btn{
        background-color: #0b5304b2;
        color: white;
        font-weight: bold;
        border: 2px solid white;
        padding: 10px;
        font-size: 16px;
        margin: 0 auto;
        cursor: pointer;
        transition: .5s;
        border-radius: 30px;
        width: 10%;
    }

    .criar-btn:hover{
        background-color: white;
        color: #0b5304b2;
        border: 2px solid #0b5304b2;
    }

    .search-btns{
        margin-top: -10px;
    }

    .excluir-btn{
        background-color: #9e0606ad;
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

    .excluir-btn:hover{
        background-color: white;
        color: #9e0606ad;
        border: 2px solid #9e0606ad;
    }

    .editar-btn{
        background-color: #1503477c;
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

    .editar-btn:hover{
        background-color: white;
        color: #1503477c;
        border: 2px solid #1503477c;
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

    .ordenacao{
        background-color: #000000e1;
        color: white;
        font-weight: bold;
        border: 2px solid white;
        padding: 10px;
        font-size: 16px;
        margin: 0 auto;
        cursor: pointer;
        transition: .5s;
        width: 140px;
        border-radius: 30px;
        margin-left: 30px;
    }

    input{
        padding: 5px 10px;
    }
</style>