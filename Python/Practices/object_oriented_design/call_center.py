"""
Call Center: Imagine you have a call center with three levels of employees: respondent, manager, and director. An incoming telephone call must be first allocated to a respondent who is free. If the respondent can't handle the call, he or she must escalate the call to a manager. If the manager is not free or not able to handle it, then the call should be escalated to a director. Design the classes and data structures for this problem. Implement a method dispatchCall() which assigns a call to the first available employee.

"""

class Customer:
    def __init__(self,call_center,name):
        self.call_center = call_center
        self.name = name
    def make_call(self):
        self.call_center.add_call(self)

class Employee:
    available,call_history = True,[]
    def __init__(self,name,ID,title):
        self.name,self.ID,self.title = name,ID,title
    def assign_call(self,customer):
        self.call_history.append(customer)
        self.available = False
    def set_available(self):
        self.available = True
        return self.available

class Respondent(Employee):
    def __init__(self,name,ID,title):
        super().__init__(name,ID,title)

class Manager(Employee):
    def __init__(self,name,ID,title):
        super().__init__(name,ID,title)

class Director(Employee):
    def __init__(self,name,ID,title):
        super().__init__(name,ID,title)

class CallCenter:
    def __init__(self,name,state,country):
        self.name,self.state,self.country = name,state,country
        self.__call_queue = []
        self.respondents = []
        self.managers = []
        self.directors = []
    def __is_available(employees, call):
        for i in range(len(employees)):
            if employees[i].available:
                employees[i]
                return True
        return False
    def add_call(self,customer):
        self.__call_queue.append(customer)
    def dispatch_call(self):
        call = self.__call_queue.pop(0)
        if self.__is_available(self.respondents,call):
            return True
        if self.__is_available(self.managers,call):
            return True
        if self.__is_available(self.directors,call):
            return True
        print("Please add more employees")
        return False
    def get_respondents:
        return respondents
    def get_managers:
        return managers
    def get_directors:
        return directors
    def add_respondent(self,respondent):
        if isinstance(respondent,Respondent):
            self.respondents.append(respondent)
            return True
        return False
    def add_manager(self,manager):
        if isinstance(manager,Manager):
            self.managers.append(manager)
            return True
        return False
    def add_director(self,director):
        if isinstance(director,Director):
            self.directors.append(director)
            return True
        return False
    
