package com.marketing.services;

import java.util.List;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;

public interface LeadService {
	
	public void saveOneLead(Lead lead);

	public List<Lead> getList();

	public Lead updateLead(long id);

	public void deleteLead(long id);

}

