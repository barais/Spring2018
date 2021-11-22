package sample.aop.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.aop.client.IClient;
import sample.aop.domain.Article;
import sample.aop.provider.IProvider;
import sample.aop.security.SecurityManager;
import sample.aop.store.impl.Store;

@Component
public class Client implements IClient {

    @Autowired
    Store store;

    @Autowired
    IProvider provider;

    /**
     * {@inheritDoc}
     * Scenario of program usage
     */
    @Override
    public void run() {

        Article screen = new Article(1, 200.0, 15, "Screen");
        Article desktop = new Article(2, 123.4, 10, "Desktop");
        Article chair = new Article(3, 430, 50, "Chair");

        // add articles to the provider
        provider.addArticle(screen);
        provider.addArticle(desktop);
        provider.addArticle(chair);

        // add articles to the store
        store.addArticle(screen);
        store.addArticle(desktop);

        // get price for a screen
        System.out.println(store.getPrice(1));


        // show screen information from the store:
        System.out.println(screen);

        //order a screen
        store.oneShotOrder(1, 1, 123);

        // show screen information from the store:
        System.out.println(screen);

        // buy two chairs as an oneshotorder
        store.oneShotOrder(3, 2, 123);

        // add a desktop to the cart
        store.addItemToCart(2, 1, 1);

        // pay for the cart
        store.pay(1, 123);

        // show desktop info
        System.out.println(desktop);

        // Let's trigger an error as non logged user
        SecurityManager.logout();
        try{
            store.oneShotOrder(3, 2, 123);
        }
        catch (SecurityException e){
            System.out.println("Succes with the security manager!");
        }

    }
}
