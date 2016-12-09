(function(app){
  app.filter('money',function(){
    return (input) => {
      return 'S./'+input;
    }
  })
})(app)