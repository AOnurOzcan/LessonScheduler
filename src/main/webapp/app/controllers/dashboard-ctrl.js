angular.module('LessonScheduler')
    .controller('DashboardCtrl', ['$scope', '$rootScope',
        function ($scope, $rootScope) {

            $rootScope.parent = "Yönetim Paneli";
            $rootScope.path = "İstatistikler";

            $scope.eventSources = [{
                events: [
                    {
                        title: 'event3',
                        start: '2017-04-07T12:30:00'
                    }]
            }];


            /* config object */
            $scope.uiConfig = {
                calendar: {
                    allDaySlot: false,
                    allDayText: false,
                    slotDuration: '00:30:00',
                    slotLabelFormat: 'H:mm',
                    minTime: "09:00:00",
                    timezone: 'local',
                    dayNames: ['Pazar', 'Pazartesi', 'Salı', 'Çarşamba', 'Perşembe', 'Cuma', 'Cumartesi'],
                    columnFormat: 'dddd',
                    now: new Date(),
                    locale: 'tr',
                    height: 500,
                    defaultView: 'agendaWeek',
                    header: {
                        left: '',
                        right: 'month,agendaWeek,agendaDay,today prev,next'
                    }
                }
            };


        }]);
