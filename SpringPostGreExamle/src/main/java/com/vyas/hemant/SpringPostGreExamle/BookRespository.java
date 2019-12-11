package com.vyas.hemant.SpringPostGreExamle;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public abstract interface BookRespository extends CrudRepository<Book, Long>
{
	  public abstract List<Book> findByName(String paramString);

}
