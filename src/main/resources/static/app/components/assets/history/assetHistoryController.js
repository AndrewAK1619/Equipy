angular.module('app')
.controller('AssetHistoryController', function ($routeParams,
                                                AssetService,
                                                Assignment, AssignmentService, AssignmentEndService,
                                                UserService) {
    const vm = this;
    const assetId = $routeParams.assetId;
    vm.asset = AssetService.get(assetId);
    const refreshData = () => {
        vm.assigned = false;
        vm.assignments = AssetService.getAssignments(assetId);
        vm.assignments.$promise.then(assignments => {
            const activeAssignment = vm.assignments.filter(a => a.end == null);
            if(activeAssignment.length) {
                vm.assigned = true;
            }
        });
    };

    const errorCallback = err => {
        vm.msg=`Błąd zapisu: ${err.data.message}`;
    };
    vm.finishAssignment = assignment => {
        AssignmentEndService.save(assignment.id)
            .then(response => {
                assignment.end = response.data;
                vm.assigned = false;
            })
            .catch(errorCallback);
    };
    vm.search = lastName => {
        vm.users = UserService.getAll({lastName});
    };

    vm.assignToUser = user => {
        const assignment = new Assignment();
        assignment.userId = user.id;
        assignment.assetId = vm.asset.id;
        AssignmentService.save(assignment)
            .then(refreshData)
            .catch(errorCallback);
    };
    refreshData();
});