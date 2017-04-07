angular.module('LessonScheduler')

    .filter('dayNames', [function () {
        return function (dayNo) { //1 = January
            var dayNames = ['Pazartesi', 'Salı', 'Çarşamba', 'Perşembe', 'Cuma', 'Cumartesi', 'Pazar'];
            return dayNames[dayNo - 1];
        }
    }]);