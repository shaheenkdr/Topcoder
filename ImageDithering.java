/*
Problem Statement
    
Sometimes when computer programs have a limited number of colors to use, they use a technique called dithering. Dithering is when you use a pattern made up of different colors such that when the colors are viewed together, they appear like another color. For example, you can use a checkerboard pattern of black and white pixels to achieve the illusion of gray.
You are writing a program to determine how much of the screen is covered by a certain dithered color. Given a computer screen where each pixel has a certain color, and a list of all the solid colors that make up the dithered color, return the number of pixels on the screen that are used to make up the dithered color. Each pixel will be represented by a character in screen. Each character in screen and in dithered will be an uppercase letter ('A'-'Z') representing a color.
Assume that any pixel which is a color contained in dithered is part of the dithered color.
Definition
    
Class:
ImageDithering
Method:
count
Parameters:
String, String[]
Returns:
int
Method signature:
int count(String dithered, String[] screen)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Constraints
-
dithered will contain between 2 and 26 upper case letters ('A'-'Z'), inclusive.
-
There will be no repeated characters in dithered.
-
screen will have between 1 and 50 elements, inclusive.
-
Each element of screen will contain between 1 and 50 upper case letters ('A'-'Z'), inclusive.
-
All elements of screen will contain the same number of characters.
Examples
0)

    
"BW"
{"AAAAAAAA",
 "ABWBWBWA",
 "AWBWBWBA",
 "ABWBWBWA",
 "AWBWBWBA",
 "AAAAAAAA"}
Returns: 24
Here, our dithered color could consist of black (B) and white (W) pixels, composing a shade of gray. In the picture, there is a dithered gray square surrounded by another color (A).
1)

    
"BW"
{"BBBBBBBB",
 "BBWBWBWB",
 "BWBWBWBB",
 "BBWBWBWB",
 "BWBWBWBB",
 "BBBBBBBB"}
Returns: 48
Here is the same picture, but with the outer color replaced with black pixels. Although in reality, the outer pixels do not form a dithered color, your algorithm should still assume they are part of the dithered pattern.
2)

    
"ACEGIKMOQSUWY"
{"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"}
Returns: 150
A picture of vertical stripes, every other stripe is considered part of the dithered color.
3)

    
"CA"
{"BBBBBBB",
 "BBBBBBB",
 "BBBBBBB"}
Returns: 0
The dithered color is not present.
4)

    
"DCBA"
{"ACBD"}
Returns: 4
The order of the colors doesn't matter.
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
*/
import java.util.Arrays;
public class ImageDithering
{


	public static int count(String dithered, String[] screen)
	{
		char[] dith_arr = dithered.toCharArray();
		final int scr_len = screen[0].length();
		int result = 0;
		Arrays.sort(dith_arr);
		for(int i=0;i<screen.length;i++)
		{
			char[] temp = screen[i].toCharArray();
			if(scr_len%2==0)
			{
				for(int x=1;x<scr_len;x+=2)
				{
					if(Arrays.binarySearch(dith_arr,temp[x-1])>=0)
						++result;
					if(Arrays.binarySearch(dith_arr,temp[x])>=0)
						++result;
				}

			}

			else
			{
				for(int x=1;x<scr_len;x++)
				{
					if(Arrays.binarySearch(dith_arr,temp[x])>0)
						++result;
				}
			}

		}

		return result;
	}
}