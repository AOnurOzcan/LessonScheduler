angular.module('LessonScheduler')

    .factory('ScheduleService', ['$http', function ($http) {
        return {
            getSchedule: function () {
                return $http.get('/api/schedule/all');
            },
            generateSchedule: function () {
                return $http.get('/api/schedule/calculate');
            }
        }
    }]);