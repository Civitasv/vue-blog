import com.blog.application.MyApplication;
import com.blog.application.dao.ArticleDao;
import com.blog.application.dao.LabelDao;
import com.blog.application.dao.impl.ArticleDaoImpl;
import com.blog.application.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class TestJDBC {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private LabelDao labelDao;

    @Test
    public void test(){
        System.out.println(articleDao.getArticleByID(2));
    }

    @Test
    public void test2(){
        System.out.println(labelDao.getAllLabels());
    }
}
