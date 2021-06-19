
/*
package in.mahabhujal.mahabhujal.registration;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class InternetUtil {

    public static   boolean myInternetConnection(Context context){

        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (mWifi.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isOnline(Context context){


        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            return true;
        }else {
            return false;
        }

    }


    public static boolean isInternetOnline(Context context){


//        if ( InternetUtil.myInternetConnection(context) || InternetUtil.isOnline(context)){

        if (InternetUtil.isOnline(context)){

            return true;
        }else {
            Toast.makeText(context, "Check Internet", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}



/*
(regmain)
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
</FrameLayout>

*/
