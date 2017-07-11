package com.backend.helper;

/**
 * Created by sophon on 7/9/17.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"convertedItems"})
public class ResponseList<T> implements Serializable {
    private static final long serialVersionUID = - 2038832193982351400L;
    private Collection<T> items;
    private Boolean hasNext;
    private String cursor;
    private Integer offset;
    private Integer limit;
    private Integer total;
    private String reverseCursor;

    protected ResponseList() {
    }

    public ResponseList(Collection<T> items) {
        this.items = items;
        this.hasNext = Boolean.valueOf(false);
        this.total = Integer.valueOf(items.size());
    }

    public <S> ResponseList(Collection<S> items, Converter<S, T> converter) {
        this(getConvertedItems(items, converter));
    }

    public ResponseList(Collection<T> items, String cursor) {
        this.items = items;
        this.hasNext = Boolean.valueOf(cursor != null && ! cursor.isEmpty());
        this.cursor = cursor;
    }

    public <S> ResponseList(Collection<S> items, String cursor, Converter<S, T> converter) {
        this(getConvertedItems(items, converter), (String) cursor);
    }

    public ResponseList(Collection<T> items, boolean hasNext, Integer offset, Integer limit) {
        this.items = items;
        this.hasNext = Boolean.valueOf(hasNext);
        this.offset = offset;
        this.limit = limit;
    }

    public ResponseList(Collection<T> items, Integer offset, Integer limit, Integer total) {
        this.items = items;
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        int offsetValue = offset != null ? offset.intValue() : 0;
        int limitValue = limit != null ? limit.intValue() : items.size();
        this.hasNext = Boolean.valueOf(offsetValue + limitValue < total.intValue());
    }

    public <S> ResponseList(Collection<S> items, boolean hasNext, Integer offset, Integer limit, Converter<S, T> converter) {
        this(getConvertedItems(items, converter), hasNext, offset, limit);
    }

    public Collection<T> getItems() {
        return this.items;
    }

    @JsonIgnore
    private static <S, T> List<T> getConvertedItems(Collection<S> items, Converter<S, T> converter) {
        List<T> convertedItems = new ArrayList(items.size());
        Iterator i$ = items.iterator();

        while (i$.hasNext()) {
            S item = (S) i$.next();
            convertedItems.add(converter.convert(item));
        }

        return convertedItems;
    }

    public Boolean getHasNext() {
        return this.hasNext;
    }

    public String getCursor() {
        return this.cursor;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public ResponseList<T> withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public ResponseList<T> withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getTotal() {
        return this.total;
    }

    public String getReverseCursor() {
        return this.reverseCursor;
    }

    public ResponseList<T> withReverseCursor(String reverseCursor) {
        this.reverseCursor = reverseCursor;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ResponseList that;
            label93:
            {
                that = (ResponseList) o;
                if (this.cursor != null) {
                    if (this.cursor.equals(that.cursor)) {
                        break label93;
                    }
                } else if (that.cursor == null) {
                    break label93;
                }

                return false;
            }

            label86:
            {
                if (this.hasNext != null) {
                    if (this.hasNext.equals(that.hasNext)) {
                        break label86;
                    }
                } else if (that.hasNext == null) {
                    break label86;
                }

                return false;
            }

            if (this.items != null) {
                if (! this.items.equals(that.items)) {
                    return false;
                }
            } else if (that.items != null) {
                return false;
            }

            label72:
            {
                if (this.limit != null) {
                    if (this.limit.equals(that.limit)) {
                        break label72;
                    }
                } else if (that.limit == null) {
                    break label72;
                }

                return false;
            }

            label65:
            {
                if (this.offset != null) {
                    if (this.offset.equals(that.offset)) {
                        break label65;
                    }
                } else if (that.offset == null) {
                    break label65;
                }

                return false;
            }

            if (this.reverseCursor != null) {
                if (! this.reverseCursor.equals(that.reverseCursor)) {
                    return false;
                }
            } else if (that.reverseCursor != null) {
                return false;
            }

            if (this.total != null) {
                if (! this.total.equals(that.total)) {
                    return false;
                }
            } else if (that.total != null) {
                return false;
            }

            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = this.items != null ? this.items.hashCode() : 0;
        result = 31 * result + (this.hasNext != null ? this.hasNext.hashCode() : 0);
        result = 31 * result + (this.cursor != null ? this.cursor.hashCode() : 0);
        result = 31 * result + (this.offset != null ? this.offset.hashCode() : 0);
        result = 31 * result + (this.limit != null ? this.limit.hashCode() : 0);
        result = 31 * result + (this.total != null ? this.total.hashCode() : 0);
        result = 31 * result + (this.reverseCursor != null ? this.reverseCursor.hashCode() : 0);
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResponseList{");
        sb.append("items = ").append(this.items);
        sb.append(", hasNext = ").append(this.hasNext);
        sb.append(", cursor = '").append(this.cursor).append('\'');
        sb.append(", offset = ").append(this.offset);
        sb.append(", limit = ").append(this.limit);
        sb.append(", total = ").append(this.total);
        sb.append(", reverseCursor = '").append(this.reverseCursor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

