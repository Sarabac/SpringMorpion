const { createApp } = Vue

terrain = createApp({
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

terrain.component("case", {
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
        .then(reponse =>this.remplir())
      
      
    },
    remplir: function(){
      axios.get("case/" + this.x + "/" + this.y)
        .then(response => {
          this.symbole = response.data[0]
          this.couleur = response.data[1]
        })
    }
  },

  template: "<td v-bind:style={color:couleur} @click = 'cliquer'>{{symbole}}</td>"
})

terrain.mount("#terrain")
