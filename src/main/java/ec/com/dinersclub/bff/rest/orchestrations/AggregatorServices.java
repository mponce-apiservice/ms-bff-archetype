package ec.com.dinersclub.bff.rest.orchestrations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import ec.com.dinersclub.bff.rest.response.CountryResponse;
import ec.com.dinersclub.bff.services.CountriesService;
import ec.com.dinersclub.bff.services.TarjetaService;
import ec.com.dinersclub.bff.services.models.Country;
import ec.com.dinersclub.bff.services.models.CreateTarjetaCommand;

@ApplicationScoped
public class AggregatorServices implements IAggregatorServices {
	
	@Inject
    @RestClient
    CountriesService countriesService;
	
	@Inject                  
	TarjetaService tarjetaService;

	@Override
	public Set<CountryResponse> getCountryByName(String name) {
		Set<CountryResponse> response = new HashSet<CountryResponse>();
		Set<Country> country = countriesService.getByName(name);
    	if(!country.isEmpty()) {
    		Iterator<Country> itr = country.iterator();
	        while (itr.hasNext()) { 
	        	Country c = itr.next();
	        	response.add(new CountryResponse(c.name,c.alpha2Code,c.capital,tarjetaService.createTarjetaCommand(new CreateTarjetaCommand(UUID.randomUUID(),name))));
	        }
    	}
    	return response;
	}

}
