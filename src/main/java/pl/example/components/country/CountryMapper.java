package pl.example.components.country;

public class CountryMapper {

	static CountryDto toDto(Country country) {
		CountryDto countryDto = new CountryDto();
		countryDto.setName(country.getName());
		countryDto.setContinent(country.getContinent());
		countryDto.setPopulation(country.getPopulation());
		countryDto.setLifeExpectancy(country.getLifeExpectancy());
		countryDto.setLanguage(country.getLanguage());
		return countryDto;
	}
}
