package dev.practice.order.infrastructure.partner;

import dev.practice.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationExecutor implements NotificationService {

    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("sendEmail success!!!");
    }

    @Override
    public void sendKakao(String phoneNo, String description) {
        log.info("sendKakao success!!!");
    }

    @Override
    public void sendSms(String phoneNo, String description) {
        log.info("sendSms success!!!");
    }

}
