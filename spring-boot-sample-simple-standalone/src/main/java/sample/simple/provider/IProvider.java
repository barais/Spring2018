package sample.simple.provider;

public interface IProvider {
    /**
     * Getter for the article price
     * @param articleId the id of the wanted article
     * @return the article price
     */
    double getPrice(int articleId);

    /**
     * Order the article designed by it id in given quantity
     * @param articleId the article we want to order
     * @param quantity the quantity in which we want to order the article
     */
    void order(int articleId, int quantity);
}
