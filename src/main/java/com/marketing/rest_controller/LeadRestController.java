package com.marketing.rest_controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entity.Lead;
import com.marketing.repositories.LeadRepository;

@RequestMapping("api/leads")
@RestController
public class LeadRestController {
		
		@Autowired
		private LeadRepository leadRepo;
		
		@GetMapping
		public List<Lead> getAllLeads(){
			List<Lead> leads = leadRepo.findAll();
			return leads;
		}
		
		@PostMapping
		public void saveLead(@RequestBody Lead lead) {
			leadRepo.save(lead);
			
		}
		
		@PutMapping
		public void updateLead(@RequestBody Lead lead) {
			leadRepo.save(lead);
		}
		
		@DeleteMapping("delete/{id}")
		public void deleteLead(@PathVariable("id") Long id) {
			leadRepo.deleteById(id);
		}
		
		@RequestMapping("oneLead/{id}")
		public Lead getData(@PathVariable Long id){
			
			Optional<Lead> lead = leadRepo.findById(id);
			Lead lead2 = lead.get();
			return lead2;
		}
}
