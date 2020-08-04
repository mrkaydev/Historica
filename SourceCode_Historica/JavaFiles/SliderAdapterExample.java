package com.kay.historica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView)
                        .load("https://www.incredibleindia.org/content/dam/incredible-india-v2/images/experiences/art/musica-forms/musica-forms.jpg/_jcr_content/renditions/cq5dam.web.512.288.jpeg")
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                Glide.with(viewHolder.itemView)
                        .load("https://www.incredibleindia.org/content/dam/incredible-india-v2/images/experiences/shopping/mcleod-ganj-market-dharamsala.jpg/_jcr_content/renditions/cq5dam.web.512.288.jpeg")
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                Glide.with(viewHolder.itemView)
                        .load("https://graphicriver.img.customer.envatousercontent.com/files/261695480/Udaipur_outline_bold_color_590.jpg?auto=compress%2Cformat&q=80&fit=crop&crop=top&max-h=8000&max-w=590&s=62ab8e44887249643a7a8fe1d6f8c680")
                        .into(viewHolder.imageViewBackground);
                break;
            case 3:
                Glide.with(viewHolder.itemView)
                        .load("https://previews.123rf.com/images/booblgum/booblgum1802/booblgum180200267/96312925-mumbai-india-city-skyline-with-color-buildings-isolated-on-white-vector-illustration-.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
            case 4:
                Glide.with(viewHolder.itemView)
                        .load("https://us.123rf.com/450wm/booblgum/booblgum1802/booblgum180200186/95682585-outline-bangalore-india-city-skyline-with-color-buildings-isolated-on-white-vector-illustration-bang.jpg?ver=6")
                        .into(viewHolder.imageViewBackground);
                break;
            default:
                Glide.with(viewHolder.itemView)
                        .load("https://as2.ftcdn.net/jpg/01/89/12/89/500_F_189128930_UIfLGZYONXyUWVzwKqWbBinnUjEgQC9l.jpg")
                        .into(viewHolder.imageViewBackground);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 6;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}