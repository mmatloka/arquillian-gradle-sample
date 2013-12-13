package org.jboss.shrinkwrap.resolver.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.gradle.archive.importer.embedded.DistributionConfigurationStage;
import org.jboss.shrinkwrap.api.gradle.archive.importer.embedded.EmbeddedGradleImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class FullGreeterTest {

    @Deployment(testable = false)
    public static JavaArchive createDeployment() {
        System.out.println("Before deploy");
        final JavaArchive as = ShrinkWrap.create(EmbeddedGradleImporter.class).forProjectDirectory("")
                .importBuildOutput().as(JavaArchive.class);
        System.out.println("After test");
        return as;
    }

    @Inject
    Greeter greeter;

    @Test
    public void should_create_greeting() {
        System.out.println("Before test");
        Assert.assertEquals("Hello, Earthling!",
                greeter.createGreeting("Earthling"));
        greeter.greet(System.out, "Earthling");
    }

//    public static void main(String[] args) {
//        ShrinkWrap.create(EmbeddedGradleImporter.class).forProjectDirectory("")
//                .importBuildOutput().as(JavaArchive.class);
//    }
}
