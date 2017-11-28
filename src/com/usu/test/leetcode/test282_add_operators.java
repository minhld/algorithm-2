package com.usu.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class test282_add_operators extends Thread {
	public void run() {
		String s = "000"; 
		int target = 0;
		addOperators(s, target);
		// System.out.println("result: " + eval3(s));
		
		// System.out.println("result: " + eval3("0*00"));
	}
	
	public static void main(String args[]) {
		new test282_add_operators().start();
	}

	public List<String> addOperators(String num, int target) {
        List<String> avalList = findPosibleString(num);
        List<String> list = new ArrayList<>();
        long eval = 0;
        for (String s : avalList) {
        	eval = eval3(s);
        	if (eval == target) {
                list.add(s);
                System.out.println(s + ": " + eval);
            } 
        }
        return list;
    }
    
    private List<String> findPosibleString(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() == 0) {
            return list;
        } else if (s.length() == 1) {
            list.add(s);
            return list;
        }
        
        String subS = s.substring(1);
        String c = s.substring(0, 1);
        List<String> subList = findPosibleString(subS);
        for (String sub : subList) {
    		list.add(c + sub);
            list.add(c + "+" + sub);
            list.add(c + "-" + sub);
            list.add(c + "*" + sub);	
        }
        
        return list;
    }
    
    long eval3(String s) {
    	java.util.Stack<String> stack = new java.util.Stack<>();
        long sum = 0;
        int i = 0; 
        long num1, num2;
        String c;
        while (i < s.length()) {
            // beginning of an operand or operator
        	c = String.valueOf(s.charAt(i));
            
            if (!isOperator(c)) {
                // get the number in string format
                StringBuffer numStr = new StringBuffer();
                while (!isOperator(c)) {
                    numStr.append(c);
                    if (i < s.length() - 1) {
                    	c = String.valueOf(s.charAt(++i));
                    } else {
                    	i++;
                    	break;
                    }
                }

                if (numStr.length() > 1 && numStr.substring(0, 1).equals("0")) {
                	return Long.MIN_VALUE;
                }
                
                // got the number
                String num = numStr.toString();
                if (stack.isEmpty()) {
                    stack.push(num);
                } else {
                    String op = stack.peek();
                    if (isOperator(op)) {
                        if (isMultiply(op)) {
                            op = stack.pop();
                            num1 = Long.parseLong(stack.pop());
                            num2 = Long.parseLong(num);
                            stack.push(Long.toString(num1 * num2));
                        } else {
                            stack.push(num);
                        }
                    }
                }
            } else {
                // add the operator to the stack
                stack.push(String.valueOf(c));
                i++;
            }
        }
        
        long sum2 = 0;
        i = 0;
        while (i < stack.size()) {
            String item = stack.get(i);
            if (item.equals("+")) {
                num1 = Long.parseLong(stack.get(i + 1));
                i += 2;
                sum2 += num1;
            } else if (item.equals("-")) {
                num1 = Long.parseLong(stack.get(i + 1));
                i += 2;
                sum2 -= num1;
            } else {
                // number
                num1 = Long.parseLong(item);
                i++;
                sum2 = num1;
            }
        }
        
        sum += sum2;
        
        return sum;
    }
    
	int eval2(String s) {
        java.util.Stack<String> stack = new java.util.Stack<>();
        int sum = 0;
        int i = 0, num1, num2;
        String c;
        while (i < s.length()) {
            c = String.valueOf(s.charAt(i));
            if (!isOperator(c)) {
                // get the number in string format
                StringBuffer numStr = new StringBuffer();
                while (!isOperator(c)) {
                    numStr.append(c);
                    if (i < s.length() - 1) {
                    	c = String.valueOf(s.charAt(++i));
                    } else {
                    	i++;
                    	break;
                    }
                }

                // got the number
                String num = numStr.toString();
                if (stack.isEmpty()) {
                    stack.push(num);
                } else {
                    String op = stack.peek();
                    if (isOperator(op)) {
                        if (isMultiply(op)) {
                            op = stack.pop();
                            num1 = Integer.parseInt(stack.pop());
                            num2 = Integer.parseInt(num);
                            stack.push(Integer.toString(num1 * num2));
                        } else {
                            stack.push(num);
                        }
                    }
                }
            } else {
                // add the operator to the stack
                stack.push(String.valueOf(c));
                i++;
            }
        }
        
        int sum2 = 0;
        i = 0;
        while (i < stack.size()) {
            String item = stack.get(i);
            if (item.equals("+")) {
                num1 = Integer.parseInt(stack.get(i + 1));
                i += 2;
                sum2 += num1;
            } else if (item.equals("-")) {
                num1 = Integer.parseInt(stack.get(i + 1));
                i += 2;
                sum2 -= num1;
            } else {
                // number
                num1 = Integer.parseInt(item);
                i++;
                sum2 = num1;
            }
        }
        
        sum += sum2;
        
        return sum;
    }
    
    private boolean isMultiply(String sc) {
        char c = sc.charAt(0);
        return c == '*';
    }
    
    private boolean isOperator(String sc) {
        char c = sc.charAt(0);
        return c == '+' || c == '-' || c == '*';
    }
}
