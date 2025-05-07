package br.com.ltda.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public class PeopleDTO {

	private int id;

	private String name;

	private LocalDate dateBirth;

	private Character gender;

	private List<AddressDTO> addresses;

	private Integer age;

	public PeopleDTO() {
	}

	public PeopleDTO(int id, String name, LocalDate dateBirth, Character gender, List<AddressDTO> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.addresses = addresses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public List<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public Integer getAge() {
		this.age = Objects.nonNull(this.dateBirth) ? Period.between(this.dateBirth, LocalDate.now()).getYears() : null;
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
