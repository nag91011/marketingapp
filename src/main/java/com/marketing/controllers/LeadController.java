package com.marketing.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadDto;
import com.marketing.entity.Lead;
import com.marketing.services.LeadService;
import com.marketing.util.EmailServiceImpl;


@Controller
public class LeadController {
		@Autowired
		private LeadService leadService;
			
		@Autowired
		private EmailServiceImpl emailService;
		
		@RequestMapping("/create")
		public String viewCreateLeadForm() {
			return "create_lead";
		}
		
//		@RequestMapping("/saveLead") 
//		public String saveOneLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
//				@RequestParam("email") String email,@RequestParam("mobile") long mobile){
//
//			Lead lead=new Lead();
//			lead.setFirstName(firstName);
//			lead.setLastName(lastName);
//			lead.setEmail(email);
//			lead.setMobile(mobile);
//			
//			leadService.saveOneLead(lead);
//			return "create_lead";
//			
//		}
		
//		@RequestMapping("/saveLead") 
//		public String saveLead(LeadDto leadDto) {
//			
//			Lead lead=new Lead();
//			
//			lead.setFirstName(leadDto.getFirstName()) ;
//			lead.setLastName(leadDto.getLastName());
//			lead.setEmail(leadDto.getEmail());
//			lead.setMobile(leadDto.getMobile());
//			leadService.saveOneLead(lead);
//			return "create_lead";
//		}
		
		@RequestMapping("/saveLead") 
		
		public String saveOneLead(@ModelAttribute("lead") Lead lead,Model model) {
			model.addAttribute("msg","data Saved Successfully");
			emailService.SendEmail(lead.getEmail(),"Welcome","welcome you are Registered");
			leadService.saveOneLead(lead);
			return "create_lead";
			
		}
		@RequestMapping("/listLead")
		public String listLeads(Model model) {
			List<Lead> leads = leadService.getList();
			model.addAttribute("leads",leads);
			return "list_leads";
		}
		
		@RequestMapping("/updateLink")
		public String updateLead(@RequestParam("id") long id, Model model) {
			
			Lead leadId = leadService.updateLead(id);
			model.addAttribute("leadId", leadId);
			return "update_lead";
		}
		
		@RequestMapping("/updateFromWeb")
		public String saveUpdate( @ModelAttribute("lead") Lead lead, Model model) {
			
			leadService.saveOneLead(lead);
			
			List<Lead> leads = leadService.getList();
			model.addAttribute("leads",leads);
			return "list_leads";	
		}
		
		@RequestMapping("/deleteLink")
		public String deleteLead(@RequestParam("id") Long id,Model model) {
			
			leadService.deleteLead(id);
			List<Lead> leads = leadService.getList();
			model.addAttribute("leads",leads);
			return "list_leads";	
			
		}
		
}
