/*

Problem Statement
    
Let's say you have a binary string such as the following:
011100011
One way to encrypt this string is to add to each digit the sum of its adjacent digits. For example, the above string would become:
123210122
In particular, if P is the original string, and Q is the encrypted string, then Q[i] = P[i-1] + P[i] + P[i+1] for all digit positions i. Characters off the left and right edges of the string are treated as zeroes.
An encrypted string given to you in this format can be decoded as follows (using 123210122 as an example):
Assume P[0] = 0.
Because Q[0] = P[0] + P[1] = 0 + P[1] = 1, we know that P[1] = 1.
Because Q[1] = P[0] + P[1] + P[2] = 0 + 1 + P[2] = 2, we know that P[2] = 1.
Because Q[2] = P[1] + P[2] + P[3] = 1 + 1 + P[3] = 3, we know that P[3] = 1.
Repeating these steps gives us P[4] = 0, P[5] = 0, P[6] = 0, P[7] = 1, and P[8] = 1.
We check our work by noting that Q[8] = P[7] + P[8] = 1 + 1 = 2. Since this equation works out, we are finished, and we have recovered one possible original string.
Now we repeat the process, assuming the opposite about P[0]:
Assume P[0] = 1.
Because Q[0] = P[0] + P[1] = 1 + P[1] = 1, we know that P[1] = 0.
Because Q[1] = P[0] + P[1] + P[2] = 1 + 0 + P[2] = 2, we know that P[2] = 1.
Now note that Q[2] = P[1] + P[2] + P[3] = 0 + 1 + P[3] = 3, which leads us to the conclusion that P[3] = 2. However, this violates the fact that each character in the original string must be '0' or '1'. Therefore, there exists no such original string P where the first digit is '1'.
Note that this algorithm produces at most two decodings for any given encrypted string. There can never be more than one possible way to decode a string once the first binary digit is set.
Given a String message, containing the encrypted string, return a String[] with exactly two elements. The first element should contain the decrypted string assuming the first character is '0'; the second element should assume the first character is '1'. If one of the tests fails, return the string "NONE" in its place. For the above example, you should return {"011100011", "NONE"}.
*/

import java.util.Arrays;
public class Binary
{
	public static void main(String[] args)
	{
		String[] data = decode("3");
		System.out.println(data[0]);
		System.out.println(data[1]);
	}


public static String[] decode(String encoded)
{
	char[] test = encoded.toCharArray();
	int[] decode_arr = new int[test.length];
	String[] result = new String[2];
	boolean flag= false;

	for(int i=0;i<2;i++)
	{
		flag = false;
		if(test.length>1)
		{
			decode_arr[0] = i;
		decode_arr[1] = Character.getNumericValue(test[0])-decode_arr[0];

		if(Character.getNumericValue(test[test.length-1])==0 || test.length==1)
			flag = true;

		for(int x=2;x<test.length;x++)
		{
			decode_arr[x] = Character.getNumericValue(test[x-1]) - decode_arr[x-2]-decode_arr[x-1];
			if(decode_arr[x]>1 || decode_arr[x]<0)
				flag=true;


		}
		}
		else
			flag = true;
		
		if(!flag)
		    result[i] = Arrays.toString(decode_arr).replace(", ", "").replace("[", "").replace("]", "");

		else
			result[i] = "NONE";
		decode_arr = null;
		decode_arr = new int[test.length];
	}

	return result;

}

}