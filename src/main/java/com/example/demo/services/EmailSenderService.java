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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        model.put("id", movement.getId());
        model.put("type", movement.getType());
        model.put("createdAt", movement.getCreatedAt());
        model.put("quantity", movement.getQuantity());
        model.put("weight", movement.getWeight());
        model.put("description", movement.getDescription());
        model.put("totalQuantity", movement.getTotalQuantity());
        model.put("totalWeight", movement.getTotalWeight());
        model.put("reference", movement.getReference());
        model.put("currentTime", dtf.format(now));
        model.put("customsCode", movement.getCustomsCode());
        model.put("customsDocumentType", movement.getCustomsDocumentType());
        model.put("customsDocumentReference", movement.getCustomsDocumentReference());
        String template = movement.getEntry() ? "entry_movement.ftl" : "out_movement.ftl";
        configuration.getTemplate(template).process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
