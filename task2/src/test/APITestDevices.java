package test;

import org.junit.Test;
import topology.API;

import java.util.ArrayList;
import java.util.Collections;

import static junit.framework.Assert.assertEquals;

public class APITestDevices {
    /**
     * test case for get topology devices from memory with correct id.
     */
    @Test
    public void testGetTopologyDevices() {
        API api = new API();
        String fileName = "./topology.json";
        api.readJson(fileName);
        String id = "top1";
        ArrayList<String>  expected = new ArrayList<>();
        expected.add("m(l)");
        expected.add("resistance");
        ArrayList<String> result = api.getTopologyDevices(id);
        assertEquals(result.size(), expected.size());
        Collections.sort(expected);
        Collections.sort(result);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }
    /**
     * test case for get topology devices from memory with wrong id.
     */
    @Test
    public void testGetTopologyDevicesWithWrongId() {
        API api = new API();
        String fileName = "./topology.json";
        api.readJson(fileName);
        String id = "top";
        ArrayList<String> result = api.getTopologyDevices(id);
        assertEquals(result.size(), 0);
        Collections.sort(result);

    }
    /**
     * test case for Delete topology devices that
     * is connected to certain node from memory.
     */
    @Test
    public void testGetTopologyDevicesWithNodeId() {
        API api = new API();
        String fileName = "./topology.json";
        api.readJson(fileName);
        String id = "top1";
        ArrayList<String>  expected = new ArrayList<>();
        expected.add("m(l)");
        expected.add("resistance");
        ArrayList<String> result = api.getDeviceByNode(id, "n1");
        assertEquals(result.size(), expected.size());
        Collections.sort(expected);
        Collections.sort(result);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }
    /**
     * test case for Delete topology devices that
     * is connected to certain wrong node id from memory.
     */
    @Test
    public void testGetTopologyDevicesWithWrongNodeId() {
        API api = new API();
        String fileName = "./topology.json";
        api.readJson(fileName);
        String id = "top1";
        ArrayList<String> result = api.getDeviceByNode(id, "n");
        assertEquals(result.size(), 0);
        Collections.sort(result);

    }
    /**
     * test case for Delete topology devices that
     * is connected to certain wrong node id from memory.
     */
    @Test
    public void testGetTopologyDevicesWithWrongTopologyId() {
        API api = new API();
        String fileName = "./topology.json";
        api.readJson(fileName);
        String id = "top";
        ArrayList<String> result = api.getDeviceByNode(id, "n1");
        assertEquals(result.size(), 0);
        Collections.sort(result);

    }
}
