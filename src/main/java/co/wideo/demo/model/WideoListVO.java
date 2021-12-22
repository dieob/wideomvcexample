package co.wideo.demo.model;

import java.io.Serializable;
import java.util.List;

public class WideoListVO implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private List<WideoVO> wideoList;
	
	public WideoListVO() {
		super();
	}

	public WideoListVO(List<WideoVO> wideoList) {
		super();
		this.wideoList = wideoList;
	}

	public List<WideoVO> getWideoList() {
		return wideoList;
	}

	public void setWideoList(List<WideoVO> wideoList) {
		this.wideoList = wideoList;
	}

}
