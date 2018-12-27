package com.app.elib.paypal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.elib.paypal.config.PaypalPaymentIntent;
import com.app.elib.paypal.config.PaypalPaymentMethod;
import com.app.elib.paypal.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class RestGatewayController {

	/*@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public void paymentGateway(){
		Gateway gateway = GatewayFactory.getGateway(AvailableGateways.AUTHORIZE);
		 gateway.setTestMode(true);
		 JSONObject apiSampleParameters = gateway.getApiSampleParameters();
		    System.out.println(apiSampleParameters);
	}
	*/
	
	public static final String PAYPAL_SUCCESS_URL = "pay/success";
	public static final String PAYPAL_CANCEL_URL = "pay/cancel";
	
	@Autowired
	private PaypalService paypalService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/pay")
	public String pay(HttpServletRequest request){
		String cancelUrl = com.app.elib.utils.URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
		String successUrl = com.app.elib.utils.URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
		try {
			Payment payment = paypalService.createPayment(
					4.00, 
					"USD", 
					PaypalPaymentMethod.paypal, 
					PaypalPaymentIntent.sale,
					"payment description", 
					cancelUrl, 
					successUrl);
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			e.getMessage();
		}
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
	public String cancelPay(){
		return "cancel";
	}

	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				return "success";
			}
		} catch (PayPalRESTException e) {
			e.getMessage();
		}
		return "redirect:/";
	}
	
	
}
