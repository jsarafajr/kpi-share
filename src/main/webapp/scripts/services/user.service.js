app.factory("userService", userService);

userService.$inject = ["$http"];

function userService($http) {
    return {
        registerUser: function(user) {
            return $http.post("/api/user", user).then();
        }
    }
}