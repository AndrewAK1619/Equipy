angular.module('app')
.constant('CATEGORY_NAMES_ENDPOINT', '/api/categories/names')
.service('CategoryService', function($resource, CATEGORY_NAMES_ENDPOINT) {
    this.getAllNames = () => $resource(CATEGORY_NAMES_ENDPOINT).query();
});