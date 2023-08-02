public class StepTracker {
    private int minSteps;
    private int totalSteps;
    private int numDays;

    public StepTracker(int minSteps) {
        this.minSteps = minSteps;
        this.totalSteps = 0;
        this.numDays = 0;
    }

    public void addDailySteps(int steps) {
        totalSteps += steps;
        numDays++;
    }

    public int activeDays() {
        int activeDays = 0;
        if (totalSteps >= minSteps) {
            activeDays = numDays;
        }
        return activeDays;
    }

    public double averageSteps() {
        if (numDays == 0) {
            return 0.0;
        }
        return (double) totalSteps / numDays;
    }
}
