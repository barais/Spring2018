package sample.simple.store.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.bank.IBank;
import sample.simple.domain.Article;
import sample.simple.domain.Order;
import sample.simple.provider.IProvider;
import sample.simple.store.IFastLane;
import sample.simple.store.IJustHaveALook;
import sample.simple.store.ILane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class Store implements IFastLane, ILane, IJustHaveALook {

    private final int storeBankAccountId = 123456789;

    @Autowired
    private IBank bank;

    @Autowired
    private IProvider provider;

    // Map of known carts where the cart id is the key in the map
    Map<Integer, Order> carts = new HashMap<>();
    List<Article> articles = new ArrayList<>();

    @Override
    public void oneShotOrder(int articleId, int quantity, int accountId) {
        int cartId = carts.size() +1;
        addItemToCart(articleId, quantity, cartId);
        pay(cartId, accountId);
    }

    @Override
    public double getPrice(int articleId) {
        return provider.getPrice(articleId);
    }

    @Override
    public boolean isAvailable(int articleId) {
        return provider.getArticleById(articleId).getStock() > 0;
    }

    @Override
    public void addItemToCart(int articleId, int quantity, int cartId) {
        if(carts.containsKey(cartId)){
            carts.get(cartId).setArticleId(articleId);
            carts.get(cartId).setQuantity(quantity);
        }
        else
            carts.put(cartId, new Order(articleId, quantity));
    }

    @Override
    public void pay(int cartId, int accountId) {
        if(carts.containsKey(cartId)){
            Order order = carts.get(cartId);
            Article article = provider.getArticleById(order.getArticleId());
            article.takeFromStock(order.getQuantity());
            bank.transfert((article.getPrice() * order.getQuantity()), accountId, storeBankAccountId);
            carts.remove(cartId);
        }
        else{
            Logger.getGlobal().warning(String.format("[Store] Couldn't find cart with id %d", cartId));
        }
    }

    /**
     * Adds an article to the store
     * @param toAdd the article to add
     * @return if the addition was a success
     */
    @Override
    public boolean addArticle(Article toAdd){
        return this.articles.add(toAdd);
    }

}
