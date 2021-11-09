package com.example.carrent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.admixer.sdk.AdListener;
import net.admixer.sdk.AdSize;
import net.admixer.sdk.AdView;
import net.admixer.sdk.BannerAdView;
import net.admixer.sdk.ResultCode;

import java.util.ArrayList;

public class ThirdScreenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType == R.layout.item_ad_view){
            View layout = inflater.inflate(R.layout.item_ad_view, parent, false);
            return new AdViewHolder(layout);
        }
        else{
            View layout = inflater.inflate(R.layout.text_item, parent, false);
            return new ViewHolder(layout);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case R.layout.item_ad_view: {
                AdViewHolder adViewHolder = (AdViewHolder) holder;
                adViewHolder.bind(position);
            }
        }
    }

    @Override
    public int getItemCount() {
        return 200;
    }

    @Override
    public int getItemViewType(int position) {
        if(position %9 == 0){
            return R.layout.item_ad_view;
        }
        else{
            return  R.layout.text_item;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class AdViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private BannerAdView bav;

        public AdViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            bav = this.itemView.findViewById(R.id.item_view);

        }

        public void bind (int position){
            final String zoneId = "f9a26255-08a2-40ec-9667-3ab35e69625a";
            bav.setPlacementID(zoneId);
            ArrayList<AdSize> sizes = new ArrayList<>();
            sizes.add(new AdSize(300, 250));
            bav.setAdSizes(sizes);

            bav.loadAd();
            bav.setVisibility(View.INVISIBLE);

            bav.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded(AdView adView) {
                    bav.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAdRequestFailed(AdView adView, ResultCode resultCode) {

                }

                @Override
                public void onAdExpanded(AdView adView) {

                }

                @Override
                public void onAdCollapsed(AdView adView) {

                }

                @Override
                public void onAdClicked(AdView adView) {

                }

                @Override
                public void onAdClicked(AdView adView, String s) {

                }
            });
        }
    }
}
