angular.module('LessonScheduler')

.controller('GenerateScheduleController', ['$scope','ScheduleService', 'ngNotify', function ($scope, ScheduleService, ngNotify) {
    
    $scope.generateSchedule = function () {
        ScheduleService.generateSchedule().then(function () {
            ngNotify.set('Ders programı başarıyla oluşturuldu', 'success');
        });
    }
    
}]);