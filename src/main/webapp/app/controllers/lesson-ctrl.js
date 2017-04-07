angular.module('LessonScheduler')

    .controller('LessonController', ['$scope', '$state', 'LessonService', 'ClassroomService', 'ngNotify', '$timeout', '$rootScope',
        function ($scope, $state, LessonService, ClassroomService, ngNotify, $timeout, $rootScope) {

            $rootScope.parent = "Yönetim Paneli";
            $rootScope.path = "Ders Yönetimi";

            if ($state.is('edit-lesson')) {

                ClassroomService.getClassrooms().then(function (response) {
                    $scope.classrooms = response.data;

                    LessonService.getLesson($state.params.id).then(function (response) {
                        response.data.classRoom.id = response.data.classRoom.id.toString();
                        $scope.lesson = response.data;
                    });
                });
            }

            if ($state.is('add-lesson')) {
                ClassroomService.getClassrooms().then(function (response) {
                    $scope.classrooms = response.data;
                });
            }

            if ($state.is('lessons')) {
                LessonService.getLessons().then(function (response) {
                    $scope.lessons = response.data;
                });
            }

            $scope.removeLesson = function (id) {
                LessonService.removeLesson(id).then(function (response) {
                    LessonService.getLessons().then(function (response) {
                        $scope.lessons = response.data;
                    });
                });
            };

            $scope.createLesson = function (lesson) {
                LessonService.createLesson(lesson).then(function () {
                    $timeout(function () {
                        $state.go('lessons');
                    }, 1000);
                    ngNotify.set("Ders başarılı bir şekilde eklendi.", "success");
                });
            };

            $scope.updateLesson = function (lesson) {
                LessonService.updateLesson(lesson).then(function () {
                    $timeout(function () {
                        $state.go('lessons');
                    }, 1000);
                    ngNotify.set("Ders başarılı bir şekilde düzenlendi", "success");
                });
            };

        }]);
