package io.github.henryhuang.pc;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Henry Huang
 * @create 2018-07-08 23:19:37
 */
public class RenderPomXML {

  public void render(String templatePath, String outputPath, PomXMLVariables variables) throws IOException {
    Writer writer = new FileWriter(outputPath);
    MustacheFactory factory = new DefaultMustacheFactory();
    Mustache mustache = factory.compile(new FileReader(templatePath), "pom.xml");
    mustache.execute(writer, variables);
    writer.flush();
  }

}
