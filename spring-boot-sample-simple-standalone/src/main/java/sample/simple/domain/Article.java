package sample.simple.domain;

import java.util.logging.Logger;

public class Article {

    int Articleid;
    double price;
    int stock;

    public Article(int articleid, double price, int stock) {
        Articleid = articleid;
        this.price = price;
        this.stock = stock;
    }

    public int getArticleid() {
        return Articleid;
    }

    public void setArticleid(int articleid) {
        Articleid = articleid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Take as much as possible from the stock
     * @param amount the wanted amount
     * @return the amount took from stock
     */
    public int takeFromStock(int amount){
        int ret;
        if(amount < 0){
            Logger.getGlobal().warning("[Article] Can't take negative amount.");
            return 0;
        }
        // the amount is included inside the stock;
        if(amount <= stock){
            stock -= amount;
            Logger.getGlobal().warning(String.format("[Article] Took %d from the stock.", amount));
            return amount;
        }
        else{
            Logger.getGlobal().warning("[Article] Request overflow.");
            ret = stock;
            stock = 0;
            Logger.getGlobal().warning(String.format("[Article] Took %d from the stock.", amount));
            return ret;
        }
    }

    @Override
    public String toString() {
        return "Article{" +
                "Articleid=" + Articleid +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
