'use strict';

angular.module("todoApp.services", ["ngResource"])
    .factory("Todo", function($resource){
    	return $resource('rest/todos/:id', {id:'@id'});
    });

angular.module('updateService', ['ngResource'])
.factory('rmaService', ['$resource',
    function ($resource) {
        return $resource(
               'rest/todos/:key/value/commentedflag',{},
               {
                  update: { method: 'PUT', params: {key : '@key',
						value : '@value',
						commentedflag : '@commentedflag'}},
                });
    }]);