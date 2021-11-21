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
        return getArticleById(articleId).getStock() > 0;
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
            getArticleById(order.getArticleId()).takeFromStock(order.getQuantity());
            Logger.getGlobal().info(String.format("[Store] Payed the cart %d, on account %d", cartId, accountId));
            carts.remove(cartId);
        }
        else{
            Logger.getGlobal().info(String.format("[Store] Couldn't find cart with id %d", cartId));
        }
    }

    private Article getArticleById(int articleId) {
        return this.articles.stream().filter(art -> art.getArticleid() == articleId).findFirst().orElse(null);
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
