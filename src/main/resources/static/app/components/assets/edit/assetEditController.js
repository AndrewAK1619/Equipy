angular.module('app')
.controller('AssetEditController', function($routeParams, $location, Asset, AssetService, CategoryService) {
    const vm = this;
    const assetId = $routeParams.assetId;
    if(assetId)
        vm.asset = AssetService.get(assetId);
    else
        vm.asset = new Asset();
    vm.categoryNames = CategoryService.getAllNames();

    const saveCallback = () => {
        $location.path(`/asset-edit/${vm.asset.id}`);
    };
    const errorCallback = err => {
        vm.msg=`Błąd zapisu: ${err.data.message}`;
    };

    vm.save = () => {
        console.log(vm.asset);
        AssetService.save(vm.asset)
            .then(saveCallback)
            .catch(errorCallback);
    };

    const updateCallback = response => vm.msg='Zapisano zmiany';
    vm.update = () => {
        AssetService.update(vm.asset)
            .then(updateCallback)
            .catch(errorCallback);
    };
});