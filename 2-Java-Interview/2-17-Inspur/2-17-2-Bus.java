package acmCoder;

import java.util.Scanner;

/**
 * @author WuPing
 * @version 2016年9月6日 下午8:09:24
 */

public class Bus {

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()) {
	    int n = cin.nextInt();
	    int vb = cin.nextInt();
	    int vs = cin.nextInt();
	    int[] zuobiao = new int[n];
	    for (int i = 0; i < n; i++) {
		zuobiao[i] = cin.nextInt();
	    }
	    int xd = cin.nextInt();
	    int yd = cin.nextInt();

	    int site = 1;
	    double[] sumTime = new double[n];
	    if (xd >= 100000 || yd >= 100000) {
		site = n;
	    } else {
		for (int i = 0; i < n; i++) {
		    double sL = 0.0;
		    if (zuobiao[i] < xd) {
			sL = Math.sqrt((xd - zuobiao[i]) * (xd - zuobiao[i]) + yd * yd);
			sumTime[i] = zuobiao[i] / vb + sL / vs;
		    }

		    if (zuobiao[i] == xd) {
			sumTime[i] = zuobiao[i] / vb + yd / vs;
		    }

		    if (zuobiao[i] > xd) {
			sL = Math.sqrt((zuobiao[i] - xd) * (zuobiao[i] - xd) + yd * yd);
			sumTime[i] = zuobiao[i] / vb + sL / vs;
		    }
		}

		double minTime = sumTime[0];
		for (int i = 1; i < sumTime.length; i++) {
		    if (sumTime[i] < minTime) {
			minTime = sumTime[i];
		    }
		}

		for (int i = 0; i < sumTime.length; i++) {
		    if (sumTime[i] - minTime < 0.00000000000000001) {
			site = i + 1;
		    }
		}
	    }

	    System.out.println(site);
	}
	cin.close();
    }

}
