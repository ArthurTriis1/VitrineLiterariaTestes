/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enums.PaymentForm;
import interfaces.services.IPayService;
import models.Payment;
import utils.GenerateRandomValues;

/**
 *
 * @author arthur
 */
public class TicketPayService implements IPayService {

    public static Payment pay(Payment payment) {
        if(payment.getPaymentForm() != PaymentForm.TICKET){
            return null;
        }
        payment.setTicketHash(GenerateRandomValues.generateRandomString(20));
        payment.setPaymentForm(PaymentForm.WAIT_PAY);
        return payment;
    }
    
}
