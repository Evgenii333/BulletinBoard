package e.simakov.bulletinboard.accounthelper

import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import e.simakov.bulletinboard.MainActivity
import e.simakov.bulletinboard.R

class AccountHelper(act: MainActivity) {
    private val act = act
    fun signUpWithEmail(email: String, password: String){
       if(email.isNotEmpty() && password.isNotEmpty()){
           act.mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{task ->
               if(task.isSuccessful){
                   sendEmailVerification(task.result?.user!!)


               }else{
                   Toast.makeText(act, act.resources.getString(R.string.sign_up_error), Toast.LENGTH_LONG).show()
               }

           }
       }
    }

    private fun sendEmailVerification(user:FirebaseUser){
        user.sendEmailVerification().addOnCompleteListener{task ->
            if(task.isSuccessful){
                Toast.makeText(act, act.resources.getString(R.string.send_verification_done), Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(act, act.resources.getString(R.string.send_verification_email_error), Toast.LENGTH_LONG).show()
            }
        }
    }
}