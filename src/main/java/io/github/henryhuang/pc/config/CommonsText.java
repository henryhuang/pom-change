package io.github.henryhuang.pc.config;

import lombok.Getter;

/**
 * @author Henry Huang
 * @create 2018-07-06 23:01:45
 */
@Getter
public class CommonsText implements IConfig {

  private String srcGroupId = "org.apache.commons";
  private String srcArtifactId = "commons-text";
  private String srcPackaging = "jar";
  private String srcName = "commons-text";

  private String destGroupId = "org.apache.commons";
  private String destArtifactId = "commons-text";
  private String destPackaging = "jar";
  private String destName = "commons-text";

  private String relativePath = "commons-text";

}
