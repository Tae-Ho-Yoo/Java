/**
 * Expression.java
 * program that takes in a postfix expression then print post,in,prefix,simplified then evaluate using user input value for variable
 * Homework 8
 */

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/*
 *  Note: the indentation and placment of {'s and }'s is somewhat
 * of a mess in this file.  That is on purpose to give you (the student)
 * a chance to see what it's like working in code that has arbitrary
 * and inconsistent style.  I encourage you to clean it up for your 
 * submission (and sanity!).
 * 
 * /

/**
 * A class representing an abstract arithmetic expression
 */
public abstract class Expression
{
   /**
    * Creates a tree from an expression in postfix notation
    * @param postfix an array of Strings representing a postfix arithmetic expression
    * @return a new Expression that represents postfix
    */
   public static Expression expressionFromPostfix(String[] postfix)
   {
      Stack<Expression> expressionStack = new Stack<Expression>();
      for (String value : postfix){
         if (value.equals("+")){
            Expression right = expressionStack.pop();
            Expression left = expressionStack.pop();
            SumExpression sum = new SumExpression(left, right);
            expressionStack.push(sum);
         }  else if (value.equals("-")){
            Expression right = expressionStack.pop();
            Expression left = expressionStack.pop();
            DifferenceExpression diff = new DifferenceExpression(left, right);
            expressionStack.push(diff);
         } else if (value.equals("*")){
            Expression right = expressionStack.pop();
            Expression left = expressionStack.pop();
            ProductExpression mult = new ProductExpression(left, right);
            expressionStack.push(mult);
         } else if (value.equals("/")){
            Expression right = expressionStack.pop();
            Expression left = expressionStack.pop();
            QuotientExpression div = new QuotientExpression(left, right);
            expressionStack.push(div);
         } else if (Character.isLetter(value.charAt(0))){
            VariableOperand varExp = new VariableOperand(value);
            expressionStack.push(varExp);
         } else {
            IntegerOperand intExp= new IntegerOperand(Integer.parseInt(value));
            expressionStack.push(intExp);
         }   
      }
      return expressionStack.pop();
   }

   /**
    * @return a String that represents this expression in prefix notation.
    */
   public abstract String toPrefix();

   /**
    * @return a String that represents this expression in infix notation.
    */  
   public abstract String toInfix();

   /**
    * @return a String that represents this expression in postfix notation.
    */  
   public abstract String toPostfix();

   /**
    * @return a String that represents the expression in infix notation
    */
   @Override
   public String toString()
   {
      return toInfix();
   }
   
   /**
    * @return a new Expression mathematically equivalent to this one, but simplified.
    */  
   public abstract Expression simplify();

   /**
    * Evaluates the expression given assignments of values to variables.
    * @param assignments a HashMap from Strings (variable names) to Integers (values).
    * @return the result of evaluating the expression with the given variable assignments
    */
   public abstract int evaluate(HashMap<String, Integer> assignments);

   /**
    * @return a Set of the variables contained in this expression
    */
   public abstract Set<String> getVariables();

   @Override
   public abstract boolean equals(Object obj);

   /**
    * Prints the expression as a tree in DOT format for visualization
    * @param filename the name of the output file
    */
   public void drawExpression(String filename) throws IOException
   {
      BufferedWriter bw = null;
      FileWriter fw = new FileWriter(filename);
      bw = new BufferedWriter(fw);
      
      bw.write("graph Expression {\n");
      
      drawExprHelper(bw);
      
      bw.write("}\n");
      
      bw.close();
      fw.close();     
   }

   /**
    * Recursively prints the vertices and edges of the expression tree for visualization
    * @param bw the BufferedWriter to write to
    */
   protected abstract void drawExprHelper(BufferedWriter bw) throws IOException;
}

/**
 * A class representing an abstract operand
 */
abstract class Operand extends Expression
{
}

/**
 * A class representing an expression containing only a single integer value
 */
class IntegerOperand extends Operand
{
   protected int operand;

   /**
    * Create the expression
    * @param operand the integer value this expression represents
    */
   public IntegerOperand(int operand)
   {
      this.operand = operand;
   }

   /**
    * @return a String that represents this expression in prefix notation.
    */   
   public String toPrefix()
   {
      return String.valueOf(operand);
   }

   /**
    * @return a String that represents this expression in postfix notation.
    */  
   public String toPostfix()
   {
      return String.valueOf(operand);
   }   

   /**
    * @return a String that represents the expression in infix notation
    */
   public String toInfix()
   {
      return String.valueOf(operand);      
   }

   /**
    * @return a new Expression mathematically equivalent to this one, but simplified.
    */  
   public Expression simplify()
   {
      return new IntegerOperand(operand);
   }   

   /**
    * Evaluates the expression given assignments of values to variables.
    * @param assignments a HashMap from Strings (variable names) to Integers (values).
    * @return the result of evaluating the expression with the given variable assignments
    */
   public int evaluate(HashMap<String, Integer> assignments)
   {
      return operand;
   }

   /**
    * @return a Set of the variables contained in this expression
    */
   public Set<String> getVariables()
   {
      TreeSet<String> intSet = new TreeSet<String>();
      return intSet;
   }

   /**
    * @param obj and Object to compare to
    * @return true if obj is a logically equivalent Expression 
    */
   @Override
   public boolean equals(Object obj)
   {
      if (obj != null){
         if (obj instanceof IntegerOperand){
            IntegerOperand intOp = (IntegerOperand)obj;
            return intOp.operand==this.operand;
         }
      }
      return false;
   }   

   /**
    * Recursively prints the vertices and edges of the expression tree for visualization
    * @param bw the BufferedWriter to write to
    */
   protected void drawExprHelper(BufferedWriter bw) throws IOException
   {
      bw.write("\tnode"+hashCode()+"[label="+operand+"];\n");
   }
}

/**
 * A class representing an expression containing only a single variable
 */
class VariableOperand extends Operand
{
   protected String variable;

   /**
    * Create the expression
    * @param variable the variable name contained with this expression
    */
   public VariableOperand(String variable)
   {
      this.variable = variable;
   }

   /**
    * @return a String that represents this expression in prefix notation.
    */   
   public String toPrefix()
   {
      return variable;
   }

   /**
    * @return a String that represents this expression in postfix notation.
    */  
   public String toPostfix()
   {
      return variable;
   }   

   /**
    * @return a String that represents the expression in infix notation
    */
   public String toInfix()
   {
      return variable;      
   }

   /**
    * @return a new Expression mathematically equivalent to this one, but simplified.
    */  
   public Expression simplify()
   {
      return new VariableOperand(variable);
   }   

   /**
    * Evaluates the expression given assignments of values to variables.
    * @param assignments a HashMap from Strings (variable names) to Integers (values).
    * @return the result of evaluating the expression with the given variable assignments
    */
   public int evaluate(HashMap<String, Integer> assignments)
   {
      return assignments.get(variable);
   }

   /**
    * @return a Set of the variables contained in this expression
    */
   public Set<String> getVariables()
   {
      TreeSet<String> setVar = new TreeSet<String>();
      setVar.add(variable);
      return setVar;
   }

   /**
    * @param obj and Object to compare to
    * @return true if obj is a logically equivalent Expression 
    */
   @Override
   public boolean equals(Object obj)
   {
      if (obj != null){
         if (obj instanceof VariableOperand){
            VariableOperand varObj = (VariableOperand)obj;
            return varObj.variable.equals(this.variable);
         }
      }
      return false;
   }   

   /**
    * Recursively prints the vertices and edges of the expression tree for visualization
    * @param bw the BufferedWriter to write to
    */
   protected void drawExprHelper(BufferedWriter bw) throws IOException
   {
      bw.write("\tnode"+hashCode()+"[label="+variable+"];\n");
   }   
}

/**
 * A class representing an expression involving an operator
 */
abstract class OperatorExpression extends Expression
{
   protected Expression left;
   protected Expression right;

   /**
    * Create the expression
    * @param left the expression representing the left operand
    * @param right the expression representing the right operand
    */
   public OperatorExpression(Expression left, Expression right)
   {
      this.left = left;
      this.right = right;
   }

   /**
    * @return a string representing the operator
    */
   protected abstract String getOperator();     
   
   /**
    * @return a String that represents this expression in prefix notation.
    */   
    public String toPrefix()
    {
       String str = this.getOperator() + " " + left.toPrefix() + " " + right.toPrefix();
       return str;
    }

       /**
    * @return a String that represents this expression in postfix notation.
    */  
   public String toPostfix()
   {
      String str = left.toPostfix() + " " + right.toPostfix() + " " + this.getOperator();
      return str;
   }   

   /**
    * @return a String that represents the expression in infix notation
    */
   public String toInfix()
   {
      String str = "(" + left.toInfix() + this.getOperator() + right.toInfix() + ")";
      return str;      
   }
   /**
    * Recursively prints the vertices and edges of the expression tree for visualization
    * @param bw the BufferedWriter to write to
    */
   protected void drawExprHelper(BufferedWriter bw) throws IOException
   {
      String rootID = "\tnode"+hashCode();
      bw.write(rootID+"[label=\""+getOperator()+"\"];\n");

      bw.write(rootID + " -- node" + left.hashCode() + ";\n");
      bw.write(rootID + " -- node" + right.hashCode() + ";\n");
      left.drawExprHelper(bw);
      right.drawExprHelper(bw);
   }   

      /**
    * @return a Set of the variables contained in this expression
    */
    public Set<String> getVariables()
    {
       TreeSet<String> varSet = new TreeSet<String>();
       if (left.getVariables() != null){
          varSet.addAll(left.getVariables());
       }
       if (right.getVariables() != null){
          varSet.addAll(right.getVariables());
       }
       return varSet;
    }

    /**
    * @return a new Expression mathematically equivalent to this one, but simplified.
    */  
   public Expression simplify()
   {
      Expression simpRight = this.right.simplify();
      Expression simpLeft = this.left.simplify();
      if (!(simpLeft instanceof IntegerOperand) && simpRight instanceof IntegerOperand){
         if (!(this instanceof QuotientExpression) && !(this instanceof ProductExpression)){
            if (((IntegerOperand)simpRight).operand == 0){
               return simpLeft;
            }
         }
         if (this instanceof QuotientExpression || this instanceof ProductExpression){
            if (((IntegerOperand)simpRight).operand == 1){
            return simpLeft;
            }
         }
      }
      if (!(this instanceof QuotientExpression)){
         if (!(simpRight instanceof IntegerOperand) && simpLeft instanceof IntegerOperand){
            if (!(this instanceof ProductExpression)){
               if (((IntegerOperand)simpLeft).operand == 0){
                  return simpRight;
               }
            }
            if (this instanceof ProductExpression){
               if (((IntegerOperand)simpLeft).operand == 1){
               return simpRight;
               }
            }
         }
      }
      return simplifyChild(simpLeft, simpRight);
   }   
   /**
    * calls child class for special cases
    * @param simpLeft expression on the left side
    * @param simpRight expression on the right side
    * @return new expression in most simplified form
    */
   abstract public Expression simplifyChild(Expression simpLeft, Expression simpRight);
   }

/**
 * A class representing an expression involving an sum
 */
class SumExpression extends OperatorExpression
{
   /**
    * Create the expression
    * @param left the expression representing the left operand
    * @param right the expression representing the right operand
    */
   public SumExpression(Expression left, Expression right)
   {
      super(left, right);
   }

   /**
    * @return a string representing the operand
    */
   protected String getOperator()
   {
      return "+";
   }

   /**
    * Evaluates the expression given assignments of values to variables.
    * @param assignments a HashMap from Strings (variable names) to Integers (values).
    * @return the result of evaluating the expression with the given variable assignments
    */
   public int evaluate(HashMap<String, Integer> assignments)
   {
      int ans = left.evaluate(assignments) + right.evaluate(assignments);
      return ans;
   }

   /**
    * @param obj and Object to compare to
    * @return true if obj is a logically equivalent Expression 
    */
   @Override
   public boolean equals(Object obj)
   {
      if (obj != null){
         if (obj instanceof SumExpression){
            SumExpression expr = (SumExpression)obj;
            if (expr.left.equals(this.right)  && expr.right.equals(this.left)){
               return true;
            }
            if (expr.left.equals(this.left) && expr.right.equals(this.right)){
               return true;
            }
         }
      }
      return false;
   }

   @Override
   public Expression simplifyChild(Expression simpLeft, Expression simpRight) {
      if (simpRight instanceof IntegerOperand && simpLeft instanceof IntegerOperand){
         return new IntegerOperand(((IntegerOperand)simpLeft).operand + ((IntegerOperand)simpRight).operand);
      }
      return new SumExpression(simpLeft, simpRight);
   }   
}

/**
 * A class representing an expression involving an differnce
 */
class DifferenceExpression extends OperatorExpression
{
   /**
    * Create the expression
    * @param left the expression representing the left operand
    * @param right the expression representing the right operand
    */
   public DifferenceExpression(Expression left, Expression right)
   {
      super(left, right);
   }

   /**
    * @return a string representing the operand
    */
   protected String getOperator()
   {
      return "-";
   }

   /**
    * Evaluates the expression given assignments of values to variables.
    * @param assignments a HashMap from Strings (variable names) to Integers (values).
    * @return the result of evaluating the expression with the given variable assignments
    */
   public int evaluate(HashMap<String, Integer> assignments)
   {
      int ans = left.evaluate(assignments) - right.evaluate(assignments);
      return ans;
   }

   /**
    * @param obj and Object to compare to
    * @return true if obj is a logically equivalent Expression 
    */
   @Override
   public boolean equals(Object obj)
   {
      if (obj != null){
         if (obj instanceof DifferenceExpression){
            DifferenceExpression expr = (DifferenceExpression)obj;
            if (expr.left.equals(this.left) && expr.right.equals(this.right)){
               return true;
            }
         }
      }
      return false;
   }

   @Override
   public Expression simplifyChild(Expression simpLeft, Expression simpRight) {
      if (simpLeft.equals(simpRight)){
         return new IntegerOperand(0);
      }
      if (simpRight instanceof IntegerOperand && simpLeft instanceof IntegerOperand){
         return new IntegerOperand(((IntegerOperand)simpLeft).operand - ((IntegerOperand)simpRight).operand);
      }
      return new DifferenceExpression(simpLeft, simpRight);
   }      
}

/**
 * A class representing an expression involving a product
 */
class ProductExpression extends OperatorExpression
{
   /**
    * Create the expression
    * @param left the expression representing the left operand
    * @param right the expression representing the right operand
    */
   public ProductExpression(Expression left, Expression right)
   {
      super(left, right);
   }

   /**
    * @return a string representing the operand
    */
   protected String getOperator()
   {
      return "*";
   }

   /**
    * Evaluates the expression given assignments of values to variables.
    * @param assignments a HashMap from Strings (variable names) to Integers (values).
    * @return the result of evaluating the expression with the given variable assignments
    */
   public int evaluate(HashMap<String, Integer> assignments)
   {
      int ans = left.evaluate(assignments) * right.evaluate(assignments);
      return ans;
   }

   /**
    * @param obj and Object to compare to
    * @return true if obj is a logically equivalent Expression 
    */
   @Override
   public boolean equals(Object obj)
   {
      if (obj != null){
         if (obj instanceof ProductExpression){
            ProductExpression expr = (ProductExpression)obj;
            if (expr.left.equals(this.right)  && expr.right.equals(this.left)){
               return true;
            }
            if (expr.left.equals(this.left) && expr.right.equals(this.right)){
               return true;
            }
         }
      }
      return false;
   }

   @Override
   public Expression simplifyChild(Expression simpLeft, Expression simpRight) {
      if (simpRight instanceof IntegerOperand && !(simpLeft instanceof IntegerOperand)){
         if (((IntegerOperand)simpRight).operand == 0){
         return new IntegerOperand(0);
         }
      }
      if (simpLeft instanceof IntegerOperand && !(simpRight instanceof IntegerOperand)){
         if (((IntegerOperand)simpLeft).operand == 0){
         return new IntegerOperand(0);
         }
      }
      if (simpRight instanceof IntegerOperand && simpLeft instanceof IntegerOperand){
         return new IntegerOperand(((IntegerOperand)simpLeft).operand * ((IntegerOperand)simpRight).operand);
      }
      return new ProductExpression(simpLeft, simpRight);
   }      
}

/**
 * A class representing an expression involving a division
 */
class QuotientExpression extends OperatorExpression
{
   /**
    * Create the expression
    * @param left the expression representing the left operand
    * @param right the expression representing the right operand
    */
   public QuotientExpression(Expression left, Expression right)
   {
      super(left, right);
   }

   /**
    * @return a string representing the operand
    */
   protected String getOperator()
   {
      return "/";
   }

   /**
    * Evaluates the expression given assignments of values to variables.
    * @param assignments a HashMap from Strings (variable names) to Integers (values).
    * @return the numerica result of evaluating the expression with the given variable assignments
    */
   public int evaluate(HashMap<String, Integer> assignments)
   {
      int ans = left.evaluate(assignments) / right.evaluate(assignments);
      return ans;
   }

   /**
    * @param obj and Object to compare to
    * @return true if obj is a logically equivalent Expression 
    */
   @Override
   public boolean equals(Object obj)
   {
      if (obj != null){
         if (obj instanceof QuotientExpression){
            QuotientExpression expr = (QuotientExpression)obj;
            if (expr.left.equals(this.left) && expr.right.equals(this.right)){
               return true;
            }
         }
      }
      return false;
   }

   @Override
   public Expression simplifyChild(Expression simpLeft, Expression simpRight) {
      if (simpLeft instanceof IntegerOperand && !(simpRight instanceof IntegerOperand)){
         if (((IntegerOperand)simpLeft).operand == 0){
            return new IntegerOperand(0);
         }
      }
      if (simpLeft.equals(simpRight)){
         return new IntegerOperand(1);
      }
      if (simpRight instanceof IntegerOperand && simpLeft instanceof IntegerOperand){
         return new IntegerOperand(((IntegerOperand)simpLeft).operand / ((IntegerOperand)simpRight).operand);
      }
      return new QuotientExpression(simpLeft, simpRight);
   }      
}
