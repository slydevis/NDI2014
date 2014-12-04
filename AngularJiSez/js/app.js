var HealthCare = angular.module('HealthCare', ['ngRoute','ui.bootstrap']);

HealthCare.config(function($routeProvider){
	$routeProvider

.when('/', {
		templateUrl: 'templates/main.html',
		controller :  'mainController',
	})
.otherwise({
	redirectTo: '/'	
});
})

.constant('', ''+(Config.debug ? '/dev' : ''));