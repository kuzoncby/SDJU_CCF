package edu.sdju.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import edu.sdju.model.Data;

@Transactional
public interface DataDao extends CrudRepository<Data, Long>{
	
	public List<Data> findByPlatform(int Platform);
	
}
