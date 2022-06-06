<template>
<div class="form-box">
    <h1>New User</h1>
    <div class="form-group">
        <label for="first_name">First name</label>
        <input class="form-control" id="first_name" type="text" name="First_name" v-model="first_name">
    </div>
    <div class="form-group">
        <label for="last_name">Last name</label>
        <input class="form-control" id="last_name" type="text" name="Last_name" v-model="last_name">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input class="form-control" id="email" type="email" name="Email" v-model="email">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input class="form-control" id="password" type="text" name="Password" v-model="password">
    </div>
    <input class="btn btn-primary" type="submit" value="Submit" v-on:click="createUser" />
</div>
</template>

<script>
const baseURL = "http://localhost:3000";
export default {
    name: 'SignUpView',
    data() {
        return {
            first_name: "Goran",
            last_name: "Kirov",
            email: "",
            password: "",
        }
    },
    methods: {
        async createUser() {
            try {
                const postData = {
                    first_name: this.first_name,
                    last_name: this.last_name,
                    email: this.email,
                    password: this.password
                }
                const res = await fetch(`${baseURL}/users`, {
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
                    name: 'users'
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
