package sample.simple.store;

public interface ILane extends IStore{
    void oneShotOrder(Object article, int quantity);
    void pay();
}
