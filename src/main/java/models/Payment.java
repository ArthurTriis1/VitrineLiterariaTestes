/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import enums.PaymentForm;

/**
 *
 * @author arthur
 */
public class Payment {
    PaymentForm paymentForm;
    Card card;
    String ticketHash;
    Double totalValue;

    public Payment(Double totalValue) {
        this.totalValue = totalValue;
        this.paymentForm = PaymentForm.NO_CHOSEN;
    }
    
    

    public PaymentForm getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(PaymentForm paymentForm) {
        this.paymentForm = paymentForm;
    }

    public Card getCard() {
        if(paymentForm == PaymentForm.CARD){
            return card;
        }
        
        return null;
        
    }

    public void setCard(Card card) {
        paymentForm = PaymentForm.CARD;
        this.card = card;
    }

    public String getTicketHash() {
        if(paymentForm == PaymentForm.WAIT_PAY){
            return ticketHash;
        }
        return null;
    }
    
    public void setTicketHash(String hash){
        this.ticketHash = hash;
        this.paymentForm = this.paymentForm.TICKET;
    }

    public Double getTotalValue() {
        return totalValue;
    }

}
