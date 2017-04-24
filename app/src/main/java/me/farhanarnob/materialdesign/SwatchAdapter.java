package me.farhanarnob.materialdesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

class SwatchAdapter extends RecyclerView.Adapter<SwatchAdapter.ViewHolder> {
    private Object[] mEntries;

    SwatchAdapter(Object[] entries) {
        mEntries = entries;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.swatch_view, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap.Entry<String, Integer> entry = (HashMap.Entry<String, Integer>) mEntries[position];
        if (entry != null) {
            holder.colorView.setBackgroundColor(entry.getValue());
            holder.textView.setText(entry.getKey() + " (#" +
                    Integer.toHexString(entry.getValue()).toUpperCase() + ")");
        }
    }

    @Override
    public int getItemCount() {
        return mEntries.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private View colorView;

        private ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewOfSwatch);
            colorView = itemView.findViewById(R.id.colorSwatch);
        }
    }


}
