<template>
    <div id="nav">
        <div id="links">
            <router-link to="/">Usuarios</router-link>
            <router-link to="">Produtos</router-link>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Navbar'
    }
</script>

<style scoped>
    #nav{
        top: 0;
        width: 100%;
        background-color: #0a3d807c;
        display: flex;
        justify-content: center;
        padding: 15px 50px;
        align-items: center;
        margin-bottom: 100px;
    }

    #links a{
        color: white;
        margin: 50px;
        text-decoration: none;
        transition: .5s;
        font-size: 25px;
    }

    #links a:hover{
        color: rgba(43, 3, 187, 0.548);
    }
</style>