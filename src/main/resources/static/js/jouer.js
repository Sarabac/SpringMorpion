
terrain1 = new Vue({
  el: "#terrain1",
  data: function(){
    return{
      dims: []
    }
  },
  created(){
    axios.get('dim')
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
      reponse = axios.post("marque", chargement)
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
    axios.get('dim')
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

