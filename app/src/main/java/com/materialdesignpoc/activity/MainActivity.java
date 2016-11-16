package com.materialdesignpoc.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.materialdesignpoc.R;
import com.materialdesignpoc.adapter.UserDetailAdapter;
import com.materialdesignpoc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar mToolbar;
    private FloatingActionButton mFabBtn;
    private RecyclerView mRecyclerView;
    private String[] name;
    private String[] description;
    private List<UserDTO> mUserList;
    private LinearLayoutManager linearLayoutManager;
    private UserDetailAdapter mCustomAdapter;
    private ImageView mIvGrid;
    private ImageView mIvList;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserList = new ArrayList<>();
        initUI();
        addData();
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mCustomAdapter = new UserDetailAdapter(this, mUserList);
        mRecyclerView.setAdapter(mCustomAdapter);

    }

    private void initUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mFabBtn = (FloatingActionButton) findViewById(R.id.fab);
        mIvGrid = (ImageView) findViewById(R.id.iv_grid);
        mIvList = (ImageView) findViewById(R.id.iv_list);
        mIvGrid.setOnClickListener(this);
        mIvList.setOnClickListener(this);
        mFabBtn.setOnClickListener(this);
    }

    private void addData() {
        name = getResources().getStringArray(R.array.names);
        description = getResources().getStringArray(R.array.description);
        for (int i = 0; i < name.length; i++) {
            UserDTO dto = new UserDTO();
            dto.setName(name[i]);
            dto.setDescription(description[i]);
            mUserList.add(dto);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_grid:
                mRecyclerView.setLayoutManager(gridLayoutManager);
                mIvGrid.setVisibility(View.GONE);
                mIvList.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_list:
                mRecyclerView.setLayoutManager(linearLayoutManager);
                mIvGrid.setVisibility(View.VISIBLE);
                mIvList.setVisibility(View.GONE);
                break;
            case R.id.fab:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }

    }
}
