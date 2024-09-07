import java.io.*;
import java.util.*;

// Problem Statement - https://cses.fi/problemset/task/1069

public class Repetitions {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int maxRepeatedCount = 0, currentCount = 0;
		char currentChar = 'A';
		char[] allChars = sc.next().toCharArray();

		for (int i = 0; i < allChars.length; i++) {
			if (allChars[i] == currentChar) {
				currentCount++;
				maxRepeatedCount = Math.max(maxRepeatedCount, currentCount);
			} else {
				currentChar = allChars[i];
				currentCount = 1;
			}
		}

		System.out.println(maxRepeatedCount);

		sc.close();
	}
}
