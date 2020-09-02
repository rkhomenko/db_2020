package homework.enums;

import homework.enums.logic.BusinessLogic;
import homework.enums.logic.InfoLogic;
import homework.enums.logic.SuccessLogic;
import homework.enums.logic.RedirectionLogic;
import homework.enums.logic.ClientErrorLogic;
import homework.enums.logic.ServerErrorLogic;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class HttpCodeProcessorTest {
    private static HttpCodeProcessor processor;

    @BeforeClass
    public static void initialize() {
        processor = new HttpCodeProcessor();
    }

    @Test
    public void testInfoLogic() {
        BusinessLogic logic = processor.getBusinessLogicForCode(150);
        assertThat(logic, instanceOf(InfoLogic.class));
    }

    @Test
    public void testSuccessLogic() {
        BusinessLogic logic = processor.getBusinessLogicForCode(250);
        assertThat(logic, instanceOf(SuccessLogic.class));
    }

    @Test
    public void testRedirectionLogic() {
        BusinessLogic logic = processor.getBusinessLogicForCode(350);
        assertThat(logic, instanceOf(RedirectionLogic.class));
    }

    @Test
    public void testClientErrorLogic() {
        BusinessLogic logic = processor.getBusinessLogicForCode(450);
        assertThat(logic, instanceOf(ClientErrorLogic.class));
    }

    @Test
    public void testServerErrorLogic() {
        BusinessLogic logic = processor.getBusinessLogicForCode(550);
        assertThat(logic, instanceOf(ServerErrorLogic.class));
    }
}