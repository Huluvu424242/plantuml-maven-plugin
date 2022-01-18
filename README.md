[![Apache 2.0 License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.funthomas424242/plantuml-maven-plugin/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.github.funthomas424242/plantuml-maven-plugin)
[![Build Status](https://travis-ci.org/Huluvu424242/plantuml-maven-plugin.svg?branch=master)](https://travis-ci.org/Huluvu424242/plantuml-maven-plugin)
![Github CI Build](https://github.com/Huluvu424242/plantuml-maven-plugin/workflows/Github%20CI%20Build/badge.svg)
[![Codacy code quality](https://api.codacy.com/project/badge/Grade/88bf76546176437ea389629a2087d1b5)](https://www.codacy.com/app/Huluvu424242/plantuml-maven-plugin?utm_source=github.com&utm_medium=referral&utm_content=Huluvu424242/plantuml-maven-plugin&utm_campaign=Badge_Grade)
[![Scrum Board](http://images.webestools.com/buttons.php?frm=2&btn_type=11&txt=Scrum%20Board&scaledwidth="15%")](https://github.com/Huluvu424242/plantuml-maven-plugin/projects/1)

A [maven](http://maven.apache.org/) plugin to generate UML diagrams using [PlantUML](http://plantuml.sourceforge.net/) syntax.
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.funthomas424242/plantuml-maven-plugin/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.github.funthomas424242/plantuml-maven-plugin)

This project is a fork of https://github.com/jeluard/maven-plantuml-plugin.
Many thanks to Julien Eluard, the founder of the original project. 
Big thanks also to all the other contributors in the source control system tree.

# Important note

If you want to use versions of PlantUML greater than 8059 you have to use version 1.5.0 and following of this plugin.

# Usage

To generate images from PlantUML description add following dependency to your pom.xml:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>com.github.funthomas424242</groupId>
      <artifactId>plantuml-maven-plugin</artifactId>
      <version>1.5.2</version>
      <configuration>
        <truncatePattern>src/main/*</truncatePattern>
        <sourceFiles>
          <directory>${basedir}</directory>
          <includes>
            <include>src/main/plantuml/**/*.txt</include>
          </includes>
        </sourceFiles>
      </configuration>
      <dependencies>
        <dependency>
          <groupId>net.sourceforge.plantuml</groupId>
          <artifactId>plantuml</artifactId>
          <version>1.2020.19</version>
          <scope>runtime</scope>
        </dependency>
      </dependencies>
    </plugin>
  </plugins>
</build>
```

Note that you must explicitely define the PlantUML version you want to use.

Then execute command:

```
mvn clean com.github.funthomas424242:plantuml-maven-plugin:generate
```

# Extra configuration options

`outputDirectory` Directory where generated images are generated. Defaults to `${basedir}/target/plantuml`

`outputInSourceDirectory` Whether or not to generate images in same directory as the source file. Defaults to `false`.

`format` Output format. Defaults to `png`.

`verbose` Wether or not to output details during generation. Defaults to `false`.


Released under [Apache 2 license](http://www.apache.org/licenses/LICENSE-2.0.html).

# Roadmap 

At now there is an [asciidoctor-maven-plugin](https://github.com/asciidoctor/asciidoctor)
wich comes with an asciidoctor-diagram part to generate documentation + diagrams from text files. 
This takes input from asciidoc files *.adoc and plantuml files for generation with 
support many output formats: html, pdf, ... 
An example for this you can find out under 
[asciidoctor-diagram-example](https://github.com/asciidoctor/asciidoctor-maven-examples/tree/main/asciidoctor-diagram-example)
  
Since there is asciidoctor with out of the box plantuml support, this plantuml-maven-plugin is obsolete and only 
useful for special cases. I leave the plugin project public, so if you have special cases and you need extra plugin support 
please send an issue for missing feature or better send an pull request to add the missing feature.

If no special cases will be detect for an long time - i will be change the project status to pulic archive.

\\// Thank you for you support and live long and prosper. :vulcan_salute: