package sample.aop.store;

import sample.aop.domain.Article;

public interface IStore {
    boolean addArticle(Article toAdd);
}
