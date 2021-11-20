package sample.simple.store;

public interface IStore {
    String getProductInfo(int productId);
    double getPrice();
    boolean isAvailable(int productId);
}
