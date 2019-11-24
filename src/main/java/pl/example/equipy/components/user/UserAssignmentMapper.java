package pl.example.equipy.components.user;

import pl.example.equipy.components.assignment.Assignment;
import pl.example.equipy.components.inventory.asset.Asset;

class UserAssignmentMapper {

    static UserAssignmentDto toDto(Assignment assignment) {
        UserAssignmentDto dto = new UserAssignmentDto();
        dto.setId(assignment.getId());
        dto.setAssetId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        Asset asset = assignment.getAsset();
        dto.setAssetName(asset.getName());
        dto.setAssetSerialNumber(asset.getSerialNumber());
        return dto;
    }

}