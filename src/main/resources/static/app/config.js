angular.module('app')
.config(function ($routeProvider) {
    $routeProvider
        .when('/users', {
            templateUrl: 'app/components/users/list/userList.html',
            controller: 'UserListController',
            controllerAs: 'ctrl'
        })
        .when('/user-edit/:userId', {
            templateUrl: 'app/components/users/edit/userEdit.html',
            controller: 'UserEditController',
            controllerAs: 'ctrl'
        })
        .when('/user-add', {
            templateUrl: 'app/components/users/edit/userEdit.html',
            controller: 'UserEditController',
            controllerAs: 'ctrl'
        })
        .when('/user-assets/:userId', {
            templateUrl: 'app/components/users/assets/userAssets.html',
            controller: 'UserAssetsController',
            controllerAs: 'ctrl'
        })
        .when('/assets', {
            templateUrl: 'app/components/assets/list/assetList.html',
            controller: 'AssetListController',
            controllerAs: 'ctrl'
        })
        .when('/asset-edit/:assetId', {
            templateUrl: 'app/components/assets/edit/assetEdit.html',
            controller: 'AssetEditController',
            controllerAs: 'ctrl'
        })
        .when('/asset-add', {
            templateUrl: 'app/components/assets/edit/assetEdit.html',
            controller: 'AssetEditController',
            controllerAs: 'ctrl'
        })
        .when('/asset-history/:assetId', {
            templateUrl: 'app/components/assets/history/assetHistory.html',
            controller: 'AssetHistoryController',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/users'
        });
});