package pl.example.equipy.components.inventory.asset;

import pl.example.equipy.components.assignment.Assignment;
import pl.example.equipy.components.user.User;

public class AssetAssignmentMapper {

    static AssetAssignmentDto toDto(Assignment assignment) {
        AssetAssignmentDto dto = new AssetAssignmentDto();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());

        User user = assignment.getUser();
        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }
}