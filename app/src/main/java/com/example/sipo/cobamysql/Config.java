package com.example.sipo.cobamysql;

/**
 * Created by SIPO on 9/26/2016.
 */
public class Config {

    //Alamat URL tempat kita meletakkan script PHP di PC Server
    // Link untuk INSERT Data
    public static final String URL_ADD="http://192.168.43.151/crud/create.php";

    // Filed yang digunakan untuk dikirimkan ke Database, sesuaikan saja dengan Field di Tabel Mahasiswa
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NPM = "npm";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_JURUSAN = "jurusan";

    // Tags Format JSON
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NPM = "npm";
    public static final String TAG_NAME = "nama";
    public static final String TAG_JURUSAN = "jurusan";

}
