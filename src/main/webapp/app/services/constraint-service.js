angular.module('LessonScheduler')

    .factory('ConstraintService', ['$http', function ($http) {
        return {
            getConstraints: function () {
                return $http.get('/api/constraint/all');
            },
            createConstraint: function (formData) {
                return $http.post('/api/constraint', formData);
            },
            removeConstraint: function (constraintId) {
                return $http.delete('/api/constraint/' + constraintId);
            },
            updateConstraint: function (formData) {
                return $http.put('/api/constraint', formData);
            },
            getConstraint: function (constraintId) {
                return $http.get('/api/constraint/' + constraintId);
            }
        }
    }]);