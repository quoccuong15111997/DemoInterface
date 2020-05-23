package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    List<Student> students;
    Context context;
    OnItemClick onItemClick;
    GetEdittext getEdittext;

    public ListAdapter(List<Student> students, Context context, OnItemClick onItemClick,GetEdittext getEdittext) {
        this.students = students;
        this.context = context;
        this.onItemClick = onItemClick;
        this.getEdittext=getEdittext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.item_student,parent,false);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Student student=students.get(position);
        holder.getTxtName().setText(student.getName());
        holder.getTxtId().setText(String.valueOf(student.getId()));
        holder.getImg().setImageResource(student.getAvatar());
        holder.getImg().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClickItem(student);
                getEdittext.onGet(holder.getEditText().getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName, txtId;
        private ImageView img;
        private EditText editText;

        public TextView getTxtName() {
            return txtName;
        }

        public void setTxtName(TextView txtName) {
            this.txtName = txtName;
        }

        public TextView getTxtId() {
            return txtId;
        }

        public void setTxtId(TextView txtId) {
            this.txtId = txtId;
        }

        public ImageView getImg() {
            return img;
        }

        public void setImg(ImageView img) {
            this.img = img;
        }

        public EditText getEditText() {
            return editText;
        }

        public void setEditText(EditText editText) {
            this.editText = editText;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId=itemView.findViewById(R.id.textView4);
            txtName=itemView.findViewById(R.id.textView5);
            img=itemView.findViewById(R.id.imageView);
            editText=itemView.findViewById(R.id.editText3);
        }
    }
}
