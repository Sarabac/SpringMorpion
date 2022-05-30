
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
  props:["x", "y"],
  data: function(){
    return {
      marque: ""
    }
  },
  template: "<a>{{x}}:{{y}}</a>"
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
