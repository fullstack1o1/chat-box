package net.samitkumar.chat_box;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ChatBoxApplicationTests {

	@Test
	void contextLoads() {
	}

}
