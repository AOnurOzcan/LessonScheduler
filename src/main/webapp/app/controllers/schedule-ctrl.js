angular.module('LessonScheduler')
    .controller('ScheduleCtrl', ['$scope', '$rootScope', 'ScheduleService',
        function ($scope, $rootScope, ScheduleService) {

            $rootScope.parent = "Yönetim Paneli";
            $rootScope.path = "İstatistikler";
            $scope.eventSources = [{
                events: []
            }];

            //Haftalık takvim ile ilgili ayarlar yapılıyor.
            $scope.uiConfig = {
                calendar: {
                    allDaySlot: false,
                    allDayText: false,
                    slotDuration: '00:30:00',
                    slotLabelFormat: 'H:mm',
                    minTime: "09:00:00",
                    timezone: 'local',
                    dayNames: ['Pazar', 'Pazartesi', 'Salı', 'Çarşamba', 'Perşembe', 'Cuma', 'Cumartesi'],
                    firstDay: 1,
                    columnFormat: 'dddd',
                    now: new Date(),
                    locale: 'tr',
                    height: 500,
                    sticky: true,
                    defaultView: 'agendaWeek',
                    header: {
                        left: '',
                        right: ''
                    },
                    eventRender: function (event, element) {
                        element.find(".fc-title").append(" <br><br> (" + event.class + ")");
                        element.find(".fc-title").append(" <br>" + event.teacher);
                    }
                }
            };


            var date = new Date();
            var dayOfWeek = date.getDay() || 7;
            var day = date.getDate();
            var month = date.getMonth();
            var year = date.getFullYear();
            var showDay = day;

            //Ders programını sunucudan al
            ScheduleService.getSchedule().then(function (response) {
                //Haftalık takvime yerleştir.
                response.data.forEach(function (dbEvent) {
                    
                    showDay = day;
                    if (dbEvent.day > dayOfWeek) {
                        showDay += dbEvent.day - dayOfWeek;
                    } else {
                        showDay -= (dayOfWeek - dbEvent.day);
                    }

                    var event = {};
                    event.title = dbEvent.lesson.lessonName;
                    event.start = new Date(year, month, showDay, dbEvent.startTime);
                    event.end = new Date(year, month, showDay, dbEvent.endTime);
                    event.class = dbEvent.lesson.classRoom.classRoomNo;
                    event.teacher = dbEvent.lesson.user.name;
                    $scope.eventSources[0].events.push(event);
                });
            });

        }]);
