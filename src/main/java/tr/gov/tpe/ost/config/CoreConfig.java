package tr.gov.tpe.ost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tr.gov.tpe.ost.web.controller.demo.UserService;
import tr.gov.tpe.ost.web.controller.demo.UserServiceImpl;


@Configuration
public class CoreConfig {
  // core beans

  @Bean
  public UserService userService() {
    return new UserServiceImpl();
  }
}
