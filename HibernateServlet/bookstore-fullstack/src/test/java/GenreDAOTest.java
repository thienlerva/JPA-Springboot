import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;

import org.junit.Test;

import com.ex.dao.DAO;
import com.ex.dao.GenreDao;
import com.ex.pojo.Genre;

public class GenreDAOTest {

	 
	DAO<Genre, Integer> dao;
	private static Logger logger = Logger.getLogger(GenreDAOTest.class);
	
	private void setUp() {
		// TODO Auto-generated method stub
		dao = new GenreDao();
		System.out.println("Setting up instance before test");

	}
	@Test
	public void test() {
		List<Genre> genres = dao.findAll();
		for(Genre g : genres) {
			logger.debug(g);
		}
		
		assertNotNull(genres);
		assertTrue(genres.size() > 0);
		
		
	}

	
	
}
