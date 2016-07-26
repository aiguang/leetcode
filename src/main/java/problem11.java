/**
 Given n non-negative integers a1, a2, ..., an,
 where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
public class problem11 {
  public int maxArea(int[] height) {
    int result = 0;
    for (int a = 0, b = height.length - 1; a < b;) {
      result = Math.max(result, Math.min(height[a], height[b]) * (b - a));
      if (height[a] < height[b]) a++; else b--;
    }
    return result;
  }
}
