package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.banking.model.Bank;
import com.banking.service.BankService;

@Controller
public class BankController {

	@Autowired
	BankService bankService;

	@GetMapping("/getbanks")
	public String getBanks(Model model) {

		List<Bank> bankList = bankService.getBanks();
		model.addAttribute("allbanks", bankList);
		model.addAttribute("bank", new Bank());
		model.addAttribute("isSaved", true);
		return "view/bank";
	}

	
	@PostMapping("/savebank")
	public String saveBanks(@ModelAttribute Bank bank, Model model) {
		
		Bank dBBanks= bankService.saveBanks(bank);
		if(dBBanks!=null) {
			
		} else {
			
		}
		
		return "redirect:/getbanks";
		
		
	}
	
	@GetMapping("/getbank/{id}")
	public String getBank(@PathVariable Integer id, Model model) {
	
		List<Bank> bankList = bankService.getBanks();
		model.addAttribute("allbanks", bankList);
		Bank dBBank = bankService.getBank(id);
		model.addAttribute("bank", dBBank);
		model.addAttribute("isSaved", false);
		
		return "view/bank";
		
	}
	
	
	@PostMapping("/updatebank")
	public String updateBank(@ModelAttribute Bank bank, Model model) {
		
		bankService.updateBank(bank);
		
		return "redirect:/getbanks";
	}
	
	
	@GetMapping("/deletebank/{id}")
	public String deleteBank(@PathVariable Integer id) {
		
		bankService.deleteBank(id);
		return "redirect:/getbanks";
		
		
	}
	
	
	
	
	
}
	