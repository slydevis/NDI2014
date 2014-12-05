angular.module('HealthCare')

HealthCare.controller('mainController', function($scope){
});

HealthCare.controller('CarouselDemoCtrl', function ($scope) {
  $scope.myInterval = 5000;
  var slides = $scope.slides = [];
  $scope.addSlide = function() {
    var newWidth = 600 + slides.length + 1;
    slides.push({
      image: 'http://placekitten.com/' + newWidth + '/300',
      text: ['More','Extra','Lots of','Surplus'][slides.length % 4] + ' ' +
        ['Cats', 'Kittys', 'Felines', 'Cutes'][slides.length % 4]
    });
  };
  for (var i=0; i<4; i++) {
    $scope.addSlide();
  }
})

.controller('FormCtrl', function($scope, $q, $state, UserBase, Stock){
  $scope.data = {
    user: Stock.get('user'),
    saving: false,
  };
  
  $scope.save = function(profile){
    $scope.data.saving = true;
      var user = Stock.get('user') || {};
      if(!user.created){user.created = Date.now();}
      user.id = results[0];
      user.profile = profile;
      }
});