package fr.formation.geo.services;

import fr.formation.geo.model.Commune;

import java.util.List;

/**
 * The interface Commune service.
 *
 * @author Nicolas Hodicq (nhodicq@sqli.com)
 */
public interface CommuneService {

	/**
	 * Gets communes.
	 *
	 * @param nom the nom
	 *
	 * @return the communes
	 */
	List<Commune> getCommunes(final String nom);


	/**
	 * Gets commune by code
	 * @param code the code
	 * @return the commune by code
	 */
	List<Commune> getCommunesByCode(final String code);


}
