package homework.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */

@Component
public class MailDistributor {
    @Autowired
    private DefaultMailSender defaultMailSender;

    private Map<Integer,MailSender> mailSenderMap = new HashMap<>();


    @Autowired
    public MailDistributor(List<MailSender> mailSenders) {
        for (MailSender mailSender : mailSenders) {
            mailSenderMap.put(mailSender.myCode(), mailSender);
        }
    }

    public void sendMailInfo(MailInfo mailInfo) {

        MailSender mailSender = mailSenderMap.getOrDefault(mailInfo.getMailType(), defaultMailSender);
        mailSender.sendMail(mailInfo);
    }
}








