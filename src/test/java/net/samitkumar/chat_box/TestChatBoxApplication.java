package net.samitkumar.chat_box;

import org.springframework.boot.SpringApplication;

public class TestChatBoxApplication {

	public static void main(String[] args) {
		SpringApplication.from(ChatBoxApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
