package ec.com.dinersclub.bff.rest.orchestrations;

import java.util.Set;

import ec.com.dinersclub.bff.rest.response.CountryResponse;

public interface IAggregatorServices {
	
	Set<CountryResponse> getCountryByName(String name);

}
