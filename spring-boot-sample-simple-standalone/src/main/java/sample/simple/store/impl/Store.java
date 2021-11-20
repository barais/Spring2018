package sample.simple.store.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.bank.IBank;
import sample.simple.provider.IProvider;
import sample.simple.store.IStore;

@Component
public class Store implements IStore {

    @Autowired
    private IBank iBank;

    @Autowired
    private IProvider iProvider;


    @Override
    public String getProductInfo(int productId) {
        return String.format("Product: {id: %d}", productId);
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public boolean isAvailable(int productId) {
        return false;
    }
}
