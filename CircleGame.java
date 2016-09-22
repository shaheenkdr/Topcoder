/*Problem Statement
    
Tommy is learning a simple card game called Circle. To play the game, the single player shuffles a deck of cards. He or she then flips through the deck, removing all instances of the 'K' card, and all consecutive pairs of cards that add up to 13. The deck does wrap around, so that if the last card remaining in the deck and the first card remaining in the deck add up to 13, they are both removed. The player keeps cycling through the deck until no more cards can be removed.
Create a class CircleGame containing the method cardsLeft that takes a String deck representing a not-necessarily complete nor correct deck of cards. Each character of deck represents the value of a card without the suit. The values shown on the card represent the following numerical values:
'A' - 1
'2' - 2
'3' - 3
'4' - 4
'5' - 5
'6' - 6
'7' - 7
'8' - 8
'9' - 9
'T' - 10
'J' - 11
'Q' - 12
'K' - 13
Given deck, return the number of cards remaining after the game has been played to its fullest such that no more cards can be removed.
Definition
    
Class:
CircleGame
Method:
cardsLeft
Parameters:
String
Returns:
int
Method signature:
int cardsLeft(String deck)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
64
Notes
-
There are no guarantees made about the contents of the deck. For example, there can be more than four of a given value of card.
-
Note that if a particular card can make a sum of 13 with the card before or after it, it does not matter which is chosen. For example, 38582, whether you use the first 8 or the second 8, will still become 382 after the two cards (5 and 8) are removed.
Constraints
-
deck will have between 10 and 50 characters, inclusive.
-
each character of deck will be a character from the set {'2'-'9','A','T','J','Q','K'}.
Examples
0)

    
"KKKKKKKKKK"
Returns: 0
All K cards are always removed from the deck.
1)

    
"KKKKKAQT23"
Returns: 1
The K cards are removed, leaving AQT23. AQ are then removed because they add up to 13, leaving T23. Since the deck wraps around and T and 3 add up to 13, they are also removed, just leaving the 2.
2)

    
"KKKKATQ23J"
Returns: 6
Only the K cards can be removed.
3)

    
"AT68482AK6875QJ5K9573Q"
Returns: 4
The remaining deck is 6875.
4)

    
"AQK262362TKKAQ6262437892KTTJA332"
Returns: 24
*/

import java.util.HashMap;
public class CircleGame
{
	private static final HashMap<Character,Integer> myMap;

	static
	{
		myMap = new HashMap<Character,Integer>();
		myMap.put('A',1);
		myMap.put('2',2);
		myMap.put('3',3);
		myMap.put('4',4);
		myMap.put('5',5);
		myMap.put('6',6);
		myMap.put('7',7);
		myMap.put('8',8);
		myMap.put('9',9);
		myMap.put('T',10);
		myMap.put('J',11);
		myMap.put('Q',12);
		myMap.put('K',13);
	}
	

	public static int cardsLeft(String card_sent)
	{
		card_sent = card_sent.replace("K", "");
		char[] cards = card_sent.toCharArray();

		for(int i=0;i<cards.length-1;i++)
		{
			if(cards[i]!='X'&&cards[i+1]!='X')
			{
				if(myMap.get(cards[i])+myMap.get(cards[i+1])==13)
			    {
				    cards[i] = cards[i+1] = 'X';
			    }
			}
			
		}

		int max = 0;
		if(card_sent.length()>1)
		{
			StringBuilder remx = new StringBuilder();
		    remx.setLength(0);
		    for(int i=0;i<cards.length;i++)
		    {
			    if(cards[i]!='X')
				    remx.append(cards[i]);
		    }

		    if(myMap.get(remx.charAt(0))+myMap.get(remx.charAt(remx.length()-1))==13)
			    max = 2;

		    max = remx.length() - max;

		}
		if(card_sent.length()==1)
		   max =1;		
		return max;
	}

}