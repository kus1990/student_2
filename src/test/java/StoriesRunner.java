import net.serenitybdd.jbehave.SerenityStepFactory;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.guice.Injectors;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;

import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

public class StoriesRunner extends SerenityStories{
    /*public static net.thucydides.core.webdriver.Configuration getConfiguration() {
        return Injectors.getInjector().getInstance(net.thucydides.core.webdriver.Configuration.class);
    }*/

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(URLDecoder.decode(CodeLocations.codeLocationFromClass(this.getClass()).getFile()), Arrays.asList("**/stories/*.story"), null);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return SerenityStepFactory.withStepsFromPackage("steps", configuration()).andClassLoader(getClassLoader());
    }
}
