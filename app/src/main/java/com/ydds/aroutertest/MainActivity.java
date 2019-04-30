package com.ydds.aroutertest;

import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ydds.ARouterTest.R;
import com.ydds.libcommon.base.BaseActivity;
import com.ydds.librouter.consts.MFirstConst;
import com.ydds.librouter.consts.MSecondConst;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtFirst;
    private Button mBtSecond;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

    }

    @Override
    public void initView() {
        mBtFirst = findViewById(R.id.bt_first);
        mBtSecond = findViewById(R.id.bt_second);
    }

    @Override
    public void initListener() {
        mBtFirst.setOnClickListener(this);
        mBtSecond.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    public void startFirst() {
        ARouter.getInstance()
                .build(MFirstConst.MF_ACTIVITY_FIRST)
                .withString("name", "王五")
                .withString("from", "主app")
                .greenChannel()
                .navigation();
    }

    public void startSecond() {
        ARouter.getInstance()
                .build(MSecondConst.MS_ACTIVITY_SECOND)
                .withString("name", "王五")
                .withString("from", "主app")
                .navigation();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_first) {
            startFirst();
        } else if (id == R.id.bt_second) {
            startSecond();
        }
    }
}
