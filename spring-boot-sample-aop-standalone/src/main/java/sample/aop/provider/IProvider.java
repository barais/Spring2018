package sample.aop.provider;

import sample.aop.domain.Article;

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

    /**
     * Adds an article to the store
     * @param toAdd the article to add
     * @return if the addition was a success
     */
    boolean addArticle(Article toAdd);

    /**
     * return an article from the id
     * @param articleId the id
     * @return the article
     */
    Article getArticleById(int articleId);
}
