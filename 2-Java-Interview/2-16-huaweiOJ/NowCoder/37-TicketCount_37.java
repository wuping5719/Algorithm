package huawei;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月3日 下午3:01:37
 */

public class TicketCount_37 {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String numOfCandidatesStr = cin.nextLine();
	    long numOfCandidates = Long.valueOf(numOfCandidatesStr);
	    
	    String candidateStr = cin.nextLine();
	    String[] candidates = candidateStr.split(" ");
	    
	    String numOfVotersStr = cin.nextLine();
	    long numOfVoters = Long.valueOf(numOfVotersStr);
	    
	    String voteStr = cin.nextLine();
	    String[] votes = voteStr.split(" ");
	    
	    LinkedHashMap<String, Long> map = new LinkedHashMap<String, Long>();
	    for(int i=0; i<numOfCandidates; i++) {
		if(!map.containsKey(candidates[i])) {
		    map.put(candidates[i], (long)0);
		}
	    }
	    
	    long invalidNum = 0;
	    for(int i=0; i<numOfVoters; i++) {
		if(map.containsKey(votes[i])) {
		    map.put(votes[i], map.get(votes[i])+1);
		}else {
		    invalidNum++; 
		}
	    }
	    
	    for(String str: map.keySet()) {
		System.out.println(str + " : " + map.get(str));
	    }
	    System.out.println("Invalid : " + invalidNum);
	}
        cin.close();
    }

}
