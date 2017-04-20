;
(function() {
	var SERVICE = ['store', function(store) {
		var service 	= this,
		currentUser = null;
	
	service.setUser = function(user) {
		currentUser = user;
		store.set('user', user);
		return currentUser;
	}
	
	service.getUser = function() {
		if (!currentUser) {
			currentUser = store.get('user');
		}
		
		return currentUser;
	}
	
	}];
	
	angular.module('burguerapp').service('UserService', SERVICE);
})();