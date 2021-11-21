package sample.simple.provider.impl;

import org.springframework.stereotype.Component;
import sample.simple.provider.IProvider;

import java.util.logging.Logger;

@Component
public class Provider implements IProvider {
    /**
     * {@inheritDoc}
     * @param articleId the id of the wanted article
     * @return the price
     * Logs into global the result
     */
    @Override
    public double getPrice(int articleId) {
        Logger.getGlobal().info(String.format("[Provider] Got the price for %d", articleId));
        return 0;
    }

    /**
     * {@inheritDoc}
     * @param articleId the article we want to order
     * @param quantity the quantity in which we want to order the article
     * Logs into global the result
     */
    @Override
    public void order(int articleId, int quantity) {
        Logger.getGlobal().info(String.format("[Provider] Ordered %d of %d", quantity, articleId));
    }
}
