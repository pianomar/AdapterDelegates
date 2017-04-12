package com.learn.omarhezi.adapterdelegatestest;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.List;

import AdapterDelegates.ImageAdapterDelegates;
import AdapterDelegates.TextMessageDelegates;
import Entities.BaseMessage;

/**
 * Created by Omar Hezi on 12/04/17.
 */

public class Adapter extends RecyclerView.Adapter{
    private AdapterDelegatesManager<List<BaseMessage>> delegatesManager;
    private List<BaseMessage> msgsList;

    public Adapter(Activity listActivity, List<BaseMessage> msgsList) {
        this.msgsList = msgsList;

        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new ImageAdapterDelegates(listActivity));
        delegatesManager.addDelegate(new TextMessageDelegates(listActivity));
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(msgsList, position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(msgsList, position, holder);
    }

    @Override
    public int getItemCount() {
        return msgsList.size();
    }


}
