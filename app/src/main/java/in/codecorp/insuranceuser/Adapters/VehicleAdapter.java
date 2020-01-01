package in.codecorp.insuranceuser.Adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.codecorp.insuranceuser.R;
import in.codecorp.insuranceuser.VehicleDetailsActivity;
import in.codecorp.insuranceuser.models.Vehicle;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.MyViewHolder> {

    private List<Vehicle> vehicleList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
        }
    }


    public VehicleAdapter(Context context, List<Vehicle> vehicleList) {
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
        final Vehicle vehicle = vehicleList.get(position);
        holder.title.setText(vehicle.getvBrand()+" -- "+vehicle.getvName() );
        holder.genre.setText(vehicle.getvNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VehicleDetailsActivity.class);
                intent.putExtra("brand", vehicle.getvBrand());
                intent.putExtra("name", vehicle.getvName());
                intent.putExtra("number", vehicle.getvNumber());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }
}