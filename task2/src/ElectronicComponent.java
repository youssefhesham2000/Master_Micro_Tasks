public class ElectronicComponent {
    private double defaultVal;
    private double minVal;
    private double maxVal;

    /**
     *
     * @param defaultVal
     * @param minVal
     * @param maxVal
     */
    public ElectronicComponent(double defaultVal, double minVal, double maxVal) {
        this.defaultVal = defaultVal;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    /**
     *
     * @return double default_val
     */
    public double getDefaultVal() {
        return defaultVal;
    }

    /**
     *
     * @param defaultVal
     */
    public void setDefaultVal(double defaultVal) {
        this.defaultVal = defaultVal;
    }

    /**
     *
     * @return double minVal
     */
    public double getMinVal() {
        return minVal;
    }

    /**
     *
     * @param minVal
     */
    public void setMinVal(double minVal) {
        this.minVal = minVal;
    }

    /**
     *
     * @return double maxVal
     */
    public double getMaxVal() {
        return maxVal;
    }

    /**
     *
     * @param maxVal
     */
    public void setMaxVal(double maxVal) {
        this.maxVal = maxVal;
    }
}
