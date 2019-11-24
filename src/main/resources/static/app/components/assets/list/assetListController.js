angular.module('app')
.controller('AssetListController', function(AssetService) {
    const vm = this;
    vm.assets = AssetService.getAll();
    vm.search = text => {
        vm.assets = AssetService.getAll({text});
    };
});