package com.viliussutkus89.relinkersharedstl;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LibraryLoadTest {
    @Test
    public void load() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        MainActivity.loadLibrary(appContext);
    }
}
