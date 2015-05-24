app.factory("taskService", taskService);

taskService.$inject = ["$http"];

function taskService($http) {
    return {
        createTask: function(task) {
            return $http.post("/api/task", task).then();
        },

        getAllTasks: function() {
            return $http.get("/api/task/list").then(function(response) {
                return response.data;
            });
        }
    }
}