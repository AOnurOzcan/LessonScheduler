angular.module('LessonScheduler')

    .factory('UserService', ['$http', '$rootScope', function ($http, $rootScope) {
        return {
            registerUser: function (user) {
                return $http.post('/api/user/register', user);
            },
            checkAuth: function () {
                return $http.get('/api/user/authentication');
            },
            invalidateSession: function () {
                return $http.get('/api/user/logout');
            },
            login: function (user) {
                return $http.post("/api/user/login", user);
            },
            saveLessonInterval: function (user) {
                return $http.post("/api/user/lessonInterval", user);
            },
            getUser: function (userId) {
                return $http.get("/api/user/" + userId);
            },
            setCredentials: function (user) {
                $rootScope.currentUser = {
                    id: user.id,
                    name: user.name,
                    username: user.username,
                    accountType: user.accountType
                }
            }
        }
    }]);