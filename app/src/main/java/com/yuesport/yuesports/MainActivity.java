package com.yuesport.yuesports;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends FragmentActivity implements OnClickListener {

    private LinearLayout navFind;
    private LinearLayout navMsg;
    private LinearLayout navMine;

    private ImageButton navFindImg;
    private ImageButton navMsgImg;
    private ImageButton navMineImg;

    private Fragment Find;
    private Fragment Msg;
    private Fragment Mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉title栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        initEvent();
        setSelect(0);
    }

    private void initView(){
        navFind = (LinearLayout) findViewById(R.id.id_nav_find);
        navMsg = (LinearLayout) findViewById(R.id.id_nav_msg);
        navMine = (LinearLayout) findViewById(R.id.id_nav_mine);

        navFindImg = (ImageButton) findViewById(R.id.id_nav_find_img);
        navMsgImg = (ImageButton) findViewById(R.id.id_nav_msg_img);
        navMineImg = (ImageButton) findViewById(R.id.id_nav_mine_img);
    }

    private void initEvent()
    {
        navFind.setOnClickListener(this);
        navMsg.setOnClickListener(this);
        navMine.setOnClickListener(this);
    }

    private void setSelect(int i)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i)
        {
            case 0:
                if (Find == null)
                {
                    Find = new FindFragment_W();
                    transaction.add(R.id.id_content, Find);
                } else
                {
                    transaction.show(Find);
                }
                navFindImg.setImageResource(R.drawable.nav_find_pressed);
                break;
            case 1:
                if (Msg == null)
                {
                    Msg = new MsgFragment_L();
                    transaction.add(R.id.id_content, Msg);
                } else
                {
                    transaction.show(Msg);

                }
                navMsgImg.setImageResource(R.drawable.nav_find_pressed);
                break;
            case 2:
                if (Mine == null)
                {
                    Mine = new MineFragment_Z();
                    transaction.add(R.id.id_content, Mine);
                } else
                {
                    transaction.show(Mine);
                }
                navMineImg.setImageResource(R.drawable.nav_find_pressed);
                break;

            default:
                break;
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction)
    {
        if (Find != null)
        {
            transaction.hide(Find);
        }
        if (Msg != null)
        {
            transaction.hide(Msg);
        }
        if (Mine != null)
        {
            transaction.hide(Mine);
        }
    }

    @Override
    public void onClick(View v)
    {
        resetImgs();
        switch (v.getId())
        {
            case R.id.id_nav_find:
                setSelect(0);
                break;
            case R.id.id_nav_msg:
                setSelect(1);
                break;
            case R.id.id_nav_mine:
                setSelect(2);
                break;

            default:
                break;
        }
    }
    
    /**
     * 切换图片至暗色
     */
    private void resetImgs()
    {
        navFindImg.setImageResource(R.drawable.nav_find_normal);
        navMsgImg.setImageResource(R.drawable.nav_find_normal);
        navMineImg.setImageResource(R.drawable.nav_find_normal);
    }
}
