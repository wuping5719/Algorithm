package huawei;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年10月4日 下午9:16:56
 */

class Student {
    public String name;
    public int grade;

    public Student(String name, int grade) {
	this.name = name;
	this.grade = grade;
    }
}

public class SortsScores_62 {
    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    String nStr = cin.nextLine();
	    int n = Integer.parseInt(nStr);
	    String modeStr = cin.nextLine();
	    int mode = Integer.parseInt(modeStr);
	    
	    Student[] students = new Student[n];
	    for(int i=0; i<n; i++) {
		String str = cin.nextLine();
		String[] strArray = str.split(" ");
		
		String name = strArray[0];
		int grade = Integer.parseInt(strArray[1]);
		students[i] = new Student(name, grade);
	    }
	    
	    //排序
            if(mode == 0){
                //从大到小排序(冒泡)
                for(int i=0; i<n; i++){
                    for(int j=0; j<n-1-i; j++){
                        if(students[j].grade < students[j+1].grade){
                            Student temp = students[j];
                            students[j] = students[j+1];
                            students[j+1] = temp;
                        }
                    }
                }
            }else{
                //从小到大排序
                for(int i=0; i<n; i++){
                    for(int j=0; j<n-1-i; j++){
                        if(students[j].grade > students[j+1].grade){
                            Student temp = students[j];
                            students[j] = students[j+1];
                            students[j+1] = temp;
                        }
                    }
                }
            }
             
            //输出
            for(int i=0; i<n; i++){
                System.out.println(students[i].name +" "+ students[i].grade);
            }
	}
	cin.close();
    }

}
