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
import in.codecorp.insuranceuser.models.Request;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder> {

    private List<Request> vehicleList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
        }
    }


    public RequestAdapter(Context context, List<Request> vehicleList) {
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
        Request vehicle = vehicleList.get(position);
        holder.title.setText("Vehicle :"+vehicle.getvNumber() );
        holder.genre.setText("Workshop "+vehicle.getWorkshopId());
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