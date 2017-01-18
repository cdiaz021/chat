package team.sngular.chat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cdiazmo on 18/1/17.
 */

public class ChatAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> messages;

    public ChatAdapter(Context context, List<String> objects) {
        super(context, 0, objects);
        this.context = context;
        this.messages = objects;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String message = messages.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_left_chat, parent, false);
        ChatViewHolder holder = new ChatViewHolder();
        holder.messageTextView = (TextView) v.findViewById(R.id.messageTextView);
        holder.hourTextView = (TextView) v.findViewById(R.id.hourTextView);
        //TextView nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        holder.image = (ImageView) v.findViewById(R.id.imageView);
        holder.messageTextView.setText(message);
        return v;
    }
    public class ChatViewHolder {
        TextView messageTextView;
        TextView hourTextView;
        //TextView nameTextView;
        ImageView image;
    }
}
