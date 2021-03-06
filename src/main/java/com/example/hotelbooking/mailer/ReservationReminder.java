package com.example.hotelbooking.mailer;

import com.example.hotelbooking.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class ReservationReminder {
    private MailService mailService;
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationReminder(MailService mailService, ReservationRepository reservationRepository) {
        this.mailService = mailService;
        this.reservationRepository = reservationRepository;
    }

    @Scheduled(cron = "0 0 * * * ?")
    public void sendMail() {
        List<String> emailToRemind = reservationRepository.findEmailToRemind();

        emailToRemind.forEach(email -> {
            try {
                mailService.sendMail(email, "Room booking reminder", "Your room reservation starts tomorrow", true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }
}
