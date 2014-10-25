package com.tempos21.cieguitos.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.sergibc.sdk.data.Museo;
import com.squareup.picasso.Picasso;
import com.tempos21.cieguitos.R;

import java.util.List;

/**
 * Created by Bernat on 25/10/2014.
 */
public class MuseumsAdapter extends ArrayAdapter<Museo> {
	private final LayoutInflater from;
	public int itemSelected = -1;

	public MuseumsAdapter(Context context, List<Museo> objects) {
		super(context, 0, objects);
		from = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = from.inflate(R.layout.museo_layout, parent, false);

		ImageView image = (ImageView) v.findViewById(R.id.image);
		View qr = v.findViewById(R.id.qr);

		Museo item = getItem(position);

		Picasso.with(getContext()).load(item.getImage()).into(image);

		TextView text = (TextView) v.findViewById(R.id.text);
		TextView title = (TextView) v.findViewById(R.id.title);

		title.setText(item.getName());
		String description = item.getDescription();
		if (itemSelected != position && description.length() > 100) {
			description = description.substring(0, description.length() / 3);
		}

		if (itemSelected == position) {
			qr.setVisibility(View.VISIBLE);
		} else {
			qr.setVisibility(View.GONE);
		}
		text.setText(description);

		return v;
	}

	public void setSelectedItem(int position) {
		if (position != itemSelected) {
			this.itemSelected = position;
		} else {
			this.itemSelected = -1;
		}
		notifyDataSetChanged();
	}
}