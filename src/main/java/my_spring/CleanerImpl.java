package my_spring;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements Cleaner {


    @InjectRandomInt(min=3,max=10)
    private int repeat;

    @Override
    public void clean() {
        System.out.println("VVVVVVVVVVVVVVVVVVvvvvvvvvvvvvvvvvvvvv");
    }
}
