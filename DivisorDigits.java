/*

Problem Statement
    
Create a class DivisorDigits containing a method howMany which takes an int number and returns how many digits in number divide evenly into number itself.
Definition
    
Class:
DivisorDigits
Method:
howMany
Parameters:
int
Returns:
int
Method signature:
int howMany(int number)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
No number is divisible by 0.
Constraints
-
number will be between 10000 and 999999999.
Examples
0)

    
12345
Returns: 3
12345 is divisible by 1, 3, and 5.
1)

    
661232
Returns: 3
661232 is divisible by 1 and 2.
2)

    
52527
Returns: 0
52527 is not divisible by 5, 2, or 7.
3)

    
730000000
Returns: 0
Nothing is divisible by 0. In this case, the number is also not divisible by 7 or 3.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
*/

public class DivisorDigits
{
	

	public static int howMany(int num)
	{
		char[] x = new String(""+num).toCharArray();
		int count = 0;
		try{

		for(int i=0;i<x.length;i++)
		{
			int temp = Integer.valueOf(x[i])-'0';
			if(temp==0)
				continue;
			if(num%temp==0)
				++count;
		}
	}
	catch(Exception e){}
		return count;

	}
}