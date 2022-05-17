package topology;

import java.util.HashMap;
import java.util.Map;

public final  class TopologyMemory {
    /**
     * instance singelton instance.
     */
    private static TopologyMemory instance;
        /**
        * arraylist of the exising topologies in memory.
        */
    private Map<String, Topology> storedTopologies;

    private TopologyMemory() {
        this.storedTopologies = new HashMap<>();
    }

    /**
     *
     * @return instance of the memory.
     */
    public static TopologyMemory getInstance() {
        if (instance == null) {
            instance = new TopologyMemory();
        }

        return instance;
    }

    /**
     *
     * @param topology
     */
    public void addToMemeory(final Topology topology) {
         storedTopologies.put(topology.getId(), topology);

    }
    /**
     *
     * @return arrayList of topologies which are in the current memory
     */
    public Map<String, Topology> getMemoryContent() {
        return storedTopologies;
    }

    /**
     * @param topologyId the id of the wanted topology
     * @return null if the topology not found else returns the  topology.
     */
    public Topology searchMemory(final String topologyId) {

        if (storedTopologies.containsKey(topologyId)) {
            return storedTopologies.get(topologyId);
        } else {
            return null;
        }
    }

    /**
     *
     * @param topologyId the id of the to be deleted topology
     * @return true if delete  is successful or false in case of any problem.
     */
    public boolean deleteTopology(final String topologyId) {
        boolean found = storedTopologies.containsKey(topologyId);
        if (!found) {
            return false;
        } else {
             storedTopologies.remove(topologyId);
        }
        return true;
    }


}
