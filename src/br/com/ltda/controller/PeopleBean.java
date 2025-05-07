package br.com.ltda.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

import br.com.ltda.dto.AddressDTO;
import br.com.ltda.dto.PeopleDTO;
import br.com.ltda.service.AddressUtil;
import br.com.ltda.service.PeopleService;
// import jakarta.inject.Named;

@SessionScoped
@Named(value = "peopleBean")
public class PeopleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PeopleService peopleService;

	private List<PeopleDTO> selectedPeople;
	private List<PeopleDTO> people;

	private List<AddressDTO> addressList;
	private AddressDTO address;
	
	private List<String> cities;

	private PeopleDTO person;

	@PostConstruct
	public void init() {
		this.resetPeople();
		this.setSelectedPeople(new ArrayList<>());
		this.setCities(new ArrayList<>());
		this.resetAddress();
		this.setPeople(this.peopleService.findAll());
	}

	public void save() throws IOException {
		this.person.setAddresses(addressList);
		this.peopleService.saveOrUpdate(this.person);
		this.resetPeople();
		this.setPeople(this.peopleService.findAll());
		this.indexPage();
	}

	public void resetPeople() {
		this.person = new PeopleDTO();
	}

	public void resetAddress() {
		this.address = new AddressDTO();
	}

	public String getDeleteButtonMessage() {
		if (hasSelectedPeople()) {
			int size = this.selectedPeople.size();
			return size > 1 ? size + " Pessoas selecionadas" : "1 Pessoa selecionada";
		}
		return "Excluir";
	}

	public String cssAge(Integer age) {
		if (Objects.isNull(age)) {
			return "";
		} else {
			return age < 18 ? "of-minor" : "of-major";
		}
	}

	public void updateCities() {
		if (Objects.nonNull(address) && Objects.nonNull(address.getState())) {
			setCities(AddressUtil.citysFromState(this.address.getState()));
		}
	}

	public void peoplePage(PeopleDTO peopleGridModel) throws IOException {
		this.setPerson(this.peopleService.findById(peopleGridModel.getId()));
		setAddressList(peopleGridModel.getAddresses());
		this.peoplePage();
	}

	public void peoplePage() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("people.xhtml");
	}

	public void indexPage() throws IOException {
		resetAddress();
		resetPeople();
		this.setAddressList(new ArrayList<>());
		this.setPeople(this.peopleService.findAll());
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	}

	public boolean hasSelectedPeople() {
		return Objects.nonNull(this.selectedPeople) && !this.selectedPeople.isEmpty();
	}

	public void deletePeople() throws IOException {
		this.peopleService.delete(this.person.getId());
		this.selectedPeople = null;
		this.setPeople(this.peopleService.findAll());
		this.indexPage();
	}

	public void deleteAddress(AddressDTO dto) {
		if (Objects.nonNull(addressList)) {
			this.addressList.remove(dto);
		}
	}

	public void addAddress() {
		if (Objects.isNull(addressList)) {
			this.addressList = new ArrayList<>();
		}
		AddressDTO addressDTO = new ModelMapper().map(this.address, AddressDTO.class);
		addressDTO.setPeople(this.person);
		this.addressList.add(addressDTO);
		this.resetAddress();
	}
	
	public List<String> states() {
		return AddressUtil.states();
	}

	public List<PeopleDTO> getPeople() {
		return people;
	}

	public void setPeople(List<PeopleDTO> people) {
		this.people = people;
	}

	public PeopleDTO getPerson() {
		return person;
	}

	public void setPerson(PeopleDTO person) {
		this.person = person;
	}

	public List<PeopleDTO> getSelectedPeople() {
		return selectedPeople;
	}

	public void setSelectedPeople(List<PeopleDTO> selectedPeople) {
		this.selectedPeople = selectedPeople;
	}

	public List<AddressDTO> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressDTO> addressList) {
		this.addressList = addressList;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

}
