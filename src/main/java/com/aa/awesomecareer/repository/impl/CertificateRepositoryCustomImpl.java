package com.aa.awesomecareer.repository.impl;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.aa.awesomecareer.entity.Certificate;
import com.aa.awesomecareer.repository.CertificateRepositoryCustom;
import com.aa.awesomecareer.service.impl.CertificateServiceImp;


public class CertificateRepositoryCustomImpl implements CertificateRepositoryCustom {
	
	private static Logger log = LoggerFactory.getLogger(CertificateServiceImp.class);
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Certificate> findCertificateByUserId(Integer userId) {
		log.info("Tim certificate theo userId trong co so du lieu");
		try {
			TypedQuery<Certificate> query = entityManager.createQuery("FROM Certificate certificate WHERE certificate.userId = :userId", Certificate.class);
			query.setParameter("userId", userId);
			return query.getResultList();
		} catch (Exception e) {
			log.error("An error occurred while fetching the certificate details by userId from the database", e);
			return null;
		}
	}

	@Override
	public List<Certificate> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certificate> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certificate> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Certificate> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Certificate> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Certificate> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Certificate getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Certificate> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Certificate> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Certificate> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Certificate> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Certificate> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Certificate entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Certificate> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Certificate> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Certificate> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Certificate> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Certificate> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
