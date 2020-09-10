package homework.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyService {
    @Autowired
    @Derby
    private Dao doWorkDao;

    @Autowired
    @Oracle
    private Dao doBackupDao;

    @Scheduled(fixedDelay = 1000)
    public void doWork() {
        doWorkDao.save();
    }

    @Scheduled(fixedDelay = 5000)
    public void doBackup() {
        doBackupDao.save();
    }
}
