package com.example.cain.reinventist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import static com.example.cain.reinventist.MainActivity.aaaa;

public class QueueAdapter extends BaseAdapter {
    private List<QueueData> mData;
    private LayoutInflater mInflater;
    public QueueAdapter(LayoutInflater inflater,List<QueueData> data){
        mInflater = inflater;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewDatatest = mInflater.inflate(R.layout.activity_queue_adapter,null);
        final QueueData datatest = mData.get(position);
        TextView name = (TextView) viewDatatest.findViewById(R.id.textView);
        TextView item = (TextView) viewDatatest.findViewById(R.id.textView2);
        final TextView status = (TextView) viewDatatest.findViewById(R.id.textView3);
        final Button button=(Button)viewDatatest.findViewById(R.id.button);
        name.setText(datatest.getname());
        item.setText(datatest.getitem());
        if(datatest.getbool_n()){
            status.setText(datatest.getsorder_n());
            button.setVisibility(View.INVISIBLE);
        }else{
            status.setText(datatest.getstatus());
        }
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                status.setText(""+aaaa);
                aaaa++;
                button.setVisibility(View.INVISIBLE);
                datatest.setstatus("");
                datatest.setbool_n("1");
            }
        });
        return viewDatatest;
    }
}
