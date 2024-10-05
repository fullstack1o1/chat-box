package net.samitkumar.chat_box;

import jakarta.servlet.DispatcherType;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class ChatBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatBoxApplication.class, args);
	}

}

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

	/*@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	@Bean
	@SneakyThrows
	public SecurityFilterChain filterChain(HttpSecurity http) {
		return http
				//.csrf(csrf -> csrf.ignoringRequestMatchers("/register")) // this way we can disable csrf for one endpoint
				.authorizeHttpRequests((authorize) -> authorize
						.dispatcherTypeMatchers(HttpMethod.GET, DispatcherType.FORWARD).permitAll()
						.requestMatchers("/register", "/csrf").permitAll()
						//.requestMatchers(HttpMethod.POST, "/register").permitAll() // more specific way , but above can be used as well
						.anyRequest()
						.authenticated())
				.formLogin(Customizer.withDefaults()) //we can have a customise login page as well
				//.httpBasic(Customizer.withDefaults())
				.build();
	}
}

@Configuration
class WebSocketConfiguration {

}

