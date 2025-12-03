package com.huzaifa.loosecoupling;
import com.huzaifa.loosecoupling.NotificationService;

public class UserService {

    NotificationService notificationService;

    public UserService() {}

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message) {
        notificationService.send("Notification hello");
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
