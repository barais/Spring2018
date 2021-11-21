package sample.simple.store;

public interface IFastLane extends IStore{
    /**
     * Order the article in the quantity
     * @param articleId the id of wanted article
     * @param quantity the quantity wanted for this article
     * @param accountId the customer account id
     */
    void oneShotOrder(int articleId, int quantity, int accountId);
}
