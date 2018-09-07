package nobel.com.route2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import nobel.com.route2.Adapters.CarsListAdapter;
import nobel.com.route2.Model.Car;

public class CarsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CarsListAdapter adapter;
    ArrayList <Car> carsList;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        recyclerView= findViewById(R.id.recycler_view);
        AddCars();
       // layoutManager= new LinearLayoutManager(this);
        //if need horizontal layout
        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        adapter = new CarsListAdapter(carsList);
       adapter.setOnImageClickListener(new CarsListAdapter.OnItemClickListener() {
           @Override
           public void onClick(int position, Car car) {
               Toast.makeText(CarsActivity.this, car.getName(), Toast.LENGTH_SHORT).show();
           }
       });
       adapter.setOnCardClickListener(new CarsListAdapter.OnItemClickListener() {
           @Override
           public void onClick(int position, Car car) {
               //startActivity for details
               Toast.makeText(CarsActivity.this, "future work (open details)", Toast.LENGTH_SHORT).show();
           }
       });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void AddCars(){
        carsList=new ArrayList<>();
        for(int i=0;i<20;i++)
            carsList.add(new Car("jeep "+i,i+"/2/2015",R.drawable.car,R.drawable.logo));

    }
}
