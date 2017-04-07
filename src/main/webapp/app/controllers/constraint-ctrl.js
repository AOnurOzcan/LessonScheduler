angular.module('LessonScheduler')

    .controller('ConstraintController', ['$scope', '$state', 'ConstraintService', 'UserService', 'ngNotify', '$timeout', '$rootScope',
        function ($scope, $state, ConstraintService, UserService, ngNotify, $timeout, $rootScope) {

            $rootScope.parent = "Yönetim Paneli";
            $rootScope.path = "Kısıt Yönetimi";

            if ($state.is('edit-constraint')) {
                ConstraintService.getConstraint($state.params.id).then(function (response) {
                    //Html selectbox value olarak string kabul ettiği için değeri stringe dönüştürdük.
                    response.data.availableDay = response.data.availableDay.toString();
                    $scope.constraint = response.data;
                });
            }

            if ($state.is('constraints')) {
                ConstraintService.getConstraints().then(function (response) {
                    $scope.constraints = response.data;
                });
                UserService.getUser($rootScope.currentUser.id).then(function (response) {
                    $scope.user = response.data;
                });
            }

            $scope.saveLessonInterval = function (user) {
                user.id = $rootScope.currentUser.id;
                UserService.saveLessonInterval(user).then(function () {
                    ngNotify.set("Başarıyla kaydedildi!", "success");
                });
            };

            $scope.removeConstraint = function (id) {
                ConstraintService.removeConstraint(id).then(function (response) {
                    ConstraintService.getConstraints().then(function (response) {
                        $scope.constraints = response.data;
                    });
                });
            };

            $scope.createConstraint = function (constraint) {
                constraint.user = {};
                constraint.user.id = $rootScope.currentUser.id;
                ConstraintService.createConstraint(constraint).then(function () {
                    $timeout(function () {
                        $state.go('constraints');
                    }, 1000);
                    ngNotify.set("Kısıt başarılı bir şekilde eklendi.", "success");
                });
            };

            $scope.updateConstraint = function (constraint) {
                ConstraintService.updateConstraint(constraint).then(function () {
                    $timeout(function () {
                        $state.go('constraints');
                    }, 1000);
                    ngNotify.set("Kısıt başarılı bir şekilde düzenlendi", "success");
                });
            }

        }]);
