angular.module('LessonScheduler')
    .controller('SidebarCtrl', ['$scope', function ($scope) {
        $scope.menus = [
            {"name": "Yönetim Merkezi", "href": "#/dashboard", "icon": "fa-dashboard"},
            {"name": "Sınıf Yönetimi", "href": "#/classrooms", "icon": "fa-stack-overflow"},
            {"name": "Kısıt Yönetimi", "href": "#/constraints", "icon": "fa-users"},
            {"name": "Ders Yönetimi", "href": "#/lessons", "icon": "fa-pied-piper"},
            {"name": "Ders Seçimi", "href": "#/choose-lesson", "icon": "fa-level-up"}
            // {"name": "Madalyalar", "href": "#/medals", "icon": "fa-trophy"},
            // {"name": "Bildirilen Zafiyetler", "href": "#/reports", "icon": "fa-file-archive-o"},
            // {"name": "Zafiyet Tipleri", "href": "#/report-types", "icon": "fa-file-code-o"},
            // {"name": "Destek Mesajları", "href": "#/tickets", "icon": "fa-life-ring"},
            // {"name": "Duyurular", "href": "#/notices", "icon": "fa-bell"}
        ];
    }]);
