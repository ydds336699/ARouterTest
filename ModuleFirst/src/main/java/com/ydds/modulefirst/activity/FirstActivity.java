package com.ydds.modulefirst.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ydds.libcommon.base.BaseActivity;
import com.ydds.librouter.ServiceCallback;
import com.ydds.librouter.consts.MFirstConst;
import com.ydds.librouter.consts.MSecondConst;
import com.ydds.librouter.services.ISecondService;
import com.ydds.modulefirst.R;
import com.ydds.modulefirst.bean.Person;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        Administrator
 * version:       V1.0
 * Date:          2019/4/29
 */

@Route(path = MFirstConst.MF_ACTIVITY_FIRST, name = "module first first")
public class FirstActivity extends BaseActivity implements View.OnClickListener {

    @Autowired
    public String from;

    @Autowired(name = "name")
    public String mName;

    @Autowired
    public Person person;

    @Autowired
    public ISecondService secondService;

    private Button mBtGo;
    private Button mBtGoResult;
    private Button mBtDo;
    private Button mBtDoAsync;
    private Button mBtSet;
    private Button mBtCheckSet;
    private Button mBtDegrade;
    private TextView mTv;


    @Override
    public int getLayoutID() {
        return R.layout.activity_first;
    }

    @Override
    public void init() {
        ARouter.getInstance().inject(this);
    }

    @Override
    public void initView() {
        mTv = findViewById(R.id.tv);
        mBtGo = findViewById(R.id.bt_go);
        mBtGoResult = findViewById(R.id.bt_go_result);
        mBtDo = findViewById(R.id.bt_do);
        mBtDoAsync = findViewById(R.id.bt_do_async);
        mBtSet = findViewById(R.id.bt_set);
        mBtCheckSet = findViewById(R.id.bt_check_set);
        mBtDegrade = findViewById(R.id.bt_degrade);
    }

    @Override
    public void initListener() {
        mBtGo.setOnClickListener(this);
        mBtGoResult.setOnClickListener(this);
        mBtDo.setOnClickListener(this);
        mBtDoAsync.setOnClickListener(this);
        mBtSet.setOnClickListener(this);
        mBtCheckSet.setOnClickListener(this);
        mBtDegrade.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mTv.setText("name:" + mName + "  from:" + from);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_go) {
            startSecond();
        } else if (id == R.id.bt_go_result) {
            startSecondForResult();
        } else if (id == R.id.bt_do) {
            doSecond();
        } else if (id == R.id.bt_do_async) {
            doSecondAsync();
        } else if (id == R.id.bt_set) {
            setSecond();
        } else if (id == R.id.bt_check_set) {
            getSetSecond();
        } else if (id == R.id.bt_degrade) {
            testDegrade();
        }
    }

    private void testDegrade() {
        ARouter.getInstance().build("/ModuleFirst/xxx").navigation(this);
    }

    private void getSetSecond() {
        String str = secondService.getSetInfo();
        mTv.setText(str);
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    private void setSecond() {
        secondService.setSecondInfo("还能不能玩了!!!");
    }

    private void doSecondAsync() {
        secondService.getSecondInfo(new ServiceCallback<Person>() {
            @Override
            public void onSuccess(Person person) {
                mTv.setText(person.name + " 来自：" + person.from);
                Toast.makeText(FirstActivity.this, mTv.getText(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFail(String msg) {

            }
        }, Person.class);
    }

    private void doSecond() {
        if (secondService != null) {
            mTv.setText(secondService.getSecondInfo());
        }
    }

    private void startSecondForResult() {
        ARouter.getInstance()
                .build(MSecondConst.MS_ACTIVITY_SECOND)
                .withString("name", "张三")
                .withString("from", "module first")
                .navigation(FirstActivity.this, MSecondConst.MS_REQUEST_INFO);
    }

    private void startSecond() {
        ARouter.getInstance()
                .build(MSecondConst.MS_ACTIVITY_SECOND)
                .withString("name", "张三")
                .withString("from", "module first")
                .navigation();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (resultCode == MSecondConst.MS_REQUEST_INFO) {
            mTv.setText("result:" + data.getStringExtra("ms_second_info"));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        secondService = null;
    }
}