package charlie.a07073.com.ultimatetrickster.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import charlie.a07073.com.ultimatetrickster.R;
import charlie.a07073.com.ultimatetrickster.activity.BrokenScreenActivity;
import charlie.a07073.com.ultimatetrickster.activity.CallPoliceActivity;
import charlie.a07073.com.ultimatetrickster.activity.ElectricScreenActivity;
import charlie.a07073.com.ultimatetrickster.activity.FartMachineActivity;
import charlie.a07073.com.ultimatetrickster.activity.HorrorCameraActivity;
import charlie.a07073.com.ultimatetrickster.activity.IQTestActivity;
import charlie.a07073.com.ultimatetrickster.activity.TransparentWallpaperActivity;

public class ToolFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView brokenScreenTv, iqTestTv, fartMachineTv, horrorCameraTv,
            callPoliceTv, moreTv, electricTv, wallpaperTv;

    private static final int PERMISSIONS_REQUEST_CAMERA = 454;
    private Context mContext;
    static final String PERMISSION_CAMERA = Manifest.permission.CAMERA;

    private String mParam1;
    private String mParam2;
    private View inflate;

    public ToolFragment() {
        // Required empty public constructor
    }

    public static ToolFragment newInstance(String param1, String param2) {
        ToolFragment fragment = new ToolFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_tool, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View view) {
        brokenScreenTv = view.findViewById(R.id.broken_screen_tv);
        iqTestTv = view.findViewById(R.id.iq_test_tv);
        fartMachineTv = view.findViewById(R.id.fart_machine_tv);
        horrorCameraTv = view.findViewById(R.id.horror_camera_tv);
        callPoliceTv = view.findViewById(R.id.call_police_tv);
        moreTv = view.findViewById(R.id.more_tv);
        electricTv = view.findViewById(R.id.electric_screen_tv);
        wallpaperTv = view.findViewById(R.id.transparent_tv);

        brokenScreenTv.setOnClickListener(this);
        iqTestTv.setOnClickListener(this);
        fartMachineTv.setOnClickListener(this);
        horrorCameraTv.setOnClickListener(this);
        callPoliceTv.setOnClickListener(this);
        moreTv.setOnClickListener(this);
        electricTv.setOnClickListener(this);
        wallpaperTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.broken_screen_tv:
                Intent bsintent = new Intent(getActivity(), BrokenScreenActivity.class);
                startActivity(bsintent);
                getActivity().finish();
//                Snackbar.make(inflate,"You Clicked The Broken Screen",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.iq_test_tv:
                Intent iqIntent = new Intent(getActivity(), IQTestActivity.class);
                startActivity(iqIntent);
//                Snackbar.make(inflate, "You Clicked The IQ Test", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.fart_machine_tv:
//                Snackbar.make(inflate,"You Clicked The Fart Machine",Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FartMachineActivity.class);
                startActivity(intent);
                break;
            case R.id.horror_camera_tv:
                if (ContextCompat.checkSelfPermission(getActivity(), PERMISSION_CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{PERMISSION_CAMERA},
                            PERMISSIONS_REQUEST_CAMERA);
                } else {
//            setTransparentWallpaper();
                    Intent cameraIntent = new Intent(getActivity(), HorrorCameraActivity.class);
                    startActivity(cameraIntent);
                }

//                Snackbar.make(inflate, "You Clicked The Horror Camera", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.call_police_tv:

//                Intent callIntent = new Intent(getActivity(), CallPoliceActivity.class);
//                startActivity(callIntent);

                Snackbar.make(inflate, "Call Police Will Be Coming Soon...", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.more_tv:
                Snackbar.make(inflate, "Stay Tuned For More...", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.electric_screen_tv:
//                Snackbar.make(inflate,"Stay Tuned For More...",Snackbar.LENGTH_SHORT).show();
                Intent electricIntent = new Intent(getActivity(), ElectricScreenActivity.class);
                startActivity(electricIntent);
                getActivity().finish();
                break;
            case R.id.transparent_tv:
//                Snackbar.make(inflate,"Stay Tuned For More...",Snackbar.LENGTH_SHORT).show();
                Intent wallpaperIntent = new Intent(getActivity(), TransparentWallpaperActivity.class);
                startActivity(wallpaperIntent);
                break;
        }
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    setTransparentWallpaper();
                    Intent cameraIntent = new Intent(getActivity(), HorrorCameraActivity.class);
                    startActivity(cameraIntent);

                } else {
                    Toast.makeText(mContext, getString(R.string._lease_open_permissions), Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
