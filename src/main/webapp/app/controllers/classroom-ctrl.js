angular.module('LessonScheduler')

    .controller('ClassroomController', ['$scope', '$state', 'ClassroomService', 'ngNotify', '$timeout', '$rootScope', function ($scope, $state, ClassroomService, ngNotify, $timeout, $rootScope) {

        $rootScope.parent = "Yönetim Paneli";
        $rootScope.path = "Sınıf Yönetimi";

        if ($state.is('edit-classroom')) {
            ClassroomService.getClassroom($state.params.id).then(function (response) {
                $scope.classroom = response.data;
            });
        }

        if ($state.is('classrooms')) {
            ClassroomService.getClassrooms().then(function (response) {
                $scope.classrooms = response.data;
            });
        }

        $scope.removeClassroom = function (id) {
            ClassroomService.removeClassroom(id).then(function (response) {
                ClassroomService.getClassrooms().then(function (response) {
                    $scope.classrooms = response.data;
                });
            });
        };

        $scope.createClassroom = function (classroom) {
            ClassroomService.createClassroom(classroom).then(function () {
                $timeout(function () {
                    $state.go('classrooms');
                }, 1000);
                ngNotify.set("Sınıf başarılı bir şekilde eklendi.", "success");
            });
        };

        $scope.updateClassroom = function (classroom) {
            ClassroomService.updateClassroom(classroom).then(function () {
                $timeout(function () {
                    $state.go('classrooms');
                }, 1000);
                ngNotify.set("Sınıf başarılı bir şekilde düzenlendi", "success");
            });
        }

    }]);
