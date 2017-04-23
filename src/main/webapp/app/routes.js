angular.module('LessonScheduler', ['ui.router', 'ngNotify', 'ui.bootstrap', 'ui.calendar'])

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

            .state('schedule', {
                url: '/schedule',
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
                        templateUrl: "app/templates/schedule/schedule.html",
                        controller: "ScheduleCtrl"
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
            })

            .state('constraints', {
                url: '/constraints',
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
                        templateUrl: "app/templates/constraint/constraints.html",
                        controller: "ConstraintController"
                    }
                }
            })

            .state('add-constraint', {
                url: '/add-constraint',
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
                        templateUrl: "app/templates/constraint/add-constraint.html",
                        controller: "ConstraintController"
                    }
                }
            })

            .state('edit-constraint', {
                url: '/edit-constraint/:id',
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
                        templateUrl: "app/templates/constraint/edit-constraint.html",
                        controller: "ConstraintController"
                    }
                }
            })
            
            .state('lessons', {
                url: '/lessons',
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
                        templateUrl: "app/templates/lesson/lessons.html",
                        controller: "LessonController"
                    }
                }
            })

            .state('add-lesson', {
                url: '/add-lesson',
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
                        templateUrl: "app/templates/lesson/add-lesson.html",
                        controller: "LessonController"
                    }
                }
            })

            .state('edit-lesson', {
                url: '/edit-lesson/:id',
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
                        templateUrl: "app/templates/lesson/edit-lesson.html",
                        controller: "LessonController"
                    }
                }
            })

            .state('choose-lesson', {
                url: '/choose-lesson',
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
                        templateUrl: "app/templates/chooseLesson/choose-lesson.html",
                        controller: "ChooseLessonController"
                    }
                }
            })
            
            .state('generate-schedule', {
                url: '/generate-schedule',
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
                        templateUrl: "app/templates/generateSchedule/generate-schedule.html",
                        controller: "GenerateScheduleController"
                    }
                }
            });

        $urlRouterProvider.otherwise("/");

    }]);
