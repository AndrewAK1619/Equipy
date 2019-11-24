angular.module('app')
.controller('UserAssetsController', function($routeParams, UserService, AssignmentEndService) {
    const vm = this;
    const userId = $routeParams.userId;
    vm.user = UserService.get(userId);
    vm.assignments = UserService.getAssignments(userId);

    vm.finishAssignment = assignment => {
        AssignmentEndService.save(assignment.id)
            .then(response => {
                assignment.end = response.data;
            });
    };
});