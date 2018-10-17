package roman_calculator;
import java.util.Scanner;

public class RomanCalculator {
// scan can now be used anywhere within this class
Scanner scan = new Scanner(System.in);

boolean doCalculation()
{

char operator = getOperator();
if(operator=='q'){
	return false;
}

int operand1 = getOperand(1);
int operand2 = getOperand(2);
int answer = doArithmetic(operand1, operand2, operator);

String sAnswer = convert_to_Roman(answer);
System.out.println("The answer is " + sAnswer);

return true;
}

char getOperator()
{char operator='q';
boolean operator_is_good=false; 

while(!operator_is_good){
System.out.print("Enter an Operator: +  -   *  /  q for quit: ");
operator = scan.next().toLowerCase().charAt(0);
switch (operator)
{case 'q':
case 'Q':
case '+':
case '-':
case '*':
case '/':
operator_is_good = true;
break;
default:
System.out.println("Your operator is bad ... try again:");
operator_is_good = false;
break;}

}

return operator;
}

int getOperand(int which)
{
	System.out.print("Enter operand" + which + ": ");
	String op = scan.next();
	
	return convert_from_Roman(op);
	
// ************** FILL IN CODE     
}

String convert_to_Roman(int value)
{	
	String retval = "";
	String one = "";
	
	while(value > 0)
	{int rom_digit = value / 1000;
	if(rom_digit > 0)
		{for (int i = rom_digit; i > 0; i --)
			{one = "M";
			value = value - 1000;
			retval = retval + one;
			}
		}
	else
		{rom_digit = value / 500;
			if(rom_digit > 0)
			{for (int i = rom_digit; i > 0; i --)
				{one = "D";
				value = value - 500;
				retval = retval + one;
				}
			}
			else{rom_digit = value / 100;
				if (rom_digit > 0)
					{for (int i = rom_digit; i > 0; i --)
						{one = "C";
						value = value - 100;
						retval = retval + one;}
					}
			else{rom_digit = value / 50;
					if(rom_digit > 0)
						{for (int i = rom_digit; i > 0; i --)
							{one = "L";
							value = value - 50;
							retval = retval + one;}
					}
			else{rom_digit = value / 10;
					if(rom_digit > 0){
						for (int i = rom_digit; i > 0; i --){
							one = "X";
							value = value - 10;
							retval = retval + one;
						}
					}
					else{
						rom_digit = value / 5;
						if(rom_digit > 0){
							for (int i = rom_digit; i >0; i --){
								one = "V";
								value = value - 5;
								retval = retval + one;
							}
						}
						else{
							rom_digit = value / 1;
							if(rom_digit > 0){
								for(int i = rom_digit; i >0; i--){
									one = "I";
									value = value -1;
									retval = retval + one;
								}
							}
						}
					}
					
						
					}
				}
		}
	
	}
}
	return retval;
}


int convert_from_Roman(String value)
{
	boolean operand_is_good = false;
	String s = value.toUpperCase().trim();
	int len = s.length();
	int total = 0;
	int digitValue = 0;
	
while(!operand_is_good){
	for(int i = len-1; i >= 0; i--){
		
		char c = s.charAt(i);
		switch(c){
		case 'I': digitValue = 1;operand_is_good = true;break;
		case 'V': digitValue = 5;operand_is_good = true; break;
		case 'X': digitValue = 10;operand_is_good = true; break;
		case 'L': digitValue = 50;operand_is_good = true; break;
		case 'C': digitValue = 100;operand_is_good = true; break; 
		case 'D': digitValue = 500;operand_is_good = true; break;
		case 'M': digitValue = 1000;operand_is_good = true; break;
		default: System.out.println("Invalid Entry at " + i);
		operand_is_good = false;
		System.out.print("Re-enter operand: ");
		s = scan.next().toUpperCase().trim();
		len = s.length();
		digitValue = 0;
		total = 0;}
		total += digitValue;
	}
}
	return total;
// ************** FILL IN CODE 
}

int doArithmetic(int operand1, int operand2, char operator)
{int answer;
switch(operator)
{case '+':answer = operand1 + operand2;
break;
case '-':answer = operand1 -operand2;
break;
case '*':answer = operand1 * operand2;
break;
case '/':answer = operand1 / operand2;
break;
default:
System.out.println("We shouldn't get here in doArithmentic!!!!");
answer = -1;
break;}
return answer;
}
public static void main(String[] args) {
RomanCalculator rc = new RomanCalculator();
while (rc.doCalculation())
{
System.out.println("Good job");
}
System.out.println("Finished Roman Computations");
}
}