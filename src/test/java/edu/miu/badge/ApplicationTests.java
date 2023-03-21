package edu.miu.badge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void myTest(){
		System.out.println(LocalDateTime.now().getDayOfWeek());
	}

}
