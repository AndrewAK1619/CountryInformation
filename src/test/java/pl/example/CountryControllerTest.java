package pl.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.server.ResponseStatusException;

import pl.example.components.country.CountryController;

@SpringBootTest
public class CountryControllerTest {

	@Autowired
	private CountryController countryController;

	@Autowired
	private DataSource dataSource;

	@Test
	public void shouldInvalidCountryCode1() {
		try {
			countryController.findByCode("BHRR");
		} catch (ResponseStatusException exc) {
			assertEquals(exc.getMessage(),
					new ResponseStatusException
					(HttpStatus.INTERNAL_SERVER_ERROR, "INVALID_COUNTRY_CODE").getMessage());
		}
	}

	@Test
	public void shouldInvalidCountryCode2() {
		try {
			countryController.findByCode("bhr");
		} catch (ResponseStatusException exc) {
			assertEquals(exc.getMessage(),
					new ResponseStatusException
					(HttpStatus.INTERNAL_SERVER_ERROR, "INVALID_COUNTRY_CODE").getMessage());
		}
	}

	@Test
	public void shouldInvalidCountryCode3() {
		try {
			countryController.findByCode("gshhdhgd");
		} catch (ResponseStatusException exc) {
			assertEquals(exc.getMessage(),
					new ResponseStatusException
					(HttpStatus.INTERNAL_SERVER_ERROR, "INVALID_COUNTRY_CODE").getMessage());
		}
	}

	@Test
	public void shouldInternalError1() {

		Connection connection = DataSourceUtils.getConnection(dataSource);

		if (connection == null) {
			try {
				countryController.findByCode("POL");
			} catch (ResponseStatusException exc) {
				assertEquals(exc.getMessage(),
						new ResponseStatusException
						(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR").getMessage());
			}
		}
	}
}
