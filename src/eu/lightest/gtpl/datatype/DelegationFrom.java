package eu.lightest.gtpl.datatype;

import java.io.Serializable;
import java.util.ArrayList;

public class DelegationFrom extends Valuetype implements Serializable {
  @Override
  public ArrayList<String> getVars() {
    return new ArrayList<>();
  }

  @Override
  public String toDebugString() {
    return "DelegationFrom";
  }
}
