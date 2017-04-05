angular.module('LessonScheduler')
    .controller('DashboardCtrl', ['$scope', '$rootScope',
        function ($scope, $rootScope) {

            $rootScope.parent = "Yönetim Paneli";
            $rootScope.path = "İstatistikler";

        }]);
