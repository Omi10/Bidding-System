package om.run;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages= {"om"})
//@EnableOAuth2Sso
//@Configuration
//@Configuration
//@ImportResource("src/main/resouces/application.properties")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Application {

  @RequestMapping("/user")
	  public Principal user(Principal principal) {
	    return principal;
	  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  
 /* @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .antMatcher("/**")
      .authorizeRequests()
        .antMatchers("/", "/login**", "/webjars/**")
        .permitAll()
      .anyRequest()
        .authenticated();
  }*/

  
}
