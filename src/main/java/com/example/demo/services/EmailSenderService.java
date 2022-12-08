package com.example.demo.services;

import com.example.demo.models.Movement;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private Configuration configuration;
    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("christian.huang.49@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);

        System.out.println("Mail sent successfully ...");
    }

    public void sendMovement(Movement movement) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Test");
        helper.setTo("christian.huang.49@gmail.com");
        String emailContent = getEntryContent(movement);
        helper.setText(emailContent, false);
        mailSender.send(mimeMessage);
    }


    String getEntryContent(Movement movement) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("type", movement.getType());
        model.put("createAt", movement.getCreatedAt());
        model.put("quantity", movement.getQuantity());
        model.put("weight", movement.getWeight());
        model.put("description", movement.getDescription());
        model.put("totalQuantity", movement.getTotalQuantity());
        model.put("totalWeight", movement.getTotalWeight());
        configuration.getTemplate("entry_movement.ftl").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
