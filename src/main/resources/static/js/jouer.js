
terrain1 = new Vue({
  el: "#terrain1",
  data: function(){
    return{
      dims: []
    }
  },
  created(){
    axios.get('http://localhost:8080/api/jouer/4/dim')
      .then(response => (this.dims = response.data))
  },
  computed: {
    nbX: function(){
      return this.dims[0]
    },
    nbY: function(){
      return this.dims[1]
    }

  }
})


Vue.component("Case", {
  props:{
    x: Number,
    y: Number
  },
  data: function(){
    return {
      marque: ""
    }
  },
  methods:{
    cliquer: function(){
      chargement = {
        x: this.x,
        y: this.y
      }
      reponse = axios.post("/marque", chargement)
      console.log(reponse.data)
    }
  },

  template: "<a>{{x}}:{{y}}</a>"
})


terrain2 = new Vue({
  el: "#terrain2",
  data: function(){
    return{
      dims: [],
      grille: [{}]
    }
  },
  created(){
    axios.get('/4/dim')
      .then(response => (this.dims = response.data))
  },
  computed: {
    nbX: function(){
      return this.dims[0]
    },
    nbY: function(){
      return this.dims[1]
    }

  }
})


app1 = new Vue({
  el: '#app',
  data: {
    dim: [],
    intevalle: undefined
  },
  created() {
    this.getDims
    this.intevalle = setInterval(this.getDims, 1000)
  },
  methods: {
    getDims: function(){
      axios
        .get('http://localhost:8080/api/jouer/4/dim')
        .then(response => (this.dim = response.data))
    }
  }
})
