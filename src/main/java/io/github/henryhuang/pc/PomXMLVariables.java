package io.github.henryhuang.pc;

import io.github.henryhuang.pc.config.IDestinationVariables;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Henry Huang
 * @create 2018-07-08 22:54:09
 */
@Getter
@AllArgsConstructor
public class PomXMLVariables {

  private IDestinationVariables destinationVariables;
  private String version;

  public String getGroupId() {
    return destinationVariables.getDestGroupId();
  }

  public String getArtifactId() {
    return destinationVariables.getDestArtifactId();
  }

  public String getPackaging() {
    return destinationVariables.getDestPackaging();
  }

  public String getName() {
    return destinationVariables.getDestName();
  }

}
