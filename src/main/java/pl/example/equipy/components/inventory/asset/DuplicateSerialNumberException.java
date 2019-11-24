package pl.example.equipy.components.inventory.asset;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Zasób z takim numerem seryjnym już istnieje")
public class DuplicateSerialNumberException extends RuntimeException { }