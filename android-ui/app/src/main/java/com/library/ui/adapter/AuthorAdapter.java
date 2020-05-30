package com.library.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.library.rest.api.vo.book.AuthorVo;
import com.library.ui.R;


public class AuthorAdapter extends ListAdapter<AuthorVo, AuthorAdapter.AuthorVoHolder> {
    private static final DiffUtil.ItemCallback<AuthorVo> DIFF_CALLBACK = new DiffUtil.ItemCallback<AuthorVo>() {
        @Override
        public boolean areItemsTheSame(AuthorVo oldItem, AuthorVo newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(AuthorVo oldItem, AuthorVo newItem) {
            return oldItem.getId().equals(newItem.getId()) &&
                    oldItem.getName().equals(newItem.getName());
        }
    };
    private OnItemClickListener listener;

    public AuthorAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public AuthorVoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_user_item, parent, false);
        return new AuthorVoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorVoHolder holder, int position) {
        AuthorVo current = getAuthorVoAt(position);
        holder.authorName.setText(current.getName());
    }


    public AuthorVo getAuthorVoAt(int position) {
        return getItem(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(AuthorVo user);
    }

    class AuthorVoHolder extends RecyclerView.ViewHolder {
        private TextView authorName;

        public AuthorVoHolder(View itemView) {
            super(itemView);
            authorName = itemView.findViewById(R.id.author_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getAuthorVoAt(position));
                    }
                }
            });
        }
    }
}
