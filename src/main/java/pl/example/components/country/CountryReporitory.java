package pl.example.components.country;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.example.components.country.Country;

@Repository
public interface CountryReporitory extends JpaRepository<Country, Long> {
		
	@Query(value = "SELECT c.code, c.name, c.continent, c.population, c.life_expectancy, cl.language\r\n" + 
			"FROM country c \r\n" + 
			"INNER JOIN country_language cl ON c.code = cl.country_code\r\n" + 
			"WHERE c.code =:code and cl.is_official = true", nativeQuery = true)
	public Optional<Country> findByCode(@Param("code") String code);
}
