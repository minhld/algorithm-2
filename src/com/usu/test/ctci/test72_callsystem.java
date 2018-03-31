package com.usu.test.ctci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test72_callsystem extends Thread {
	public void run() {
		
	}
	
	public static void main(String args[]) {
		new test72_callsystem().start();
	}
	
	public enum Rank {
		Respondent,
		Manager,
		Director
	}
	
	class CallCenter {
		List<Employee> employees = new ArrayList<>();
		LinkedList<Call> callQueues = new LinkedList<>();
		
		/**
		 * assign a call to employee 
		 * 
		 * @param call
		 */
		public void dispatchCall(Call call) {
			Employee emp = getFirstAvailableEmployee(Rank.Respondent);
			if (emp != null) {
				emp.receiveCall(call);
			} else {
				callQueues.add(call);
			}
		}
		
		/**
		 * find one available employee
		 * 
		 * @return
		 */
		Employee getFirstAvailableEmployee(Rank rank) {
			for (Employee emp : employees) {
				if (emp.isAvailable() && emp.getRank() == rank) return emp;
			}
			return null;
		}
	}
	
	class Call {
		Rank rank;
		Caller caller;
		
		public Call(Caller c) {
			rank = Rank.Respondent;
			caller = c; 
		}
		
		public void setHandler(Employee e) { }
		public void reply(String message) { }
		public void disconnect() { }
	}
	
	class Caller {
		
	}
	
	abstract class Employee {
		protected Rank rank;
		
		public Rank getRank() {
			return rank;
		}
		
		public boolean isAvailable() {
			return true;
		}
		
		public void receiveCall(Call call) {
			
		}
		
		public abstract void escalate(Call call);
	}
	
	class Respondent extends Employee {
		public Respondent() {
			rank = Rank.Respondent;
		}
		
		@Override
		public void escalate(Call call) {
			
		}
	}

	class Manager extends Employee {
		public Manager() {
			rank = Rank.Manager;
		}
		
		@Override
		public void escalate(Call call) {
			
		}
	}

	class Director extends Employee {
		public Director() {
			rank = Rank.Director;
		}
		
		@Override
		public void escalate(Call call) {
			
		}
	}
}
