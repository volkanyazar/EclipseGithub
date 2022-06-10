package articlemanagement.articleManagement.business.abstracts;

import java.util.List;

import articlemanagement.articleManagement.core.utilities.results.DataResult;
import articlemanagement.articleManagement.core.utilities.results.Result;
import articlemanagement.articleManagement.entities.concretes.Article;
import articlemanagement.articleManagement.entities.dtos.ArticleWithUserDto;

public interface ArticleService {
	DataResult<List<Article>> getAll();
	DataResult<List<Article>> getAllSorted();
	DataResult<List<Article>> getAll(int pageNo, int pageSize);
	
	Result add(Article article);
	
	DataResult<Article> getBySubject(String subject);
	
	DataResult<List<Article>> getByArticleIdIn(List<Integer> articles);
	
	DataResult<List<Article>> getByJournalNameContains(String journalName);
	DataResult<List<ArticleWithUserDto>> getArticleWithAuthorDetails();
}
