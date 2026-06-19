class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int midSpeed = low + (high - low) / 2;
            int totalHoursSpent = calculateHours(piles, midSpeed);

            if (totalHoursSpent <= h) {
                high = midSpeed;
            } else {
                low = midSpeed + 1;
            }
        }

        return low;
    }

    private int calculateHours(int[] piles, int speed) {
        int totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed;
        }

        return totalHours;
    }
}
