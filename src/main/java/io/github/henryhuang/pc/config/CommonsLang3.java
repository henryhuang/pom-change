package io.github.henryhuang.pc.config;

import lombok.Getter;

/**
 * @author Henry Huang
 * @create 2018-07-06 23:01:45
 */
@Getter
public class CommonsLang3 implements IConfig {

  private String srcGroupId = "org.apache.commons";
  private String srcArtifactId = "commons-lang3";
  private String srcPackaging = "jar";
  private String srcName = "commons-lang3";

  private String destGroupId = "org.apache.commons";
  private String destArtifactId = "commons-lang3";
  private String destPackaging = "jar";
  private String destName = "commons-lang3";

  private String relativePath = "commons-lang3";

}
