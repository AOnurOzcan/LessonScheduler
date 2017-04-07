angular.module('LessonScheduler')

    .controller('UserCtrl', ['$scope', '$state', 'UserService', 'ngNotify', '$timeout', '$rootScope',
        function ($scope, $state, UserService, ngNotify, $timeout, $rootScope) {

            $scope.registerUser = function (user) {
                UserService.registerUser(user).then(function () {
                    UserService.setCredentials(user);
                    $timeout(function () {
                        $state.go("login");
                    }, 1000);
                    ngNotify.set("Kayıt Başarılı. Lütfen giriş yapınız..", "success");
                }, function (error) {
                    ngNotify.set(error.data, "error");
                });
            };

            $scope.login = function (user) {
                UserService.login(user).then(function () {
                    UserService.setCredentials(user);
                    $timeout(function () {
                        $state.go("dashboard");
                    }, 1000);
                    ngNotify.set("Giriş Başarılı. Yönlendiriiyorsunuz..", "success");
                }, function () {
                    ngNotify.set("Kullanıcı adı ya da şifre hatalı!", "error");
                });
            }

        }]);
