var HealthCare = angular.module('HealthCare', ['ngRoute','ui.bootstrap','firebase']);

HealthCare.config(function($routeProvider){
	$routeProvider

.when('/', {
		templateUrl:  'templates/main.html',
		controller :  'mainController',
	})
.when('/templates',{
		templateUrl: 'templates/form.html',
		controller:  'formController',
	})
.otherwise({
	redirectTo: '/'	
});
})

.constant('firebaseURL', 'burning-inferno-7783.firebaseapp.com');