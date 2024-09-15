package problem.solving.patterns;

import java.util.ArrayList;
import java.util.HashMap;

public class SlidingWindow {

	public static int maxSumSubarray(int[] arr, int k) {
		int windowSum = 0;
		int n = arr.length;
		for (int i = 0; i < k; i++) {
			windowSum += arr[i];
		}
		int maxSum = windowSum;
		for (int i = k; i < n; i++) {
			windowSum += arr[i] - arr[i - k];
			maxSum = Math.max(maxSum, windowSum);
		}

		return maxSum;
	}

//	public static ArrayList<Integer> maxValueOfAllSubarrays(int[] arr , int k ){
//		
//		int n = arr.length;
//		ArrayList<Integer> output = new ArrayList<>();
//		for(int i=k;i<n;i+=k){
//			int windowSum = 0;
//			System.arraycopy(arr, i, output, k, n);
//	
//			output.add(windowSum);
//		}
//		return output;
//	}
//	
	public static int max(int[] arr) {
		int m = 0;
		m = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (m < arr[i])
				m = arr[i];
		}
		return m;
	}

	public static int LongestSubstringWithoutRepeatingCharacters(String s) {
		HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
		int start = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			Character currentChar = s.charAt(i);

			if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
				start = charIndexMap.get(currentChar) + 1;
			}

			charIndexMap.put(currentChar, i);

			max = Math.max(max, i - start + 1);
			System.out.println("i=  " + i);
			System.out.println("charIndexMap length: " + charIndexMap.keySet());

		}

		return max;
	}

	public static int LongestSubstringLengthWithKDistinctChar(String s, int k) {

		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
		int maxLength = 0;
		int start = 0;

		for (int end = 0; end < s.length(); end++) {
			Character currentChar = s.charAt(end);

			charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

			while (charCount.size() > k) {
				Character leftChar = s.charAt(start);
				charCount.put(leftChar, charCount.get(leftChar) - 1);
				if (charCount.get(leftChar) == 0) {
					charCount.remove(leftChar);
				}
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
	}

	public static int characterReplacement(String s, int k) {
		int maxLength = 0;
		int maxFreq = 0;
		int start = 0;
		int[] charFreq = new int[26];
		for (int end = 0; end < s.length(); end++) {

			char currentChar = s.charAt(end);
			charFreq[currentChar - 'A']++;
			maxFreq = Math.max(maxFreq, charFreq[currentChar - 'A']);

			while ((end - start + 1) - maxFreq > k) {
				charFreq[s.charAt(start) - 'A']--;
				start++;
			}

			maxLength = Math.max(maxLength, (end - start + 1));
		}

		return maxLength;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSumSubarray(arr, k)); // Output: 9
		int[] arr2 = { 1, 3, 9, -1, -3, 5, 3, 6, 7 };
//	        System.out.println("maxValueOfAllSubarrays "+ maxValueOfAllSubarrays(arr2, k));  // Output: [3, 3, 5, 5, 6, 7]
//	        System.out.println("max "+ max(arr2));  // Output: [3, 3, 5, 5, 6, 7]

		String s = "pwwkew";
		System.out.println("Longest Substring Without Repeating Characters of" + s + " is: "
				+ LongestSubstringWithoutRepeatingCharacters(s));

		String s2 = "aaahhibc";
		System.out.println("Longest Substring Length With K Distinct Char" + s + " is: "
				+ LongestSubstringLengthWithKDistinctChar(s2, 2));

		String s3 = "AABABBA";
		System.out.println("characterReplacement" + s + " is: " + characterReplacement(s3, 1));

	}
}
