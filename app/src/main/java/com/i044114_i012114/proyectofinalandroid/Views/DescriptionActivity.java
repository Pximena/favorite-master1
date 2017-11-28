package com.i044114_i012114.proyectofinalandroid.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.i044114_i012114.proyectofinalandroid.R;
import com.squareup.picasso.Picasso;

public class DescriptionActivity extends AppCompatActivity {
    TextView textViewname;
    TextView textViewdesc;
    TextView textViewcanti;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        textViewname= (TextView) findViewById(R.id.id_tv_name);
        textViewdesc = (TextView) findViewById(R.id.id_tv_description);
        textViewcanti = (TextView) findViewById(R.id.id_tv_cantidad);
        imageView=(ImageView) findViewById(R.id.id_img_imagen);

        textViewname.setText( getIntent().getExtras().getString("nameprod") );
        textViewdesc.setText( getIntent().getExtras().getString("description") );
        textViewcanti.setText( getIntent().getExtras().getString("cantidad") );
        Picasso.with(this).load(getIntent().getExtras().getString("url")).into(imageView);
        appendTextAlignment(textViewdesc,Layout.Alignment.ALIGN_NORMAL,"Izquierda");
       // appendTextAlignment(textViewdesc,Layout.Alignment.ALIGN_CENTER,"Centrado\n");
        //appendTextAlignment(textViewdesc,Layout.Alignment.ALIGN_OPPOSITE,"Derecha\n");

    }
    private void appendTextAlignment(final TextView tv, Layout.Alignment align, CharSequence text) {
        if (text == null || text.toString().trim().length() == 0) { return; }

        AlignmentSpan span = new AlignmentSpan.Standard(align);
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(span, 0, text.length(), 0);

        if (tv != null) {
            tv.append(spannableString);
        }
    }
}
