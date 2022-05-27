var app = new Vue({
    el: '#app',
    data:{
        message: "bonjour tout le monde"
    }
    
})

var app2 = new Vue({
    el: '#app-2',
    data: {
      message: 'Vous avez affiché cette page le ' + new Date().toLocaleString()
    }
  })

  var app4 = new Vue({
    el: '#app-4',
    data: {
      todos: [
        { text: 'Apprendre JavaScript' },
        { text: 'Apprendre Vue' },
        { text: 'Créer quelque chose de génial' }
      ]
    }
  })


  Vue.component("testage-p", {
      template: "<p>template test</p>"
  })

  var test1 = new Vue({
      el: "#test1"
  })