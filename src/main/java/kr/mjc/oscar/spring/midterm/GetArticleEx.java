package kr.mjc.oscar.spring.midterm;

import kr.mjc.oscar.java.jdbc.article.Article;
import kr.mjc.oscar.java.jdbc.article.ArticleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

@Slf4j
public class GetArticleEx {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

    ArticleDao articleDao = context.getBean(ArticleDao.class);

    try {
      Article article = articleDao.getArticle(1000);
      log.info(article.toString());
    } catch (EmptyResultDataAccessException e) {
      log.error("데이터가 없습니다.");
    }
  }
}
