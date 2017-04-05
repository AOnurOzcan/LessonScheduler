angular.module('LessonScheduler')
    .controller('MasterCtrl', ['$scope', MasterCtrl]);

function MasterCtrl($scope) {

    $scope.toggle = true;

    $scope.toggleSidebar = function () {
        $scope.toggle = !$scope.toggle;
    };
}