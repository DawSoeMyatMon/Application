package com.example.nyinyi.mmbtws1;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class AdapterTWS extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataTWS> data= Collections.emptyList();
    DataTWS current;
    int currentPos=0;

    public AdapterTWS(Context context,List<DataTWS> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.activity_adapter_tws,parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder=(MyHolder)holder;
        DataTWS current=data.get(position);
        myHolder.tAccountNumber.setText("AccountNumber: " + current.AccountNumber);
        myHolder.tTellerID.setText("TellerID: " + current.TellerID);
        myHolder.tQTy.setText("Qty: " + current.Qty);
        myHolder.tDenomination.setText("Denomination. " + current.Qty);
        myHolder.tAmount.setText("Amount. " + current.Amount);
        myHolder.tAmount.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView tAccountNumber;
        ImageView iList;
        TextView tTellerID;
        TextView tQTy;
        TextView tDenomination;
        TextView tAmount;

        public MyHolder(View itemView) {
            super(itemView);
            tAccountNumber= (TextView) itemView.findViewById(R.id.txtAccountNumber);
            iList= (ImageView) itemView.findViewById(R.id.ivTWS);
            tTellerID = (TextView) itemView.findViewById(R.id.txtTellerID);
            tQTy = (TextView) itemView.findViewById(R.id.txtqty);
            tDenomination = (TextView) itemView.findViewById(R.id.txtDenomination);
            tAmount = (TextView) itemView.findViewById(R.id.txtAmount);

        }

    }
}
