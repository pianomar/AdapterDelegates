package AdapterDelegates;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.learn.omarhezi.adapterdelegatestest.R;

import java.util.List;

import Entities.BaseMessage;
import Entities.TextMessage;

/**
 * Created by Omar Hezi on 12/04/17.
 */

public class TextMessageDelegates extends AdapterDelegate<List<BaseMessage>> {

    LayoutInflater layoutInflater;

    public TextMessageDelegates(Activity activity) {
        layoutInflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(@NonNull List<BaseMessage> items, int position) {
        return items.get(position) instanceof TextMessage;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new TextMessageViewHolder(layoutInflater.inflate(R.layout.textmessage, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<BaseMessage> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        TextMessageViewHolder vh = (TextMessageViewHolder) holder;
        TextMessage message = (TextMessage) items.get(position);

        vh.message.setText(message.getMessageContents());
    }

    static class TextMessageViewHolder extends RecyclerView.ViewHolder{
        public TextView message;

        public TextMessageViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.message_txtView);
        }
    }
}
