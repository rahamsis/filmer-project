package com.filmer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmer.dao.IPeliculasDAO;
import com.filmer.entities.Pelicula;
import com.filmer.service.IPeliculaService;

@Service
public class peliculasServiceImpl implements IPeliculaService {

	@Autowired
	private IPeliculasDAO peliculasDao;
	
	@Override
	public void Save(Pelicula pelicula) {
		peliculasDao.save(pelicula);
		
	}

}
