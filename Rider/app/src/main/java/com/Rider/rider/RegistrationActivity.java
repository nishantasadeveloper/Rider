package com.Rider.rider;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends Activity
{
    private static final int INTENT_COUNTRY_SEL = 0;

    private int mVersionCode = 0;


    //Maintains the position of a user-selected country in the list of countries
    int currListPosition = NO_SELECTION;
    private Activity mContext;
    private Resources mResources;
    public static boolean sIsShowingTour = false;
    private boolean mComingFromTour = false;

    private boolean mIsAccountConfigured = false;
    private int mRegistartionFlow = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        mContext = this;
        mResources = this.getResources();
        setContentView(R.layout.activity_registration);

        Button btnregister = (Button) findViewById(R.id.btnregister);
        TextView registrationtvmobilenumber = (TextView) findViewById(R.id.registration_tv_mobilenumber);
        TextView registrationtvcountry = (TextView) findViewById(R.id.registration_tv_country);
        EditText registrationetmobilenumber = (EditText) findViewById(R.id.registration_et_mobilenumber);
        EditText registrationetcountrycode = (EditText) findViewById(R.id.registration_et_countrycode);
        TextView registrationtvmobile = (TextView) findViewById(R.id.registration_tv_mobile);

        //We need to check if we need to redirect to another activity
//        mRegistartionFlow = SharedPrefrencesUtils.getIntSharedPreferences(mContext, SharedPrefrencesUtils.REG_FLOW_STEP);

        if (mRegistartionFlow > 0)
        {
            checkRedirect();
        }

        if (btnregister != null)
        {
            btnregister.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                }
            });
        }
    }

    /*
     * As registration is the starting activity of the app, we need to find out whether user already did registration or not.
     * If not registered and No Registration Code - Registration Screen
     * If not registered but have Registration Code - VerifyCode Screen (Depending on National/International number)
     * If Registration Code sent but not Registered - Verifying Screen
     * If Registration is done but not skipped Discover Screen - Discover Screen
     * If Registration done and skipped Discover Screen - HomeTabActivity.
     */
    private void checkRedirect()
    {

        if (!sIsShowingTour)
        {

            if (mIsAccountConfigured)
            {
//                if (mRegistartionFlow == Utils.inProfileActivity)
//                {
//                    Intent intent = new Intent(mContext, ProfileActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                    intent.putExtra("registration_flow", true);
//                    mContext.startActivity(intent);
//                    finish();
//                }
//                else
//                {
                Intent i = new Intent(this, HomeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                finish();
//                }
            }
//            else if (mRegistartionFlow == Utils.inVerifyCodeActivity)
//            {
//                String verifyCode = SharedPrefrencesUtils.getStringSharedPreferences(mContext, SharedPrefrencesUtils.VERIF_CODE);
//
//                Intent i = new Intent();
//                i.setClass(this, VerifyCodeActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
//                finish();
//            }
        }
    }


}
