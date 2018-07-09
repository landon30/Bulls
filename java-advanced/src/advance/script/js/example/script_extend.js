var fun1 = function() {
	var map = new java.util.HashMap();
	map.put('foo','val1');
	map.put('bar','val2');
	
	for each (var e in map.keySet()) print(e);
	for each (var e in map.values()) print(e);
};

var fun2 = function() {
	var list = new java.util.ArrayList();
	list.add("ddd2");
	list.add("aaa2");
	list.add("bbb1");
	list.add("aaa1");
	list.add("bbb3");
	list.add("ccc");
	list.add("bbb2");
	list.add("ddd1");
 
	list
	    .stream()
	    .filter(function(el) {
	        return el.startsWith("aaa");
	    })
	    .sorted()
	    .forEach(function(el) {
	        print(el);
	    });
};