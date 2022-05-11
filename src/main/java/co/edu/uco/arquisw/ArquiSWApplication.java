package co.edu.uco.arquisw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@EnableWebSecurity(debug = true)
public class ArquiSwApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ArquiSwApplication.class, args);
	}
}