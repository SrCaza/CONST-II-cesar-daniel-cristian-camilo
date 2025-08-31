package app.domain.port.out;

public interface NotificationService {
    void sendEmail(String to, String subject, String body);
}