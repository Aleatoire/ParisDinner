package adev.parisdinner.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class Cover {

    private int id;
    @SerializedName("account_id")
    private int accountId;
    @SerializedName("path")
    private String urlPath;
    private int order;
    @SerializedName("uploadcare_id")
    private String idUploadcare;
    private boolean show;
    @SerializedName("attachable_id")
    private int idAttachable;
    @SerializedName("attachable_type")
    private String typeAttachable;

    public Cover() {
    }

    public Cover(int id,
                 int accountId,
                 String urlPath,
                 int order,
                 String idUploadcare,
                 boolean show,
                 int idAttachable,
                 String typeAttachable) {
        this.id = id;
        this.accountId = accountId;
        this.urlPath = urlPath;
        this.order = order;
        this.idUploadcare = idUploadcare;
        this.show = show;
        this.idAttachable = idAttachable;
        this.typeAttachable = typeAttachable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getIdUploadcare() {
        return idUploadcare;
    }

    public void setIdUploadcare(String idUploadcare) {
        this.idUploadcare = idUploadcare;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public int getIdAttachable() {
        return idAttachable;
    }

    public void setIdAttachable(int idAttachable) {
        this.idAttachable = idAttachable;
    }

    public String getTypeAttachable() {
        return typeAttachable;
    }

    public void setTypeAttachable(String typeAttachable) {
        this.typeAttachable = typeAttachable;
    }
}
