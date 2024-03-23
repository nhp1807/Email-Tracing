package com.example.emailtracing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class CheckingMails {
    /**
     * this method checks for new messages in the inbox folder of the email
     * account
     * @param host: the host of the email account
     * @param storeType: the store type of the email account
     * @param user: the email address of the account
     * @param password: the password of the account
     */
    public static void check(String host, String storeType, String user, String password)
    {
        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.store.protocol", "pop3s");
            properties.put("mail.pop3s.host", host);
            properties.put("mail.pop3s.port", "995");
            properties.put("mail.pop3s.ssl.enable", "true");
            properties.put("mail.pop3s.ssl.protocols", "TLSv1.2");

            // Setup mail server
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.   length---" + messages.length);

            // iterate through the messages
            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String host = "pop.gmail.com";
        String mailStoreType = "pop3";
        // Get email and password from file
        Map<String, String> emailAndPass = ReadMail.emailAndPass("src/main/java/com/example/emailtracing/mails.txt");
        String username = "phongnguyenhai@tech.admicro.vn";
        String password = emailAndPass.get(username);

        // Call check method
        check(host, mailStoreType, username, password);
    }
}
