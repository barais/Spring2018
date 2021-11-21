package sample.simple.store;

import sample.simple.domain.Article;

public interface IStore {
    boolean addArticle(Article toAdd);
}
