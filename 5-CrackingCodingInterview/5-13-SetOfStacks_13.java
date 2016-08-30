package crackingCodingInterview;

import java.util.ArrayList;

/**
 * @author WuPing
 * @version 2016年8月30日 下午2:52:05
 */

public class SetOfStacks_13 {

    public static ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
	ArrayList<ArrayList<Integer>> stackSet = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentArray = new ArrayList<Integer>();
        stackSet.add(currentArray);
        
        for(int i=0;i<ope.length;i++){
            int cmd = ope[i][0];
            int data = ope[i][1];
            
            switch(cmd){
            //1: push
            case 1:
                // 当前数组未满
                if(currentArray.size()!=size){
                    currentArray.add(data);
                }
                else{
                    currentArray = new ArrayList<Integer>();
                    stackSet.add(currentArray);
                    currentArray.add(data);
                }
                break;
            //2: pop
            case 2:
                // 当前数组不为空
                if(currentArray.size()!=0){
                    currentArray.remove(currentArray.size()-1);
                }
                else{
                    stackSet.remove(stackSet.size()-1);
                    currentArray = stackSet.get(stackSet.size()-1);
                    currentArray.remove(currentArray.size()-1);
                }
                break;
            }
        }
        return stackSet;
    }

    public static void main(String[] args) {
	int[][] ope = {{1,1},{1,2},{1,3},{1,4},{1,5},{2,0},{2,0},{2,0},{1,6}};
        int size = 3;
        
        ArrayList<ArrayList<Integer>> stackSet = new ArrayList<ArrayList<Integer>>();
        stackSet = setOfStacks(ope, size);
        for(int i=0; i<stackSet.size(); i++) {
            for(int j=0; j<stackSet.get(i).size(); j++) {
        	System.out.print(stackSet.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
