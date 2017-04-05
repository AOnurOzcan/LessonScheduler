angular.module('LessonScheduler')

    .factory('ClassroomService', ['$http', function ($http) {
        return {
            getClassrooms: function () {
                return $http.get('/api/classroom/all');
            },
            createClassroom: function (formData) {
                return $http.post('/api/classroom', formData);
            },
            removeClassroom: function (classroomId) {
                return $http.delete('/api/classroom/' + classroomId);
            },
            updateClassroom: function (formData) {
                return $http.put('/api/classroom', formData);
            },
            getClassroom: function (classroomId) {
                return $http.get('/api/classroom/' + classroomId);
            }
        }
    }]);