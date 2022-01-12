package com.github.plantuml.maven;

/*-
 * #%L
 * Maven PlantUML plugin
 * %%
 * Copyright (C) 2011 - 2019 Julien Eluard
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import io.takari.maven.testing.TestMavenRuntime;
import io.takari.maven.testing.TestResources;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.project.MavenProject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.takari.maven.testing.TestMavenRuntime.newParameter;
import static io.takari.maven.testing.TestResources.assertFilesPresent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@Ignore
public class PlantUMLMojoUnitTest {

    @Rule
    public final TestResources resources = new TestResources("src/test/resources/unit", "target/test-unit");

    @Rule
    public final TestMavenRuntime maven = new TestMavenRuntime();

    protected File basedir = null;

    @Before
    public void setUpTestCase() throws Exception {
        basedir = resources.getBasedir("project-to-test");
        // exceptionRule.expect(RuntimeException.class);
    }


    @Test
    public void basicTest() throws Exception {
        maven.executeMojo(basedir, "generate", newParameter("name", "value"));
        assertFilesPresent(basedir, "target/plantuml/Donors.png");
        final File file = new File(basedir, "target/plantuml/Donors.png");
        final BufferedImage image = ImageIO.read(file);
        assertEquals(BufferedImage.TYPE_3BYTE_BGR, image.getType());
    }

    @Test
    public void checkParameter() throws Exception {
        final MavenProject mavenProject = maven.readMavenProject(basedir);
        final MavenSession mavenSession = maven.newMavenSession(mavenProject);
        final MojoExecution mojoExecution = maven.newMojoExecution("generate");
        final PlantUMLMojo mojo = (PlantUMLMojo) maven.lookupConfiguredMojo(mavenSession, mojoExecution);

        /* check default values */
        // check outputDirectory
        assertNotNull(mojo.outputDirectory);
        final Path plantumlTargetDir = Paths.get(basedir.getAbsolutePath().toString(), "target/plantuml");
        assertEquals(plantumlTargetDir.toAbsolutePath().toFile(), mojo.outputDirectory);
        // outputInSourceDirectory
        assertFalse(mojo.outputInSourceDirectory);
        // verbose
        assertFalse(mojo.verbose);

        /* check required parameters */
        assertNotNull(mojo.sourceFiles);
        assertEquals(basedir.getAbsolutePath().toString(), mojo.sourceFiles.getDirectory().toString());

        /* check others parameters */
        assertNotNull(mojo.truncatePattern);
        assertEquals("src/main/*", mojo.truncatePattern);
    }


}
