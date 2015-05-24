app.controller("TaskController", TaskController);

TaskController.$inject = ["$scope", "taskService"];

function TaskController($scope, taskService) {
    $scope.task = {};

    $scope.allTasks = [];


    taskService.getAllTasks().then(function(tasks) {
        $scope.allTasks = tasks;
    });

    $scope.createTask = function() {
        taskService.createTask($scope.task).then(function() {
            alert("Новое задание создано");
            $scope.task = {};
        });
    }


}