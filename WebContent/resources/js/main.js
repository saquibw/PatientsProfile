
var PatientManager = (function(){
	var saveToSessionStorage = function(key, value){
		sessionStorage.setItem(key, value);
	}
	
	var getFromSessionStorage = function(key){
		return sessionStorage.getItem(key);
	}
	
	var setRegNo = function(day, month, year){
		var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
		var request = $.ajax({
			type: "GET",
			url: "getRegNo",
			dataType: 'JSON',
			data: {
				"day": day,
				"month": month,
				"year": year
			}
		});
		
		request.done(function(response){
			if(response.success){
				var regNo = response.regNo;
				if(month.split("")[0]=="0"){
					month = month.split("")[1];
				}
				var displayRegNo = year + "/" + day + "/" + months[parseInt(month)-1] + "/" + regNo;
				
				$("#regNo").val(displayRegNo);
			}
		});
	}
	
	var getPatientVisitList = function(searchCriteria){
		var request = $.ajax({
			type: "GET",
			url: "getPatientVisitList",
			dataType: 'JSON',
			data: {
				"searchCriteria": searchCriteria
			}
		});
		
		request.done(function(response){
			if(response.success){
				$("#patientVisitTable tbody").empty();
				$("#noPatientNotification").removeClass("hide");
				var patientList = JSON.parse(response.patientList);
				if(patientList){
					if(patientList.length > 0){
						$("#noPatientNotification").addClass("hide");
						$.each(patientList, function(key, patient){
							var colStart = "<td>";
							var colEnd = "</td>";
							var html = "<tr>";
							html += colStart + patient.visitDate + colEnd;
							html += colStart + patient.regNo + colEnd;
							html += colStart + patient.patientName + colEnd;
							html += colStart + patient.contactNo + colEnd;
							html += colStart + patient.zilla + colEnd;
							html += colStart + patient.chiefComplains + colEnd;
							html += colStart + patient.finalDiagnosis + colEnd;
							html += colStart + "<a class='btn btn-primary' href='viewvt?visitId=" + patient.visitId + "'>View</a>" + colEnd;
							html += colStart + "<a class='btn btn-danger' href='deletepatientvisit?visitId=" + patient.visitId + "'>Delete</a>" + colEnd;
							html += "</tr>";
							
							$("#patientVisitTable tbody").append(html);
						});
					}
				}
			}
		});
	};
	
	var getPatientList = function(searchCriteria){
		var request = $.ajax({
			type: "GET",
			url: "getPatientViewList",
			dataType: 'JSON',
			data: {
				"searchCriteria": searchCriteria
			}
		});
		
		request.done(function(response){
			if(response.success){
				$("#patientViewTable tbody").empty();
				$("#noPatientNotification").removeClass("hide");
				var patientList = JSON.parse(response.patientList);
				if(patientList){
					if(patientList.length > 0){
						$("#noPatientNotification").addClass("hide");
						$.each(patientList, function(key, patient){
							var colStart = "<td>";
							var colEnd = "</td>";
							var html = "<tr>";
							html += colStart + patient.regNo + colEnd;
							html += colStart + patient.name + colEnd;
							html += colStart + patient.age + colEnd;
							html += colStart + patient.sex + colEnd;
							html += colStart + patient.profession + colEnd;
							html += colStart + patient.contactNo + colEnd;
							html += colStart + patient.nid + colEnd;
							html += colStart + patient.area + colEnd;
							html += colStart + patient.thana + colEnd;
							html += colStart + patient.zilla + colEnd;
							html += colStart + "<a class='btn btn-primary' href='viewpatient?regNo=" + patient.regNo + "'>View</a>" + colEnd;
							html += colStart + "<a class='btn btn-danger' href='deletepatient?regNo=" + patient.regNo + "'>Delete</a>" + colEnd;
							html += "</tr>";
							
							$("#patientViewTable tbody").append(html);
						});
					}
				}
			}
		});
	};
	
	var selectRadioButton = function(element){
		console.log("Select element: " + element);
		var input = $('input:radio[name=' + element + ']')[1];
		input.checked = true;
	}
	
	var updateRadioButtonValue = function(element, value){
		var input = $('input:radio[name=' + element + ']:checked');
		input.val(value);
	}
	
	return{
		saveToSessionStorage: saveToSessionStorage,
		getFromSessionStorage:getFromSessionStorage,
		setRegNo: setRegNo,
		getPatientVisitList: getPatientVisitList,
		getPatientList: getPatientList,
		selectRadioButton: selectRadioButton,
		updateRadioButtonValue: updateRadioButtonValue
	}
})();