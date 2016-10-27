var peopleProto = function(name, age, state) {
  this.name = name;
  this.age = age;
  this.state = state;
  if (typeof this.printPerson !== 'function') {
    peopleProto.prototype.printPeron = function() {
      console.log(this.name + ", " + this.age + ", " + this.state);
    };
  };
};

var person1 = new peopleProto('Stephen', 21, 'CA');
person1.printPerson = function() {
  console.log(this.name + ",,,,,, " + this.age + ", " + this.state);
};

person1.printPerson();

var person2 = new peopleProto('Stefanie', 21, 'LA');
person2.printPeron();
