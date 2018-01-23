package br.com.dispositivosmoveis.curriculum;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        executarSom();
    }


    public void abrirDadosPessoais(View view) {
        Intent it = new Intent(this.getApplicationContext(),
                DadosPessoaisActivity.class);
        startActivity(it);
    }

    public void executarSom() {
        MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.gemidao);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mp.start();
    }

    public void enviarEmail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Assunto do Email");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Corpo do Email");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }


    public void efetuarLigacao(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:" + "911229988"));

        startActivity(intent);
    }
}