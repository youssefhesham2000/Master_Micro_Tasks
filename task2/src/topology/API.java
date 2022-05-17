package topology;

import java.util.ArrayList;
import java.util.Map;

public class API {
    /**
     * an instance of the TopologyAPI.Result object.
     */
    private Result resultBuilder = new Result();
    /**
     * an instance of the fileManager object.
     */
    private FileManager fileManager = new FileManager();

    /**
     *
     * @param fileName the name of the json file
     * @return process result message .
     */
    public String readJson(final String fileName) {
        //read the json and create a new topology
        Topology topology = fileManager.readJsonTopology(fileName);
        //in case of read or parse error in the read operation
        String statusCode = fileManager.getStatusCode();
        String processResult = resultBuilder.getResult(statusCode);
        if (topology == null) {
            return processResult;
        } else {
            //add the new topology to the singelton memeory instance
            TopologyMemory.getInstance().addToMemeory(topology);
            return processResult;
        }
    }

    /**
     *
     * @param topologyId the id of the topology to be written
     * @return process msg to indicate the result.
     */
    public String writeJson(final String topologyId) {
        boolean result = fileManager.writeTopologyFromMemory(topologyId);
        String statusCode = fileManager.getStatusCode();
        String processResult = resultBuilder.getResult(statusCode);
        return processResult;
    }

    /**
     *
     * @return a Map of key:TopologyId value:the topology object.
     */
    public Map<String, Topology> getTopologyMemeory() {
        return TopologyMemory.getInstance().getMemoryContent();

    }

    /**
     *
     * @param topologyId the id of the  topology to be deleted
     * @return process result msg.
     */
    public String deleteTopology(final String topologyId) {

        boolean deleteResult = TopologyMemory.
                getInstance().
                deleteTopology(topologyId);
        if (deleteResult) {
            fileManager.setStatusCode("one");
        } else {
            fileManager.setStatusCode("five");
        }
        return resultBuilder.getResult(fileManager.getStatusCode());

    }

    /**
     *
     * @param topologyId the id of the topology to get it's devices
     * @return list of the names of the devices.
     */
    public ArrayList<String> getTopologyDevices(final String topologyId) {
        TopologyMemory memory = TopologyMemory.getInstance();
        Topology topology = memory.searchMemory(topologyId);
        if (topology == null) {
            return new ArrayList<String>();
        }

        return topology.getDevices();
    }

    /**
     *
     * @param t the id of the wanted topology to be searched
     * @param nId the id of the connected node.
     * @return an ArrayList of String of the names of the connected devices.
     */
    public ArrayList<String> getDeviceByNode(final String t, final String nId) {
        TopologyMemory memory = TopologyMemory.getInstance();
        Topology topology = memory.searchMemory(t);
        if (topology == null) {
            return new ArrayList<String>();
        }
        return topology.getDevicesWithNetList(nId);
    }
}
