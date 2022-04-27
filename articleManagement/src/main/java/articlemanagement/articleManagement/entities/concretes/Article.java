package articlemanagement.articleManagement.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="article")
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="article_id")
    private int articleId;
	
	@Column(name="article_status")
    private int articleStatus;
	
	@Column(name="title")
    private String title;
	
	@Column(name="subject")
    private String subject;
	
	@Column(name="keywords")
    private String keywords;
	
	@Column(name="language")
    private String language;
	
	@Column(name="copyright")
    private String copyright;
	
	@Column(name="file_path")
    private String filePath;
	
	@Column(name="journal_name")
    private String journalName;
	
	@Column(name="author_name")
    private String authorName;
	
	@Column(name="editor_name")
    private String editorName;
	
	@Column(name="referee_name")
    private String refereeName;
	
	@Column(name="reject_text")
    private String rejectText;
	
	/* LOMBOKSUZ CTROS
	public Article() {
		
	}

    public Article(int id, int articleStatus, String title, String subject, String keywords, String language, String copyright, String filePath, String journalName, String authorName, String editorName, String refereeName, String rejectText) {
        this.id = id;
        this.articleStatus = articleStatus;
        this.title = title;
        this.subject = subject;
        this.keywords = keywords;
        this.language = language;
        this.copyright = copyright;
        this.filePath = filePath;
        this.journalName = journalName;
        this.authorName = authorName;
        this.editorName = editorName;
        this.refereeName = refereeName;
        this.rejectText = rejectText;
    }
	*/
    /* LOMBOKSUZ GETTER SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(int articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }

    public String getRejectText() {
        return rejectText;
    }

    public void setRejectText(String rejectText) {
        this.rejectText = rejectText;
    }
    */
}
