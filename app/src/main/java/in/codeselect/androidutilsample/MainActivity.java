package in.codeselect.androidutilsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import in.codeselect.andoidutils.ResUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageDrawable(ResUtil.getDrawable(R.drawable.ic_launcher));
    }
}
