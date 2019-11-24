package pl.example.equipy.components.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak użytkownika o takim ID")
class UserNotFoundException extends RuntimeException {}