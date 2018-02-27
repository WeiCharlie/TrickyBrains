package charlie.a07073.com.ultimatetrickster.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import charlie.a07073.com.ultimatetrickster.R;
import charlie.a07073.com.ultimatetrickster.activity.WebGameActivity;
import charlie.a07073.com.ultimatetrickster.base.ConstantUrl;

public class GameFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageView img1, img2, img3;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_game, container, false);
        img1 = inflate.findViewById(R.id.img_1);
        img2 = inflate.findViewById(R.id.img_2);
        img3 = inflate.findViewById(R.id.img_3);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);

        return inflate;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.img_1:
                Intent intentFriv = new Intent(getActivity(), WebGameActivity.class);
                intentFriv.putExtra("gameUrl", ConstantUrl.FRIV_URL);
                startActivity(intentFriv);
                break;
            case R.id.img_2:
                Intent intent7k7k = new Intent(getActivity(), WebGameActivity.class);
                intent7k7k.putExtra("gameUrl", ConstantUrl.GAME_7K7K_URL);
                startActivity(intent7k7k);
                break;
            case R.id.img_3:
                Intent intent4399 = new Intent(getActivity(), WebGameActivity.class);
                intent4399.putExtra("gameUrl", ConstantUrl.GAME_4399_URL);
                startActivity(intent4399);
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
}
