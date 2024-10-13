package com.juanfra.autocompletetextviewyspinner

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

/*
Autor: Juan Francisco Sánchez González
Fecha: 12/10/2024
Clase: Actividad donde se utiliza un adaptador simple para asignar las opciones a un control AutoCompleteTextView
y a un Spinner. Se implementa un RatingBar con su manejador de eventos.
*/

class MainActivity : AppCompatActivity() {

    // Controles básicos a utilizar
    lateinit var marcas: AutoCompleteTextView
    lateinit var listadoMarcas: Spinner
    lateinit var ratingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initControles()
        initRatingBar()
    }

    // Se instancian los controles AutoCompleteTextView y Spinner. Y se les asigna un adaptador simple
    private fun initControles() {
        marcas = findViewById(R.id.autoCompleteTextView)
        listadoMarcas = findViewById(R.id.spinner)

        marcas.setAdapter(ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.marcas_surf)))
        listadoMarcas.adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.marcas_surf))
    }

    // Se instancia el RatingBar y se implementa su controlador para mostrar la puntuación
    private fun initRatingBar() {
        ratingBar = findViewById(R.id.ratingBar)

        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(this, getString(R.string.toast_ratingbar, String.format(Locale.getDefault(), "%.1f", rating)), Toast.LENGTH_SHORT).show()
        }
    }
}