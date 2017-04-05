angular.module('LessonScheduler')
    .controller('SidebarCtrl', ['$scope', function ($scope) {
        $scope.menus = [
            {"name": "Yönetim Merkezi", "href": "#/dashboard", "icon": "fa-dashboard"},
            {"name": "Sınıf Yönetimi", "href": "#/classrooms", "icon": "fa-stack-overflow"}
            // {"name": "Kullanıcılar", "href": "#/users", "icon": "fa-users"},
            // {"name": "Markalar", "href": "#/brands", "icon": "fa-pied-piper"},
            // {"name": "Level Yönetimi", "href": "#/levels", "icon": "fa-level-up"},
            // {"name": "Madalyalar", "href": "#/medals", "icon": "fa-trophy"},
            // {"name": "Bildirilen Zafiyetler", "href": "#/reports", "icon": "fa-file-archive-o"},
            // {"name": "Zafiyet Tipleri", "href": "#/report-types", "icon": "fa-file-code-o"},
            // {"name": "Destek Mesajları", "href": "#/tickets", "icon": "fa-life-ring"},
            // {"name": "Duyurular", "href": "#/notices", "icon": "fa-bell"}
        ];
    }]);
