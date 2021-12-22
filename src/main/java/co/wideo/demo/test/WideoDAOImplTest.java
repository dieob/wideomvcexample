package co.wideo.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import co.wideo.demo.dao.WideoDAOImpl;
import co.wideo.demo.model.WideoVO;

public class WideoDAOImplTest {

	private static final String JSON1 = "\r\n" + 
			"{\"id\":\"1\",\"class\":\"wideo\",\"timeStamp\":0,\"version\":6,\"width\":1080,\"height\":1080,\"scenes\":[]}";
	private static final String JSON2 = "\r\n" + 
			"{\"id\":\"2\",\"class\":\"wideo\",\"timeStamp\":0,\"version\":6,\"width\":1080,\"height\":1080,\"scenes\":[]}";
	private static final String JSON3 = "\r\n" + 
			"{\"id\":\"3\",\"class\":\"wideo\",\"timeStamp\":0,\"version\":6,\"width\":1080,\"height\":1080,\"scenes\":[]}";

	
	WideoDAOImpl wideoDAO = new WideoDAOImpl();
	
	@Test
	public void testGetAllWideos() {
		List<WideoVO> wideos = wideoDAO.getAllWideos();
		
		assertEquals(wideos.size(), 2);
		assertTrue(wideos.get(0).getId()==1);
		assertTrue(wideos.get(0).getName().equalsIgnoreCase("Wideo 1"));
		assertTrue(wideos.get(0).getJson().equalsIgnoreCase(JSON1));
		
		assertTrue(wideos.get(1).getId()==2);
		assertTrue(wideos.get(1).getName().equalsIgnoreCase("Wideo 2"));
		assertTrue(wideos.get(1).getJson().equalsIgnoreCase(JSON2));
	}
	
	@Test
	public void testSaveWideo() {
		WideoVO newWideo = new WideoVO();
		newWideo.setJson(JSON3);
		newWideo.setName("Wideo 3");
		
		wideoDAO.saveWideo(newWideo);
		
		List<WideoVO> wideoList = wideoDAO.getAllWideos();
		
		assertEquals(wideoList.size(), 3);
		assertTrue(wideoList.get(2).getId()==3);
		assertTrue(wideoList.get(2).getName().equalsIgnoreCase("Wideo 3"));
		assertTrue(wideoList.get(2).getJson().equalsIgnoreCase(JSON3));
	}
}
