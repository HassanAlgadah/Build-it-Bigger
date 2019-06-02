
package builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
@LargeTest

public class EndpointsAsyncTaskTestUnit extends AndroidTestCase{
   @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);



   @Test
   public void testJokeIsNotEmpty() throws Exception {
       EndpointsAsyncTaskTest aTest =  new EndpointsAsyncTaskTest();
       aTest.execute(InstrumentationRegistry.getContext());
       String joke = aTest.get(5, TimeUnit.SECONDS);
       Assert.assertTrue(!joke.equals(""));
   }

    @Test
    public void testVerifyResponse() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.joke)).check(matches(isDisplayed()));
    }

}

