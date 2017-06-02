package ar.com.reduceFatFast;

import java.io.IOException;
import java.util.Arrays;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import ar.com.reduceFatFast.model.UserAccount;
import ar.com.reduceFatFast.repository.AccountRepository;

@SpringBootApplication
@ImportResource("applicationContext.xml")
public class ReduceFatFastApplication {
	
	@Autowired
	private ResourceLoader rl;

	public static void main(String[] args) {
		SpringApplication.run(ReduceFatFastApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");
	    return registration;
	}
	

	@Bean
    public CommandLineRunner init(AccountRepository repository) {
		return null;
//    	return (evt) -> Arrays.asList(
//    			"mrizzo, jrossi, nn".split(",")).forEach(
//    					a -> { 
//    						((JpaRepository<UserAccount, Long>)repository).save(new UserAccount());	
//    					}	
//    			);

    }

//	@Bean
//	public LocalSessionFactoryBean sessionFactory() throws IOException {
//	    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//	    sessionFactoryBean.setMappingLocations(loadResources());
//	    return sessionFactoryBean;
//	}

	public Resource[] loadResources() {
	    Resource[] resources = null;
	    try {
	        resources = ResourcePatternUtils.getResourcePatternResolver(rl)
	            .getResources("classpath:/hibernate/*.hbm.xml");
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return resources;
	}
	
}
