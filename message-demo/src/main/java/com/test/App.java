package com.test;

import sun.net.smtp.SmtpClient;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author chenyunan 2018/1/3 13:36
 */
public class App {

    public static void main(String[] args) throws MessagingException {

        String mailhost = "smtp.exmail.qq.com";
        final String mail = "@qq.com";
        final String password = new String(new byte[]{1});
        String to = "@qq.com";
        String protocol = "pop3";

        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.smtp.host", mailhost);
        properties.setProperty("mail.smtp.ssl.enable", "true");

        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mail, password);
            }
        });
        session.setDebug(false);

        Store store = session.getStore(protocol);
        store.connect(mailhost, mail, password);

        MimeMessage mimeMessage = new MimeMessage(session);

        mimeMessage.setFrom(mail);
        mimeMessage.setRecipients(Message.RecipientType.TO, to);

        mimeMessage.setSubject("Test");
        mimeMessage.setText("test");

        Transport.send(mimeMessage);

    }

}
