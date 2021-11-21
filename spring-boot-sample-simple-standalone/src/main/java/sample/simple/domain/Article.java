package sample.simple.domain;

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

    @Override
    public String toString() {
        return "Article{" +
                "Articleid=" + Articleid +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
