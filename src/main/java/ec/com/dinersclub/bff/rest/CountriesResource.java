package ec.com.dinersclub.bff.rest;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import ec.com.dinersclub.bff.services.CountriesService;
import ec.com.dinersclub.bff.services.models.Country;

import ec.com.dinersclub.bff.rest.orchestrations.IAggregatorServices;
import ec.com.dinersclub.bff.rest.response.CountryResponse;
import io.smallrye.mutiny.Uni;

@Path("/country")
public class CountriesResource {
	
	@Inject
    @RestClient
    CountriesService countriesService;

	@Inject
	IAggregatorServices aggregatorService;
	
	@GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response name(@PathParam String name) {
    	
		Set<CountryResponse> country = aggregatorService.getCountryByName(name);
    	if(!country.isEmpty()) {
    		return Response.ok(country).build();
    	}else {
    		return Response.noContent().build();
    	}
   
    }

    @GET
    @Path("/name-async/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Set<Country>> nameAsync(@PathParam String name) {
        return countriesService.getByNameAsync(name);
    }

    @GET
    @Path("/name-uni/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Set<Country>> nameMutiny(@PathParam String name) {
        return countriesService.getByNameAsUni(name);
    }
    
}