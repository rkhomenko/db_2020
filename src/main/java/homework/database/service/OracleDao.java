package homework.database.service;

public class OracleDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to Oracle DB");
    }
}
