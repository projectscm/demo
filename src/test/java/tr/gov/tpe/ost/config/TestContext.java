package tr.gov.tpe.ost.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tr.gov.tpe.ost.web.controller.demo.UserService;

@Configuration
public class TestContext {
  @Bean
  UserService userService() {
    return Mockito.mock(UserService.class);
  }
}
