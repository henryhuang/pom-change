package io.github.henryhuang.pc;

import io.github.henryhuang.pc.config.CommonsIO;
import io.github.henryhuang.pc.config.CommonsLang3;
import io.github.henryhuang.pc.config.CommonsText;
import io.github.henryhuang.pc.config.IConfig;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

/**
 * @author Henry Huang
 * @create 2018-07-06 22:07:59
 */
public class Main {

  private static String BASE_URL = "http://central.maven.org/maven2/%s/%s/%s/%s-%s.%s";
  private static String POM_OUTPUT_ROOT = "/Users/henry/dev/workspace/idea/pom-change/test/%s/pom.xml";
  private static String PACKAGE_OUTPUT_ROOT = "/Users/henry/dev/workspace/idea/pom-change/test/%s/%s.%s";
  private static String TEMPLATE_PATH = "/Users/henry/dev/workspace/idea/pom-change/src/main/resources/pom.xml.mustache";

  public static void main(String[] args) throws IOException {

    renderAndDownload(new CommonsLang3(), "3.7", "3.8");
    renderAndDownload(new CommonsIO(), "2.6", "2.7");
    renderAndDownload(new CommonsText(), "1.4", "1.5");

  }

  private static void renderAndDownload(IConfig config, String srcVersion, String destVersion) throws IOException {
    render(config, destVersion);
    download(config, srcVersion, destVersion);
  }

  private static void render(IConfig config, String version) throws IOException {

    PomXMLVariables pomXMLVariables = new PomXMLVariables(config, version);

    String outputPath = String.format(POM_OUTPUT_ROOT, config.getRelativePath());

    File outputFile = new File(outputPath);
    if (!outputFile.getParentFile().exists()) {
      outputFile.getParentFile().mkdirs();
    }

    new RenderPomXML().render(TEMPLATE_PATH, outputPath, pomXMLVariables);

  }

  private static void download(IConfig config, String srcVersion, String destVersion) throws IOException {

    String groupIdPath = transferGroupIdToPath(config.getSrcGroupId());

    String url = String
        .format(BASE_URL, groupIdPath, config.getSrcArtifactId(),
            srcVersion,
            config.getSrcArtifactId(),
            srcVersion, config.getSrcPackaging());

    String outputPath = String
        .format(PACKAGE_OUTPUT_ROOT, config.getRelativePath(), config.getDestName(),
            config.getDestPackaging());

    System.out.println("Downloading: " + url);
    FileUtils.copyURLToFile(new URL(url), new File(outputPath), 10000, 10000);

  }

  private static String transferGroupIdToPath(String groupId) {
    return groupId.replaceAll("\\.", "/");
  }

}
