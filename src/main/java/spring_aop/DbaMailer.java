package spring_aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbaMailer implements Mailer {
    @Value("#{'${dba.emails}'.split(',')}")
    private List<String> emails;

    @Override
    public void send(RuntimeException ex) {
        System.out.println("Send error info to emails:");
        emails.forEach(System.out::println);
    }
}
