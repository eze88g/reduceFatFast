package ar.com.reduceFatFast;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.com.reduceFatFast.model.Sistema;
import ar.com.reduceFatFast.service.SistemaService;

@SpringBootApplication
public class ReduceFatFastApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ReduceFatFastApplication.class);
	
	@Value("${sistema.nombre}")
	private String systemName;
	
	@Autowired
	private SistemaService service;

	public static void main(String[] args) {
		SpringApplication.run(ReduceFatFastApplication.class, args);
	}
	
	@PostConstruct
	private void checkBasicInfo(){	
		logger.info("Checking Basic Data for this System");
		if(!isBasicSystemCreated()){
			logger.info("Creating the Basic Data");
			createBasicInfo();
			logger.info("Basic Data Created");
		}else{
			logger.info("The Basic Data has been already created");
		}
	}
	
	private void createBasicInfo() {
		Sistema sistema = new Sistema();
		sistema.setNombre(this.systemName);
		sistema.setStartedDate(new Date());
		this.getService().save(sistema);
	}

	private boolean isBasicSystemCreated() {
		List<Sistema> list = (List<Sistema>) this.getService().findAll();
		return list.size()>0;
	}
	
	// Setters and Getters

	/**
	 * @return the service
	 */
	public SistemaService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(SistemaService service) {
		this.service = service;
	}
	
	

	
}
