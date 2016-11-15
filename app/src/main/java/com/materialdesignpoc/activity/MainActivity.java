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
    private ImageView mIvRecycler;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserList = new ArrayList<>();
        initUI();
        setSupportActionBar(mToolbar);
        addData();


        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mCustomAdapter = new UserDetailAdapter(this, mUserList);
        mRecyclerView.setAdapter(mCustomAdapter);
    }

    private void initUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mFabBtn = (FloatingActionButton) findViewById(R.id.fab);
        mIvGrid = (ImageView) findViewById(R.id.image_btn_recycler_view);
        mIvRecycler = (ImageView) findViewById(R.id.image_btn_grid);
        mFabBtn.setOnClickListener(this);
        mIvGrid.setOnClickListener(this);
        mIvRecycler.setOnClickListener(this);

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
            case R.id.fab:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.image_btn_recycler_view:
                mRecyclerView.setLayoutManager(linearLayoutManager);

                break;
            case R.id.image_btn_grid:
                mRecyclerView.setLayoutManager(gridLayoutManager);


                break;
        }

    }
}
