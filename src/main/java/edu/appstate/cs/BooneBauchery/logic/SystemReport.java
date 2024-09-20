package edu.appstate.cs.BooneBauchery.logic;
//import java.lang.Runtime;

public class SystemReport {

  Runtime gfg = Runtime.getRuntime();
  public long freeMem = gfg.freeMemory();
  public long totalMem = gfg.totalMemory();
  public long maxMem = gfg.maxMemory();
  public long byte2Mb = 1048576;
  public long byte2Gb = 1073741824;

  public String getReport() {
    String str = "";
    str += (freeMem / byte2Gb) + "Gb out of " + (totalMem / byte2Gb) + "Gb\n";

    return str;
  }
}
