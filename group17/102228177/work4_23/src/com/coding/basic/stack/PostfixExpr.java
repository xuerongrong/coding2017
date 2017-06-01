package com.coding.basic.stack;

import java.util.List;
import java.util.Stack;

/**

 * @Description 后缀表达式
 * 				<br>从左向右运算，不考虑优先级 
 * 				<br>eg： 3 4 + 5 × 6 -  => (3+4)*5-6

 * @author REEFE

 * @time 2017年4月26日

 */
public class PostfixExpr {
	String expr = null;
	
	public PostfixExpr(String expr) {
		this.expr = expr;
	}

	public float evaluate() {
		TokenParser tokenParser = new TokenParser();
		List<Token> tokens = tokenParser.parse(this.expr);
		
		Stack<Float> numStack = new Stack<Float>();
		
		for (Token token : tokens) {
			//判断是数字就向数字栈中push
			if(token.isNumber()){
				numStack.push(new Float(token.getIntValue()));
			}else{
				Float f2 = numStack.pop();
				Float f1 = numStack.pop();
				numStack.push(calculate(token.toString(), f1, f2));
			}
		}
		return numStack.pop().floatValue();
	}

	private Float calculate(String op, Float f1, Float f2){
		if(op.equals("+")){
			return f1+f2;
		}
		if(op.equals("-")){
			return f1-f2;
		}
		if(op.equals("*")){
			return f1*f2;
		}
		if(op.equals("/")){
			return f1/f2;
		}
		throw new RuntimeException(op + " is not supported");
	}
}
