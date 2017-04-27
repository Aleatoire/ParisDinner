package adev.parisdinner.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class Avatar {

    private int id;
    @SerializedName("account_id")
    private int idAccount;
    @SerializedName("uploadcare_id")
    private String idUploadcare;
    private boolean show;
    @SerializedName("attachable_id")
    private int idAttachable;
    @SerializedName("attachable_type")
    private String typeAttachable;
    private String path;
    private int order;

    public Avatar() {
    }

    public Avatar(int id,
                  int idAccount,
                  String idUploadcare,
                  boolean show,
                  int idAttachable,
                  String typeAttachable,
                  String path,
                  int order) {
        this.id = id;
        this.idAccount = idAccount;
        this.idUploadcare = idUploadcare;
        this.show = show;
        this.path = path;
        this.idAttachable = idAttachable;
        this.typeAttachable = typeAttachable;
        this.order = order;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
