package br.com.ltda.dto;

public class AddressDTO {

	private int id;

	private String state;

	private String city;

	private String publicPlace;

	private int number;

	private String zipCode;

	private PeopleDTO people;

	public AddressDTO() {
	}

	public AddressDTO(int id, String state, String city, String publicPlace, int number, String zipCode, PeopleDTO people) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
		this.publicPlace = publicPlace;
		this.number = number;
		this.zipCode = zipCode;
		this.people = people;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public PeopleDTO getPeople() {
		return people;
	}

	public void setPeople(PeopleDTO people) {
		this.people = people;
	}

}