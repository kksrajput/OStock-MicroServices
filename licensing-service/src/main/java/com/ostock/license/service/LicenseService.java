package com.ostock.license.service;

import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.ostock.license.model.License;
@Service
public class LicenseService {
	
	@Autowired
	MessageSource messages;
	//hardcoded for now
	//will be changed later on
	public License getLicense(String licenseId,String organizationId) {
		
		
		License license = new License();
		license.setId(new Random().nextInt(1000));
		license.setLicenseId(licenseId);
		license.setOrganizationId(organizationId);
		license.setDescription("Software product");
		license.setProductName("Ostock");
		license.setLicenseType("full");
		return license;
	}

	public String createLicense(License license, String organizationId,Locale locale) {
		String responseMessage = null;
		if(license != null) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format(messages.getMessage("license.create.message"
					,null,locale));
//			responseMessage = String.format("This is the post"
//					+ " and the object is: %s", license.toString());
		}
		return responseMessage;
		
	}
	
	public String updateLicense(License license, String organizationId,Locale locale) {
		String responseMessage = null;
		if(license != null) {
			license.setOrganizationId(organizationId);
			responseMessage = String.format(messages.getMessage("license.update.message"
					,null,locale));
//			responseMessage = String.format("This is the put"
//					+ " and the object is: %s", license.toString());
		}
		return responseMessage;
	}
	
	public String deleteLicense(String licenseId, String organizationId,Locale locale) {
		String responseMessage = null;
		responseMessage = String.format(messages.getMessage("license.delete.message"
				,null,locale));
//			responseMessage = String.format("Deleting license with id %s"
//					+ " for the organization %s", licenseId, organizationId);
		return responseMessage;
	}
}
