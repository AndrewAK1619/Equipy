package pl.example.equipy.components.inventory.asset;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetResource {

    private AssetService assetService;

    public AssetResource(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("")
    public List<AssetDto> findAll(@RequestParam(required = false) String text) {
        if(text != null)
            return assetService.findAllByNameOrSerialNumber(text);
        else
            return assetService.findAll();
    }
    
    @PostMapping("")
    public ResponseEntity<AssetDto> save(@RequestBody AssetDto asset) {
        if(asset.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zapisywany obiekt nie może mieć ustawionego id");
        AssetDto savedAsset = assetService.save(asset);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAsset.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedAsset);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AssetDto> findById(@PathVariable Long id) {
        return assetService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AssetDto> update(@PathVariable Long id,
                                           @RequestBody AssetDto asset) {
        if(!id.equals(asset.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aktualizowany obiekt powinien mieć id zgodne z id ścieżki zasobu");
        AssetDto updatedAsset = assetService.update(asset);
        return ResponseEntity.ok(updatedAsset);
    }
    
    @GetMapping("/{id}/assignments")
    public List<AssetAssignmentDto> getAssetAssignments(@PathVariable Long id) {
        return assetService.getAssetAssignments(id);
    }
}