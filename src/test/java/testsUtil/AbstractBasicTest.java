package testsUtil;
/*
 * To change license header, choose License Headers in Project Properties.
 * To change template file, choose Tools | Templates
 * and open the template in the editor.
 */

import enums.BrazilianStates;
import enums.Condition;
import exceptions.EmailNotMatchException;
import java.text.ParseException;
import models.Address;
import models.Book;
import models.Cart;
import models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import repositories.BookRepository;
import repositories.UserRepository;
import services.GoogleClient;
import services.LoginService;

/**
 *
 * @author arthu
 */
public abstract class AbstractBasicTest {
    
    protected UserRepository userRepository = UserRepository.createUserRepository();
    protected BookRepository bookRepository = BookRepository.createBookRepository();
    protected GoogleClient googleClient = GoogleClient.createUserRepository();
    
    static User userMock1, userMock2, userMock3;
    static Book bookMock1, bookMock2, bookMock3, bookMock4, bookMock5, bookMock6;
    
    @BeforeClass
    public static void setUpClass() throws ParseException, EmailNotMatchException {        
        userMock1 = new User(
        "userMock1@ifpe.com.br",
        "111.111.111-11",
        "userMock1Pass",
        "Arthur Andrade",
        "27/04/1999",
            new Address(
                "Rua. Ourem",
                "San Martin",
                175,
                "Proximo a cavalaria",
                "50761340",
                "Recife",
                BrazilianStates.PE
            )
        );
        
        userMock2 = new User(
        "userMock2@ifpe.com.br",
        "222.222.222-22",
        "userMock2Pass",
        "Arthur Andrade",
        "27/04/1999",
            new Address(
                "Rua. Ourem",
                "San Martin",
                175,
                "Proximo a cavalaria",
                "50761340",
                "Recife",
                BrazilianStates.PE
            )
        );
        
        userMock3 = new User(
        "userMock3@ifpe.com.br",
        "333.333.333-33",
        "userMock3Pass",
        "Arthur Andrade",
        "27/04/1999",
            new Address(
                "Rua. Ourem",
                "San Martin",
                175,
                "Proximo a cavalaria",
                "50761340",
                "Recife",
                BrazilianStates.PE
            )
        );
        
        bookMock1 = new Book("Capitães da Areia", "Casa da ideias", Condition.NEW, 30.00, 1L);
        bookMock2 = new Book("Maus", "Quadrinhos na CIA", Condition.SEMI_NEW, 20.00, 2L);
        bookMock3 = new Book("Tres Buracos", "Mino", Condition.MANIPULATED, 50.00, 0L);
        bookMock4 = new Book("Astronauta", "Panini", Condition.SEMI_NEW, 70.00, 1L);
        bookMock5 = new Book("Supremos", "Panini", Condition.NEW, 11.00, 0L);
        bookMock6 = new Book("Capitães da areia", "Intrisseca", Condition.MANIPULATED, 31.00, 0L);
        
        Cart cart = new Cart();
        
        cart.addBook(bookMock1);
        cart.addBook(bookMock2);
        cart.addBook(bookMock3);
        
        userMock1.setCart(cart);
        
        Cart cart2 = new Cart();
        
        cart2.addBook(bookMock4);
        cart2.addBook(bookMock5);
        cart2.addBook(bookMock6);
        
        userMock2.setCart(cart2);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    @Before
    public void setUp() {
        userRepository.create(userMock1);
        userRepository.create(userMock2);
        userRepository.create(userMock3);
        bookRepository.create(bookMock1);
        bookRepository.create(bookMock2);
        bookRepository.create(bookMock3);
        bookRepository.create(bookMock4);
        bookRepository.create(bookMock5);
        bookRepository.create(bookMock6);
        LoginService.setUserLoggedId(null);
    }
    
    @After
    public void tearDown() {
      userRepository.clear();
      bookRepository.clear();
      LoginService.setUserLoggedId(null);
    }
    
}
