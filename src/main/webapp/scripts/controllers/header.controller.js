app.controller("HeaderController", HeaderController);

HeaderController.$inject = ["$scope"];

function HeaderController($scope) {
    $scope.logout = function() {
        location.href = "/logout"
    }
}