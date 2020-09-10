package homework.database.service;

import org.springframework.stereotype.Component;

@Component
@Derby
public class DerbyDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to Derby DB");
    }
}
