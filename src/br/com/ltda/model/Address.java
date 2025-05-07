package br.com.ltda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ltda.service.AddressUtil;

@Entity
@Table(name = "endereco")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
	@SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq", allocationSize = 1)
	private int id;

	@Column(name = "estado", length = 2)
	private String state;

	@Column(name = "cidade", length = 100)
	private String city;

	@Column(name = "logradouro", length = 100)
	private String publicPlace;

	@Column(name = "numero")
	private int number;

	@Column(name = "cep", length = 8)
	private String zipCode;

	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private People people;

	public Address() {
	}

	public Address(int id, String state, String city, String publicPlace, int number, String zipCode, People people) {
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
		return AddressUtil.getStateComplete(this.state);
	}

	public void setState(String state) {
		this.state = AddressUtil.getStateAcronym(state);
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

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}