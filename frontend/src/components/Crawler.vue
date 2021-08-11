<template>
  <container>
    <h1>{{ msg }}</h1>
    <p>
      <label>Url</label>
      <input type="text" v-model="url" placeholder="Enter web page url here"/>
    </p>
    <p>
      <label>Word</label>
      <input type="text" v-model="word" placeholder="Enter word to search"/>
    </p>
    <p>
      <button @click="search()" :disabled='isDisabled'>Search</button>
    </p>

    <h1 v-if="result">
      <label>Result</label>
      {{ result.word }}:
      {{ result.count }}
    </h1>
  </container>


</template>

<script lang="ts">
import { defineComponent, ref } from 'vue'

export default defineComponent({
  name: 'Crawler',
  data: () => ({
    url: '',
    word: '',
    result: null
  }),
  methods: {
    async search() {
      const encodedUrl = encodeURIComponent(this.url)
      const fullUrl = `/api/mentions/count?word=${this.word}&url=${encodedUrl}`
      const response = await fetch(fullUrl)
      const result = await response.json()
      this.result = result
      console.log(result)
    }
  },
  props: {
    msg: {
      type: String,
      required: true
    }
  },
  setup: () => {
    const count = ref(0)
    return { count }
  },
  computed: {
    isDisabled() {
      return !(this.url && this.word)
    },
  },
})
</script>

<style scoped>
label {
  font-weight: bold;
  align-items: start;
  width: 10%;
}

input {
  flex-grow: 1;
}

code {
  background-color: #eee;
  padding: 2px 4px;
  border-radius: 4px;
  color: #304455;
}

container {
  display: flex;
  justify-content: center;
  align-content: center;
  flex-direction: column;
}

p {
  display: flex;
  justify-content: center;
}
</style>
