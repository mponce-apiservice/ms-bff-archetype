package ec.com.dinersclub.bff.rest.response;

public class CountryResponse {
	
	private String name;
	private String alpha2Code;
	private String capital;
	private String saludo;
	
	public CountryResponse(String name, String alpha2Code, String capital, String saludo) {
		this.name = name;
		this.alpha2Code = alpha2Code;
		this.capital = capital;
		this.saludo = saludo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAlpha2Code() {
		return alpha2Code;
	}
	
	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}
	
	public String getCapital() {
		return capital;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

}
