/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import enums.PaymentForm;
import java.text.ParseException;
import models.Card;
import models.Payment;
import models.User;
import org.junit.Test;
import static org.junit.Assert.*;
import services.CardPayService;
import services.TicketPayService;
import testsUtil.AbstractBasicTest;

/**
 *
 * @author arthur
 */
public class PayCartTest extends AbstractBasicTest{
    
    @Test
    public void UsuarioConfirmaCompra () {
        Double expectedTotalValue = 100.0;
        
        User user = userRepository.findById(0L);
        
        Payment payment = user.getCart().generatePayment();
        
        assertEquals(payment.getTotalValue(), expectedTotalValue);
    }
    
    @Test
    public void UsuarioEscolheBoleto () {       
        User user = userRepository.findById(0L);
        
        Payment payment = user.getCart().generatePayment();
        
        payment.setPaymentForm(PaymentForm.TICKET);
        
        Payment paymentTicket = TicketPayService.pay(payment);
        
        assertNotNull(paymentTicket);
        assertEquals(paymentTicket.getTicketHash().length(), 20);
        
    }
    
    @Test
    public void UsuarioEscolheCartao () throws ParseException {       
        User user = userRepository.findById(0L);
        
        Payment payment = user.getCart().generatePayment();
        
        payment.setPaymentForm(PaymentForm.CARD);
        
        payment.setCard(new Card(
            538157988L,
            312,
            "04/22",
            "Arthur F G Andrade"
        ));
        
        Payment paymentCard = CardPayService.pay(payment);
        
        assertNotNull(paymentCard);
        assertEquals(paymentCard.getPaymentForm(), PaymentForm.PAYED);
        
    }
    
    @Test
    public void UsuarioEscolheCartaoInvalido () throws ParseException {       
        User user = userRepository.findById(0L);
        
        Payment payment = user.getCart().generatePayment();
        
        payment.setPaymentForm(PaymentForm.CARD);
        
        payment.setCard(new Card(
            123L,
            0,
            "04/99",
            ""
        ));
        
        Payment paymentCard = CardPayService.pay(payment);
        
        assertNull(paymentCard);       
    }
}
