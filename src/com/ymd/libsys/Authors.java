package com.ymd.libsys;

import java.util.ArrayList;
import java.util.List;

public class Authors {

	private List<Author> authors;
	
	public Authors () {
		authors = new ArrayList<>();
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
