package cn.wecook.et.adapter;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    private List<Item> mItemList;
    private ItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemList = new ArrayList<Item>();

        for (int i = 0; i < 50; i++) {
            Item item = new Item();
            item.name = "Item-" + (i + 1);
            mItemList.add(item);
        }

        ListView listView = (ListView) findViewById(R.id.app_listview);

        mAdapter = new ItemAdapter(this, mItemList);
        listView.setAdapter(mAdapter);
    }

    public class Item {
        String name;
    }

    public class ItemAdapter extends UIAdapter<Item> {

        public ItemAdapter(Context context, List<Item> data) {
            super(context, R.layout.listview_item_text, data);
        }

        @Override
        public void updateView(int position, int viewType, Item data, Bundle extra) {
            super.updateView(position, viewType, data, extra);

            TextView textView = (TextView) findViewById(R.id.app_item_name);
            textView.setText(data.name);

        }
    }

}
