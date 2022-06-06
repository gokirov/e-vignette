<template>
<div class="form-box">
    <h1>Check Vignette</h1>
    <div class="form-group">
        <label for="plate_number">Plate Number</label>
        <input class="form-control" id="plate_number" type="text" name="Plate_number" v-model="plate_number">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit" v-on:click="checkVignette" />

</div>
</template>

<script>
const baseURL = "http://localhost:8080";
export default {
    name: 'ValidityCheck',
    data() {
        return {
            plate_number: "Goran",
            status: ""
        }
    },
    methods: {
        async checkVignette() {
            try {
                const postData = {
                    plate_number: this.plate_number
                }
                const res = await fetch(`${baseURL}/validity`, {
                    method: "post",
                    headers: {
                        "Content-Type": "application/json",
                        "x-access-token": "token-value",
                    },
                    body: JSON.stringify(postData),
                });
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
                    data: data,
                };
                console.log(result);
                this.status = data;
            } catch (err) {
                this.postResult = err.message;
            }
        },
    }
}
</script>

<style scoped>
body {
    background: #42b983;
}

.form-box {
    max-width: 500px;
    margin: auto;
    padding: 50px;
    background: #ffffff;
    border: 10px solid #42b983;
}

.btn-primary {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    vertical-align: middle;
    background-color: #42b983;
    border-color: #42b983;
}

h1,
p {
    text-align: center;
}

input,
textarea {
    width: 100%;
}
</style>
