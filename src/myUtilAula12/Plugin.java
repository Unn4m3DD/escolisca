package myUtilAula12;

import java.io.File;
import java.util.ArrayList;

abstract class PluginManager {
    public static IPlugin load(String name) throws Exception {
        Class<?> c = Class.forName(name);
        return (IPlugin) c.newInstance();
    }
}

public class Plugin {
    public static void main(String[] args) throws Exception {
        File proxyList = new File("plugins");
        ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
        for (String f : proxyList.list()) {
            try {
                plgs.add(PluginManager.load("myUtilAula12." + f.substring(0, f.lastIndexOf('.'))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (IPlugin plg : plgs) {
            plg.fazQualQuerCoisa();
        }
    }
}