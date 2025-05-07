package br.com.ltda.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressUtil {

	private static final Map<String, List<String>> citysFromState = initializeCitys();

	private AddressUtil() {
	}

	public static List<String> states() {
		List<String> states = new ArrayList<>();
		states.add("AC - Acre");
		states.add("AL - Alagoas");
		states.add("AP - Amapá");
		states.add("AM - Amazonas");
		states.add("BA - Bahia");
		states.add("CE - Ceará");
		states.add("DF - Distrito Federal");
		states.add("ES - Espírito Santo");
		states.add("GO - Goiás");
		states.add("MA - Maranhão");
		states.add("MT - Mato Grosso");
		states.add("MS - Mato Grosso do Sul");
		states.add("MG - Minas Gerais");
		states.add("PA - Pará");
		states.add("PB - Paraíba");
		states.add("PR - Paraná");
		states.add("PE - Pernambuco");
		states.add("PI - Piauí");
		states.add("RJ - Rio de Janeiro");
		states.add("RN - Rio Grande do Norte");
		states.add("RS - Rio Grande do Sul");
		states.add("RO - Rondônia");
		states.add("RR - Roraima");
		states.add("SC - Santa Catarina");
		states.add("SP - São Paulo");
		states.add("SE - Sergipe");
		states.add("TO - Tocantins");
		return states;
	}

	public static List<String> citys() {
		List<String> all = new ArrayList<>();
		for (List<String> cities : citysFromState.values()) {
			all.addAll(cities);
		}
		return all;
	}

	public static List<String> citysFromState(String state) {
		return citysFromState.getOrDefault(getStateAcronym(state), new ArrayList<>());
	}

	public static String getStateAcronym(String state) {
		return state.length() > 2 ? state.substring(0, 2) : state;
	}
	
	public static String getStateComplete(String acronym) {
		return states().stream().filter(uf -> uf.startsWith(acronym)).findFirst().orElse("");
	}

	private static Map<String, List<String>> initializeCitys() {
		Map<String, List<String>> mapCitysFromState = new HashMap<>();
		mapCitysFromState.put("AC", List.of("Rio Branco", "Cruzeiro do Sul"));
		mapCitysFromState.put("AL", List.of("Maceió", "Arapiraca"));
		mapCitysFromState.put("AP", List.of("Macapá", "Santana"));
		mapCitysFromState.put("AM", List.of("Manaus", "Parintins"));
		mapCitysFromState.put("BA", List.of("Salvador", "Feira de Santana"));
		mapCitysFromState.put("CE", List.of("Fortaleza", "Sobral"));
		mapCitysFromState.put("DF", List.of("Brasília"));
		mapCitysFromState.put("ES", List.of("Vitória", "Vila Velha"));
		mapCitysFromState.put("GO", List.of("Goiânia", "Anápolis"));
		mapCitysFromState.put("MA", List.of("São Luís", "Imperatriz"));
		mapCitysFromState.put("MT", List.of("Cuiabá", "Rondonópolis"));
		mapCitysFromState.put("MS", List.of("Campo Grande", "Dourados"));
		mapCitysFromState.put("MG", List.of("Belo Horizonte", "Uberlândia"));
		mapCitysFromState.put("PA", List.of("Belém", "Santarem"));
		mapCitysFromState.put("PB", List.of("João Pessoa", "Campina Grande"));
		mapCitysFromState.put("PR", List.of("Curitiba", "Londrina"));
		mapCitysFromState.put("PE", List.of("Recife", "Caruaru"));
		mapCitysFromState.put("PI", List.of("Teresina", "Parnaíba"));
		mapCitysFromState.put("RJ", List.of("Rio de Janeiro", "Niterói"));
		mapCitysFromState.put("RN", List.of("Natal", "Mossoró"));
		mapCitysFromState.put("RS", List.of("Porto Alegre", "Caxias do Sul"));
		mapCitysFromState.put("RO", List.of("Porto Velho", "Ji-Paraná"));
		mapCitysFromState.put("RR", List.of("Boa Vista", "Rorainópolis"));
		mapCitysFromState.put("SC", List.of("Florianópolis", "Joinville"));
		mapCitysFromState.put("SP", List.of("São Paulo", "Campinas"));
		mapCitysFromState.put("SE", List.of("Aracaju", "Itabaiana"));
		mapCitysFromState.put("TO", List.of("Palmas", "Araguaína"));
		return mapCitysFromState;
	}

}
