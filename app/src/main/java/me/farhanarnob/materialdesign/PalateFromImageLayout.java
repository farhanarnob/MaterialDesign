package me.farhanarnob.materialdesign;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class PalateFromImageLayout extends AppCompatActivity {
    @BindView(R.id.image_action_fab)
    FloatingActionButton fab;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keep_palate_from_image_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_action_fab)
    void fabAction(View view) {
        Snackbar.make(findViewById(R.id.nested_layout), R.string.button, Snackbar.LENGTH_LONG).show();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ImagePickerFragment imagePickerFragment = new ImagePickerFragment();
        imagePickerFragment.show(fm, "dialog");
        ft.commit();
    }

    public void createPalette(Bundle imageBundle) {
        Log.i("LOAD", imageBundle.toString());
        ImageView imageView = (ImageView) findViewById(R.id.app_bar_image);
        Bitmap imageBitmap = (Bitmap) imageBundle.get("data");
        imageView.setImageBitmap(imageBitmap);
    }
}
