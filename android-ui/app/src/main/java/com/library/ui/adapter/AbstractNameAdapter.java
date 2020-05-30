package com.library.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.library.rest.api.vo.NamedEntityVo;
import com.library.ui.R;

import org.jetbrains.annotations.NotNull;


public abstract class AbstractNameAdapter<Entity extends NamedEntityVo> extends ListAdapter<Entity, AbstractNameAdapter<Entity>.EntityHolder> {
    private OnItemClickListener<Entity> listener;

    public AbstractNameAdapter() {
        super(new DiffUtil.ItemCallback<Entity>() {
            @Override
            public boolean areItemsTheSame(@NotNull Entity oldItem, @NotNull Entity newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NotNull Entity oldItem, @NotNull Entity newItem) {
                return oldItem.getId().equals(newItem.getId()) && oldItem.getName().equals(newItem.getName());
            }
        });
    }

    @NonNull
    @Override
    public EntityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_named_item, parent, false);
        return new EntityHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EntityHolder holder, int position) {
        Entity current = getEntityAt(position);
        holder.name.setText(current.getName());
    }


    public Entity getEntityAt(int position) {
        return getItem(position);
    }

    public void setOnItemClickListener(OnItemClickListener<Entity> listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener<Entity> {
        void onItemClick(Entity user);
    }

    class EntityHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public EntityHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.named_item);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getEntityAt(position));
                }
            });
        }
    }
}
