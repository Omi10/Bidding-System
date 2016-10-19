package om.run;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.sql.Driver;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import com.mysql.jdbc.Driver;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  
  /*
  @Bean
  protected ServletContextListener listener() {

      return new ServletContextListener() {

          @Override
          public void contextInitialized(ServletContextEvent sce) {
             System.out.println("Initialising Context...");
          }

          @Override
          public final void contextDestroyed(ServletContextEvent sce) {

        	  System.out.println("Destroying Context...");

              try {
            	  System.out.println("Calling MySQL AbandonedConnectionCleanupThread shutdown");
                  com.mysql.jdbc.AbandonedConnectionCleanupThread.shutdown();

              } catch (InterruptedException e) {
            	  System.out.println("Error calling MySQL AbandonedConnectionCleanupThread shutdown {}"); e.printStackTrace();
              }

              ClassLoader cl = Thread.currentThread().getContextClassLoader();

              Enumeration<Driver> drivers = DriverManager.getDrivers();
              while (drivers.hasMoreElements()) {
                  Driver driver = drivers.nextElement();

                  if (driver.getClass().getClassLoader() == cl) {

                      try {
                    	  System.out.println("Deregistering JDBC driver {}");
                          DriverManager.deregisterDriver(driver);

                      } catch (SQLException ex) {
                    	  System.out.println("Error deregistering JDBC driver {}");//, driver, ex);
                      }

                  } else {
                     // log.trace("Not deregistering JDBC driver {} as it does not belong to this webapp's ClassLoader", driver);
                  }
              }
          }
      };
  }*/

}
