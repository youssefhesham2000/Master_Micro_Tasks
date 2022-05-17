package topology;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Set;

public class Topology  {
    /**
     *the id of the topology.
     *
     */
    private String id;
    /**
     * arraylist of the electric components in the topology.
     */
    private ArrayList<Component> components;

    /**
     *
     * @param topologyId
     * @param topologyComponents
     */
    public Topology(final String topologyId,
                    final ArrayList<Component> topologyComponents) {
        this.id = topologyId;
        this.components = topologyComponents;
    }

    /**
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param topologyId
     */
    public void setId(final String topologyId) {
        this.id = topologyId;
    }

    /**
     *
     * @return ArrayList<TopologyAPI.Component>
     */
    public ArrayList<Component> getComponents() {
        return components;
    }

    /**
     *
     * @param tComponent
     */
    public void setComponents(final ArrayList<Component> tComponent) {
        this.components = tComponent;
    }

    /**
     *
     * @return JSONObject instance of the topology.
     */
    public JSONObject toJson() {
        JSONObject tempTopology = new JSONObject();
        tempTopology.put("id", id);
        JSONArray list = new JSONArray();
        for (int i = 0; i < components.size(); i++) {
            JSONObject tempComponent = components.get(i).toJson();
            list.add(tempComponent);
        }
        tempTopology.put("components", list);
        return tempTopology;
    }
    /**
     *
     * @return an ArrayList contains the names of the existing devices.
     */
    public ArrayList<String> getDevices() {
        ArrayList<String> devicseName = new ArrayList<>();
        for (int i = 0; i < components.size(); i++) {
            String deviceName = components.get(i).getComponentName();
            devicseName.add(deviceName);
        }
        return devicseName;
    }

    /**
     *
     * @param netId the id of the node;
     * @return an ArrayList of Strings of the connected devices names.
     */
    public ArrayList<String> getDevicesWithNetList(final String netId) {
        ArrayList<String> devices = new ArrayList<>();
        for (int i = 0; i < components.size(); i++) {
            Component component = components.get(i);
            NetList netList = component.getComponentNetList();
            Set<String> netListIds = netList.getNodesIds();
            if (netListIds.contains(netId)) {
                devices.add(component.getComponentName());
            }
        }
        return devices;
    }

}
