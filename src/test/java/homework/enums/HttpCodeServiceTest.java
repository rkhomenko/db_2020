package homework.enums;

import org.junit.Assert;
import org.junit.Test;

public class HttpCodeServiceTest {
    @Test
    public void extractEmpty() {
        Assert.assertEquals(HttpCodeService.extractCode("httpcode:"), 0);
    }
}