package br.com.ltda.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pessoa")
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
	@SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq", allocationSize = 1)
	private int id;

	@Column(name = "nome", length = 150)
	private String name;

	@Column(name = "data_nascimento")
	private LocalDate dateBirth;

	@Column(name = "sexo", length = 1)
	private Character gender;

	@OneToMany(mappedBy = "people", cascade = CascadeType.ALL)
	private List<Address> addresses;

	@Transient
	private Integer age;

	public People() {
	}

	public People(int id, String name, LocalDate dateBirth, Character gender, List<Address> addresses) {
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Integer getAge() {
		return Objects.nonNull(this.dateBirth) ? Period.between(this.dateBirth, LocalDate.now()).getYears() : null;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
