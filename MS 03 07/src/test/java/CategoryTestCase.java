import junit.framework.TestCase;
import mvc.MUSIC_STORE.dao.CategoryDAO;
import mvc.MUSIC_STORE.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class CategoryTestCase {

    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private Category category;

    @BeforeClass
    public static void init() {

        context = new AnnotationConfigApplicationContext();
        context.scan("mvc.MUSIC_STORE");
        context.refresh();
        categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
    }

    @Test
    public void testAddCategory() {
        category = new Category();

        category.setName("Mobile");
        category.setDescription("This is some description for mobile");
        category.setImageURL("CAT_3.png");

      assertTrue("Successfully added a category inside the table", categoryDAO.add(category));
    }
}
