var rest = angular.module('qkstart.rest', []);

var clientId = '1033278383340-2sshat4uc1ejdfpamcgqhqrc0sjgs17g.apps.googleusercontent.com';

rest.service('buttonsSvc', [function () {

  this.retrieveButtons = function (callback) {
    gapi.client.buttons.list().execute(callback);
  };

  this.click = function(button, callback) {
    gapi.client.buttons.click({id:button.id}).execute(callback);
  };

  this.newButton = function(name, callback) {
    gapi.client.buttons.newButton({name:name}).execute(callback);
  };

}]);

