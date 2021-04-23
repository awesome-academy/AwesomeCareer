package com.aa.awesomecareer.service;

import com.aa.awesomecareer.configuration.PaypalPaymentIntent;
import com.aa.awesomecareer.configuration.PaypalPaymentMethod;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface PaypalService {

	Payment createPayment(Double total, String currency, PaypalPaymentMethod method, PaypalPaymentIntent intent,
			String description, String cancelUrl, String successUrl) throws PayPalRESTException;

	Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;

}
