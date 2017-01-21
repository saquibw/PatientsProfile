
var PatientManager = (function(){
	var saveToSessionStorage = function(key, value){
		sessionStorage.setItem(key, value);
	}
	
	var getFromSessionStorage = function(key){
		return sessionStorage.getItem(key);
	}
	
	return{
		saveToSessionStorage: saveToSessionStorage,
		getFromSessionStorage:getFromSessionStorage
	}
})();