package nobel.com.route2.Base;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class MyBaseActivity extends AppCompatActivity {

    protected Context activity;
    MaterialDialog dialog;
   public MyBaseActivity(){
    activity=this;
    }

   public void ShowMessageDialoge(String title,String message){
      dialog= new MaterialDialog.Builder(this)
               .title(title)
               .content(message)
               .positiveText("ok")
               .onPositive(new MaterialDialog.SingleButtonCallback() {
                   @Override
                   public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                       dialog.dismiss();
                   }
               })
               .show();

    }

    public void ShowProgressBar(){
       if(dialog!=null&&dialog.isShowing())return;

        dialog=new MaterialDialog.Builder(this)
              //  .title("please wait")
                .content("Loading...")
                .progress(true,0)
                .cancelable(false)
                .show();
    }

    public void HideProgressBar(){
       if(dialog!=null)
         dialog.dismiss();
    }

    public String getString(String key){
        SharedPreferences sharedPreferences=
                getSharedPreferences("routeApplicationFile",MODE_PRIVATE);
        return  sharedPreferences.getString(key,null);
    }
    public void saveString(String key,String value){
        SharedPreferences.Editor editor =
                getSharedPreferences("routeApplicationFile",MODE_PRIVATE).edit();
        editor.putString(key,value);
        editor.apply();
    }

}
