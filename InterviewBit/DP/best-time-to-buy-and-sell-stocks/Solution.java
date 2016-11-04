public class Solution {
	public int maxProfit(final List<Integer> a) {

		if (a == null || a.size() == 0)
			return (0);
		int min = a.get(0);
		int dp[] = new int[a.size()];
		dp[0] = 0;
		for (int i = 1; i < a.size(); ++i)
		{
			dp[i] = Math.max(dp[i - 1], a.get(i) - min);
			min = Math.min(min, a.get(i));
		}
		return (dp[a.size() - 1]);
	}
}
