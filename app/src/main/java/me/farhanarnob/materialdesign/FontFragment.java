package me.farhanarnob.materialdesign;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class FontFragment extends Fragment {
    @BindView(R.id.display4)
    TextView display4View;
    Typeface courgette;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.font_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        display4View.setTypeface(courgette);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        courgette = Typeface.createFromAsset(context.getAssets(), "Courgette-Regular.ttf");
    }
}
