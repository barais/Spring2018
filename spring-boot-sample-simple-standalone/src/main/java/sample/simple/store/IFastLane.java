package sample.simple.store;

public interface IFastLane extends IStore{
    void oneShotOrder(Object article, int quantity);
}
