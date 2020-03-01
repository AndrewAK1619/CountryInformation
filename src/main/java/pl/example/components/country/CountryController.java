package pl.example.components.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pl.example.components.country.CountryMapper;

@RestController
public class CountryController {

	private CountryReporitory countryRepository;

	@Autowired
	CountryController(CountryReporitory countryRepository) {
		this.countryRepository = countryRepository;
	}

	@GetMapping("/{code}")
	public ResponseEntity<CountryDto> findByCode(@PathVariable String code) {

		try {
			return countryRepository.findByCode(code)
					.map(CountryMapper::toDto)
					.map(ResponseEntity::ok)
					.orElseThrow(
							() -> new ResponseStatusException
							(HttpStatus.INTERNAL_SERVER_ERROR, "INVALID_COUNTRY_CODE"));
		} catch (DataAccessResourceFailureException exc) {
			throw new ResponseStatusException
			(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR", exc);
		}
	}
}