angular.module('HealthCare')

.factory('UserBase', function($http, $firebase, firebaseUrl, wht){
   'use strict'
  var userUrl = firebaseUrl+'/'+wht;
  var sync = $firebase(new Firebase(userUrl));
  var service = {
    syncUsers: syncUsers,
    get: get,
    save: save
  };

  function syncUsers(){
    return sync.$asArray();
  }

  function get(whtId){
    return $http.get(userUrl+'/'+userId+'.json').then(function(res){
      return res.data
    });
  }

  function save(user){
    return $http.put(userUrl+'/'+user.id+'.json', user);
  }
  return service;
})

.factory('Stock', function($window){
  'use strict';
  var localStorageCache = {};
  var localStoragePrefix = 'hlcare-';
  var service = {
    get: get,
    set: set
  };

  function get(key){
    if(!localStorageCache[key] && $window.localStorage){
      localStorageCache[key] = JSON.parse($window.localStorage.getItem(localStoragePrefix+key));
    }
    return angular.copy(localStorageCache[key]);
  }

  function set(key, value){
    if(!angular.equals(localStorageCache[key], value)){
      localStorageCache[key] = angular.copy(value);
      if($window.localStorage){
        $window.localStorage.setItem(localStoragePrefix+key, JSON.stringify(localStorageCache[key]));
      }
    }
  }
  return service;
});