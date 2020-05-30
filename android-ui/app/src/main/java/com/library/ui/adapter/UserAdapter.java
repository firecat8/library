package com.library.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.library.rest.api.vo.user.UserVo;
import com.library.ui.R;

import org.jetbrains.annotations.NotNull;


public class UserAdapter extends ListAdapter<UserVo, UserAdapter.UserVoHolder> {
    private OnItemClickListener listener;

    public UserAdapter() {
        super(new DiffUtil.ItemCallback<UserVo>() {
            @Override
            public boolean areItemsTheSame(@NotNull UserVo oldItem,@NotNull  UserVo newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NotNull UserVo oldItem,@NotNull  UserVo newItem) {
                return oldItem.getId().equals(newItem.getId()) &&
                        oldItem.getEmail().equals(newItem.getEmail()) &&
                        oldItem.getUserName().equals(newItem.getUserName());
            }
        });
    }

    @NonNull
    @Override
    public UserVoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_item, parent, false);
        return new UserVoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserVoHolder holder, int position) {
        UserVo current = getUserVoAt(position);
        holder.email.setText(current.getEmail());
        holder.fullName.setText(current.getFullName());
        holder.username.setText(current.getUserName());
    }


    public UserVo getUserVoAt(int position) {
        return getItem(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(UserVo user);
    }

    class UserVoHolder extends RecyclerView.ViewHolder {
        private TextView email;
        private TextView fullName;
        private TextView username;

        public UserVoHolder(View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.text_view_email);
            fullName = itemView.findViewById(R.id.text_view_full_name);
            username = itemView.findViewById(R.id.text_view_user_name);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getUserVoAt(position));
                }
            });
        }
    }
}
