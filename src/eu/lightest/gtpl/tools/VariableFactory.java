package eu.lightest.gtpl.tools;

import java.util.HashSet;
import java.util.List;


public class VariableFactory {
  HashSet<String> used = new HashSet<>();

  private String createVariable(String suggestion, Integer i) {
    if (i == null) {
      if (used.contains(suggestion)) {
        return createVariable(suggestion, 2);
      } else {
        used.add(suggestion);
        return suggestion;
      }
    } else {
      if (used.contains(suggestion + i)) {
        return createVariable(suggestion, i + 1);
      } else {
        used.add(suggestion + i);
        return suggestion + i;
      }
    }
  }

  public String createVariable(String suggestion){
    return createVariable(suggestion,null);
  }

  public void registerVariables(List<String> vars){
    for (String var : vars){
      registerVariable(var);
    }
  }

  public void registerVariable(String var){
    used.add(var);
  }
}
