
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
				var displayRegNo = year + "/" + day + "/" + months[month] + "/" + regNo;
				
				$("#regNo").val(displayRegNo);
			}
		});
	}
	
	return{
		saveToSessionStorage: saveToSessionStorage,
		getFromSessionStorage:getFromSessionStorage,
		setRegNo: setRegNo
	}
})();