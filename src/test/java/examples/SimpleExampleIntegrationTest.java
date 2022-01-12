package examples;

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
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static io.takari.maven.testing.TestMavenRuntime.newParameter;
import static io.takari.maven.testing.TestResources.assertFilesPresent;

// http://takari.io/book/70-testing.html
@Ignore
public class SimpleExampleIntegrationTest {

    @Rule
    public final TestResources resources = new TestResources("src/examples", "target/test-examples");

    @Rule
    public final TestMavenRuntime maven = new TestMavenRuntime();


    @Test
    public void generatePngExample() throws Exception {
        final File basedir = resources.getBasedir("example");
        maven.executeMojo(basedir, "generate", newParameter("unused", "unused"));
        assertFilesPresent(basedir, "target/plantuml/Statechart.png");
        assertFilesPresent(basedir, "target/plantuml/QueueStatechart.png");
    }
}


