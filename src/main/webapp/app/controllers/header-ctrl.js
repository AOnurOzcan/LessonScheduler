angular.module('LessonScheduler')
    .controller('HeaderCtrl', ['$scope', '$state', 'UserService', function ($scope, $state, UserService) {

        $scope.logout = function () {
            UserService.invalidateSession().then(function () {
                $state.go("login");
            });
        };

    }]);
