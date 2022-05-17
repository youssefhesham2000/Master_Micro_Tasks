package topology;

import org.json.simple.JSONObject;

public class ComponentValues {
    /**
     * the default value of the component.
     */
    private Object defaultVal;
    /**
     * the min value of the component.
     */
    private Object minVal;
    /**
     * the max value of the component.
     */
    private Object maxVal;

    /**
     *
     * @param defaultValue the default value of the component.
     * @param min the min value of the component.
     * @param max the max value of the component.
     */
    public ComponentValues(final Object defaultValue,
                           final Object min,
                           final Object max) {
        this.defaultVal = defaultValue;
        this.minVal = min;
        this.maxVal = max;
    }

    /**
     *
     * @return double default_val
     */
    public Object getDefaultVal() {
        return defaultVal;
    }

    /**
     *
     * @param defaultValue the default value of the compnent.
     */
    public void setDefaultVal(final Object defaultValue) {
        this.defaultVal = defaultValue;
    }

    /**
     *
     * @return double minVal
     */
    public Object getMinVal() {
        return minVal;
    }

    /**
     *
     * @param min the new min value.
     */
    public void setMinVal(final Object min) {
        this.minVal = min;
    }

    /**
     *
     * @return double maxVal
     */
    public Object getMaxVal() {
        return maxVal;
    }

    /**
     *
     * @param max the new max value.
     */
    public void setMaxVal(final Object max) {
        this.maxVal = max;
    }

    /**
     *
     * @return JSON object instance of the values.
     */
    public JSONObject toJson() {
        JSONObject tempVals = new JSONObject();
        tempVals.put("default", defaultVal);
        tempVals.put("min", minVal);
        tempVals.put("max", maxVal);
        return tempVals;
    }
}
