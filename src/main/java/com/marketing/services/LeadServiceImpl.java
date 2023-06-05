package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entity.Lead;
import com.marketing.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(Lead lead) {
		leadRepo.save(lead);
		
	}

	@Override
	public List<Lead> getList() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public Lead updateLead(long id) {
			Optional<Lead> findById = leadRepo.findById(id);
			Lead lead = findById.get();
			return lead;
	}

	@Override
	public void deleteLead(long id) {
		leadRepo.deleteById(id);
	}

}
