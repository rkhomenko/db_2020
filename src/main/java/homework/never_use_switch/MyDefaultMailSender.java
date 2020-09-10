package homework.never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */

@Component
public class MyDefaultMailSender implements DefaultMailSender {
    @Override
    public void sendMail(MailInfo mailInfo) {
        throw new UnsupportedOperationException(mailInfo.getMailType() + " not supported yet");
    }

    @Override
    public int myCode() {
        return 0;
    }
}
