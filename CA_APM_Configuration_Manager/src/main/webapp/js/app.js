'use strict';

angular.module('todoApp', [
	'ngRoute',
    'todoApp.services',
    'updateService',
    'todoApp.controllers'
]).config(function($routeProvider) {
	  $routeProvider.when('/', {templateUrl: 'partial/list.html'});
	  $routeProvider.when('/:todoId', {templateUrl: 'partial/list.html'});
	  $routeProvider.when('/todoUpdate/:currentKey/:updatedValue/:commentedflagValue', {templateUrl: 'partial/update.html', controller: 'TodoUpdateCtrl'});
	  $routeProvider.otherwise({redirectTo: '/'});
	});
