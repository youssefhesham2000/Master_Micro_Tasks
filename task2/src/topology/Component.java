package topology;

import org.json.simple.JSONObject;

public class Component {
    /**
     * the type of the component.
     */
    private String type;
    /**
     * the id of the component.
     */
    private String id;
    /**
     * the name of the component.
     */
    private String componentName;
    /**
     * the values of the component.
     */
    private ComponentValues componentVal;
    /**
     * the netList of the component.
     */
    private NetList componentNetList;

    /**
     *
     * @param cType
     * @param cId
     * @param name
     * @param vals
     * @param netList
     */
    public Component(final String cType,
                     final String cId,
                     final String name,
                     final ComponentValues vals,
                     final NetList netList) {
        this.type = cType;
        this.id = cId;
        this.componentName = name;
        this.componentVal = vals;
        this.componentNetList = netList;
    }

    /**
     *
     * @return String type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param newType
     */
    public void setType(final String newType) {
        this.type = newType;
    }

    /**
     *
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param newId
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     *
     * @return String
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     *
     * @param name the name of the component.
     */
    public void setComponentName(final String name) {
        this.componentName = name;
    }

    /**
     *
     * @return TopologyAPI.ComponentValues
     */
    public ComponentValues getComponentVal() {
        return componentVal;
    }

    /**
     *
     * @param vals the component values.
     */
    public void setComponentVal(final ComponentValues vals) {
        this.componentVal = vals;
    }

    /**
     *
     * @return TopologyAPI.NetList
     */
    public NetList getComponentNetList() {
        return componentNetList;
    }

    /**
     *
     * @param netList the new netList.
     */
    public void setComponentNetList(final NetList netList) {
        this.componentNetList = netList;
    }

    /**
     *
     * @return JSONObject instance of the component.
     */
    public JSONObject toJson() {
        JSONObject tempComponent = new JSONObject();
        tempComponent.put("type", type);
        tempComponent.put("id", id);
        tempComponent.put("type", type);
        tempComponent.put(componentName, componentVal.toJson());
        tempComponent.put("netlist", componentNetList.toJsonArray());
        return tempComponent;

    }
}
