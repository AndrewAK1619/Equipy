package pl.example.equipy.components.inventory.asset;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class AssetService {
    
    private AssetRepository assetRepository;
    private AssetMapper assetMapper;

    AssetService(AssetRepository assetRepository, AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }

    List<AssetDto> findAll() {
        return assetRepository.findAll()
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }
    
    List<AssetDto> findAllByNameOrSerialNumber(String text) {
        return assetRepository.findAllByNameOrSerialNumber(text)
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }
    
    Optional<AssetDto> findById(Long id) {
        return assetRepository.findById(id).map(assetMapper::toDto);
    }
    
    AssetDto save(AssetDto asset) {
        Optional<Asset> assetBySerialNo = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetBySerialNo.ifPresent(a -> {
            throw new DuplicateSerialNumberException();
        });
        return mapAndSave(asset);
    }

    AssetDto update(AssetDto asset) {
        Optional<Asset> assetBySerialNo = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetBySerialNo.ifPresent(a -> {
            if(!a.getId().equals(asset.getId()))
                throw new DuplicateSerialNumberException();
        });
        return mapAndSave(asset);
    }

    private AssetDto mapAndSave(AssetDto asset) {
        Asset assetEntity = assetMapper.toEntity(asset);
        Asset savedAsset = assetRepository.save(assetEntity);
        return assetMapper.toDto(savedAsset);
    }
    
    List<AssetAssignmentDto> getAssetAssignments(Long id) {
        return assetRepository.findById(id)
                .map(Asset::getAssignments)
                .orElseThrow(AssetNotFoundException::new)
                .stream()
                .map(AssetAssignmentMapper::toDto)
                .collect(Collectors.toList());
    }
}