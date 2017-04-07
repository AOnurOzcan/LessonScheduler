angular.module('LessonScheduler')

    .controller('ChooseLessonController', ['$scope', '$state', 'LessonService', 'ngNotify', '$timeout', '$rootScope',
        function ($scope, $state, LessonService, ngNotify, $timeout, $rootScope) {

            $rootScope.parent = "Yönetim Paneli";
            $rootScope.path = "Ders Seçimi";

            LessonService.getNotChosenLessons().then(function (response) {
                response.data.forEach(function (lesson) {
                    if (lesson.user != undefined && lesson.user.id == $rootScope.currentUser.id) {
                        lesson.checked = true;
                    } else {
                        lesson.checked = false;
                    }
                });
                $scope.lessons = response.data;
            });

            $scope.saveLessonChoice = function (lessons) {
                var lessonsToSave = [];
                lessons.forEach(function (lesson) {
                    lesson.user = lesson.user == undefined ? {} : lesson.user;
                    if (lesson.checked == true) {
                        lesson.user.id = $rootScope.currentUser.id;
                    } else {
                        lesson.user.id = null;
                    }
                    delete lesson.checked;
                    lessonsToSave.push(lesson);
                });

                LessonService.saveMultiLesson(lessonsToSave).then(function () {
                    
                    ngNotify.set("Dersler başarıyla seçildi.", "success");
                    LessonService.getNotChosenLessons().then(function (response) {
                        response.data.forEach(function (lesson) {
                            if (lesson.user != undefined && lesson.user.id == $rootScope.currentUser.id) {
                                lesson.checked = true;
                            } else {
                                lesson.checked = false;
                            }
                        });
                        $scope.lessons = response.data;
                    });
                });
            }

        }]);
