package com.example.fengxianlicloudcom.myapplicationlistviewmenuoptiondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fengxianlicloudcom.myapplicationlistviewmenuoptiondemo.MoreAdapter;


public class MainActivity extends AppCompatActivity {

    private ListView moreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  MainService.allActivity.add(this);
        moreList = (ListView) findViewById(R.id.more_List);
        MoreAdapter adapter = new MoreAdapter(this);
        moreList.setAdapter(adapter);
        moreList.setOnItemClickListener(new AdapterView.OnItemClickListener() { //为每一个item设置相应的响应

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch(position){
                    case 0: //关于
                        startActivity(AboutActivity.class);
                        break;
                    case 1:
                        //分享
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                        intent.putExtra(Intent.EXTRA_TEXT, "I would like to share this with you...");
                        startActivity(Intent.createChooser(intent, getTitle()));
                        break;
                    case 2:
                        //帮助
                        startActivity(HelpActivity.class);
                        break;
                    case 3:
                        //意见反馈
                        //AppConnect.getInstance(MainActivity.this).showFeedback();
                        break;
                    case 4://退出
                        //AlertDlgUtil.AlertExit(MainActivity.this);
                        break;
                }
            }
        });
    }
    private void startActivity(Class<?>cls){
        Intent intent = new Intent(this, cls);
        this.startActivity(intent);
    }


}
