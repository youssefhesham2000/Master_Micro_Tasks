package test;

import org.junit.Test;
import topology.API;
import topology.FileManager;
import topology.Topology;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class APITestMemory {
    /**
     * test case for unsuccessful Delete topology from memory.
     */
    @Test
    public void testUnsuccessfulDeleteTopology() {
        API api = new API();
        String id = "top1";
        Map<String, Topology> returned = api.getTopologyMemeory();
        System.out.println(returned.size());
        assertEquals("removing failed",
                api.deleteTopology(id));
    }
    /**
     * test case for empty memory.
     */
    @Test
    public void testEmptyGetTopologyFromMemory() {
        API api = new API();
        FileManager fileManager = new FileManager();
        Map<String, Topology> expected = new HashMap<>();
        Topology expectedTopology = fileManager.readJsonTopology(
                "./topology.json");
        Map<String, Topology> returned = api.getTopologyMemeory();
        assertEquals(0, returned.size());

    }
    /**
     * test case for Delete topology from memory.
     */
    @Test
    public void testDeleteTopology() {
        API api = new API();
        String fileName = "./topology.json";
        api.readJson(fileName);
        String id = "top1";
        assertEquals("removed successfully",
                api.deleteTopology(id));
    }
}
