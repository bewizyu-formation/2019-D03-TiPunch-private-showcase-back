package fr.formation.geo.controllers;

import fr.formation.geo.model.Commune;
import fr.formation.geo.services.CommuneService;
import fr.formation.security.SecurityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Commune controller.
 */
@RestController
@Secured(SecurityConstants.ROLE_USER)
@RequestMapping("/communes")
public class CommuneController {

	private static final Logger log = LoggerFactory.getLogger(CommuneController.class);

	private CommuneService communeService;

	/**
	 * Instantiates a new Commune controller.
	 *
	 * @param communeService the commune service
	 */
	@Autowired
	public CommuneController(CommuneService communeService) {
		this.communeService = communeService;
	}

	/**
	 * Gets communes.
	 *
	 * @param nom the nom
	 *
	 * @return the communes
	 */
	@GetMapping("/")
	public ResponseEntity<List<Commune>> getCommunes(@RequestParam final String nom) {
		final List<Commune> communes = this.communeService.getCommunes(nom);
		System.out.println(communes);
		return new ResponseEntity<>(communes, HttpStatus.OK);
	}

	/**
	 * Gets commune by code.
	 *
	 * @param code the code
	 *
	 * @return the commune by code
	 */
	@GetMapping("/{code}")
	public ResponseEntity<List<Commune>> getCommunesByCode(@PathVariable(value = "code") final String code) {
		final List<Commune> commune = this.communeService.getCommunesByCode(code);
		return new ResponseEntity<>(commune, HttpStatus.OK);
	}
}
