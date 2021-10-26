package com.example.via_2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class ModalDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context ctxt = requireActivity().getApplicationContext();
        String[] lst = getResources().getStringArray(R.array.items);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("nG05 Group's Dialog:")
                .setMultiChoiceItems(R.array.items, null, (dialog, which, isChecked) -> {
                    if (isChecked) {
                        Toast.makeText(ctxt, lst[which] + " checked", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ctxt, lst[which] + " unchecked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("OK", null)
                .setNegativeButton("Close", (dialog, id)-> {
                    Toast.makeText(ctxt, "You closed dialog", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                });
        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener(dialogInterface -> {
            Button okButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            okButton.setOnClickListener(view -> Toast.makeText(ctxt, "You clicked OK", Toast.LENGTH_SHORT).show());
        });
        return dialog;
   }
}
