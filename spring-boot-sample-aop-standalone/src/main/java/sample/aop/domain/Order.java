package sample.aop.domain;

/**
 * Class that represents a customer order
 */
public class Order {

    private int articleId;
    private int quantity;

    public Order(int articleId, int quantity) {
        this.articleId = articleId;
        this.quantity = quantity;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "articleId=" + articleId +
                ", quantity=" + quantity +
                '}';
    }
}
