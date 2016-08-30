package crackingCodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WuPing
 * @version 2016年8月30日 下午4:25:34
 */

public class CatDogAsylum_15 {

    public static ArrayList<Integer> asylum(int[][] ope) {
        Queue<Integer> dog = new LinkedList<Integer>();
        Queue<Integer> cat = new LinkedList<Integer>();
        Queue<Integer> all = new LinkedList<Integer>();
        ArrayList<Integer> animal = new ArrayList<Integer>();
        
        for(int i=0; i<ope.length; i++)
        {
            if(ope[i][0]==1)
            {
                all.offer(ope[i][1]);
                if(ope[i][1] > 0)
                    dog.offer(ope[i][1]);
                else if(ope[i][1]<0)
                    cat.offer(ope[i][1]);
            }
            else if(ope[i][0]==2)
            {
                if(ope[i][1]==0)
                {
                    if(!all.isEmpty())
                    {
                        // 看最先被领养的是猫还是狗, 同步删除猫或狗中的stack
                        int temp = all.poll();
                        animal.add(temp);
                        if(temp>0)
                            dog.poll();
                        else
                            cat.poll();
                    }
                }
                else if(ope[i][1]>0)
                {
                    if(!dog.isEmpty())
                    {
                        //指定领养狗,同步删除动物队列和狗队列
                        int temp = dog.poll();
                        animal.add(temp);
                        all.remove(temp);
                    }
                }
                else
                {
                    if(!cat.isEmpty())
                    {
                        //指定领养猫,同步删除动物队列和猫队列
                        int temp = cat.poll();
                        animal.add(temp);
                        all.remove(temp);
                    }
                }
            }
        }
        return animal;
    }
    
    public static void main(String[] args) {
	int[][] ope = {{1,1},{1,-1},{2,0},{2,-1}};
	ArrayList<Integer> animal = new ArrayList<Integer>();
	animal = asylum(ope);
	for(int i=0; i<animal.size(); i++) {
	    if(i==0) {
		 System.out.print(animal.get(i));
	    }else {
		System.out.print("," + animal.get(i));
	    }
	}
    }

}
