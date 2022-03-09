import java.io.IOException;
import java.util.HashMap;

public class Hw8Test {
    public static void main (String[] args) throws IOException{
        TestController tc = new TestControllerImpl("results.html");

        Test equalsAdd = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                IntegerOperand y = new IntegerOperand(2);
                SumExpression sumExp = new SumExpression(x, y);
                String[] postfix = {"x", "2", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(sumExp)){
                    return TestResult.createPassedResult("equals works for addition");
                }
                return TestResult.createFailedResult("equals doesn't work for addition");
            }
        };
        tc.addTest(equalsAdd, 81.0);

        Test equalsMult = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                IntegerOperand y = new IntegerOperand(2);
                ProductExpression prodExp = new ProductExpression(x, y);
                String[] postfix = {"x", "2", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(prodExp)){
                    return TestResult.createPassedResult("equals works for multiplication");
                }
                return TestResult.createFailedResult("equals doesn't work for multiplication");
            }
        };
        tc.addTest(equalsMult, 82.0);
        
        Test equalsDiv = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                IntegerOperand y = new IntegerOperand(2);
                QuotientExpression divExp = new QuotientExpression(x, y);
                String[] postfix = {"x", "2", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(divExp)){
                    return TestResult.createPassedResult("equals works for division");
                }
                return TestResult.createFailedResult("equals doesn't work for division");
            }
        };
        tc.addTest(equalsDiv, 83.0);
        
        Test equalsSubs = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                IntegerOperand y = new IntegerOperand(2);
                DifferenceExpression subsExp = new DifferenceExpression(x, y);
                String[] postfix = {"x", "2", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(subsExp)){
                    return TestResult.createPassedResult("equals works for subtraction");
                }
                return TestResult.createFailedResult("equals doesn't work for subtraction");
            }
        };
        tc.addTest(equalsSubs, 84.0);
        
        Test testExpFromPostFixAdd = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand left = new VariableOperand("y");
                IntegerOperand right = new IntegerOperand(2);
                SumExpression sumExp = new SumExpression(left, right);
                String[] postfix = {"y", "2", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(sumExp)){
                    return TestResult.createPassedResult("expressionFromPostfix works for addition");
                }
                return TestResult.createFailedResult("expressionFromPostfix does not work for addition");
            }
        };
        tc.addTest(testExpFromPostFixAdd, 1.0);

        Test testExpFromPostFixMult = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand left = new VariableOperand("y");
                IntegerOperand right = new IntegerOperand(1);
                ProductExpression ProdExp = new ProductExpression(left, right);
                String[] postfix = {"y", "1", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(ProdExp)){
                    return TestResult.createPassedResult("expressionFromPostfix works for multiplication");
                }
                return TestResult.createFailedResult("expressionFromPostfix does not work for multiplication");
            }
        };
        tc.addTest(testExpFromPostFixMult, 2.0);

        Test testExpFromPostFixSubs = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand left = new VariableOperand("y");
                IntegerOperand right = new IntegerOperand(4);
                DifferenceExpression SubsExp = new DifferenceExpression(left, right);
                String[] postfix = {"y", "4", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(SubsExp)){
                    return TestResult.createPassedResult("expressionFromPostfix works for subtraction");
                }
                return TestResult.createFailedResult("expressionFromPostfix does not work for subtraction");
            }
        };
        tc.addTest(testExpFromPostFixSubs, 3.0);

        Test testExpFromPostFixDiv = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand left = new IntegerOperand(2);
                VariableOperand right = new VariableOperand("x");
                QuotientExpression divExp = new QuotientExpression(left, right);
                String[] postfix = {"2", "x", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(divExp)){
                    return TestResult.createPassedResult("expressionFromPostfix works for division");
                }
                return TestResult.createFailedResult("expressionFromPostfix does not work for division");
            }
        };
        tc.addTest(testExpFromPostFixDiv, 4.0);

        Test toPrefixAdd = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "1", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("+ y 1")){
                    return TestResult.createPassedResult("toPrefix works for addition");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for addition");
            }
        };
        tc.addTest(toPrefixAdd, 5.0);

        Test toPrefixAddComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "x", "2", "+", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("+ y + x 2")){
                    return TestResult.createPassedResult("toPrefix works for complex addition");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for complex addition");
            }
        };
        tc.addTest(toPrefixAddComplex, 6.0);

        Test toPrefixSubs = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "3", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("- x 3")){
                    return TestResult.createPassedResult("toPrefix works for subtraction");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for subtraction");
            }
        };
        tc.addTest(toPrefixSubs, 7.0);

        Test toPrefixSubsComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"4", "y", "z", "-", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("- 4 - y z")){
                    return TestResult.createPassedResult("toPrefix works for complex subtraction");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for complex subtraction");
            }
        };
        tc.addTest(toPrefixSubsComplex, 8.0);

        Test toPrefixMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "1", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("* x 1")){
                    return TestResult.createPassedResult("toPrefix works for multiplication");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for multiplication");
            }
        };
        tc.addTest(toPrefixMult, 9.0);

        Test toPrefixMultComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "2", "z", "*", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("* x * 2 z")){
                    return TestResult.createPassedResult("toPrefix works for complex multiplication");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for complex multiplication");
            }
        };
        tc.addTest(toPrefixMultComplex, 10.0);

        Test toPrefixDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"1", "y", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("/ 1 y")){
                    return TestResult.createPassedResult("toPrefix works for division");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for division");
            }
        };
        tc.addTest(toPrefixDiv, 11.0);

        Test toPrefixDivComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "3", "/", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("/ x / y 3")){
                    return TestResult.createPassedResult("toPrefix works for complex division");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for complex division");
            }
        };
        tc.addTest(toPrefixDivComplex, 12.0);

        Test toPrefixAddMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "5", "z", "+", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("* x + 5 z")){
                    return TestResult.createPassedResult("toPrefix works for addition and multiplication");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for addition and multiplication");
            }
        };
        tc.addTest(toPrefixAddMult, 13.0);

        Test toPrefixAddSubs = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "7", "+", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("- x + y 7")){
                    return TestResult.createPassedResult("toPrefix works for addition and subtraction");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for addition and subtraction");
            }
        };
        tc.addTest(toPrefixAddSubs, 14.0);

        Test toPrefixAddDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"8", "y", "z", "+", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("/ 8 + y z")){
                    return TestResult.createPassedResult("toPrefix works for addition and division");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for addition and division");
            }
        };
        tc.addTest(toPrefixAddDiv, 15.0);

        Test toPrefixSubsMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "2", "z", "-", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("* x - 2 z")){
                    return TestResult.createPassedResult("toPrefix works for subtraction and multiplication");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for subtraction and multiplication");
            }
        };
        tc.addTest(toPrefixSubsMult, 16.0);

        Test toPrefixSubsDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"1", "y", "z", "-", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("/ 1 - y z")){
                    return TestResult.createPassedResult("toPrefix works for subtraction and division");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for subtraction and division");
            }
        };
        tc.addTest(toPrefixSubsDiv, 17.0);

        Test toPrefixMultDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "3", "/", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("* x / y 3")){
                    return TestResult.createPassedResult("toPrefix works for division and multiplication");
                }
                return TestResult.createFailedResult("toPrefix doesn't work for division and multiplication");
            }
        };
        tc.addTest(toPrefixMultDiv, 18.0);

        Test toInfixAdd = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "4", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(y+4)")){
                    return TestResult.createPassedResult("toInfix works for addition");
                }
                return TestResult.createFailedResult("toInfix doesn't work for addition");
            }
        };
        tc.addTest(toInfixAdd, 19.0);

        Test toInfixAddComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"5", "x", "z", "+", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(5+(x+z))")){
                    return TestResult.createPassedResult("toInfix works for complex addition");
                }
                return TestResult.createFailedResult("toInfix doesn't work for complex addition");
            }
        };
        tc.addTest(toInfixAddComplex, 20.0);

        Test toInfixSubs = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"2", "y", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(2-y)")){
                    return TestResult.createPassedResult("toInfix works for subtraction");
                }
                return TestResult.createFailedResult("toInfix doesn't work for subtraction");
            }
        };
        tc.addTest(toInfixSubs, 21.0);

        Test toInfixSubsComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "3", "z", "-", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(x-(3-z))")){
                    return TestResult.createPassedResult("toInfix works for complex subtraction");
                }
                return TestResult.createFailedResult("toInfix doesn't work for complex subtraction");
            }
        };
        tc.addTest(toInfixSubsComplex, 22.0);

        Test toInfixMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "1", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(x*1)")){
                    return TestResult.createPassedResult("toInfix works for multiplication");
                }
                return TestResult.createFailedResult("toInfix doesn't work for multiplication");
            }
        };
        tc.addTest(toInfixMult, 23.0);

        Test toInfixMultComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "2", "*", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(x*(y*2))")){
                    return TestResult.createPassedResult("toInfix works for complex multiplication");
                }
                return TestResult.createFailedResult("toInfix doesn't work for complex multiplication");
            }
        };
        tc.addTest(toInfixMultComplex, 24.0);

        Test toInfixDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"1", "y", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(1/y)")){
                    return TestResult.createPassedResult("toInfix works for division");
                }
                return TestResult.createFailedResult("toInfix doesn't work for division");
            }
        };
        tc.addTest(toInfixDiv, 25.0);

        Test toInfixDivComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "3", "z", "/", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(x/(3/z))")){
                    return TestResult.createPassedResult("toInfix works for complex division");
                }
                return TestResult.createFailedResult("toInfix doesn't work for complex division");
            }
        };
        tc.addTest(toInfixDivComplex, 26.0);

        Test toInfixAddMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"5", "y", "z", "+", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(5*(y+z))")){
                    return TestResult.createPassedResult("toInfix works for addition and multiplication");
                }
                return TestResult.createFailedResult("toInfix doesn't work for addition and multiplication");
            }
        };
        tc.addTest(toInfixAddMult, 27.0);

        Test toInfixAddSubs = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "7", "+", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(x-(y+7))")){
                    return TestResult.createPassedResult("toInfix works for addition and subtraction");
                }
                return TestResult.createFailedResult("toInfix doesn't work for addition and subtraction");
            }
        };
        tc.addTest(toInfixAddSubs, 28.0);

        Test toInfixAddDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "3", "z", "+", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(x/(3+z))")){
                    return TestResult.createPassedResult("toInfix works for addition and division");
                }
                return TestResult.createFailedResult("toInfix doesn't work for addition and division");
            }
        };
        tc.addTest(toInfixAddDiv, 29.0);

        Test toInfixSubsMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"2", "y", "z", "-", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(2*(y-z))")){
                    return TestResult.createPassedResult("toInfix works for subtraction and multiplication");
                }
                return TestResult.createFailedResult("toInfix doesn't work for subtraction and multiplication");
            }
        };
        tc.addTest(toInfixSubsMult, 30.0);

        Test toInfixSubsDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "3", "z", "-", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(x/(3-z))")){
                    return TestResult.createPassedResult("toInfix works for subtraction and division");
                }
                return TestResult.createFailedResult("toInfix doesn't work for subtraction and division");
            }
        };
        tc.addTest(toInfixSubsDiv, 31.0);

        Test toInfixMultDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "5", "/", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(x*(y/5))")){
                    return TestResult.createPassedResult("toInfix works for division and multiplication");
                }
                return TestResult.createFailedResult("toInfix doesn't work for division and multiplication");
            }
        };
        tc.addTest(toInfixMultDiv, 32.0);


        Test toPostfixAdd = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "6", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("y 6 +")){
                    return TestResult.createPassedResult("toPostfix works for addition");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for addition");
            }
        };
        tc.addTest(toPostfixAdd, 33.0);

        Test toPostfixAddComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "x", "7", "+", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("y x 7 + +")){
                    return TestResult.createPassedResult("toPostfix works for complex addition");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for complex addition");
            }
        };
        tc.addTest(toPostfixAddComplex, 34.0);

        Test toPostfixSubs = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"2", "y", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("2 y -")){
                    return TestResult.createPassedResult("toPostfix works for subtraction");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for subtraction");
            }
        };
        tc.addTest(toPostfixSubs, 35.0);

        Test toPostfixSubsComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "1", "z", "-", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x 1 z - -")){
                    return TestResult.createPassedResult("toPostfix works for complex subtraction");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for complex subtraction");
            }
        };
        tc.addTest(toPostfixSubsComplex, 36.0);

        Test toPostfixMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "2", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x 2 *")){
                    return TestResult.createPassedResult("toPostfix works for multiplication");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for multiplication");
            }
        };
        tc.addTest(toPostfixMult, 37.0);

        Test toPostfixMultComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"3", "y", "z", "*", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("3 y z * *")){
                    return TestResult.createPassedResult("toPostfix works for complex multiplication");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for complex multiplication");
            }
        };
        tc.addTest(toPostfixMultComplex, 38.0);

        Test toPostfixDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "5", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x 5 /")){
                    return TestResult.createPassedResult("toPostfix works for division");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for division");
            }
        };
        tc.addTest(toPostfixDiv, 39.0);

        Test toPostfixDivComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "6", "/", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x y 6 / /")){
                    return TestResult.createPassedResult("toPostfix works for complex division");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for complex division");
            }
        };
        tc.addTest(toPostfixDivComplex, 40.0);

        Test toPostfixAddMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "7", "z", "+", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x 7 z + *")){
                    return TestResult.createPassedResult("toPostfix works for addition and multiplication");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for addition and multiplication");
            }
        };
        tc.addTest(toPostfixAddMult, 41.0);

        Test toPostfixAddSubs = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "2", "z", "+", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x 2 z + -")){
                    return TestResult.createPassedResult("toPostfix works for addition and subtraction");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for addition and subtraction");
            }
        };
        tc.addTest(toPostfixAddSubs, 42.0);

        Test toPostfixAddDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"3", "y", "z", "+", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("3 y z + /")){
                    return TestResult.createPassedResult("toPostfix works for addition and division");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for addition and division");
            }
        };
        tc.addTest(toPostfixAddDiv, 43.0);

        Test toPostfixSubsMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "4", "-", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x y 4 - *")){
                    return TestResult.createPassedResult("toPostfix works for subtraction and multiplication");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for subtraction and multiplication");
            }
        };
        tc.addTest(toPostfixSubsMult, 44.0);

        Test toPostfixSubsDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "4", "z", "-", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x 4 z - /")){
                    return TestResult.createPassedResult("toPostfix works for subtraction and division");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for subtraction and division");
            }
        };
        tc.addTest(toPostfixSubsDiv, 45.0);

        Test toPostfixMultDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "5", "/", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("x y 5 / *")){
                    return TestResult.createPassedResult("toPostfix works for division and multiplication");
                }
                return TestResult.createFailedResult("toPostfix doesn't work for division and multiplication");
            }
        };
        tc.addTest(toPostfixMultDiv, 46.0);

        Test toStringAdd = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"2", "x", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(2+x)")){
                    return TestResult.createPassedResult("toString works for addition");
                }
                return TestResult.createFailedResult("toString doesn't work for addition");
            }
        };
        tc.addTest(toStringAdd, 47.0);

        Test toStringAddComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "3", "z", "+", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(y+(3+z))")){
                    return TestResult.createPassedResult("toString works for complex addition");
                }
                return TestResult.createFailedResult("toString doesn't work for complex addition");
            }
        };
        tc.addTest(toStringAddComplex, 48.0);

        Test toStringSubs = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "4", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(x-4)")){
                    return TestResult.createPassedResult("toString works for subtraction");
                }
                return TestResult.createFailedResult("toString doesn't work for subtraction");
            }
        };
        tc.addTest(toStringSubs, 49.0);

        Test toStringSubsComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"5", "y", "z", "-", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(5-(y-z))")){
                    return TestResult.createPassedResult("toString works for complex subtraction");
                }
                return TestResult.createFailedResult("toString doesn't work for complex subtraction");
            }
        };
        tc.addTest(toStringSubsComplex, 50.0);

        Test toStringMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "6", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(x*6)")){
                    return TestResult.createPassedResult("toString works for multiplication");
                }
                return TestResult.createFailedResult("toString doesn't work for multiplication");
            }
        };
        tc.addTest(toStringMult, 51.0);

        Test toStringMultComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"7", "y", "z", "*", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(7*(y*z))")){
                    return TestResult.createPassedResult("toString works for complex multiplication");
                }
                return TestResult.createFailedResult("toString doesn't work for complex multiplication");
            }
        };
        tc.addTest(toStringMultComplex, 52.0);

        Test toStringDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "3", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(x/3)")){
                    return TestResult.createPassedResult("toString works for division");
                }
                return TestResult.createFailedResult("toString doesn't work for division");
            }
        };
        tc.addTest(toStringDiv, 53.0);

        Test toStringDivComplex = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "4", "z", "/", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(x/(4/z))")){
                    return TestResult.createPassedResult("toString works for complex division");
                }
                return TestResult.createFailedResult("toString doesn't work for complex division");
            }
        };
        tc.addTest(toStringDivComplex, 54.0);

        Test toStringAddMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"2", "y", "z", "+", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(2*(y+z))")){
                    return TestResult.createPassedResult("toString works for addition and multiplication");
                }
                return TestResult.createFailedResult("toString doesn't work for addition and multiplication");
            }
        };
        tc.addTest(toStringAddMult, 55.0);

        Test toStringAddSubs = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "3", "z", "+", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(x-(3+z))")){
                    return TestResult.createPassedResult("toString works for addition and subtraction");
                }
                return TestResult.createFailedResult("toString doesn't work for addition and subtraction");
            }
        };
        tc.addTest(toStringAddSubs, 56.0);

        Test toStringAddDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "4", "+", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(x/(y+4))")){
                    return TestResult.createPassedResult("toString works for addition and division");
                }
                return TestResult.createFailedResult("toString doesn't work for addition and division");
            }
        };
        tc.addTest(toStringAddDiv, 57.0);

        Test toStringSubsMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"5", "y", "z", "-", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(5*(y-z))")){
                    return TestResult.createPassedResult("toString works for subtraction and multiplication");
                }
                return TestResult.createFailedResult("toString doesn't work for subtraction and multiplication");
            }
        };
        tc.addTest(toStringSubsMult, 58.0);

        Test toStringSubsDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "6", "z", "-", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(x/(6-z))")){
                    return TestResult.createPassedResult("toString works for subtraction and division");
                }
                return TestResult.createFailedResult("toString doesn't work for subtraction and division");
            }
        };
        tc.addTest(toStringSubsDiv, 59.0);

        Test toStringMultDiv = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"7", "y", "z", "/", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(7*(y/z))")){
                    return TestResult.createPassedResult("toString works for division and multiplication");
                }
                return TestResult.createFailedResult("toString doesn't work for division and multiplication");
            }
        };
        tc.addTest(toStringMultDiv, 60.0);

        Test simplifyAddZero = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                String[] postfix = {"x", "0", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the addition of zero to variable");
                }
                return TestResult.createFailedResult("simplify doesn't work for the addition of zero to variable");
            }
        };
        tc.addTest(simplifyAddZero, 61.0);

        Test simplifyAddVar = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                String[] postfix = {"0", "x", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the addition of variable to zero");
                }
                return TestResult.createFailedResult("simplify doesn't work for the addition of variable to zero");
            }
        };
        tc.addTest(simplifyAddVar, 62.0);

        Test simplifyMultOne = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                String[] postfix = {"x", "1", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the multiplication of one to variable");
                }
                return TestResult.createFailedResult("simplify doesn't work for the multiplication of one to variable");
            }
        };
        tc.addTest(simplifyMultOne, 63.0);

        Test simplifyMultVar = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                String[] postfix = {"1", "x", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the multiplication of variable to one");
                }
                return TestResult.createFailedResult("simplify doesn't work for the multiplication of variable to one");
            }
        };
        tc.addTest(simplifyMultVar, 63.0);

        Test simplifyMultZero = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(0);
                String[] postfix = {"x", "0", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the multiplication of zero to variable");
                }
                return TestResult.createFailedResult("simplify doesn't work for the multiplication of zero to variable");
            }
        };
        tc.addTest(simplifyMultZero, 64.0);

        Test simplifyMultVarZero = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(0);
                String[] postfix = {"0", "x", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the multiplication of variable to zero");
                }
                return TestResult.createFailedResult("simplify doesn't work for the multiplication of variable to zero");
            }
        };
        tc.addTest(simplifyMultVarZero, 65.0);

        Test simplifyDivZero = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(0);
                String[] postfix = {"0", "x", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the division of variable to zero");
                }
                return TestResult.createFailedResult("simplify doesn't work for the division of variable to zero");
            }
        };
        tc.addTest(simplifyDivZero, 66.0);

        Test simplifyDivOne = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                String[] postfix = {"x", "1", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the division of one to variable");
                }
                return TestResult.createFailedResult("simplify doesn't work for the division of one to variable");
            }
        };
        tc.addTest(simplifyDivOne, 67.0);

        Test simplifyDivVar = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(1);
                String[] postfix = {"x", "x", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the division of same variable to variable");
                }
                return TestResult.createFailedResult("simplify doesn't work for the division of same variable to variable");
            }
        };
        tc.addTest(simplifyDivVar, 68.0);

        Test simplifySubsZero = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                String[] postfix = {"x", "0", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the subtraction of 0 from variable");
                }
                return TestResult.createFailedResult("simplify doesn't work for the subtraction of 0 from variable");
            }
        };
        tc.addTest(simplifySubsZero, 69.0);

        Test simplifySubsVar = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(0);
                String[] postfix = {"x", "x", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the subtraction of same variable from variable");
                }
                return TestResult.createFailedResult("simplify doesn't work for the subtraction of same variable from variable");
            }
        };
        tc.addTest(simplifySubsVar, 70.0);

        Test simplifyOnlyNumAdd = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(7);
                String[] postfix = {"4", "3", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the addition of only numbers");
                }
                return TestResult.createFailedResult("simplify doesn't work for the addition of only numbers");
            }
        };
        tc.addTest(simplifyOnlyNumAdd, 71.0);

        Test simplifyOnlyNumMult = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(12);
                String[] postfix = {"4", "3", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the multiplication of only numbers");
                }
                return TestResult.createFailedResult("simplify doesn't work for the multiplication of only numbers");
            }
        };
        tc.addTest(simplifyOnlyNumMult, 72.0);

        Test simplifyOnlyNumDiv = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(2);
                String[] postfix = {"6", "3", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the division of only numbers");
                }
                return TestResult.createFailedResult("simplify doesn't work for the division of only numbers");
            }
        };
        tc.addTest(simplifyOnlyNumDiv, 73.0);

        Test simplifyOnlyNumSubs = new Test() {
            @Override
            public TestResult runTest() {
                IntegerOperand x = new IntegerOperand(1);
                String[] postfix = {"4", "3", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("simplify works for the subtraction of only numbers");
                }
                return TestResult.createFailedResult("simplify doesn't work for the subtraction of only numbers");
            }
        };
        tc.addTest(simplifyOnlyNumSubs, 74.0);

        Test evaluateAdd = new Test() {
            @Override
            public TestResult runTest() {
                HashMap<String, Integer> assignment = new HashMap<String, Integer>();
                String x = "x";
                assignment.put(x, 2);
                String[] postfix = {"x", "3", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.evaluate(assignment) == 5){
                    return TestResult.createPassedResult("evaluate works for the addition");
                }
                return TestResult.createFailedResult("evaluate doesn't work for the addition");
            }
        };
        tc.addTest(evaluateAdd, 75.0);

        Test evaluateMult = new Test() {
            @Override
            public TestResult runTest() {
                HashMap<String, Integer> assignment = new HashMap<String, Integer>();
                String x = "x";
                assignment.put(x, 2);
                String[] postfix = {"x", "3", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.evaluate(assignment) == 6){
                    return TestResult.createPassedResult("evaluate works for the multiplication");
                }
                return TestResult.createFailedResult("evaluate doesn't work for the multiplication");
            }
        };
        tc.addTest(evaluateMult, 76.0);

        Test evaluateDiv = new Test() {
            @Override
            public TestResult runTest() {
                HashMap<String, Integer> assignment = new HashMap<String, Integer>();
                String x = "x";
                assignment.put(x, 6);
                String[] postfix = {"x", "3", "/"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.evaluate(assignment) == 2){
                    return TestResult.createPassedResult("evaluate works for the division");
                }
                return TestResult.createFailedResult("evaluate doesn't work for the division");
            }
        };
        tc.addTest(evaluateDiv, 77.0);

        Test evaluateSubs = new Test() {
            @Override
            public TestResult runTest() {
                HashMap<String, Integer> assignment = new HashMap<String, Integer>();
                String x = "x";
                assignment.put(x, 4);
                String[] postfix = {"x", "3", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.evaluate(assignment) == 1){
                    return TestResult.createPassedResult("evaluate works for the subtraction");
                }
                return TestResult.createFailedResult("evaluate doesn't work for the subtraction");
            }
        };
        tc.addTest(evaluateSubs, 78.0);

        Test getVariableOne = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "3", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.getVariables().size() == 1 && exp.getVariables().contains("x")){
                    return TestResult.createPassedResult("getVariable works for one variable");
                }
                return TestResult.createFailedResult("getVariable doesn't work for one variable");
            }
        };
        tc.addTest(getVariableOne, 79.0);

        Test getVariableMult = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"x", "y", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.getVariables().size() == 2 && exp.getVariables().contains("x") && exp.getVariables().contains("y")){
                    return TestResult.createPassedResult("getVariable works for multiple variable");
                }
                return TestResult.createFailedResult("getVariable doesn't work for multiple variable");
            }
        };
        tc.addTest(getVariableMult, 80.0);

        Test failedtestExpFromPostFixAdd = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand left = new VariableOperand("x");
                IntegerOperand right = new IntegerOperand(2);
                SumExpression sumExp = new SumExpression(left, right);
                String[] postfix = {"y", "2", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(sumExp)){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedtestExpFromPostFixAdd, 85.0);

        Test failedtoInfixAdd = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "6", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toInfix().equals("(y+4)")){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedtoInfixAdd, 86.0);

        Test failedtoPrefixAdd = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "2", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPrefix().equals("+ y 1")){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedtoPrefixAdd, 87.0);

        Test failedtoPostfixAdd = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "2", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toPostfix().equals("y 6 +")){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedtoPostfixAdd, 88.0);

        Test failedtoStringAdd = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"5", "x", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.toString().equals("(2+x)")){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedtoStringAdd, 89.0);

        Test failedsimplifyMultOne = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("z");
                String[] postfix = {"x", "1", "*"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.simplify().equals(x)){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedsimplifyMultOne, 90.0);

        Test failedevaluateAdd = new Test() {
            @Override
            public TestResult runTest() {
                HashMap<String, Integer> assignment = new HashMap<String, Integer>();
                String x = "x";
                assignment.put(x, 2);
                String[] postfix = {"x", "3", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.evaluate(assignment) == 8){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedevaluateAdd, 91.0);

        Test failedgetVariableOne = new Test() {
            @Override
            public TestResult runTest() {
                String[] postfix = {"y", "3", "-"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.getVariables().size() == 1 && exp.getVariables().contains("x")){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedgetVariableOne, 92.0);

        Test failedequalsAdd = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand x = new VariableOperand("x");
                IntegerOperand y = new IntegerOperand(3);
                SumExpression sumExp = new SumExpression(x, y);
                String[] postfix = {"x", "2", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(sumExp)){
                    return TestResult.createPassedResult("should fail");
                }
                return TestResult.createFailedResult("should fail");
            }
        };
        tc.addTest(failedequalsAdd, 93.0);

        Test exceptionevaluateAdd = new Test() {
            @Override
            public TestResult runTest() {
                HashMap<String, Integer> assignment = new HashMap<String, Integer>();
                String x = "";
                assignment.put(x, 2);
                String[] postfix = {"x", "3", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.evaluate(assignment) == 8){
                    return TestResult.createPassedResult("should give exception");
                }
                return TestResult.createFailedResult("should give exception");
            }
        };
        tc.addTest(exceptionevaluateAdd, 94.0);

        Test expressionFromPostFixSpecial = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand left = new VariableOperand("x");
                VariableOperand right = new VariableOperand("#");
                SumExpression sum = new SumExpression(left, right);
                String[] postfix = {"x", "#", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(sum)){
                    return TestResult.createPassedResult("expressionFromPostFixSpecial doesn't work with eliminating special case letters");
                }
                return TestResult.createExceptionResult("expressionFromPostFixSpecial works with eliminating special case letters");
            }
        };
        tc.addTest(expressionFromPostFixSpecial, 95.0);

        Test expressionFromPostFixNegative = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand left = new VariableOperand("x");
                IntegerOperand right = new IntegerOperand(-6);
                SumExpression sum = new SumExpression(left, right);
                String[] postfix = {"x", "-6", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(sum)){
                    return TestResult.createPassedResult("expressionFromPost works with negative numbers");
                }
                return TestResult.createFailedResult("expressionFromPost doesn't work with negative numbers");
            }
        };
        tc.addTest(expressionFromPostFixNegative, 96.0);

        Test expressionFromPostFixTwoVar = new Test() {
            @Override
            public TestResult runTest() {
                VariableOperand left = new VariableOperand("x");
                VariableOperand right = new VariableOperand("yz");
                SumExpression sum = new SumExpression(left, right);
                String[] postfix = {"x", "yz", "+"};
                Expression exp = Expression.expressionFromPostfix(postfix);
                if (exp.equals(sum)){
                    return TestResult.createPassedResult("expressionFromPost works with variable with two characters");
                }
                return TestResult.createFailedResult("expressionFromPost doesn't work with variable with two characters");
            }
        };
        tc.addTest(expressionFromPostFixTwoVar, 97.0);

        // run tests
        tc.runTests();

        // get report
        tc.createReport();
    }
}
