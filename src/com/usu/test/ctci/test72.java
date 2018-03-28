package com.usu.test.ctci;

import java.util.ArrayList;
import java.util.List;

import com.usu.test.ctci.test72.Employee.Role;

public class test72 extends Thread {
	public void run() {
		
	}
	
	public static void main(String args[]) {
		new test72().start();
	}
	
	class CallCenter {
		List<Employee> employees = new ArrayList<>();
		
		public CallCenter() {
			
		}
		
		public Employee dispatchCall() {
			boolean foundRespondent = false;
			for (Employee e : employees) {
				if (e.isAvailable() && e.getRole() == Role.Respondent) {
					return e;
				} 
			}

			// no respondent found
			for (Employee e : employees) {
				if (e.isAvailable() && e.getRole() == Role.Manager) {
					return e;
				} 
			}
			
			return null;
		}
	}
	
	static class Employee {
		enum Role {
			Respondent,
			Manager,
			Director
		}
		
		protected Role role;
		
		public Role getRole() {
			return role;
		}
		
		public boolean isAvailable() {
			return true;
		}
		
		public void escalate() {
			
		}
	}
	
	class Respondent extends Employee {
		public Respondent() {
			role = Role.Respondent;
		}
	}

	class Manager extends Employee {
		public Manager() {
			role = Role.Manager;
		}
	}

	class Director extends Employee {
		public Director() {
			role = Role.Director;
		}
	}
}
