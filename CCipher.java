/*

Problem Statement
    
Julius Caesar used a system of cryptography, now known as Caesar Cipher, which shifted each letter 2 places further through the alphabet (e.g. 'A' shifts to 'C', 'R' shifts to 'T', etc.). At the end of the alphabet we wrap around, that is 'Y' shifts to 'A'.
We can, of course, try shifting by any number. Given an encoded text and a number of places to shift, decode it.
For example, "TOPCODER" shifted by 2 places will be encoded as "VQREQFGT". In other words, if given (quotes for clarity) "VQREQFGT" and 2 as input, you will return "TOPCODER". See example 0 below.
Definition
    
Class:
CCipher
Method:
decode
Parameters:
String, int
Returns:
String
Method signature:
String decode(String cipherText, int shift)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
cipherText has between 0 to 50 characters inclusive
-
each character of cipherText is an uppercase letter 'A'-'Z'
-
shift is between 0 and 25 inclusive
Examples
0)

    
"VQREQFGT"
2
Returns: "TOPCODER"

1)

    
"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
10
Returns: "QRSTUVWXYZABCDEFGHIJKLMNOP"

2)

    
"TOPCODER"
0
Returns: "TOPCODER"

3)

    
"ZWBGLZ"
25
Returns: "AXCHMA"

4)

    
"DBNPCBQ"
1
Returns: "CAMOBAP"

5)

    
"LIPPSASVPH"
4
Returns: "HELLOWORLD"

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
*/
public class CCipher
{
	

	public static String decode(String encoded, int shift)
	{
		char[] charOfEncoded = encoded.toCharArray();
		for(int i=0;i<encoded.length();i++)
		{
			int temp = (int)(charOfEncoded[i]) - shift;
			if(temp>=65)
				charOfEncoded[i] = (char) temp;
			else
				charOfEncoded[i] = (char)(90-temp);
		}

		return String.valueOf(charOfEncoded);
	}
}