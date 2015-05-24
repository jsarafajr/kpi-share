app.controller("TaskController", TaskController);

TaskController.$inject = ["$scope", "taskService"];

function TaskController($scope, taskService) {
    $scope.task = {};

    $scope.createTask = function() {
        taskService.createTask($scope.task).then(function() {
            alert("Новое задание создано");
            $scope.task = {};
        });
    }
}