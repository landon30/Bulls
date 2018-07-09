var fun1 = function(name) {
    print('Hi there from Javascript, ' + name);
    return "greetings from javascript";
};

var fun2 = function (object) {
    print("JS Class Definition: " + Object.prototype.toString.call(object));
};

var fun3 = function () {
    var MyJavaClass = Java.type('advance.script.js.example.JavaApi4JS');
	var result = MyJavaClass.fun1('landon');
	
	print(result);
};