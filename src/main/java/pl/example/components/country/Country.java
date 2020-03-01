package pl.example.components.country;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	private String code;
	private String name;
	private String continent;
	private int population;
	private float lifeExpectancy;
	private String language;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}