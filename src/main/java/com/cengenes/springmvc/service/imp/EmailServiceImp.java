package com.cengenes.springmvc.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cengenes.springmvc.service.EmailService;



public class EmailServiceImp implements EmailService {
 
	private final static Logger LOGGER =LoggerFactory.getLogger(EmailServiceImp.class);
	
	@Override
	public void sendEmail() {
		LOGGER.debug("EmailServiceImp : " +"service CALLED.");
		// TODO Auto-generated method stub

	}

}
