/*jslint vars: true, plusplus: true, devel: true, nomen: true, indent: 4, maxerr: 50 */ 
/*global define */



//function b() {   
//    console.log("hel");
//}
//
//b();
//function b() {   
//    console.log("asfdasf");
//}
//console.log(a);
//
//var a = 'hello world';
//console.log(a);
//
//function c() {
//    b();
//}
//
//c();
//
//function d() {
//    var myVar;
//    console.log(myVar);
//}
//function e() {
//    var myVar = 2;
//    console.log(myVar);
//    d();
//}
//
//var myVar = 1;
//console.log(myVar);
//e();
//
//
//function f() {
//    console.log(myVar);
//}
//
//function g() {
//    var myVar = 2;
//    f();
//}
//var myVar = 1;
//g();



//function g() {
//    function f() {
//        console.log(myVar);
//    }
////    var myVar = 2;
//    f();
//}
//var myVar = 1;
//g();

//var person = {  firstname: "Stephen", 
//                lastname: "Lee",
//                address: {
//                    street: '111.agasdf st.',
//                    city: 'Fremont',
//                    state: 'CA'
//                }
//              }; //same as new Object();
////
////console.log(person);
//
//function greet(person) {
//    console.log('Hi ' + person.firstname);
//}
//
//greet(person);
//
//greet({firstname: 'Marry',
//       lastname: 'Peters'
//      });


//framework aside faking namespaces
//var greet = 'hello';
//var greet = 'olah';
//
//console.log(greet);

// function statements and function expressions
greet();
function greet() { //hoisting
    console.log('afdas');
}

var anonymousGreet = function() {
    console.log('afds1!!!');
}
anonymousGreet();

function log(a) {
    a();
}

//log("afdasfafsdfadfsfafas");

log(function(){
    console.log('hi');
});
