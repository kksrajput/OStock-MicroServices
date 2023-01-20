package com.ostock.license.controller;

import java.util.Locale;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ostock.license.model.License;
import com.ostock.license.service.LicenseService;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {

	
	private final LicenseService licenseService;
	
	@Autowired
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	@GetMapping(value="/{licenseId}")
	public ResponseEntity<License> getLicense(
			@PathVariable("organizationId")String organizationId,
			@PathVariable("licenseId")String licenseId){
		
		License license = licenseService
				.getLicense(licenseId, organizationId);
		license.add(linkTo(methodOn(LicenseController.class)
				.getLicense(organizationId, licenseId))
				.withSelfRel(),
				linkTo(methodOn(LicenseController.class)
				.createLicense(organizationId, license ,null))
				.withRel("createLicense"),
				linkTo(methodOn(LicenseController.class)
				.updateLicense(organizationId, license, null))
				.withRel("updateLicense"),
				linkTo(methodOn(LicenseController.class)
				.deleteLicense(organizationId, licenseId, null))
				.withRel("deleteLicense")
				);
	 
		return ResponseEntity.ok(license);	
	}
	
	@PutMapping
	public ResponseEntity<String>updateLicense(
			@PathVariable("organizationId")String organizationId,
			@RequestBody License request,
			@RequestHeader(value = "Accept-Language",required = false)
			Locale locale){
		return ResponseEntity.ok(licenseService.updateLicense(request, 
				organizationId, locale));
	}
	
	@PostMapping
	public ResponseEntity<String>createLicense(
			@PathVariable("organizationId")String organizationId,
			@RequestBody License request,
			@RequestHeader(value = "Accept-Language",required = false)
			Locale locale){
		return ResponseEntity.ok(licenseService.createLicense(request, 
				organizationId,locale));
	}
	
	@DeleteMapping(value="/{licenseId}")                                    
	   public ResponseEntity<String> deleteLicense(
	            @PathVariable("organizationId") String organizationId,
	            @PathVariable("licenseId") String licenseId,
	            @RequestHeader(value = "Accept-Language",required = false)
				Locale locale) {
	      return ResponseEntity.ok(licenseService.deleteLicense(licenseId,
	                               organizationId,locale));
	   }
	
	
	

}
