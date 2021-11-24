<template>
    <div class="user">
        <p>{{firstname}}</p>
    </div>
</template>

<script>
export default {
  name: 'User',
  props: {
      firstname: String,
      lastname: String
  },
  methods: {
    getList() {
      this.$http.get("http://8081/User").then((response) => {
        console.log(response.data)
      })
    }
  }
}
</script>
