package com.alistapp.a_list.flipviewpager;

/**
 * Created by Christian on 2/20/2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alistapp.a_list.R;
import com.squareup.picasso.Picasso;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class VenuesActivity extends com.alistapp.a_list.context_menu.ContextMenuMainActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venues);
        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        final ListView venues = (ListView) findViewById(R.id.venues);


        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        venues.setAdapter(new VenuesAdapter(this, Utils.venues, settings));
        venues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Venue v = (Venue) venues.getAdapter().getItem(position);

                Toast.makeText(VenuesActivity.this, v.getVenuename(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    class VenuesAdapter extends BaseFlipAdapter<Venue> {

        private final int PAGES = 3;
        private int[] IDS_INTEREST = {R.id.interest_1, R.id.interest_2, R.id.interest_3, R.id.interest_4, R.id.interest_5};

        public VenuesAdapter(Context context, List<Venue> items, FlipSettings settings) {
            super(context, items, settings);
        }

        @Override
        public View getPage(int position, View convertView, ViewGroup parent, Venue venue1, Venue venue2) {
            final VenuesHolder holder;

            if (convertView == null) {
                holder = new VenuesHolder();
                convertView = getLayoutInflater().inflate(R.layout.venues_merge_page, parent, false);
                holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
                holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = getLayoutInflater().inflate(R.layout.venue_info, parent, false);

                holder.venueName = (TextView) holder.infoPage.findViewById(R.id.nickname);


                for (int id : IDS_INTEREST)
                    holder.interests.add((TextView) holder.infoPage.findViewById(id));


                convertView.setTag(holder);


            } else {
                holder = (VenuesHolder) convertView.getTag();

            }

            switch (position) {
                // Merged page with 2 venues
                case 1:
                    holder.leftAvatar.setImageResource(venue1.getAvatar());
                    if (venue2 != null)
                        holder.rightAvatar.setImageResource(venue2.getAvatar());


                    break;
                default:
                    fillHolder(holder, position == 0 ? venue1 : venue2);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }
            return convertView;
        }

        @Override
        public int getPagesCount() {
            return PAGES;
        }

        private void fillHolder(VenuesHolder holder, Venue venue) {


            if (venue.getAvatar() == R.drawable.speakeasy) {
                Picasso.with(VenuesActivity.this).load(R.drawable.speakeasy_bg).into(holder..);
            } else if (venue.getAvatar() == R.drawable.dirty_dog)
                Picasso.with(VenuesActivity.this).load(R.drawable.dirty_dog_two).into(holder.infoPage.setBackgroundResource());
            else if (venue.getAvatar() == R.drawable.golden_goose)
                holder.infoPage.setBackgroundResource(R.drawable.golden_goose_bg);
            else if (venue.getAvatar() == R.drawable.handlebar)
                holder.infoPage.setBackgroundResource(R.drawable.handlebar_bg);
            else if (venue.getAvatar() == R.drawable.amped)
                holder.infoPage.setBackgroundResource(R.drawable.amped_bg);
            else if (venue.getAvatar() == R.drawable.ginger_man)
                holder.infoPage.setBackgroundResource(R.drawable.gingerman_bg);
            else if (venue.getAvatar() == R.drawable.midnight_cowboy)
                holder.infoPage.setBackgroundResource(R.drawable.midnight_cowboy_bg);
            else if (venue.getAvatar() == R.drawable.roosevelt_room)
                holder.infoPage.setBackgroundResource(R.drawable.roosevelt_room_bg);
            else if (venue.getAvatar() == R.drawable.sae)
                holder.infoPage.setBackgroundResource(R.drawable.sae_bg);
            else if (venue.getAvatar() == R.drawable.sig_ep)
                holder.infoPage.setBackgroundResource(R.drawable.sig_ep_bg);
            else if (venue.getAvatar() == R.drawable.barcelona_out)
                holder.infoPage.setBackgroundResource(R.drawable.barcelona_out);
            else if (venue.getAvatar() == R.drawable.blind_pig_out)
                holder.infoPage.setBackgroundResource(R.drawable.blind_pig_out);
            else if (venue.getAvatar() == R.drawable.jackalope_out)
                holder.infoPage.setBackgroundResource(R.drawable.jackalope_in);
            else if (venue.getAvatar() == R.drawable.aquarium_out)
                holder.infoPage.setBackgroundResource(R.drawable.aquarium_in);
            else if (venue.getAvatar() == R.drawable.thirsty_nickel_out)
                holder.infoPage.setBackgroundResource(R.drawable.thirsty_nickel_in);
            else if (venue.getAvatar() == R.drawable.four_horseman)
                holder.infoPage.setBackgroundResource(R.drawable.four_horseman_in);
            else if (venue.getAvatar() == R.drawable.sidebar_out)
                holder.infoPage.setBackgroundResource(R.drawable.sidebar_in);
            else if (venue.getAvatar() == R.drawable.j_blacks_out)
                holder.infoPage.setBackgroundResource(R.drawable.j_blacks_in);
            else if (venue.getAvatar() == R.drawable.brew_exchange_out)
                holder.infoPage.setBackgroundResource(R.drawable.brew_exchange_in);
            else if (venue.getAvatar() == R.drawable.concrete_cowboy_out)
                holder.infoPage.setBackgroundResource(R.drawable.concrete_cowboy_in);
            else if (venue.getAvatar() == R.drawable.steampuck_out)
                holder.infoPage.setBackgroundResource(R.drawable.steampunk_in);
            else if (venue.getAvatar() == R.drawable.pop_out)
                holder.infoPage.setBackgroundResource(R.drawable.pop_in);
            else if (venue.getAvatar() == R.drawable.kung_fu_out)
                holder.infoPage.setBackgroundResource(R.drawable.kung_fu_in);


            if (venue == null)
                return;
            Iterator<TextView> iViews = holder.interests.iterator();
            Iterator<String> iInterests = venue.getInterests().iterator();

            while (iViews.hasNext() && iInterests.hasNext())
                iViews.next().setText(iInterests.next());

            holder.venueName.setText(venue.getVenuename());
        }

        class VenuesHolder {
            ImageView leftAvatar;
            ImageView rightAvatar;
            View infoPage;


            List<TextView> interests = new ArrayList<>();
            TextView venueName;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;
    }

}