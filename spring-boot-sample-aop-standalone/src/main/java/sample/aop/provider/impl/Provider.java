package sample.aop.provider.impl;

import org.springframework.stereotype.Component;
import sample.aop.domain.Article;
import sample.aop.provider.IProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class Provider implements IProvider {

    // The provider might have more references than the store that use it.
    List<Article> articles = new ArrayList<>();

    /**
     * {@inheritDoc}
     *
     * @param articleId the id of the wanted article
     * @return the price
     * Logs into global the result
     */
    @Override
    public double getPrice(int articleId) {
        Logger.getGlobal().info(String.format("[Provider] Got the price for %d", articleId));
        return getArticleById(articleId).getPrice();
    }

    /**
     * {@inheritDoc}
     *
     * @param articleId the article we want to order
     * @param quantity the quantity in which we want to order the article
     * Logs into global the result
     */
    @Override
    public void order(int articleId, int quantity) {
        Logger.getGlobal().info(String.format("[Provider] Ordered %d of %d", quantity, articleId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addArticle(Article toAdd) {
        return articles.add(toAdd);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article getArticleById(int articleId) {
        return this.articles.stream().filter(art -> art.getArticleid() == articleId).findFirst().orElse(null);
    }

}
