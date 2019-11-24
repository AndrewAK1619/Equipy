package pl.example.equipy.components.assignment;

class InvalidAssignmentException extends RuntimeException {
    public InvalidAssignmentException(String message) {
        super(message);
    }
}