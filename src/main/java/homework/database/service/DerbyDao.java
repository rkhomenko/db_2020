package homework.database.service;

import org.springframework.stereotype.Component;

@AutoDao(DaoType.Derby)
public class DerbyDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to Derby DB");
    }
}
