package com.example.juankno4.simsaticket.cTec;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juankno4.simsaticket.R;

public class fragment_sidebar extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //EditText text;
    //Button btn;
     EditText editMensaje;
     Button button;
    private IEnviarMensaje implementacion;


    public static fragment_sidebar newInstance(String param1, String param2)
    {
        fragment_sidebar fragment = new fragment_sidebar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_sidebar, container, false);

        editMensaje = v.findViewById(R.id.edtxt);
        button = v.findViewById(R.id.btnirfrag);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                implementacion.enviarMensaje(editMensaje.getText().toString());
            }
        });
        return v;
    }



    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(context instanceof IEnviarMensaje)
        {
            this.implementacion = (IEnviarMensaje) context;
        }

    }


    /*@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


    }*/


    public interface IEnviarMensaje
    {
        void enviarMensaje(String mensaje);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
