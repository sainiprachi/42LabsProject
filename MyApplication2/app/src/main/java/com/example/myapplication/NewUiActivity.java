package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NewUiActivity extends AppCompatActivity {

    private ArrayList<NavigationModel>navigationModelArrayList;
    private ArrayList<NavigationModel>othernavigationModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ui);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();
        initView();


    }


    private void initView(){
        RecyclerView recyclerItems=findViewById(R.id.recyclerItems);
        RecyclerView recyclerServiceNepal=findViewById(R.id.recyclerServiceNepal);
        RecyclerView recyclerService=findViewById(R.id.recyclerService);
        RecyclerView recyclerServiceIndia=findViewById(R.id.recyclerServiceIndia);
        LinearLayoutManager layoutManager =
                new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);

        LinearLayoutManager layoutManagero =
                new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);


        LinearLayoutManager layoutManagern =
                new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManageri =
                new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);

        recyclerItems.setLayoutManager(layoutManager);
        recyclerServiceIndia.setLayoutManager(layoutManageri);
        recyclerServiceIndia.setAdapter(new ServiceIndiaAdapter());
        recyclerServiceNepal.setLayoutManager(layoutManagern);
        recyclerServiceNepal.setAdapter(new ServiceIndiaAdapter());
        recyclerService.setLayoutManager(layoutManagero);
        if (navigationModelArrayList==null){
            navigationModelArrayList=new ArrayList<>();
        }if (othernavigationModelArrayList==null){
            othernavigationModelArrayList=new ArrayList<>();
        }

        addOtherItems();
        ItemAdapter itemAdapter=new ItemAdapter(navigationModelArrayList);
        recyclerItems.setAdapter(itemAdapter);


        addItems();
        NewItemAdapter newItemAdapter=new NewItemAdapter(othernavigationModelArrayList);
        recyclerService.setAdapter(newItemAdapter);

    }

    private void addItems() {
        NavigationModel item;
        for (int i = 0; i < 7; i++) {
            item = new NavigationModel();
            switch (i) {
                case 0:

                case 4:
                    item.itemName = "Prepaid";
                    item.itemImg = R.drawable.prepaid;

                    break;
                case 1:

                case 5:
                    item.itemName = "Postpaid";
                    item.itemImg = R.drawable.prepaid_one;

                    break;

                case 6:

                case 2:
                    item.itemName = "DTH";
                    item.itemImg = R.drawable.dth;
                    break;

                case 3:
                    item.itemName = "Electricity";
                    item.itemImg = R.drawable.electricity;
                    break;


            }
            othernavigationModelArrayList.add(item);
        }
    }

    private void addOtherItems() {
        NavigationModel item;
        for (int i = 0; i < 8; i++) {
            item = new NavigationModel();
            switch (i) {
                case 0:
                    item.itemName = "Add Money";
                    item.itemImg = R.drawable.add_mony;

                    break;
                case 1:
                    item.itemName = "Send Money";
                    item.itemImg = R.drawable.send_money;

                    break;

                case 2:
                    item.itemName = "My Order";
                    item.itemImg = R.drawable.my_order;
                    break;

                case 3:
                    item.itemName = "Remmitance";
                    item.itemImg = R.drawable.remettance;
                    break;

                case 4:
                    item.itemName = "Wallet History";
                    item.itemImg = R.drawable.wallet_history;
                    break;

                case 5:
                    item.itemName = "Recharge History India";
                    item.itemImg = R.drawable.rechage_history_india;
                    break;

                case 6:
                    item.itemName = "Recharge History Nepal";
                    item.itemImg = R.drawable.rechage_history_nepal;
                    break;


                case 7:
                    item.itemName = "Remittance History";
                    item.itemImg = R.drawable.remettance_one;
                    break;



            }
            navigationModelArrayList.add(item);
        }
    }


}
