package sample.simple.domain;

/**
 * Class that represents a customer order
 */
public class Order {

    private int orderId;
    private int articleId;
    private int quantity;

    public Order(int orderId, int articleId, int quantity) {
        this.orderId = orderId;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                "articleId=" + articleId +
                ", quantity=" + quantity +
                '}';
    }
}
