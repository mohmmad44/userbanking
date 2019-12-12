package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.banking.dto.BankBranchsDto;
import com.banking.model.Bank;
import com.banking.model.BankBranchs;
import com.banking.service.BankService;

@Controller
public class BankBranchController {

	@Autowired
	BankService bankService;

	@GetMapping("/getbankbranchs")
	public String getBanks(Model model) {

		List<Bank> bankList = bankService.getBanks();
		model.addAttribute("allbanks", bankList);

		List<BankBranchs> bankBranchs = bankService.getBankBranchs();
		model.addAttribute("bankBranchs", bankBranchs);

		model.addAttribute("bankBranch", new BankBranchsDto());
		model.addAttribute("isSaved", true);

		return "view/bankbranchs";

	}

	@PostMapping("/savebankbranch")
	public String saveBankBranch(@ModelAttribute BankBranchsDto bankBranch, Model model) {
		bankService.saveBankBranch(bankBranch);

		return "redirect:/getbankbranchs";
	}

	@PostMapping("/updatebankbranch")
	public String updateBank(@ModelAttribute BankBranchsDto bankBranch, Model model) {
		bankService.updateBankBranch(bankBranch);
		return "redirect:/getbankbranchs";
	}

	@GetMapping("/getbankbranchs/{id}")
	public String getBankBranch(@PathVariable Integer id, Model model) {

		List<Bank> bankList = bankService.getBanks();
		model.addAttribute("allbanks", bankList);
		
		List<BankBranchs> bankBranchs = bankService.getBankBranchs();
		model.addAttribute("bankBranchs", bankBranchs);

		BankBranchs bankBranch = bankService.getBankBranch(id);
		
		
		BankBranchsDto bankBranchDto = new BankBranchsDto();
		
		bankBranchDto.setBankAddress(bankBranch.getBankAddress().getBankAddress());
		bankBranchDto.setBankBranch(bankBranch.getBankAddress().getBankBranch());
		bankBranchDto.setIfscCode(bankBranch.getBankAddress().getIfscCode());
		bankBranchDto.setBankAddressId(bankBranch.getBankAddress().getId());
		bankBranchDto.setBankId(bankBranch.getBank().getId());
		
		model.addAttribute("bankBranch", bankBranchDto);
		model.addAttribute("isSaved", false);

		return "view/bankbranchs";

	}
	
	@GetMapping("/getbankbranchs/{branchid}/{addressId}")
	public String deleteBankBranch(@PathVariable Integer branchid, @PathVariable Integer addressId) {
		bankService.deleteBankBranch(branchid, addressId);
		return "redirect:/getbankbranchs";
	}
	

}
