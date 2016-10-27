//prototype inheritance

//base class
var Job = function(){
	this.pays = true;
};

Job.prototype.print = function(){
	console.log(this.pays ? 'Interested' : 'No interested');
};
//sub. class
var TechJob = function(title, pays){
	Job.call(this);
  this.title = title;
  this.pays = pays;
};

TechJob.prototype = Object.create(Job.prototype);
TechJob.prototype.contructor = TechJob;

var SoftwarePos = new TechJob("Web Dev", true);
var SoftwarePos2 = new TechJob("Web Dev", false);
//console.dir(SoftwarePos);
console.log(SoftwarePos.print());
console.log(SoftwarePos2.print());