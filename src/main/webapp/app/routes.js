angular.module('LessonScheduler', ['ui.router', 'ngNotify', 'ui.bootstrap'])

    .run(['$rootScope', '$location', 'UserService', '$http', '$state', 'ngNotify',
        function ($rootScope, $location, UserService, $http, $state, ngNotify) {

            ngNotify.config({
                theme: 'pure',
                position: 'bottom',
                duration: 500,
                type: 'info',
                sticky: false,
                html: false
            });

            $rootScope.$on('$locationChangeStart', function (event, next, current) {

                if ($location.path() != "/login" && $location.path() != "/register") {
                    UserService.checkAuth().then(function (user) {
                        UserService.setCredentials(user.data);
                    }, function (error) {
                        if (error.status == 401) {
                            $state.go("login");
                        }
                    });
                }

            });
        }
    ])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        $stateProvider

            .state('login', {
                url: '/login',
                views: {
                    "full": {
                        templateUrl: "app/templates/user/login-form.html",
                        controller: "UserCtrl"
                    }
                }
            })

            .state('register', {
                url: '/register',
                views: {
                    "full": {
                        templateUrl: "app/templates/user/registration-form.html",
                        controller: "UserCtrl"
                    }
                }
            })

            .state('dashboard', {
                url: '/dashboard',
                views: {
                    "header": {
                        templateUrl: "app/templates/header/header.html",
                        controller: "HeaderCtrl"
                    },
                    "sidebar": {
                        templateUrl: "app/templates/sidebar/sidebar.html",
                        controller: "SidebarCtrl"
                    },
                    "content": {
                        templateUrl: "app/templates/dashboard/dashboard.html",
                        controller: "DashboardCtrl"
                    }
                }
            })

            .state('classrooms', {
                url: '/classrooms',
                views: {
                    "header": {
                        templateUrl: "app/templates/header/header.html",
                        controller: "HeaderCtrl"
                    },
                    "sidebar": {
                        templateUrl: "app/templates/sidebar/sidebar.html",
                        controller: "SidebarCtrl"
                    },
                    "content": {
                        templateUrl: "app/templates/classroom/classrooms.html",
                        controller: "ClassroomController"
                    }
                }
            })

            .state('add-classroom', {
                url: '/add-classroom',
                views: {
                    "header": {
                        templateUrl: "app/templates/header/header.html",
                        controller: "HeaderCtrl"
                    },
                    "sidebar": {
                        templateUrl: "app/templates/sidebar/sidebar.html",
                        controller: "SidebarCtrl"
                    },
                    "content": {
                        templateUrl: "app/templates/classroom/add-classroom.html",
                        controller: "ClassroomController"
                    }
                }
            })

            .state('edit-classroom', {
                url: '/edit-classroom/:id',
                views: {
                    "header": {
                        templateUrl: "app/templates/header/header.html",
                        controller: "HeaderCtrl"
                    },
                    "sidebar": {
                        templateUrl: "app/templates/sidebar/sidebar.html",
                        controller: "SidebarCtrl"
                    },
                    "content": {
                        templateUrl: "app/templates/classroom/edit-classroom.html",
                        controller: "ClassroomController"
                    }
                }
            });

        $urlRouterProvider.otherwise("/");

    }]);
