package com.upgrade.volcano;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
class ApplicationTest {
}


@RunWith(SpringRunner.class)
@SpringBootTest
public class VolcanoApplicationTests {

	@Test
	public void boolTest() {
	    boolean ok = true;
        Assert.assertTrue(ok);
	}

}
