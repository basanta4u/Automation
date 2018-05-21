'use strict';

angular.module("todoApp.controllers", [])
    .controller("TodoListCtrl", function($scope, $rootScope, Todo){
    	$scope.name = "Allen";
    	$scope.todos = Todo.query();
    	console.log($scope.todos);
    	$scope.$on("updateTodos", function (event, todo) {
    		$scope.todos.push(todo);
        });
    	
    	 $scope.remove = function(idx){
             $scope.todos[idx].$remove(function(res){
                 $scope.todos.forEach(function(p, index) {
                     if (index == idx) $scope.todos.splice(index, 1);
                 });
             });
         };
         
         $scope.getdata=function(filename)
         {
        	 $scope.todos=Todo.query({id:filename});
        	 
         }
         
    })
    .controller("TodoDetailCtrl", function($scope, $routeParams, Todo){
        $scope.todo = Todo.get({id: $routeParams.todoId});
    })
    .controller("TodoAddCtrl", function($rootScope, $scope, Todo){
    	$scope.name = "";
    	$scope.owner = "";
    	$scope.priority = "Low";
    	
    	$scope.add = function(){
    		var todo = new Todo();
    		todo.name = $scope.name;
    		todo.owner = $scope.owner;
    		todo.priority = $scope.priority;
    		todo.$save(function(){
    			$rootScope.$broadcast("updateTodos", todo);
    		});
    	};
    })
    .controller("TodoUpdateCtrl", function($scope, $routeParams, $location, rmaService){
        	
    	$scope.key=$routeParams.currentKey;
    	$scope.value=$routeParams.updatedValue;
    	window.scrollTo(0, 0);
    	
    	$scope.update = function(){
    		var result=rmaService.update({key:$routeParams.currentKey,value:$routeParams.updatedValue,commentedflag:$routeParams.commentedflagValue});
    		//$location.path("/");
    		$location.path(window.location.href);
    		window.location.reload();
            
    	};
    });