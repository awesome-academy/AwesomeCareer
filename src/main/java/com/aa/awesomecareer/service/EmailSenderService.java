package com.aa.awesomecareer.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.aa.awesomecareer.model.MailModel;

public interface EmailSenderService {
	void sendEmail(MailModel mailModel) throws MessagingException, IOException;
}
