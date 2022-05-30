
terrain = new Vue({
  el: "#terrain",
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
  template: "<div><a>{{x}}:{{y}}</a></div>"
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
