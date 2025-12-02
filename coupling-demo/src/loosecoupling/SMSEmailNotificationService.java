package loosecoupling;

public class SMSEmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS:" + message);
    }
}
