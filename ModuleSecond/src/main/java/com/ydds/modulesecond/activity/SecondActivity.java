package com.ydds.modulesecond.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ydds.libcommon.base.BaseActivity;
import com.ydds.librouter.RLog;
import com.ydds.librouter.consts.MFirstConst;
import com.ydds.librouter.consts.MSecondConst;
import com.ydds.librouter.services.IFirstService;
import com.ydds.modulefirst.R;
import com.ydds.modulesecond.bean.Man;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        lizhen
 * version:       V1.0
 * Date:          2019/4/29
 */
@Route(path = MSecondConst.MS_ACTIVITY_SECOND, name = "module second second")
public class SecondActivity extends BaseActivity implements View.OnClickListener {

    @Autowired
    public String name;

    @Autowired
    public String from;

    private Button mBtDo;
    private Button mBtGo;
    private TextView mTv;


    @Override
    public int getLayoutID() {
        return R.layout.activity_second;
    }

    @Override
    public void init() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mTv = findViewById(R.id.tv);
        mBtGo = findViewById(R.id.bt_go);
        mBtDo = findViewById(R.id.bt_do);
    }

    @Override
    public void initListener() {
        mBtGo.setOnClickListener(this);
        mBtDo.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mTv.setText("name:" + name + "  from:" + from);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_go) {
            startFirst();
        } else if (id == R.id.bt_do) {
            doFirst();
        }
    }

    private void doFirst() {
        IFirstService firstService = ARouter.getInstance().navigation(IFirstService.class);
        if (firstService != null) {
            Man man = firstService.getFirstInfo2("", Man.class);
            mTv.setText(man.name + " 来自：" + man.from);
        }
    }

    private void startFirst() {
        ARouter.getInstance()
                .build(MFirstConst.MF_ACTIVITY_FIRST)
                .withString("name", "李四")
                .withString("from", "module second")
                .navigation(this, new NavCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        RLog.d("second start first onFound ");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        RLog.d("second start first onLost ");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        RLog.d("second start first onArrival ");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        RLog.d("second start first onInterrupt ");
                    }
                });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("ms_second_info", "我是ModuleSecond,给你result");
        setResult(MSecondConst.MS_REQUEST_INFO, intent);
        super.onBackPressed();
    }
}

