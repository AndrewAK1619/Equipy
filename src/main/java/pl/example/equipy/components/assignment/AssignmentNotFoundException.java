package pl.example.equipy.components.assignment;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nie istnieje przypisanie o takim ID")
class AssignmentNotFoundException extends RuntimeException { }