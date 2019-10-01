package edu.kiet.www.blackbox.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.kiet.www.blackbox.R;
import edu.kiet.www.blackbox.models.HistoryPOJO;

/**
 * Created by sooraj on 12/8/17.
 */
//Changes for HactoberFest 2019
public class historyAdapter extends RecyclerView.Adapter<historyAdapter.viewHolder> {
    List<HistoryPOJO> historyPOJOList; Context context;
   public historyAdapter(Context context, List<HistoryPOJO> history){
        historyPOJOList = history;
       this.context = context;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
     TextView date, start_time, end_time,start_location,end_location;
        View v;
        public viewHolder(View itemView) {
            super(itemView);
            date = (TextView)itemView.findViewById(R.id.date);
            start_time = (TextView)itemView.findViewById(R.id.end_time);
            end_time = (TextView)itemView.findViewById(R.id.start_time);
            start_location = (TextView)itemView.findViewById(R.id.start_location);
            end_location = (TextView)itemView.findViewById(R.id.end_location);
            v = itemView.findViewById(R.id.line);
        }
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_adapter, parent, false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        if(!historyPOJOList.get(position).getDate().equals("")) {
            holder.date.setText(historyPOJOList.get(position).getDate());
            holder.date.setVisibility(View.VISIBLE);
            //holder.v.setVisibility(View.VISIBLE);
        }
        else{
            holder.date.setVisibility(View.GONE);
           // holder.v.setVisibility(View.GONE);
        }
        holder.end_time.setText(historyPOJOList.get(position).getStart_time());
        holder.start_time.setText(historyPOJOList.get(position).getEnd_time());
        holder.start_location.setText(historyPOJOList.get(position).getStart_location());
        holder.end_location.setText(historyPOJOList.get(position).getEnd_location());
    }

    @Override
    public int getItemCount() {
        return historyPOJOList.size();
    }
}
