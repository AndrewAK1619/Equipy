angular.module('app')
.constant('ASSET_ENDPOINT', '/api/assets/:id')
.constant('ASSET_ASSIGNMENTS_ENDPOINT', '/api/assets/:id/assignments')
.factory('Asset', function($resource, ASSET_ENDPOINT, ASSET_ASSIGNMENTS_ENDPOINT) {
    return $resource(ASSET_ENDPOINT, { id: '@_id' }, {
        update: {
            method: 'PUT'
        },
        getAssignments: {
            method: 'GET',
            url: ASSET_ASSIGNMENTS_ENDPOINT,
            params: {id: '@id'},
            isArray: true
        }
    });
})
.service('AssetService', function(Asset) {
    this.getAll = params => Asset.query(params);
    this.get = index => Asset.get({id: index});
    this.getAssignments = index => Asset.getAssignments({id: index});
    this.save = asset => asset.$save();
    this.update = asset => asset.$update({id: asset.id});
});