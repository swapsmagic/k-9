package com.fsck.k9.helper;

import android.app.Activity;
import android.widget.EditText;

import com.fsck.k9.R;
import com.fsck.k9.activity.MessageCompose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 21)
public class UtilityTest {

    @Test
    public void testArrayContains_found() throws Exception {
        String[] strArray = {"one", "two", "three"};
        String searchedStr = "two";

        boolean result = Utility.arrayContains(strArray, searchedStr);

        assertTrue(result);
    }

    @Test
    public void testArrayContains_notFound() throws Exception {
        String[] strArray = {"one", "two", "three"};
        String searchedStr = "four";

        boolean result = Utility.arrayContains(strArray, searchedStr);

        assertFalse(result);
    }

    @Test
    public void testArrayContainsAny_found() throws Exception {
        String[] strArray = {"one", "two", "three"};
        String searchedStr = "two";

        boolean result = Utility.arrayContainsAny(strArray, searchedStr);

        assertTrue(result);
    }

    @Test
    public void testArrayContainsAny_notFound() throws Exception {
        String[] strArray = {"one", "two", "three"};
        String searchedStr = "four";

        boolean result = Utility.arrayContainsAny(strArray, searchedStr);

        assertFalse(result);
    }

    @Test
    public void testCombine_array() throws Exception {
        String[] strArray = {"one", "two", "three"};
        char seperator = ',';

        String actual = Utility.combine(strArray, seperator);

        String expected = "one,two,three";
        assertEquals(expected, actual);
    }

    @Test
    public void testCombine_iterable() throws Exception {
        List<String> strList = new ArrayList<String>();
        strList.add("one");
        strList.add("two");
        strList.add("three");
        char seperator = ',';

        String actual = Utility.combine(strList, seperator);

        String expected = "one,two,three";
        assertEquals(expected, actual);
    }

    @Test
    public void testRequiredFieldValid() throws Exception {
        Activity activity = Robolectric.buildActivity(MessageCompose.class).get();
        assertNotNull(activity);

        EditText editText = (EditText) activity.findViewById(R.id.subject);

        boolean result = Utility.requiredFieldValid(editText);

        assertTrue(result);
    }
}
