package charlie.a07073.com.ultimatetrickster.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import charlie.a07073.com.ultimatetrickster.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MineFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView shareTv, iqSetTv, horrorSetTv, fartSetTv, loginTv;

    public MineFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
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
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_mine, container, false);
        shareTv = inflate.findViewById(R.id.share_to_friends_tv);
        loginTv = inflate.findViewById(R.id.log_in_tv);
        iqSetTv = inflate.findViewById(R.id.iq_set_tv);
        horrorSetTv = inflate.findViewById(R.id.horror_set_tv);
        fartSetTv = inflate.findViewById(R.id.fart_set_tv);

        shareTv.setOnClickListener(this);
        loginTv.setOnClickListener(this);
        iqSetTv.setOnClickListener(this);
        horrorSetTv.setOnClickListener(this);
        fartSetTv.setOnClickListener(this);
        return inflate;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.share_to_friends_tv:
                Snackbar.make(horrorSetTv, "Share will be coming soon", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.log_in_tv:
//                Snackbar.make(horrorSetTv, "测试About", Snackbar.LENGTH_SHORT).show();
                showDialog();
                break;
            case R.id.iq_set_tv:
                break;
            case R.id.fart_set_tv:
                break;
            case R.id.horror_set_tv:
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void showDialog() {
        new AlertDialog.Builder(getActivity())
                .setTitle("About")
                .setMessage("This application is for entertainment only")
                .setNegativeButton("Yes I Know", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show()
        ;
    }
}
