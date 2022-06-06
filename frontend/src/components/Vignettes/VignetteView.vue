<template>
<transition name="vignette-fade">
    <div class="vignette-backdrop">
        <div class="vignette">
            <header class="vignette-header">
                See vignette
                <button type="button" class="btn-close" @click="close">
                    X
                </button>
            </header>

            <section class="vignette-body">
                <div class="vignette-header">
                    <div style="color:black;">First Name: </div> {{vignette?.firstName}}
                </div>
                <div class="vignette-header">
                    <div style="color:black;">Last Name: </div> {{vignette?.lastName}}
                </div>
                <div class="vignette-header">
                    <div style="color:black;">Plate Number: </div> {{vignette?.plateNumber}}
                </div>
                <div class="vignette-header">
                    <div style="color:black;">Date: </div> {{vignette?.created}}
                </div>
            </section>

            <footer class="vignette-footer">
                <button type="button" class="btn-green" @click="close">
                    Close Vignette
                </button>
            </footer>
        </div>
    </div>
</transition>
</template>

<script>
export default {
    name: 'VignetteView',
    props: {
        vignette: Object
    },
    data() {
        return {
            showVignette: false,
        }
    },
    methods: {
        close() {
            this.$emit('close');
        },
    }
}
</script>

<style scoped>
.vignette-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.3);
    display: flex;
    justify-content: center;
    align-items: center;
    min-width: 500px;
    overflow-y: auto;
}

.vignette {
    background: #FFFFFF;
    box-shadow: 2px 2px 20px 1px;
    overflow-x: auto;
    display: flex;
    flex-direction: column;
}

.vignette-header,
.vignette-footer {
    padding: 15px;
    display: flex;
}

.vignette-header {
    position: relative;
    border-bottom: 1px solid #eeeeee;
    color: #42b983;
    justify-content: space-between;
}

.vignette-footer {
    border-top: 1px solid #eeeeee;
    flex-direction: column;
    justify-content: flex-end;
}

.vignette-body {
    position: relative;
    padding: 20px 10px;
}

.btn-close {
    position: absolute;
    top: 0;
    right: 0;
    border: none;
    font-size: 20px;
    padding: 10px;
    cursor: pointer;
    font-weight: bold;
    color: #42b983;
    background: transparent;
}

.btn-green {
    color: white;
    background: #42b983;
    border: 1px solid #42b983;
    border-radius: 2px;
}

.vignette-fade-enter,
.vignette-fade-leave-to {
    opacity: 0;
}

.vignette-fade-enter-active,
.vignette-fade-leave-active {
    transition: opacity .5s ease;
}
</style>
