import loosecoupling.EmailNotificationService;
import loosecoupling.NotificationService;
import loosecoupling.SMSEmailNotificationService;
import tightcoupling.UserService;

public class AppMain {

    public static void main(String[] args) {

        //Tight
        UserService userService = new UserService();
        userService.notifyUser("Order Please");

        //Loose
        NotificationService emailService = new EmailNotificationService();
        NotificationService smsService = new SMSEmailNotificationService();
        loosecoupling.UserService userServiceLoose = new loosecoupling.UserService(smsService);
        userServiceLoose.notifyUser("Order Please");
    }
}
