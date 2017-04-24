package me.farhanarnob.materialdesign;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class PalateFromImageActivity extends AppCompatActivity {
    @BindView(R.id.image_action_fab)
    FloatingActionButton fab;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private SwatchAdapter swatchAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keep_palate_from_image_layout);
        ButterKnife.bind(this);
        imagePicking();
    }

    @OnClick(R.id.image_action_fab)
    void fabAction(View view) {
        imagePicking();
    }

    public void imagePicking() {
        Snackbar.make(findViewById(R.id.recycler_view), R.string.need_an_image, Snackbar.LENGTH_LONG).show();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ImagePickerFragment imagePickerFragment = new ImagePickerFragment();
        imagePickerFragment.show(fm, "dialog");
        ft.commit();
    }

    // from Bundle
    public void loadForPalette(Bundle imageBundle) {
        Log.i("LOAD", imageBundle.toString());
        ImageView imageView = (ImageView) findViewById(R.id.app_bar_image);
        Bitmap imageBitmap = (Bitmap) imageBundle.get("data");
        imageView.setImageBitmap(imageBitmap);
        createPalate(imageBitmap);
    }

    // from URI
    public void loadForPalette(Uri imageUri) {
        Log.i("LOAD", imageUri.toString());
        ImageView imageView = (ImageView) findViewById(R.id.app_bar_image);
        Picasso.with(this).load(imageUri).into(imageView);
        try {
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            createPalate(bitmap);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    // create palate
    public void createPalate(Bitmap bitmap) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                HashMap<String, Integer> swatches = processPalette(palette);
                Object[] entries = swatches.entrySet().toArray();
                SwatchAdapter swatchAdapter = new SwatchAdapter(entries);
                // mLayoutManager = new LinearLayoutManager(PalateFromImageActivity.this);
                mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(swatchAdapter);


            }
        });
    }

    private HashMap<String, Integer> processPalette(Palette palette) {
        HashMap<String, Integer> map = new HashMap<>();
        if (palette.getVibrantSwatch() != null) {
            map.put("Vibrant", palette.getVibrantSwatch().getRgb());
        }
        if (palette.getDarkVibrantSwatch() != null) {
            map.put("DarkVibrant", palette.getDarkVibrantSwatch().getRgb());
        }
        if (palette.getLightVibrantSwatch() != null) {
            map.put("LightVibrant", palette.getLightVibrantSwatch().getRgb());
        }
        if (palette.getMutedSwatch() != null) {
            map.put("MutedSwatch", palette.getMutedSwatch().getRgb());
        }
        if (palette.getDarkMutedSwatch() != null) {
            map.put("DarkMuted", palette.getDarkMutedSwatch().getRgb());
        }
        if (palette.getLightMutedSwatch() != null) {
            map.put("LightMuted", palette.getLightMutedSwatch().getRgb());
        }
        if (palette.getDominantSwatch() != null) {
            map.put("Dominant", palette.getDominantSwatch().getRgb());
        }
        return map;
    }

}
