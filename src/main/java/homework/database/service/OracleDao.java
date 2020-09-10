package homework.database.service;

import org.springframework.stereotype.Component;

@AutoDao(DaoType.Oracle)
public class OracleDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to Oracle DB");
    }
}
