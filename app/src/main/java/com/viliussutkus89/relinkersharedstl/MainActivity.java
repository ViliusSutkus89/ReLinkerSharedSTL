package com.viliussutkus89.relinkersharedstl;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.getkeepsafe.relinker.ReLinker;
import com.viliussutkus89.relinkersharedstl.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("c++_shared");
//        System.loadLibrary("native-lib");
//    }

    private ActivityMainBinding binding;

    private ReLinker.Logger logcatLogger = new ReLinker.Logger() {
        @Override
        public void log(String message) {
            Log.d("---ReLinker", message);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        System.loadLibrary("c++_shared");
        ReLinker.recursively().log(logcatLogger).loadLibrary(getApplicationContext(), "native-lib");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}