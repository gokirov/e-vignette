<template>
<button class="btn btn-primary" @click="$router.push({name: 'add-vignette'})">Add vignette</button>
<div class="container table-responsive py-5">
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Plate Num</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(result,i) in vignettesList" :key="i">
                <th scope="row" @click="showVignette(result)">{{i+1}}🔎</th>
                <td>{{result.firstName}}</td>
                <td>{{result.lastName}}</td>
                <td>{{result.plateNumber}}</td>
                <td @click="deleteVignette(result.id)">🗑️</td>
            </tr>
        </tbody>
    </table>
</div>
<VignetteView v-show="isVignetteVisible" @close="closeVignette" :vignette="vignette" />
</template>

<script>
const baseURL = "http://localhost:8080";
import VignetteView from './VignetteView.vue';
export default {
    name: 'VignettesList',
    components: {
        VignetteView
    },
    data() {
        return {
            vignette: null,
            vignettesList: null,
            isVignetteVisible: false,
        }
    },
    methods: {
        showVignette(Vignette) {
            this.vignette = Vignette;
            this.isVignetteVisible = true;
        },
        closeVignette() {
            this.isVignetteVisible = false;
        },
        async deleteVignette(id) {
            if (id) {
                try {
                    const res = await fetch(`${baseURL}/api/v1/vignettes/${id}`, {
                        method: "delete"
                    });
                    this.vignettesList = this.vignettesList.filter(p => p.id != id);
                    const data = await res.json();
                    const result = {
                        status: res.status + "-" + res.statusText,
                        headers: {
                            "Content-Type": res.headers.get("Content-Type")
                        },
                        data: data,
                    };
                    console.log(this.vignettesList);
                    this.vignettesList = this.vignettesList.filter(p => p.id != id);
                    console.log(this.vignettesList);
                    console.log(result);
                } catch (err) {
                    console.log(err.message);
                }
            }
        },
        async getVignettes() {
            try {
                const res = await fetch(`${baseURL}/api/v1/vignettes`);
                if (!res.ok) {
                    const message = `An error has occured: ${res.status} - ${res.statusText}`;
                    throw new Error(message);
                }
                const data = await res.json();
                const result = {
                    status: res.status + "-" + res.statusText,
                    headers: {
                        "Content-Type": res.headers.get("Content-Type"),
                        "Content-Length": res.headers.get("Content-Length"),
                    },
                    length: res.headers.get("Content-Length"),
                    data: data,
                };
                this.vignettesList = result.data;
                console.log(this.vignettesList);
            } catch (err) {
                this.vignettesList = err.message;
            }
        },
        async getVignettesById() {
            const id = this.$refs.get_id.value;
            if (id) {
                try {
                    const res = await fetch(`${baseURL}/vignettes/${id}`);
                    if (!res.ok) {
                        const message = `An error has occured: ${res.status} - ${res.statusText}`;
                        throw new Error(message);
                    }
                    const data = await res.json();
                    const result = {
                        data: data,
                        status: res.status,
                        statusText: res.statusText,
                        headers: {
                            "Content-Type": res.headers.get("Content-Type"),
                            "Content-Length": res.headers.get("Content-Length"),
                        },
                    };
                    this.vignette = result;
                    console.log(this.vignette);
                } catch (err) {
                    this.vignette = err.message;
                }
            }
        },
    },
    async created() {
        await this.getVignettes();
    }
}
</script>

<style scoped>
.container {
    margin: 30px auto
}

.btn-primary {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    vertical-align: middle;
    background-color: #42b983;
    border-color: #42b983;
}
</style>
