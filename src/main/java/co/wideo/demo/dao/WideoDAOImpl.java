package co.wideo.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.wideo.demo.model.WideoVO;

@Repository
public class WideoDAOImpl implements WideoDAO {
	
	List<WideoVO> wideos = new ArrayList<WideoVO>();

	private static final String JSON1 = "\r\n" + 
			"{\"id\":\"1\",\"class\":\"wideo\",\"timeStamp\":0,\"version\":6,\"width\":1080,\"height\":1080,\"scenes\":[]}";
	private static final String JSON2 = "\r\n" + 
			"{\"id\":\"2\",\"class\":\"wideo\",\"timeStamp\":0,\"version\":6,\"width\":1080,\"height\":1080,\"scenes\":[]}";

	

	public WideoDAOImpl() {
		WideoVO vo1 = new WideoVO();
		vo1.setId(1);
		vo1.setName("Wideo 1");
		vo1.setJson(JSON1);
		wideos.add(vo1);
		
		WideoVO vo2 = new WideoVO();
		vo2.setId(2);
		vo2.setName("Wideo 2");
		vo2.setJson(JSON2);
		wideos.add(vo2);
	}


	public List<WideoVO> getAllWideos() 
	{
		return this.wideos;
		
	}
	
	public void saveWideo(WideoVO wideo) {
		wideo.setId(generateNextId());
		wideos.add(wideo);
	}


	private Integer generateNextId() {
		return this.wideos.get(this.wideos.size()-1).getId()+1;
	}
}