

terrain1 = new Vue({
  el: "#terrain",
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


Vue.component("case", {
  props:{
    x: Number,
    y: Number
  },
  data: function(){
    return {
      symbole: " ",
      couleur: "black"
    }
  },
  created(){
    this.remplir()
    setInterval(this.remplir, 1000)
  },
  methods:{
    cliquer: function(){
      chargement = {
        x: this.x,
        y: this.y
      }
      reponse = axios.post("marque", chargement)
      console.log(reponse.data)
    },
    remplir: function(){
      axios.get("case/" + this.x + "/" + this.y)
        .then(response => {
          this.symbole = response.data[0]
          this.couleur = response.data[1]
        })
    }
  },

  template: "<td v-bind:style={color:couleur}><p>{{symbole}}</p></td>"
})


