angular.module('LessonScheduler')

    .factory('LessonService', ['$http', function ($http) {
        return {
            getLessons: function () {
                return $http.get('/api/lesson/all');
            },
            createLesson: function (formData) {
                return $http.post('/api/lesson', formData);
            },
            removeLesson: function (lessonId) {
                return $http.delete('/api/lesson/' + lessonId);
            },
            updateLesson: function (formData) {
                return $http.put('/api/lesson', formData);
            },
            getLesson: function (lessonId) {
                return $http.get('/api/lesson/' + lessonId);
            },
            getNotChosenLessons: function () {
                return $http.get('/api/lesson/notChosen');
            },
            saveMultiLesson: function (lessons) {
                return $http.post('/api/lesson/multi', lessons);
            }
        }
    }]);