package homework.database.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @AutoDao(DaoType.Derby)
    private Dao doWorkDao;

    @AutoDao(DaoType.Oracle)
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
