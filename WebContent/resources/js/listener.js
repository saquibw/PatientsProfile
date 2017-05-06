var ExamFindingsListener = (function(){
	
	var attach = function(){
		$(".liverValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".liverValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});	
		
		$(".spleenValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".spleenValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".lymphNodeValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".lymphNodeValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".lungsValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".lungsValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".heartValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".heartValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".nervousSystemValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".nervousSystemValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".clubingValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".clubingValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".gynaecomastiaValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".gynaecomastiaValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".ascitisValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".ascitisValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".cyanosisValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".cyanosisValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".oedemaValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".oedemaValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".jaundiceValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".jaundiceValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".anaemiaValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".anaemiaValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".koilonychiaValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".koilonychiaValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".palmarErythemaValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".palmarErythemaValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".flappingTremorValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".flappingTremorValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".mcTendernessValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".mcTendernessValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".lowerAbdomenValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".lowerAbdomenValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".uSugarValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".uSugarValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
	}
	
	return{
		attach: attach
	}
	
})();

var InvestigationListener = (function(){
	
	var attach = function(){
		$(".uRbcValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		
		$(".uRbcValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		
		$(".pfMalignantCellsValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		
		$(".pfMalignantCellsValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
	}
	
	return{
		attach: attach
	}
})();