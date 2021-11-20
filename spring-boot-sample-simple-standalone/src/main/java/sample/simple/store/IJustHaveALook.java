package sample.simple.store;

public interface IJustHaveALook extends IStore{
    double getPrice(Object article);
    boolean isAvailable(Object article);
}
