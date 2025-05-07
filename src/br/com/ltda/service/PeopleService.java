package br.com.ltda.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import br.com.ltda.dto.PeopleDTO;
import br.com.ltda.model.People;
import br.com.ltda.repository.PeopleRepository;

@Stateless
public class PeopleService {

	@Inject
	private PeopleRepository repository;

	public void saveOrUpdate(PeopleDTO dto) {
		People people = new ModelMapper().map(dto, People.class);
		if (Objects.isNull(people.getId())) {
			this.repository.save(people);
		} else {
			this.repository.update(people);
		}
	}

	public PeopleDTO findById(Integer id) {
		People people = this.repository.findById(id);
		return new ModelMapper().map(people, PeopleDTO.class);
	}

	public List<PeopleDTO> findAll() {
		List<People> list = this.repository.findAll();
		return list.stream().map(item -> new ModelMapper().map(item, PeopleDTO.class)).collect(Collectors.toList());
	}

	public void delete(Integer id) {
		this.repository.delete(id);
	}

}