package com.banking.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banking.dto.UserBankBranchsDto;
import com.banking.model.Bank;
import com.banking.model.BankBranchs;
import com.banking.model.UserBankBranchs;
import com.banking.service.BankService;

@Controller
public class UserBankBranchsController {
	
	@Autowired
	BankService bankService;

	@GetMapping("/getuserbank")
	public String getUserBankController(Model model) {
		
		List<Bank> allBanks = bankService.getBanks();
		model.addAttribute("allBanks", allBanks);
		
		
		List<UserBankBranchs> userBankBranchs = bankService.getUserBankBranchs();
		model.addAttribute("userBankBranchs", userBankBranchs);
		
		model.addAttribute("userbankbranch", new UserBankBranchsDto());
		
		model.addAttribute("isSaved", true);
		
		return "view/userbankbranchs";
	}
	
	@PostMapping("/saveuserbankbranch")
	public String saveUserBankBranch(@ModelAttribute UserBankBranchsDto userBankBranch) {
		bankService.saveUserBankBranch(userBankBranch);
		return "redirect:/getuserbank";
	}
	
	
	@GetMapping("/getuserbank/{id}")
	public @ResponseBody List<BankBranchs> getBankBranchs(@PathVariable Integer id){
		return bankService.getbankBranchs(id);	
	}
	
	
	
}
