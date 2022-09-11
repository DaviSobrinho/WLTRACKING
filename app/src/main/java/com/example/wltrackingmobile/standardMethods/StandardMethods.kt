package com.example.wltrackingmobile.standardMethods

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.wltrackingmobile.database.AppDatabase
import com.google.android.material.textfield.TextInputEditText
import java.text.NumberFormat


class StandardMethods {
    fun verificaStringVazia(string : String?) : Boolean{
        if (string == "" || string == null){
            return false
        }
        return true
    }
    fun verificaCPFRepetido(cpf : String?, context: Context) : Boolean{
        val db = AppDatabase.instancia(context)
        val funcoesdbdao = db.funcoesdbdao()
        val cliente = funcoesdbdao.findClientePorCPF(cpf)
        if (cliente.isEmpty()){
            return false
        }
        return true
    }
    fun toast(string : String, context : Context){
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(context, string, duration)
        toast.show()
    }
    fun iniciaActivity(activity : Activity ,activityAtual: Activity, context : Context) {
        val intent = Intent(context, activity::class.java)
        val bundle = ActivityOptions.makeSceneTransitionAnimation(activityAtual).toBundle()
        intent.removeFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(context , intent, bundle)
    }
    fun getStringLenght(string: String) : Int{
        return string.length
    }
    fun corrigeTextoCPF(textInputEditText: TextInputEditText){
        textInputEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }
    fun myValidateCPF(cpf : String) : Boolean{
        val cpfClean = cpf.replace(".", "").replace("-", "")
        if (cpfClean.length != 11)
            return false
        try {
            val number  = cpfClean.toLong()
        }catch (e : Exception){
            return false
        }
        var dvCurrent10 = cpfClean.substring(9,10).toInt()
        var dvCurrent11= cpfClean.substring(10,11).toInt()
        val cpfNineFirst = IntArray(9)
        var i = 9
        while (i > 0 ) {
            cpfNineFirst[i-1] = cpfClean.substring(i-1, i).toInt()
            i--
        }
        var sumProductNine = IntArray(9)
        var weight = 10
        var position = 0
        while (weight >= 2){
            sumProductNine[position] = weight * cpfNineFirst[position]
            weight--
            position++
        }
        //Verify the nineth digit
        var dvForTenthDigit = sumProductNine.sum() % 11
        dvForTenthDigit = 11 - dvForTenthDigit //rule for tenth digit
        if(dvForTenthDigit > 9)
            dvForTenthDigit = 0
        if (dvForTenthDigit != dvCurrent10)
            return false

        //### verify tenth digit
        var cpfTenFirst = cpfNineFirst.copyOf(10)
        cpfTenFirst[9] = dvCurrent10
        //multiple the nine digits for your weights: 10,9..2
        var sumProductTen = IntArray(10)
        var w = 11
        var p = 0
        while (w >= 2){
            sumProductTen[p] = w * cpfTenFirst[p]
            w--
            p++
        }
        //Verify the nineth digit
        var dvForeleventhDigit = sumProductTen.sum() % 11
        dvForeleventhDigit = 11 - dvForeleventhDigit //rule for tenth digit
        if(dvForeleventhDigit > 9)
            dvForeleventhDigit = 0
        if (dvForeleventhDigit != dvCurrent11)
            return false

        return true

    }
    private fun replaceChars(cpfFull : String) : String{
        return cpfFull.replace(".", "").replace("-", "")
            .replace("(", "").replace(")", "")
            .replace("/", "").replace(" ", "")
            .replace("*", "")
    }


    fun mask(mask : String, etCpf : TextInputEditText) : TextWatcher{

        val textWatcher : TextWatcher = object : TextWatcher {
            var isUpdating : Boolean = false
            var oldString : String = ""
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val str = replaceChars(s.toString())
                var cpfWithMask = ""

                if (count == 0)//is deleting
                    isUpdating = true

                if (isUpdating){
                    oldString = str
                    isUpdating = false
                    return
                }

                var i = 0
                for (m : Char in mask.toCharArray()){
                    if (m != '#' && str.length > oldString.length){
                        cpfWithMask += m
                        continue
                    }
                    try {
                        cpfWithMask += str.get(i)
                    }catch (e : Exception){
                        break
                    }
                    i++
                }

                isUpdating = true
                etCpf.setText(cpfWithMask)
                etCpf.setSelection(cpfWithMask.length)

            }

            override fun afterTextChanged(editable: Editable) {

            }
        }

        return textWatcher
    }
}