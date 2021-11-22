package sample.aop.store;

public interface ILane extends IStore{

    /**
     * Add article in given quantity to the shopping cart
     * @param articleId the article id
     * @param quantity the quantity wanted
     * @param cartId the client account id
     */
    void addItemToCart(int articleId, int quantity, int cartId);

    /**
     * Take from the customer account the price of the cart
     * @param cartId the customer cart id
     * @param accountId the customer account id
     */
    void pay(int cartId, int accountId);
}
