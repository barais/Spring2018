package sample.simple.store;

public interface IJustHaveALook extends IStore{
    /**
     * Getter for the article price
     * @param articleId the targeted article
     * @return the price
     */
    double getPrice(int articleId);

    /**
     * Returns if the article is available to order or not
     * @param articleId the targeted article
     * @return if the article could be ordered or not
     */
    boolean isAvailable(int articleId);
}
