var ExamFindingsListener = (function(){
	
	var attach = function(){
		$(".liverValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".spleenValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".lymphNodeValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".lungsValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".heartValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		$(".nervousSystemValue").keyup(function(){
			PatientManager.updateRadioButtonValue(this.className.split(" ")[0], $(this).val());
		});
		
		$(".liverValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});		
		$(".spleenValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		$(".lymphNodeValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		$(".lungsValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		$(".heartValue").focus(function(){
			PatientManager.selectRadioButton(this.className.split(" ")[0]);
		});
		$(".nervousSystemValue").focus(function(){
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
	}
	
	return{
		attach: attach
	}
})();