package swordOffer;

import java.io.IOException;

/** 
 * @author  WuPing
 * @date 2016年8月28日 上午10:28:20 
 * @version 1.0 
 */
public class FirstCharacterInStream_55 {

	private static int[] hashTable = new int[256];
	private static StringBuilder sb = new StringBuilder();
    
	public static void Insert(char ch) {
		sb.append(ch);
		if (hashTable[ch] == 0)
			hashTable[ch] = 1;
		else
			hashTable[ch] += 1;
	}
    
	public static char FirstAppearingOnce()
    {
      char[] str = sb.toString().toCharArray();
      for(char c:str)
      {
          if(hashTable[c] == 1)
             return c;
      }
      return '#';
    }
	
	public static void main(String[] args) {
		char ch;
		try {
		    while ((ch = (char) System.in.read()) != '\r') {
		    	Insert(ch);
		    	char result = FirstAppearingOnce();
		        System.out.print(result + " ");
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

}
