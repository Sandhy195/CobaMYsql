package com.example.sipo.cobamysql;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    //Mendefinisikan View Edit Text
    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextSal;
    // Mendefinisikan View Button
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Men Inisialisasi View Text dan Button
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextSal = (EditText) findViewById(R.id.editTextSalary);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);

        //Berikan event listeners Klik ke Button
        buttonAdd.setOnClickListener(this);
    }

    //Adding an employee
    private void TambahData(){
        // Ubah setiap View EditText ke tipe Data String
        final String npm = editTextName.getText().toString().trim();
        final String nama = editTextDesg.getText().toString().trim();
        final String jurusan = editTextSal.getText().toString().trim();
        // Pembuatan Class AsyncTask yang berfungsi untuk koneksi ke Database Server

        class TambahData extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Proses Kirim Data...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                // Sesuaikan bagian ini dengan field di tabel Mahasiswa
                params.put(Config.KEY_EMP_NPM,npm);
                params.put(Config.KEY_EMP_NAMA,nama);
                params.put(Config.KEY_EMP_JURUSAN,jurusan);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }
        // Jadikan Class TambahData Sabagai Object Baru
        TambahData ae = new TambahData();
        ae.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            TambahData();
        }
    }
}
