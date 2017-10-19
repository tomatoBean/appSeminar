package com.example.fengxianlicloudcom.myapplicationlistviewmenuoptiondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengxianlicloud.com on 2017/10/19.
 */

public class MoreAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    public static final List<String> more_list = new ArrayList<String>();//为条目提供数据


    public MoreAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(this.context);
        more_list.add(context.getResources().getString(R.string.item_location));
        more_list.add(context.getResources().getString(R.string.item_share));
        more_list.add(context.getResources().getString(R.string.item_help));
        more_list.add(context.getResources().getString(R.string.item_edit));
        more_list.add(context.getResources().getString(R.string.item_agenda));
    }

    @Override
    public int getCount() {
        return more_list.size();  //条目数量
    }

    @Override
    public Object getItem(int position) {  return more_list.get(position);  }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.item, null);
        }

        ImageView iconHead = (ImageView) convertView.findViewById(R.id.item_icon); // item icon
        ImageView iconEnd  = (ImageView) convertView.findViewById(R.id.item_image );  // arrow

//        if(0 == position) {
//            icon.setBackgroundResource(R.drawable.icon1);
//        }else if(1 == position) {
//            icon.setBackgroundResource(android.R.drawable.ic_menu_share);
//        }else if(2 == position) {
//            icon.setBackgroundResource(R.drawable.icon2);
//        }else if(3 == position) {
//            icon.setBackgroundResource(android.R.drawable.ic_menu_edit);
//        }else{
//            icon.setBackgroundResource(R.drawable.icon3);
//        }

        // head icon
        if(0 == position){
            iconHead.setBackgroundResource(android.R.drawable.ic_menu_mylocation); // location
        }else if(1 == position){
            iconHead.setBackgroundResource(android.R.drawable.ic_menu_share);   // share
        }else if(2 == position){
            iconHead.setBackgroundResource(android.R.drawable.ic_menu_help);    // help
        }else if(3 == position){
            iconHead.setBackgroundResource(android.R.drawable.ic_menu_edit);    // edit
        }else{
            iconHead.setBackgroundResource(android.R.drawable.ic_menu_agenda);     // agenda
        }

        // item text
        TextView text = (TextView) convertView.findViewById(R.id.more_item_text); //设置条目的文字说明
        text.setText(more_list.get(position));

        // end icon
        iconEnd.setBackgroundResource(android.R.drawable.ic_menu_directions);


        return convertView;
    }




}
