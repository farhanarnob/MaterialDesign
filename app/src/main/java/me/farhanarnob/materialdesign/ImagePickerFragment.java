package me.farhanarnob.materialdesign;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class ImagePickerFragment extends DialogFragment {
    private static final String TAG = ImagePickerFragment.class.getName();
    private static final int REQUEST_IMAGE_CAPTURE = 101;
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


    @OnClick(R.id.taking_button)
    void takeImage(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_IMAGE_CAPTURE:
                if (resultCode == Activity.RESULT_OK) {
                    Log.i("REQUEST", "SUCCESSFUL");
                    Bundle imageFromCamera = data.getExtras();
                    ((PalateFromImageLayout) getActivity()).createPalette(imageFromCamera);
                    getDialog().dismiss();
                }
                break;
            default:
                break;
        }
    }
}
