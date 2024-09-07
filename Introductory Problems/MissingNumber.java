import java.io.*;
import java.math.BigInteger;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1083

public class MissingNumber {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = BigInteger.valueOf(sc.nextInt());
		BigInteger sum = new BigInteger("0");

		for (int i = 0; i < (n.intValue() - 1); i++) {
			sum = sum.add(BigInteger.valueOf(sc.nextInt()));
		}

		BigInteger totalSum = n.multiply(new BigInteger(n.toString()).add(BigInteger.valueOf(1)));
		totalSum = totalSum.divide(BigInteger.valueOf(2));

		BigInteger missingNum = totalSum.subtract(sum);
		System.out.println(missingNum);

		sc.close();
	}
}
