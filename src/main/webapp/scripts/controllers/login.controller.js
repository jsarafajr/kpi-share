app.controller("LoginController", LoginController);

LoginController.$inject = ["$scope", "userService"];

function LoginController($scope, userService) {
    $scope.newUser = {};

    $scope.register = function() {
        userService.registerUser($scope.newUser).then(function() {
            alert("Зарегестрировано");
            location.reload();
        });
    }
}