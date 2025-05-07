package br.com.ltda.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ltda.model.People;

@Stateless
public class PeopleRepository {

	// @PersistenceUnit(unitName = "ltda-manage-people") usar em caso de configuração local RESOURCE_LOCAL
	@PersistenceContext(unitName = "ltda-persistence-unit")
	private EntityManager entityManager;

	public void save(People people) {
		this.entityManager.persist(people);
	}

	public void update(People people) {
		this.entityManager.merge(people);
	}

	public People findById(Integer id) {
		return this.entityManager.find(People.class, id);
	}

	public List<People> findAll() {
		return this.entityManager.createQuery("SELECT p FROM People p", People.class).getResultList();
	}

	public void delete(Integer id) {
		this.entityManager.remove(findById(id));
	}

}