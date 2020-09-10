package homework.database.service;

public class DerbyDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to Derby DB");
    }
}
