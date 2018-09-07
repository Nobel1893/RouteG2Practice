package nobel.com.route2.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import nobel.com.route2.Model.Car;
import nobel.com.route2.R;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class CarsListAdapter extends RecyclerView.Adapter<CarsListAdapter.ViewHolder>{

    ArrayList<Car> carsList;//data source

    OnItemClickListener onImageClickListener;
    OnItemClickListener onCardClickListener;



    public CarsListAdapter(ArrayList<Car> carsList) {
        this.carsList = carsList;
    }

    public void setOnImageClickListener(OnItemClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    public void setOnCardClickListener(OnItemClickListener onCardClickListener) {
        this.onCardClickListener = onCardClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //1- ha3ml create le view gded
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_car,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //1- getItem to bind it's data in view Holder -- hat el item 3shan trtb el data gowa el view
        final Car car = carsList.get(position);
        //2-(Bind data) ratb el data gowa el view
        holder.name.setText(car.getName());
        holder.date.setText(car.getDate());
        holder.carImage.setImageResource(car.getCarImage());
        holder.carLogo.setImageResource(car.getCarLogo());
        if(onImageClickListener!=null)
            holder.carImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        onImageClickListener.onClick(position,car);
                }
            });

        if(onCardClickListener!=null)
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   onCardClickListener.onClick(position,car);
                }
            });

    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView date;
        ImageView carImage;
        ImageView carLogo;
        View parent;

        ViewHolder(View v){
            super(v);
            name = v.findViewById(R.id.car_name);
            date = v.findViewById(R.id.date);
            carImage = v.findViewById(R.id.car_image);
            carLogo= v.findViewById(R.id.car_logo);
            parent = v.findViewById(R.id.parent);

        }
    }

   public interface OnItemClickListener{
        void onClick(int position,Car car);
   }
}
