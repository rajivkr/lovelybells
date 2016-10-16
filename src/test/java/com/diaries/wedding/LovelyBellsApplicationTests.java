package com.diaries.wedding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.diaries.wedding.LovelyBellsApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LovelyBellsApplication.class)
@WebAppConfiguration
public class LovelyBellsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
