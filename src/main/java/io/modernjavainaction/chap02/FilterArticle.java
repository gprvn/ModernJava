package io.modernjavainaction.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterArticle {
    public static void main(String[] args) {
        List<Article> articles = Arrays.asList(new Article(10000L, 32, 30.30),
                new Article(10001L,35,35.30),
                new Article(100002L,38,38.34),
                new Article(100003L,40,40.41),
                new Article(100004L,22,22.20));

        //      find List of articles where article size is greater then 32MB
        List<Article> heavyArticles = findHeavyArticles(articles,32);
        System.out.println("heavyArticles: "+heavyArticles);

        //      find list of articles where article_size is greater then 35 and pages are more then 35
        List<Article> highPageAndHighSize = findHighPageAndHighSize(articles,35,35);
        System.out.println("highPageAndHighSize: "+highPageAndHighSize);
    }

    private static List<Article> findHighPageAndHighSize(List<Article> articles, int page, int size) {
        List<Article> result = new ArrayList<>();
        for(Article article : articles){
            if(article.getArticleSize() > 35 && article.getArticlePages() > 35)
                result.add(article);
        }
        return result;
    }

    private static List<Article> findHeavyArticles(List<Article> articles, int weight) {
        List<Article> result = new ArrayList<>();
        for(Article article : articles){
            if(article.getArticleSize() > weight)
                result.add(article);
        }
        return result;
    }

}

class HighPageAndHighSize implements ArticlePredicate {

    @Override
    public boolean filter(Article article) {
        return article.getArticleSize() > 35 && article.getArticlePages() > 35;
    }
}

class HeavyArticles implements ArticlePredicate {

    @Override
    public boolean filter(Article article) {
        return false;
    }
}

interface ArticlePredicate {
    boolean filter(Article article);
}
class Article {
    private Long articleId;
    private Integer articlePages;
    private Double articleSize;

    public Article(Long articleId, Integer articlePages, Double articleSize) {
        this.articleId = articleId;
        this.articlePages = articlePages;
        this.articleSize = articleSize;
    }
    public Long getArticleId() {
        return articleId;
    }
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getArticlePages() {
        return articlePages;
    }

    public void setArticlePages(Integer articlePages) {
        this.articlePages = articlePages;
    }

    public Double getArticleSize() {
        return articleSize;
    }

    public void setArticleSize(Double articleSize) {
        this.articleSize = articleSize;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articlePages=" + articlePages +
                ", articleSize=" + articleSize +
                '}';
    }
}