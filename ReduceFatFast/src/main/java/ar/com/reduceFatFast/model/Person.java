package ar.com.reduceFatFast.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public @Data class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	String lastname;
	String firstname;
	Date bithdate;
	
	Long weight;
	Long width;
	
	@OneToMany
	List<Measure> measures;
	
	public Integer getAge(){
		return 30;
	}
}
