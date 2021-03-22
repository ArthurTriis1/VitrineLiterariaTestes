/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enums.PaymentForm;
import interfaces.services.IPayService;
import java.util.Date;
import models.Card;
import models.Payment;

/**
 *
 * @author arthur
 */
public class CardPayService implements IPayService {

    public static Payment pay(Payment payment) {
        if(payment.getPaymentForm() != PaymentForm.CARD){
            return null;
        }
        
        if(!checkCardValidate(payment.getCard())){
            return null;
        }

        payment.setPaymentForm(PaymentForm.PAYED);
        return payment;
    }
    
    private static boolean checkCardValidate(Card card){
        
        if(
          card.getName().isEmpty() || 
          card.getName() == null ||
          card.getCvv() <= 99 ||
          card.getNumber() <= 999999 ||
          card.getValidDate().before(new Date())){
            return false;
        }
        
        return true;
        
    }
    
}
