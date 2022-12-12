package e.simakov.bulletinboard.dialoghelper

import android.app.AlertDialog
import e.simakov.bulletinboard.MainActivity
import e.simakov.bulletinboard.R
import e.simakov.bulletinboard.accounthelper.AccountHelper
import e.simakov.bulletinboard.databinding.SignDialogBinding

class DialogHelper(act: MainActivity) {
    private val act = act
    private val accHelper = AccountHelper(act)

    fun createSignDialog(index: Int) {
        val builder = AlertDialog.Builder(act)
        val rootDialogElement = SignDialogBinding.inflate(act.layoutInflater)
        val view = rootDialogElement.root

        if (index == DialogConst.SIGN_UP_STATE) {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.add_sign_up)
            rootDialogElement.btnSignUpIn.text = act.resources.getString(R.string.sign_up_action)

        } else {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.add_sign_in)
            rootDialogElement.btnSignUpIn.text = act.resources.getString(R.string.sign_in_action)

        }
        rootDialogElement.btnSignUpIn.setOnClickListener {
            if (index == DialogConst.SIGN_UP_STATE) {
                accHelper.signUpWithEmail(
                    rootDialogElement.edSignEmail.text.toString(),
                    rootDialogElement.edSignPassword.text.toString()
                )

            }
        }
        builder.setView(view)
        builder.show()
    }
}