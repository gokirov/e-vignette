<template>
<div class="form-box">
    <h1>New Vignette</h1>
    <div class="form-group">
        <label for="first_name">First name</label>
        <input class="form-control" id="first_name" type="text" name="First_name" v-model="first_name">
    </div>
    <div class="form-group">
        <label for="last_name">Last name</label>
        <input class="form-control" id="last_name" type="text" name="Last_name" v-model="last_name">
    </div>
    <div class="form-group">
        <label for="plate_number">Plate number</label>
        <input class="form-control" id="plate_number" type="plate_number" name="Plate_number" v-model="plate_number">
    </div>
    <div class="form-group">
        <label for="date">Date</label>
        <input class="form-control" id="date" type="text" name="Date" v-model="date">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit" v-on:click="createVignette" />
</div>
</template>

<script>
const baseURL = "http://localhost:8080/api/v1";
export default {
    name: 'VignetteAdd',
    data() {
        return {
            first_name: "Goran",
            last_name: "Kirov",
            plate_number: "123",
            date: "2022-15-05",
        }
    },
    methods: {
        async createVignette() {
            try {
                const postData = {
                    firstName: this.first_name,
                    lastName: this.last_name,
                    plateNumber: this.plate_number
                }
                const res = await fetch(`${baseURL}/vignettes`, {
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
                this.$router.push({
                    name: 'vignettes'
                });
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
