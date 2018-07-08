package io.github.henryhuang.pc.config;

import lombok.Getter;

/**
 * @author Henry Huang
 * @create 2018-07-06 23:01:45
 */
@Getter
public class CommonsIO implements IConfig {

  private String srcGroupId = "commons-io";
  private String srcArtifactId = "commons-io";
  private String srcPackaging = "jar";
  private String srcName = "commons-io";

  private String destGroupId = "commons-io";
  private String destArtifactId = "commons-io";
  private String destPackaging = "jar";
  private String destName = "commons-io";

  private String relativePath = "commons-io";

}
