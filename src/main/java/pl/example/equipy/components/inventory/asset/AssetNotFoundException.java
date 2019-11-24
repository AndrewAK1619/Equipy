package pl.example.equipy.components.inventory.asset;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak wyposażenia o takim ID")
class AssetNotFoundException extends RuntimeException {
}