package topology;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileManager {
    /**
     * status code of the operation.
     */
    private String statusCode = "";
    /**
     *
     * @return the status code.
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     *
     * @param newStatusCode the status code of the current operation.
     */
    public void setStatusCode(final String newStatusCode) {
        this.statusCode = newStatusCode;
    }


    /**
     *
     * @param fileName
     * @return TopologyAPI.Topology
     */
    public Topology readJsonTopology(final String fileName) {

        FileReader f;
        try {
            //read json file
             f = new FileReader(fileName);

        } catch (FileNotFoundException e) {
            setStatusCode("four");
            return null;
        }
        Object jsonContent;
        try {
            //parse the file into jsonObject
            jsonContent = new JSONParser().parse(f);
        } catch (IOException | ParseException e) {
            setStatusCode("two");
            return null;
        }
        JSONObject topologyJsonObject = (JSONObject) jsonContent;
        //extract the topology attributes
        String id = (String) topologyJsonObject.get("id");
        JSONArray components = (JSONArray) topologyJsonObject.get("components");
        setStatusCode("zero");
        return new Topology(id, extractComponents(components));
    }

    /**
     *
     * @param components json array of the components
     * @return ArrayList of Component a list of electronic components.
     */
    private ArrayList<Component> extractComponents(final JSONArray components) {
        //create the return list
        ArrayList<Component> topologyComponents = new ArrayList<>();
        //loop over the existing components
        int size = components.size();
        for (int i = 0; i < size; i++) {
            JSONObject component = (JSONObject) components.get(i);
            String id = (String) component.get("id");
            String type = (String) component.get("type");
            JSONObject netListJson = (JSONObject) component.get("netlist");
            Iterator itr = component.keySet().iterator();
            String componentName = "";
            while (itr.hasNext()) {
                String attribute = (String) itr.next();
                //get the device name from the json
                if (!attribute.equals("id")
                        && !attribute.equals("type")
                        && !attribute.equals("netlist")) {
                    componentName = attribute;
                    break;
                }
            }
            //extract the values from the json object
            System.out.println(componentName);
            JSONObject valuesJson = (JSONObject) component.get(componentName);
            ComponentValues values = extractComponentValues(valuesJson);
            //extract the netlist object
            NetList netList = extractNetList(netListJson);
            //create a temp electronic component
            Component electronicComponent = new Component(type,
                    id,
                    componentName,
                    values,
                    netList);
            //add the component to the list
            topologyComponents.add(electronicComponent);
        }
        return topologyComponents;
    }

    /**
     *
     * @param netList
     * @return netList of the component.
     */
    private NetList extractNetList(final JSONObject netList) {
        Iterator itr = netList.keySet().iterator();
        NetList list = new NetList();
        while (itr.hasNext()) {
            String from = (String) itr.next();
            Node tempNode = new Node(from, (String) netList.get(from));
            list.addToNetList(tempNode);
        }
        return list;
    }

    /**
     *
     * @param values
     * @return extracted TopologyAPI.ComponentValues object.
     */
    private ComponentValues extractComponentValues(final JSONObject values) {
        System.out.println(values.keySet());
        Object defaultVal =  values.get("default");
        Object minVal =  values.get("min");
        Object maxVal =  values.get("max");
        return new ComponentValues(defaultVal, minVal, maxVal);
    }

    /**
     *
     * @param topologyID the id of the wanted topology.
     * @return result message of the operation.
     */
    public boolean writeTopologyFromMemory(final String topologyID) {
        TopologyMemory memory = TopologyMemory.getInstance();
        Topology topology = memory.searchMemory(topologyID);
        if (topology == null) {
            setStatusCode("seven");
            return false;
        } else {
            boolean writeResult = writeJson(topology);
            setStatusCode("nine");
            return writeResult;
        }
    }

    /**
     *
     * @param topology the topology to be written
     * @return true if the write process processed sucessfuly else return false.
     */
    private boolean writeJson(final Topology topology) {
        //convert topology to a JSON instance
        JSONObject topologyJson = topology.toJson();
        String fileName = "topology" + topology.getId() + ".json";
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(topologyJson.toJSONString());
        } catch (IOException e) {
            setStatusCode("eight");
            return false;
        }
        setStatusCode("nine");
        return true;

    }


}
