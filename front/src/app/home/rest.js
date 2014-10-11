var rest = angular.module('qkstart.rest', []);

var clientId = '1033278383340-2sshat4uc1ejdfpamcgqhqrc0sjgs17g.apps.googleusercontent.com';

rest.service('buttonsSvc', [function () {
  var buttons = [{name:"buttonName",timesClicked:12}];

  this.retrieveButtons = function (callback) {
    callback(buttons);
  };

  this.click = function(button, callback) {
    buttons[0].timesClicked++;
    callback({});
  };

}]);
