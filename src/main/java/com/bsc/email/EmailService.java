package com.bsc.email;

import com.bsc.email.client.Client;
import com.bsc.email.client.ClientService;
import com.bsc.email.report.EmailRelay;
import com.bsc.email.report.EmailReport;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class to send emails on behalf of clients.
 */
public class EmailService {
    private ClientService clientService;

    public List<Map<String, String>> sentEmails;

    public EmailService(Client... clients) {
        this(Arrays.asList(clients));
    }

    public EmailService(List<Client> clients) {
        this.clientService = new ClientService(clients);
        this.sentEmails = new LinkedList<>();
    }

    public void send(String id, String f, String a, String b) {
        Map<String, String> email = new HashMap<>();
        if (f == null) {
            throw new NullPointerException();
        }

        if (a == null) {
            throw new NullPointerException();
        }

        if (!b.startsWith("<html>") || !b.endsWith("</html>")) {
            return;
        }

        clientService.getClientById(Long.parseLong(id));

        email.put("from", f);
        email.put("to", a);
        email.put("body", b);

        SimpleDateFormat format = new SimpleDateFormat("yyyymmdd");
        email.put("date", format.format(new Date()));

        try {
            sentEmails.add(email);
            EmailRelay.send(email);
        } catch (Exception e) {
            System.out.println("Failed sending email: " + email);
        }

        sentEmails.add(email);
    }

    public EmailReport getReport() {
        EmailReport rpt = new EmailReport();
        rpt.emails = sentEmails;
        return rpt;
    }
}
