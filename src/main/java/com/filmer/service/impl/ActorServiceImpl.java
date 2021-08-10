package com.filmer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmer.dao.IActorDao;
import com.filmer.entities.Actor;
import com.filmer.service.IActorService;

@Service
public class ActorServiceImpl implements IActorService{
	
	@Autowired
	private IActorDao actorDao;

	@Override
	public void saveActor(Actor actor) {
		actorDao.save(actor);
	}

}
