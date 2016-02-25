package com.alistapp.a_list.flipviewpager;

/**
 * Created by Christian on 2/20/2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
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
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author Yalantis
 */
public class FriendsActivity extends com.alistapp.a_list.context_menu.ContextMenuMainActivity {

    private FragmentManager fragmentManager;
    private ContextMenuDialogFragment mMenuDialogFragment;
    private Toolbar toolbar;
    int imgResId;
    final int[] BACKGROUND_EVENT_IMAGES = {


            R.drawable.speakeasy_bg, R.drawable.dirty_dog_two, R.drawable.golden_goose_bg, R.drawable.handlebar_bg,
            R.drawable.amped_bg, R.drawable.gingerman_bg, R.drawable.midnight_cowboy_bg, R.drawable.roosevelt_room_bg,
            R.drawable.sae_bg, R.drawable.sig_ep_bg, R.drawable.blind_pig_out, R.drawable.barcelona_out, R.drawable.jackalope_out
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venues);
        fragmentManager = getSupportFragmentManager();
        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        final ListView friends = (ListView) findViewById(R.id.friends);


        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        friends.setAdapter(new FriendsAdapter(this, Utils.friends, settings));
        friends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Friend f = (Friend) friends.getAdapter().getItem(position);

                Toast.makeText(FriendsActivity.this, f.getNickname(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    class FriendsAdapter extends BaseFlipAdapter<Friend> {

        private final int PAGES = 3;
        private int[] IDS_INTEREST = {R.id.interest_1, R.id.interest_2, R.id.interest_3, R.id.interest_4, R.id.interest_5};

        public FriendsAdapter(Context context, List<Friend> items, FlipSettings settings) {
            super(context, items, settings);
        }

        @Override
        public View getPage(int position, View convertView, ViewGroup parent, Friend friend1, Friend friend2) {
            final FriendsHolder holder;

            if (convertView == null) {
                holder = new FriendsHolder();
                convertView = getLayoutInflater().inflate(R.layout.venues_merge_page, parent, false);
                holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
                holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = getLayoutInflater().inflate(R.layout.venue_info, parent, false);
                //Just testing for placement
                //holder.infoPage.setBackgroundResource(BACKGROUND_EVENT_IMAGES[position]);

                holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);


                for (int id : IDS_INTEREST)
                    holder.interests.add((TextView) holder.infoPage.findViewById(id));



                convertView.setTag(holder);


            } else {
                holder = (FriendsHolder) convertView.getTag();

            }

            switch (position) {
                // Merged page with 2 friends
                case 1:
                    holder.leftAvatar.setImageResource(friend1.getAvatar());
                    if (friend2 != null)
                        holder.rightAvatar.setImageResource(friend2.getAvatar());



                    break;
                default:
                    fillHolder(holder, position == 0 ? friend1 : friend2, position);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }
            return convertView;
        }

        @Override
        public int getPagesCount() {
            return PAGES;
        }

        private void fillHolder(FriendsHolder holder, Friend friend, int position) {

            //holder.backgroundImage = (ImageView) holder.infoPage.findViewById(R.id.background_event_image);

            if(friend.getAvatar() == R.drawable.speakeasy){
                Picasso.with(FriendsActivity.this).load(R.drawable.speakeasy_bg).into(holder..);
            }else if(friend.getAvatar() == R.drawable.dirty_dog)
                Picasso.with(FriendsActivity.this).load(R.drawable.dirty_dog_two).into(holder.infoPage.setBackgroundResource());
            else if(friend.getAvatar() == R.drawable.golden_goose)
                holder.infoPage.setBackgroundResource(R.drawable.golden_goose_bg);
            else if(friend.getAvatar() == R.drawable.handlebar)
                holder.infoPage.setBackgroundResource(R.drawable.handlebar_bg);
            else if(friend.getAvatar() == R.drawable.amped)
                holder.infoPage.setBackgroundResource(R.drawable.amped_bg);
            else if(friend.getAvatar() == R.drawable.ginger_man)
                holder.infoPage.setBackgroundResource(R.drawable.gingerman_bg);
            else if(friend.getAvatar() == R.drawable.midnight_cowboy)
                holder.infoPage.setBackgroundResource(R.drawable.midnight_cowboy_bg);
            else if(friend.getAvatar() == R.drawable.roosevelt_room)
                holder.infoPage.setBackgroundResource(R.drawable.roosevelt_room_bg);
            else if(friend.getAvatar() == R.drawable.sae)
                holder.infoPage.setBackgroundResource(R.drawable.sae_bg);
            else if(friend.getAvatar() == R.drawable.sig_ep)
                holder.infoPage.setBackgroundResource(R.drawable.sig_ep_bg);
            else if(friend.getAvatar() == R.drawable.barcelona_out)
                holder.infoPage.setBackgroundResource(R.drawable.barcelona_out);
            else if(friend.getAvatar() == R.drawable.blind_pig_out)
                holder.infoPage.setBackgroundResource(R.drawable.blind_pig_out);
            else if(friend.getAvatar() == R.drawable.jackalope_out)
                holder.infoPage.setBackgroundResource(R.drawable.jackalope_in);
            else if(friend.getAvatar() == R.drawable.aquarium_out)
                holder.infoPage.setBackgroundResource(R.drawable.aquarium_in);
            else if(friend.getAvatar() == R.drawable.thirsty_nickel_out)
                holder.infoPage.setBackgroundResource(R.drawable.thirsty_nickel_in);
            else if(friend.getAvatar() == R.drawable.four_horseman)
                holder.infoPage.setBackgroundResource(R.drawable.four_horseman_in);
            else if(friend.getAvatar() == R.drawable.sidebar_out)
                holder.infoPage.setBackgroundResource(R.drawable.sidebar_in);
            else if(friend.getAvatar() == R.drawable.j_blacks_out)
                holder.infoPage.setBackgroundResource(R.drawable.j_blacks_in);
            else if(friend.getAvatar() == R.drawable.brew_exchange_out)
                holder.infoPage.setBackgroundResource(R.drawable.brew_exchange_in);
            else if(friend.getAvatar() == R.drawable.concrete_cowboy_out)
                holder.infoPage.setBackgroundResource(R.drawable.concrete_cowboy_in);
            else if(friend.getAvatar() == R.drawable.steampuck_out)
                holder.infoPage.setBackgroundResource(R.drawable.steampunk_in);
            else if(friend.getAvatar() == R.drawable.pop_out)
                holder.infoPage.setBackgroundResource(R.drawable.pop_in);
            else if(friend.getAvatar() == R.drawable.steampuck_out)
                holder.infoPage.setBackgroundResource(R.drawable.steampunk_in);
            else if(friend.getAvatar() == R.drawable.kung_fu_out)
                holder.infoPage.setBackgroundResource(R.drawable.kung_fu_in);


            if (friend == null)
                return;
            Iterator<TextView> iViews = holder.interests.iterator();
            Iterator<String> iInterests = friend.getInterests().iterator();

            while (iViews.hasNext() && iInterests.hasNext())
                iViews.next().setText(iInterests.next());

            holder.nickName.setText(friend.getNickname());
        }

        class FriendsHolder {
            ImageView leftAvatar;
            ImageView rightAvatar;
            View infoPage;
            ImageView backgroundImage;



            List<TextView> interests = new ArrayList<>();
            TextView nickName;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:
                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    } */
}