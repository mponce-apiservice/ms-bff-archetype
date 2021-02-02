package ec.com.dinersclub.bff.rest.orchestrations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import ec.com.dinersclub.bff.services.CountriesService;
import ec.com.dinersclub.bff.services.models.Country;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import ec.com.dinersclub.bff.rest.response.CountryResponse;

import ec.com.dinersclub.dddmodules.application.grpc.GreeterGrpc;
import ec.com.dinersclub.dddmodules.application.grpc.HelloRequest;

@ApplicationScoped
public class AggregatorServices implements IAggregatorServices {
	
	@Inject
    @RestClient
    CountriesService countriesService;
	
	@Inject
    @GrpcService("hello")                     
    GreeterGrpc.GreeterBlockingStub client;

	@Override
	public Set<CountryResponse> getCountryByName(String name) {
		Set<CountryResponse> response = new HashSet<CountryResponse>();
		Set<Country> country = countriesService.getByName(name);
    	if(!country.isEmpty()) {
    		Iterator<Country> itr = country.iterator();
	        while (itr.hasNext()) { 
	        	Country c = itr.next();
	        	response.add(new CountryResponse(c.name,c.alpha2Code,c.capital,client.sayHello(HelloRequest.newBuilder().setName(name).build()).getMessage()));
	        }
    	}
    	return response;
	}

}
