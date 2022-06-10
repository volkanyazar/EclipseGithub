package articlemanagement.articleManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import articlemanagement.articleManagement.business.abstracts.ArticleService;
import articlemanagement.articleManagement.core.utilities.results.DataResult;
import articlemanagement.articleManagement.core.utilities.results.Result;
import articlemanagement.articleManagement.core.utilities.results.SuccessDataResult;
import articlemanagement.articleManagement.core.utilities.results.SuccessResult;
import articlemanagement.articleManagement.dataAccess.abstracts.ArticleDao;
import articlemanagement.articleManagement.entities.concretes.Article;
import articlemanagement.articleManagement.entities.dtos.ArticleWithUserDto;

@Service
public class ArticleManager implements ArticleService{

	private ArticleDao articleDao;
	
	@Autowired
	public ArticleManager(ArticleDao articleDao) {
		super();
		this.articleDao = articleDao;
	}

	@Override
	public DataResult<List<Article>> getAll() {
	
		return new SuccessDataResult<List<Article>>
		(this.articleDao.findAll(),"Dergiler başarıyla Listelendi");
				
				
	}

	@Override
	public Result add(Article article) {
		this.articleDao.save(article);
		
		return new SuccessResult("Dergi başarıyla eklendi");
	}

	@Override
	public DataResult<Article> getBySubject(String subject) {
		return new SuccessDataResult<Article>
		(this.articleDao.getBySubject(subject),"Dergiler başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Article>> getByArticleIdIn(List<Integer> articles) {
		return new SuccessDataResult<List<Article>>
		(this.articleDao.getByArticleIdIn(articles),"Dergiler başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Article>> getByJournalNameContains(String journalName) {
		return new SuccessDataResult<List<Article>>
		(this.articleDao.getByJournalNameContains(journalName),"Dergiler başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Article>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Article>>
		(this.articleDao.findAll(pageable).getContent());
		}

	@Override
	public DataResult<List<Article>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"journalName");
		return new SuccessDataResult<List<Article>>
		(this.articleDao.findAll(sort),"Başarılı bir şekilde sıralandı");
	}

	@Override
	public DataResult<List<ArticleWithUserDto>> getArticleWithAuthorDetails() {
		return new SuccessDataResult<List<ArticleWithUserDto>>
		(this.articleDao.getArticleWithAuthorDetails(),"Veriler Başarıyla Listelendi");
	}
}
