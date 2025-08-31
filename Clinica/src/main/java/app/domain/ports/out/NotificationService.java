package app.domain.ports.out;

public interface NotificationService {
    void sendEmail(String to, String subject, String body);
}