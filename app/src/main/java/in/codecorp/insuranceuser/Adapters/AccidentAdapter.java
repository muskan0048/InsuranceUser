package in.codecorp.insuranceuser.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.codecorp.insuranceuser.R;
import in.codecorp.insuranceuser.VehicleDetailsActivity;
import in.codecorp.insuranceuser.models.Accident;
import in.codecorp.insuranceuser.models.Workshop;


public class AccidentAdapter extends RecyclerView.Adapter<AccidentAdapter.MyViewHolder> {

    private List<Accident> vehicleList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
        }
    }


    public AccidentAdapter(Context context, List<Accident> vehicleList) {
        this.context = context;
        this.vehicleList = vehicleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vehicle_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Accident vehicle = vehicleList.get(position);
        holder.title.setText("Accident Id:"+vehicle.getAid() );
        holder.genre.setText("Adhar "+vehicle.getAdharUrl()+"Mobile No "+vehicle.getDlUrl());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, VehicleDetailsActivity.class);
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }
}