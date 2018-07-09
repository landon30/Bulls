println "Hello,World"

def echo(param) {
    println param
}

echo(1)
echo(new Date())

for(i in 0..1) {
    println "Hello " + i
}

def map = ['name':'landon','age':20]
System.out.println(map.name)

def closure = {
	str -> println("$str")
}

closure("closure")

class Person {
    List hobby=['swim','nba','watch TV']
    String name="landon"
    
    int getAge(){
        return 20
    }
}

def p = new Person()
println p.hobby[1]



