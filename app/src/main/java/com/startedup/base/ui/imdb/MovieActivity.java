package com.startedup.base.ui.imdb;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.startedup.base.R;
import com.startedup.base.listener.FragmentCommunicationListner;
import com.startedup.base.ui.base.BaseActivity;
import com.startedup.base.utils.CommonUtil;
import com.startedup.base.utils.ResourceFinder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MovieActivity extends BaseActivity implements FragmentCommunicationListner{


    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.bt_permission)
    Button btPermission;
    @BindView(R.id.bt_load_fragment)
    Button btLoadFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
    }


    @Override
    public void onFragmentCommunicated(Object object) {

    }

    @Override
    protected void onMultiplePermissionGranted() {
        showToastShort(ResourceFinder.getString(R.string.permission_granted));
    }

    @Override
    protected void onSinglePermissionGranted() {
        showToastShort(ResourceFinder.getString(R.string.permission_granted));
    }

    @Override
    protected void onNetworkOn() {
        CommonUtil.showToasShort(this, "Network ON");
    }

    @Override
    protected void onNetworkOff() {
        CommonUtil.showToasShort(this, "Network OFF");
    }


    @OnClick({R.id.bt_permission, R.id.bt_load_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_permission:
                ArrayList<String> permissionArray = new ArrayList<>();
                permissionArray.add(Manifest.permission.RECORD_AUDIO);
                permissionArray.add(Manifest.permission.CAMERA);
                permissionArray.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                requestMultiplePermission(permissionArray);
                break;
            case R.id.bt_load_fragment:
                replaceFragment(new TopRatedMovieFragment(), R.id.fragment_container, true);
                break;
        }
    }
}
