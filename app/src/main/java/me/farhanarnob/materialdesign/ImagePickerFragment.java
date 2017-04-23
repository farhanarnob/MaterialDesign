package me.farhanarnob.materialdesign;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class ImagePickerFragment extends DialogFragment {
    private static final String TAG = ImagePickerFragment.class.getName();
    @BindView(R.id.picker_button)
    Button pickerButton;
    @BindView(R.id.taking_button)
    Button takingButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_picker_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
