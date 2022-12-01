package com.kenzie.bar_volume

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.util.Calendar
import java.util.*

class MainActivityBiodata : AppCompatActivity(), View.OnClickListener {
    lateinit var edt_tanggal_lahir: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_biodata)

        val btn_simpan: Button = findViewById(R.id.btn_simpan)
        btn_simpan.setOnClickListener(this)

        edt_tanggal_lahir = findViewById(R.id.edt_tanggal_lahir)
        edt_tanggal_lahir.setOnClickListener{
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,{view, year, monthOfYear, dayOfMonth ->
                val dat= (dayOfMonth.toString()+"-"+
                        (monthOfYear +1)+"-"+year)
                edt_tanggal_lahir.setText(dat)
        }, year, month, day)

            datePickerDialog.show()

    }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_simpan->{
                val edt_nama_depan : EditText = findViewById(R.id.edt_nama_depan)
                val edt_nama_belakang : EditText = findViewById(R.id.edt_nama_belakang)
                val edt_tanggal_lahir :EditText = findViewById(R.id.edt_tanggal_lahir)
                val edt_alamat : EditText = findViewById(R.id.edt_alamat)
                val edt_phone : EditText = findViewById(R.id.edt_phone)

                val tvNama : TextView = findViewById(R.id.tv_output_nama)
                val tvTanggal : TextView = findViewById(R.id.tv_output_tanggal)
                val tvAlamat : TextView = findViewById(R.id.tv_output_alamat)
                val tvNomor : TextView = findViewById(R.id.tv_output_nomor)

                val textNama = "Nama : ${edt_nama_depan.getText().toString()} ${edt_nama_belakang.getText().toString()}"
                val textTanggal = "Tanggal Lahir : ${edt_tanggal_lahir.getText().toString()}"
                val textAlamat = "Alamat : ${edt_alamat.getText().toString()}"
                val textNomor = "Nomor : ${edt_phone.getText().toString()}"

                tvNama.text = textNama
                tvTanggal.text = textTanggal
                tvAlamat.text = textAlamat
                tvNomor.text = textNomor
            }
        }
    }
}