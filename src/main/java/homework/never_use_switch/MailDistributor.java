package homework.never_use_switch;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */

@Component
public class MailDistributor {
    @Autowired
    private List<MailSender> mailSenders;

    @Autowired
    private DefaultMailSender defaultMailSender;

    private Map<Integer,MailSender> mailSenderMap = new HashMap<>();

    @PostConstruct
    private void initMailSenderMap() {
        for (MailSender mailSender : mailSenders) {
            mailSenderMap.put(mailSender.myCode(), mailSender);
        }
    }

    public void sendMailInfo(MailInfo mailInfo) {

        MailSender mailSender = mailSenderMap.getOrDefault(mailInfo.getMailType(), defaultMailSender);
        mailSender.sendMail(mailInfo);
    }
}








